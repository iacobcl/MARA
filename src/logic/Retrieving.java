/*
#  Licensed to the Apache Software Foundation (ASF) under one
#  or more contributor license agreements.  See the NOTICE file
#  distributed with this work for additional information
#  regarding copyright ownership.  The ASF licenses this file
#  to you under the Apache License, Version 2.0 (the
#  "License"); you may not use this file except in compliance
#  with the License.  You may obtain a copy of the License at
#
#  http://www.apache.org/licenses/LICENSE-2.0
#
#  Unless required by applicable law or agreed to in writing,
#  software distributed under the License is distributed on an
#  "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
#  KIND, either express or implied.  See the License for the
#  specific language governing permissions and limitations
#  under the License.
*/

package logic;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Random;

import objs.Application;
import objs.Review;

import org.w3c.dom.*;

import storage.FileQuerying;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;

public class Retrieving 
{
	public static ArrayList<Application> apps = new ArrayList<Application>();
	public static ArrayList<String> ids = new ArrayList<String>(); 
	
	public static int totalRevs = 0;
	
	//the method gets as input the file with the raw reviews of one application and returns an object with the processed list of reviews
	//CHI paper version; June-July 2012
/*	public static ArrayList<Review> retrieveReviews(String fileName)
	{
		ArrayList<Review> revs = new ArrayList<Review>();	
		
		try 
		{
	            DocumentBuilderFactory docBuilderFactory = DocumentBuilderFactory.newInstance();
	            DocumentBuilder docBuilder = docBuilderFactory.newDocumentBuilder();
	            //Document doc = docBuilder.parse (new File("input/" + fileName + ".xml"));
	            Document doc = docBuilder.parse (new File(fileName + ".xml"));

	            
	            // normalize text representation
	            doc.getDocumentElement().normalize ();
	            NodeList allrevs = doc.getElementsByTagName("div");

	            
	            for(int i = 0; i < allrevs.getLength(); i++)
	            {
	               	for (int k = 0; k < allrevs.item(i).getAttributes().getLength(); k++)
	               	{
	               	
        				if (allrevs.item(i).getAttributes().item(k).getNodeValue().equals("doc-review"))
        				{//allrevs.item(i) stores one review
        						Review r = new Review();
        						Node nodeR = allrevs.item(i);
        						NodeList kids = nodeR.getChildNodes();

        						if (kids.getLength() != 0)
        						{
        							for (int j = 0; j < kids.getLength(); j++)
        		            		{
//System.out.println(kids.item(j).getTextContent());        								
        		            		
        								//set the device and version
        		            			if ( (kids.item(j).getNodeName().equals("#text")) && (kids.item(j).getTextContent() != null) )
        		            			{
        		            				String devver = kids.item(j).getTextContent();
        		            				
        		            				//System.out.println(devver);
        		            				
        		            				if (devver.contains("with version"))
        		            				{
        		            					r.setDevice( (kids.item(j).getTextContent().split("with version"))[0]);
        		            					r.setVersion( (kids.item(j).getTextContent().split("with version"))[1]);
        		            				}
        		            				else
        		            				{
        		            					r.setVersion(devver);
        		            				}
        		            				        		            				
        		            			}
        		            			
        		            			//set text
        		            			if (kids.item(j).getNodeName().equals("p") && (kids.item(j).getAttributes().item(0).getNodeValue().equals("review-text")))
        		            				r.setText(kids.item(j).getTextContent());
        		            				
        		            			
        		            			if (kids.item(j).getAttributes() != null) 
        		            			{
        		            					            				            				
        		            				for (int l = 0; l < kids.item(j).getAttributes().getLength(); l++)
        		            				{
        		            				
        		            					//set the date of the review
        		            					if ((kids.item(j).getAttributes().item(l).getNodeValue().equals("doc-review-date") && 
        		            							(kids.item(j).getNodeName().equals("span"))))
        		            					{
        		            									r.setDate(kids.item(j).getTextContent());
        		            									System.out.println(kids.item(j).getTextContent());
        		            					}
        		            					

        		            					if (kids.item(j).getAttributes().item(l).getNodeValue().equals("doc-review-ratings-line"))
        		            					{

        		            						NodeList ratings = kids.item(j).getChildNodes();
        		            						
        		            							
        		            						for (int t = 0; t < ratings.getLength(); t++)
        		            						{
        		            							//set the title
        		            							if (ratings.item(t).getNodeName().equals("h4"))
        		            								r.setTitle(ratings.item(t).getTextContent());
        		            							
        		            							//set the rate
        		            							if (ratings.item(t).getNodeName().equals("div"))
        		            							{
       		            									if (ratings.item(t).getAttributes() != null)
       		            									{
       		            										for (int q = 0; q < ratings.item(t).getAttributes().getLength(); q++)
       		            											if (ratings.item(t).getAttributes().item(q).getNodeValue().contains("Rating:"))
       		            												r.setRate(ratings.item(t).getAttributes().item(q).getNodeValue().substring(8, 12));
       		            									}
       		            										
        		            							}
        		            							
        		            						}
        		            						
        		            					}
        		            				}
        		            			
        		            			}

        		            		}
        						}
        						//r.print();
        						revs.add(r); //add review to list of reviews 						
        				}

	               	}
	            }
	            
	            return revs;

	        }
			catch (Exception ex) 
	        {
	        	ex.printStackTrace ();
	        	return null;
	        }
	       
	}*/
	
	//the method writes the processed reviews of an application in a tab delimited file
	public static void storeReviews(ArrayList<Review> revs, String fileName)
	{
		
		try
		{
			  FileWriter fstream = new FileWriter("outputMSRAna/" + fileName + ".txt");
			  BufferedWriter out = new BufferedWriter(fstream);

			  for (int i = 0; i < revs.size(); i++)
			  {
				  out.write(revs.get(i).getDate() + "&&&" + revs.get(i).getRate() + "&&&" + revs.get(i).getDevice() + "&&&" + revs.get(i).getVersion() + "&&&" + revs.get(i).getTitle() + "&&&" + revs.get(i).getText());
				  out.newLine();
			  }
			  out.close();
		}
		catch (Exception e)
		{//Catch exception if any
			  System.err.println("Error: " + e.getMessage());
		}
	}
	
	//the method retrieves the reviews of an application and stores them in a tab delimited file
	public static void processReviewMSR(String file)
	{
		ArrayList<Review> revs = new ArrayList<Review>();	
		revs = retrieveReviewsMSR(file);
		storeReviews(revs, file);
	}
	
	
	
	public static void createAppsMap()
	{
		try
		{
			  FileInputStream fstream = new FileInputStream("conf/apps.txt");
			  DataInputStream in = new DataInputStream(fstream);
			  BufferedReader br = new BufferedReader(new InputStreamReader(in));
			  String strLine;
			  //Read File Line By Line
			  while ((strLine = br.readLine()) != null)   
				  ids.add(strLine);
				  //Close the input stream
			  in.close();
			}
			catch (Exception e)
			{//Catch exception if any
				  System.err.println("Error: " + e.getMessage());
		}
	}
	
	public static ArrayList<Review> retrieveReviewsMSR(String fileName)
	{
		//Creates new ArrayList revs of type <Review>
		ArrayList<Review> revs = new ArrayList<Review>();	
		
		try 
		{
	            DocumentBuilderFactory docBuilderFactory = DocumentBuilderFactory.newInstance();
	            DocumentBuilder docBuilder = docBuilderFactory.newDocumentBuilder();
	            Document doc = docBuilder.parse (new File("inputMSRAna/" + fileName + ".xml"));
	            
	            // normalize text representation
	            doc.getDocumentElement().normalize ();
	            NodeList allrevs = doc.getElementsByTagName("div");

	            
	            for(int i = 0; i < allrevs.getLength(); i++)
	            {
	               	for (int k = 0; k < allrevs.item(i).getAttributes().getLength(); k++)
	               	{
	               	
        				if (allrevs.item(i).getAttributes().item(k).getNodeValue().equals("doc-review"))
        				{//allrevs.item(i) stores one review
        						Review r = new Review();
        						Node nodeR = allrevs.item(i);
        						NodeList kids = nodeR.getChildNodes();

        						if (kids.getLength() != 0)
        						{
        							for (int j = 0; j < kids.getLength(); j++)
        		            		{
        								NodeList grandkids = kids.item(j).getChildNodes();
        								
        								/*for (int jk = 0; jk < grandkids.getLength(); jk++)
        								{
        									if (kids.item(j).getChildNodes().item(jk).getAttributes().item(0).getNodeValue().equals("doc-review-author"))
        									{
               									r.setUser(kids.item(j).getChildNodes().item(jk).getTextContent());
               									System.out.println(kids.item(j).getChildNodes().item(jk).getTextContent());
        									}
        									
        								}*/
        								
        								r.setDate(kids.item(1).getChildNodes().item(0).getTextContent());
        								//System.out.println(kids.item(1).getChildNodes().item(0).getTextContent());
        								
        								r.setDate(kids.item(1).getChildNodes().item(1).getTextContent());
        								//System.out.println(kids.item(1).getChildNodes().item(1).getTextContent());
        								
        								if (kids.item(1).getChildNodes().item(2).getTextContent().contains("with version"))
        								{
        									r.setDevice(kids.item(1).getChildNodes().item(2).getTextContent().split("with version")[0]);
	        								//System.out.println(kids.item(1).getChildNodes().item(2).getTextContent().split("with version")[0]);
	        								r.setVersion(kids.item(1).getChildNodes().item(2).getTextContent().split("with version")[1]);
	        								//System.out.println(kids.item(1).getChildNodes().item(2).getTextContent().split("with version")[1]);
        								}
        								else
        								{
        									r.setVersion(kids.item(1).getChildNodes().item(2).getTextContent());
	        								//System.out.println(kids.item(1).getChildNodes().item(2).getTextContent());
        								}
        								
        								r.setTitle(kids.item(1).getChildNodes().item(4).getTextContent());
        								//System.out.println(kids.item(1).getChildNodes().item(4).getTextContent());
        								
        								r.setText(kids.item(1).getChildNodes().item(5).getTextContent());
        								//System.out.println(kids.item(1).getChildNodes().item(5).getTextContent());
        								
        								
        								
        								System.out.println("---");

        								//String content = kids.item(j).getTextContent();
        								//String[] sContent = content.split("-"); 
        								
        								//for (int ic = 0; ic < sContent.length; ic++)
        									//System.out.println(sContent[ic]);
        								//System.out.println("---");
        								
        								//r.setUser(sContent[0]);
        								//r.setDate(sContent[1]);
        		            		

        		            		}
        						}
        						//r.print();
        						revs.add(r); //add review to list of reviews 		
        						totalRevs++;
        				}

	               	}
	            }
	            
	            return revs;

	        }
			catch (Exception ex) 
	        {
	        	ex.printStackTrace ();
	        	return null;
	        }
	       
	}
	public static void main(String[] args)
	{
		for (int i = 73; i < 241; i++)
		{
			ArrayList<Review> revs = Retrieving.retrieveReviewsMSR("f_" + i);
			Retrieving.processReviewMSR("f_" + i);
		}
		
		System.out.println(totalRevs);
	}
	
	

}
