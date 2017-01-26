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
 * Class DBStoring - used for inserting data into database
 * 
 * @author iacobcl
 */
public class DBStoring 
{
    
	/**
     * inserts data of application review code in database
     * 
     * @param appid application ID
     * @param revid review ID
     * @param title
     * @param review review of application
     * @param codeclass code
     * @param refcode
     * @param rawcode 
     */
	public static void insertCode (String appid, String revid, String title, String review, String codeclass, String refcode, String rawcode)
	{
		
		try 
		{
            Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
            Connection c = DriverManager.getConnection("jdbc:odbc:mobbs", "mobbs", "mobbs");
            Statement s = c.createStatement();
            
            s.execute("insert into Codes (appid, revid, title, review, codeclass, refinedcode, rawcode) values('" +	appid + "', '" + revid + "', '" + title + "', '" + review + "', '" + codeclass + "', '" + refcode + "', '" + rawcode + "')"); 
            c.close();	
        }
		catch(Exception e)
		{
            e.printStackTrace();
        }
	}

    /**
     * changes device in code table for application review
     * 
     * @param appid application ID
     * @param revid review ID
     * @param device
     */
	public static void updateReview(String appid, String revid, String device)
	{
		try 
		{
            Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
            Connection c = DriverManager.getConnection("jdbc:odbc:mobbs", "mobbs", "mobbs");
            Statement s = c.createStatement();
            
            s.execute("UPDATE Codes SET device='" + device + "' WHERE appid='" + appid + "' AND revid='" + revid + "'"); 
            c.close();	
        }
		catch(Exception e)
		{
            e.printStackTrace();
        }
	}
	
    /**
     * insert review record to database
     * 
     * @param appid application ID
     * @param title
     * @param device
     * @param version
     * @param date 
     */
	public static void insertRev (String appid, String title, String device, String version, String date)
	{
		
		try 
		{
            Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
            Connection c = DriverManager.getConnection("jdbc:odbc:mobbs", "mobbs", "mobbs");
            Statement s = c.createStatement();
            
            s.execute("insert into Revs (appid, title, device, version, date) values('" +	appid + "', '" + title + "', '" + device + "', '" + version + "', '" + date + "')"); 
            c.close();	
        }
		catch(Exception e)
		{
            e.printStackTrace();
        }
	}

    /**
     * gets all Files in file table
     * 
     * @return files from File table
     */
	public static ArrayList<File> getFiles()
	{
		
		ArrayList<File> files = new ArrayList<File>();
	
		try 
		{
            Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
            Connection c = DriverManager.getConnection("jdbc:odbc:mobbs", "mobbs", "mobbs");
            Statement s = c.createStatement();
            
            ResultSet r = s.executeQuery("SELECT * from Files");
            
            while (r.next())
            	files.add(new File(r.getString("fileid"), r.getInt("status")));
           	
            c.close();
        }
		catch(Exception e)
		{
            e.printStackTrace();
        }
		
		return files;
	}
	
	/**
     * changes file status
     * 
     * @param filename name of file to change status
     * @param status updated status for file
     */
	public static void setFileStatus(String filename, int status)
	{
		try 
		{
            Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
            Connection c = DriverManager.getConnection("jdbc:odbc:mobbs", "mobbs", "mobbs");
            Statement s = c.createStatement();
            
           	s.executeUpdate("UPDATE Files SET status='" + status + "' WHERE fileid='" + filename + "'");
           	c.close();
        }
		catch(Exception e)
		{
            e.printStackTrace();
        }
	}

    /**
     * searches for file and gets status
     * @param filename - name of file to search for
     * @return status of file
     */
	public static int getFileStatus(String filename)
	{
		int status = -2;
		try 
		{
            Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
            Connection c = DriverManager.getConnection("jdbc:odbc:mobbs", "mobbs", "mobbs");
            Statement s = c.createStatement();
            
            ResultSet r = s.executeQuery("SELECT status FROM Files WHERE fileid='" + filename + "'");
            
            while (r.next())            
            	status = r.getInt("status");
            
           	
           	c.close();
        }
		catch(Exception e)
		{
            e.printStackTrace();
        }
		
		return status;
	}
	
    /**
     * insert all application names from apps.txt to Files and give them all 0 status
     */
	public static void initialLoadFilestoDB()
	{
		try
		{
			  Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
	          Connection c = DriverManager.getConnection("jdbc:odbc:mobbs", "mobbs", "mobbs");
	          Statement s = c.createStatement();
			
			
			  FileInputStream fstream = new FileInputStream("apps.txt");
			  DataInputStream in = new DataInputStream(fstream);
			  BufferedReader br = new BufferedReader(new InputStreamReader(in));
			  String strLine;
			  //Read File Line By Line
			  while ((strLine = br.readLine()) != null)
			  {
		           s.execute("INSERT into Files (fileid, status) VALUES('" +	strLine + "', '" + 0 + "')"); 
			  }

			  in.close();
			}
			catch (Exception e)
			{//Catch exception if any
				  System.err.println("Error: " + e.getMessage());
		}
	}
	
	
	/**
     * For each application create review and outputs review to conf/revs.txt
     */
	public static void getAllReview()
	{
		ArrayList<String> files = new ArrayList<String>();
		ArrayList<Review> revs = new ArrayList<Review>();

		try
		{
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
		
		
		for (String fileName : files)
		{
			
				try
				{
				  FileInputStream fstream = new FileInputStream("output/f_" + fileName + ".txt");
				  DataInputStream in = new DataInputStream(fstream);
				  BufferedReader br = new BufferedReader(new InputStreamReader(in));
				  String strLine;
				  //Read File Line By Line
				  while ((strLine = br.readLine()) != null)
				  {
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
					 
					  revs.add(r);
				  }
				
				  in.close();
				}
				catch (Exception e)
				{//Catch exception if any
					  System.err.println("Error: " + e.toString());
				}
		}
		
	
		 try
		 {
			  FileWriter fstream = new FileWriter("conf/revs.txt");
	    	  BufferedWriter out = new BufferedWriter(fstream);
    		  for (Review r : revs)
	    	  {
    			  System.out.println(r.getDevice());		
    			  
						out.write(r.getAppid() + "	" + r.getTitle() + "	"+  r.getDevice() + "	" + r.getVersion() + "	" + r.getDate());
						out.newLine();
			  }
			  			  
			  out.close();
		  }
		 catch (Exception e)
		 {//Catch exception if any
			  System.err.println("Error: " + e.getMessage());
		 }
		
	}
	
	/**
     * For every application in conf/apps.txt, update review on database
     * 
     * @param args 
     */
	public static void main(String[] args)
	{
		ArrayList<String> files = new ArrayList<String>();

		try
		{
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
		
		
		for (String fileName : files)
		{
			System.out.println(fileName);
				try
				{
				  FileInputStream fstream = new FileInputStream("output/f_" + fileName + ".txt");
				  DataInputStream in = new DataInputStream(fstream);
				  BufferedReader br = new BufferedReader(new InputStreamReader(in));
				  String strLine;
				  int index = 0;
				  //Read File Line By Line
				  while ((strLine = br.readLine()) != null)
				  {
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
					  
					  DBStoring.updateReview(fileName, Integer.toString(index), r.getDevice());
					  index++;
				  }
				
				  in.close();
				}
				catch (Exception e)
				{//Catch exception if any
					  System.err.println("Error: " + e.toString());
				}
		}
		
	
	}
	
	
	
		
}
