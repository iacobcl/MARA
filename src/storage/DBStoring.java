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

package storage;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import objs.CodeDistr;
import objs.File;
import objs.Review;

/**
 * Class that deals with the storage of data within databases
 */
public class DBStoring 
{

	/**
	 * Insert data into the database
	 * @param appid The app id
	 * @param revid The review ID
	 * @param title the Title for the review
	 * @param review the review itself
	 * @param codeclass the codeclass of the review
	 * @param refcode the refined code of the app
     * @param rawcode the reaw code of the app
     */
	public static void insertCode (String appid, String revid, String title, String review, String codeclass, String refcode, String rawcode)
	{
		
		try 
		{
			//Try to connect to the database
            Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
            Connection c = DriverManager.getConnection("jdbc:odbc:mobbs", "mobbs", "mobbs");
            Statement s = c.createStatement();
            //Insert the data to the database
            s.execute("insert into Codes (appid, revid, title, review, codeclass, refinedcode, rawcode) values('" +	appid + "', '" + revid + "', '" + title + "', '" + review + "', '" + codeclass + "', '" + refcode + "', '" + rawcode + "')"); 
            //Close the connection to the database
			c.close();
        }
		catch(Exception e)
		{
			//An exception was caught
            e.printStackTrace();
        }
	}

	/**
	 * Update an existing review
	 * @param appid the appID in the review
	 * @param revid the review to update
	 * @param device the device for the review
     */
	public static void updateReview(String appid, String revid, String device)
	{
		try 
		{
			//Try to connect to the database
            Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
            Connection c = DriverManager.getConnection("jdbc:odbc:mobbs", "mobbs", "mobbs");
            Statement s = c.createStatement();
            //Attempt to update the review
            s.execute("UPDATE Codes SET device='" + device + "' WHERE appid='" + appid + "' AND revid='" + revid + "'"); 
            //close the connection to the datbase
			c.close();
        }
		catch(Exception e)
		{
			//Catch any exceptions
            e.printStackTrace();
        }
	}

	/**
	 * Insert a new review into the database
	 * @param appid The appID in the review
	 * @param title the title of the review
	 * @param device the device in the review
	 * @param version the version of the review
     * @param date the date the review was done on
     */
	public static void insertRev (String appid, String title, String device, String version, String date)
	{
		
		try 
		{
			//Try to connect to the database
            Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
            Connection c = DriverManager.getConnection("jdbc:odbc:mobbs", "mobbs", "mobbs");
            Statement s = c.createStatement();
            //attempt to insert the data into the database
            s.execute("insert into Revs (appid, title, device, version, date) values('" +	appid + "', '" + title + "', '" + device + "', '" + version + "', '" + date + "')"); 
            //close the database connection
			c.close();
        }
		catch(Exception e)
		{
			//Catch any exceptions/errors
            e.printStackTrace();
        }
	}

	/**
	 * Get files from the database
 	 * @return an ArrayList of files
     */
	public static ArrayList<File> getFiles()
	{
		//setup the arraylist
		ArrayList<File> files = new ArrayList<File>();
	
		try 
		{
			//Try to connect to the database
            Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
            Connection c = DriverManager.getConnection("jdbc:odbc:mobbs", "mobbs", "mobbs");
            Statement s = c.createStatement();
            //Run the query
            ResultSet r = s.executeQuery("SELECT * from Files");

			//Add all files from the database into the arraylist
            while (r.next())
            	files.add(new File(r.getString("fileid"), r.getInt("status")));
           	//Close the connection to teh database
            c.close();
        }
		catch(Exception e)
		{
			//Catch any exceptions
            e.printStackTrace();
        }
		//Return the arraylist
		return files;
	}

	/**
	 * Set a file status within the database
	 * @param filename The file to update
	 * @param status the new status of the file
     */
	public static void setFileStatus(String filename, int status)
	{
		try 
		{
			//try to connect to the database
            Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
            Connection c = DriverManager.getConnection("jdbc:odbc:mobbs", "mobbs", "mobbs");
            Statement s = c.createStatement();
            //Attepmt to update the file in the database
           	s.executeUpdate("UPDATE Files SET status='" + status + "' WHERE fileid='" + filename + "'");
           	//End the connection to the database
			c.close();
        }
		catch(Exception e)
		{
			//Catch exceptions
			//Most likely here because the file doesn't exist
            e.printStackTrace();
        }
	}

	/**
	 * Get the status of a file from the database
	 * @param filename the file to get
	 * @return the status of the file
     */
	public static int getFileStatus(String filename)
	{
		//Default status incase of an error
		int status = -2;
		try 
		{
			//attempt to connect to the database
            Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
            Connection c = DriverManager.getConnection("jdbc:odbc:mobbs", "mobbs", "mobbs");
            Statement s = c.createStatement();
            //get the file from the database
            ResultSet r = s.executeQuery("SELECT status FROM Files WHERE fileid='" + filename + "'");

			//Get the status from the file
            while (r.next())            
            	status = r.getInt("status");
            //Close the connection
           	c.close();
        }
		catch(Exception e)
		{
			//Exception was caught
			//Probably because the file doesn't exist
            e.printStackTrace();
        }
		//Return the status of the file
		return status;
	}

	/**
	 * The initial uploading of the files to the database
	 */
	public static void initialLoadFilestoDB()
	{
		try
		{
			//Try to connect to the database
			  Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
	          Connection c = DriverManager.getConnection("jdbc:odbc:mobbs", "mobbs", "mobbs");
	          Statement s = c.createStatement();
			//Get the files content
			  FileInputStream fstream = new FileInputStream("apps.txt");
			  DataInputStream in = new DataInputStream(fstream);
			  BufferedReader br = new BufferedReader(new InputStreamReader(in));
			  String strLine;
			  //Read File Line By Line
			  while ((strLine = br.readLine()) != null)
			  {
				  //Upload the content to the database
		           s.execute("INSERT into Files (fileid, status) VALUES('" +	strLine + "', '" + 0 + "')"); 
			  }
				//Close the file "connection"
			  in.close();
			}
			catch (Exception e)
			{//Catch exception if any
				  System.err.println("Error: " + e.getMessage());
		}
	}


	/**
	 * Get all reviews from a file
	 */
	public static void getAllReview()
	{
		//Setup arraylist
		ArrayList<String> files = new ArrayList<String>();
		ArrayList<Review> revs = new ArrayList<Review>();

		try
		{
			//Get dat from files
			  FileInputStream fstream = new FileInputStream("conf/apps.txt");
			  DataInputStream in = new DataInputStream(fstream);
			  BufferedReader br = new BufferedReader(new InputStreamReader(in));
			  String strLine;
			  //Read File Line By Line
			  while ((strLine = br.readLine()) != null)   
				  files.add(strLine); //Get the data and add to arraylist
				  //Close the input stream
			  in.close();
			}
			catch (Exception e)
			{//Catch exception if any
				  System.err.println("Error: " + e.getMessage());
		}
		
		//Loop through all files
		for (String fileName : files)
		{
			
			try
			{
				//try to open the files
			  FileInputStream fstream = new FileInputStream("output/f_" + fileName + ".txt");
			  DataInputStream in = new DataInputStream(fstream);
			  BufferedReader br = new BufferedReader(new InputStreamReader(in));
			  String strLine;
			  //Read File Line By Line
			  while ((strLine = br.readLine()) != null)
			  {
				  //setup a review for the file
				  Review r = new Review();
				  r.setAppid(fileName);
				  r.setDate(strLine.split("&&&")[0]);
				  r.setRate(strLine.split("&&&")[1]);
				  r.setDevice(strLine.split("&&&")[2]);
				  r.setVersion(strLine.split("&&&")[3]);
				  r.setTitle(strLine.split("&&&")[4]);
				  if (strLine.split("&&&").length == 6)
					  r.setText(strLine.split("&&&")[5]);
				  else
					  r.setText("");
				 //add the review to the arraylist
				  revs.add(r);
			  }
			//Close the connection to the file
			  in.close();
			}
			catch (Exception e)
			{//Catch exception if any
				  System.err.println("Error: " + e.toString());
			}
		}
		
	
		 try
		 {
			 //Writing back to the file
			  FileWriter fstream = new FileWriter("conf/revs.txt");
	    	  BufferedWriter out = new BufferedWriter(fstream);
			 //loop through all reviews
    		  for (Review r : revs)
	    	  {
				  //send the reviews to the file
    			  System.out.println(r.getDevice());
				  out.write(r.getAppid() + "	" + r.getTitle() + "	"+  r.getDevice() + "	" + r.getVersion() + "	" + r.getDate());
				  out.newLine();
			  }
			  //close the file
			  out.close();
		  }
		 catch (Exception e)
		 {//Catch exception if any
			  System.err.println("Error: " + e.getMessage());
		 }
		
	}

	/**
	 * Run this section of the app
	 * @param args user defined arguments
     */
	public static void main(String[] args)
	{
		//Setup fules array list
		ArrayList<String> files = new ArrayList<String>();

		try
		{
			//open file connection
			  FileInputStream fstream = new FileInputStream("conf/apps.txt");
			  DataInputStream in = new DataInputStream(fstream);
			  BufferedReader br = new BufferedReader(new InputStreamReader(in));
			  String strLine;
			  //Read File Line By Line
			  while ((strLine = br.readLine()) != null)   
				  files.add(strLine);
				  //Close the input stream
			  in.close();
			}
			catch (Exception e)
			{//Catch exception if any
				  System.err.println("Error: " + e.getMessage());
		}
		
		//Loop through all files
		for (String fileName : files)
		{
			//Print the file name to the debug console
			System.out.println(fileName);
				try
				{
					//read the files data
				  FileInputStream fstream = new FileInputStream("output/f_" + fileName + ".txt");
				  DataInputStream in = new DataInputStream(fstream);
				  BufferedReader br = new BufferedReader(new InputStreamReader(in));
				  String strLine;
				  int index = 0;
				  //Read File Line By Line
				  while ((strLine = br.readLine()) != null)
				  {
					  //Create a review for the file
					  Review r = new Review();
					  r.setAppid(fileName);
					  r.setDate(strLine.split("&&&")[0]);
					  r.setRate(strLine.split("&&&")[1]);
					  r.setDevice(strLine.split("&&&")[2].replace("'", " "));
					  r.setVersion(strLine.split("&&&")[3]);
					  r.setTitle(strLine.split("&&&")[4]);
					  if (strLine.split("&&&").length == 6)
						  r.setText(strLine.split("&&&")[5]);
					  else
						  r.setText("");
					  //Add the review to the database
					  DBStoring.updateReview(fileName, Integer.toString(index), r.getDevice());
					  index++;
				  }
				//Close the file
				  in.close();
				}
				catch (Exception e)
				{//Catch exception if any
					  System.err.println("Error: " + e.toString());
				}
		}
		
	
	}
	
	
	
		
}
