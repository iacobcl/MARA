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


public class DBStoring 
{
        /**
         * @param appid ID of app
         * @param revid ID of rev
         * @param title title name
         * @param review review name
         * @param codeclass code of class
         * @param refcode code of ref
         * @param rawcode code of raw
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
         * @param appid ID of app
         * @param revid ID of rev
         * @param device device name
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
         * @param appid ID of app
         * @param title name of title
         * @param device name of device
         * @param version version identifier
         * @param date date identifier
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
         * @return Returns array list of files
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
         * @param filename name of file
         * @param status int display of status
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
         * @param filename name of file
         * @return Return status of file
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
         * @param args Array of string arguments
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
