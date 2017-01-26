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
import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import objs.AppRevCode;
import objs.Application;
import objs.Review;



public class DBQuerying 
{
	
	/**
         * @return Return Total number of codes
         */
	public static int getTotalCodes()
	{
		{
			int total = 0;
			try
			{
				 Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
		         Connection c = DriverManager.getConnection("jdbc:odbc:mobbs", "mobbs", "mobbs");
		         Statement s = c.createStatement();
		         ResultSet r = s.executeQuery("SELECT * FROM Codes");;
		         
		         while (r.next())
		        	 total++;
		         c.close();
			}
			catch (Exception e)
			{
				e.printStackTrace();
			}
			
			return total;
		}
	}
        
        /**
         * @param appid ID of app
         * @return Return Total number of codes for app
         */
	public static int getTotalCodesForApp(String appid)
	{
		{
			int total = 0;
			try
			{
				 Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
		         Connection c = DriverManager.getConnection("jdbc:odbc:mobbs", "mobbs", "mobbs");
		         Statement s = c.createStatement();
		         ResultSet r = s.executeQuery("SELECT * FROM Codes WHERE appid='" + appid + "'");;
		         
		         while (r.next())
		        	 total++;
		         c.close();
			}
			catch (Exception e)
			{
				e.printStackTrace();
			}
			
			return total;
		}
	}
	
        /**
         * @param classcode Code of class
         * @return Return Total number of class codes
         */
	public static int getTotalClassCode(String classcode)
	{
		int total = 0;
		try
		{
			 Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
	         Connection c = DriverManager.getConnection("jdbc:odbc:mobbs", "mobbs", "mobbs");
	         Statement s = c.createStatement();
	         ResultSet r = s.executeQuery("SELECT * FROM Codes WHERE codeclass='" + classcode + "'");;
	         //c.close();
	         
	         while (r.next())
	        	 total++;
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		
		return total;
	}
	
        /**
         * @param classcode Code of class
         * @param refcode Code of ref
         * @return Return Total number of ref codes
         */
	public static int getTotalRefCode(String classcode, String refcode)
	{
		int total = 0;
		try
		{
			 Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
	         Connection c = DriverManager.getConnection("jdbc:odbc:mobbs", "mobbs", "mobbs");
	         Statement s = c.createStatement();
	         ResultSet r = s.executeQuery("SELECT * FROM Codes WHERE codeclass='" + classcode + "' AND refinedcode='" + refcode + "'");;
	         //c.close();
	         
	         while (r.next())
	        	 total++;
	         c.close();
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		
		return total;
	}
	
	/**
         * @param cat Chosen Category
         * @return Returns all apps from a category cat
         */
	public static ResultSet getAppsForCat(String cat)
	{
		try
		{
			 Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
	         Connection c = DriverManager.getConnection("jdbc:odbc:mobbs", "mobbs", "mobbs");
	         Statement s = c.createStatement();
	         ResultSet r = s.executeQuery("SELECT * FROM Apps WHERE Cat='" + cat + "'");;
	         //c.close();
	         return r;
		}
		catch (Exception e)
		{
			e.printStackTrace();
			return null;
		}
	}
	
	/**
         * @param i int for lowest range
         * @param j int for highest range
         * @return Returns all apps which have the no of rates assigned to them between i anf j
         */
	public static ArrayList<String> getAppsForNoRatesRange(int i, int j)
	{
		
		ArrayList<String> apps = new ArrayList<String>();
System.out.println(i + "  " + j);		
		try
		{
			 Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
	         Connection c = DriverManager.getConnection("jdbc:odbc:mobbs", "mobbs", "mobbs");
	         Statement s = c.createStatement();
	         
	         ResultSet r = s.executeQuery("SELECT * FROM Apps");
	         
	         while (r.next())
	         {
	        	 int norates = r.getInt("Norates");
	        	 if ((norates >= i) && (norates < j))
	        	 {
	        		 String appid = r.getString("ID");
	        		 if (isCoded(appid))
	        			 apps.add(appid);
	        	 }
	         }
	         
	         
	         //c.close();
	         return apps;
		}
		catch (Exception e)
		{
			e.printStackTrace();
			return null;
		}
	}
        
        /**
         * @param i int for lowest range
         * @param j int for highest range
         * @return Returns all apps which cost more than i, but less than j
         */
	public static ArrayList<String> getAppsForPriceRange(double i, double j)
	{//!!!! optimize
		
		ArrayList<String> apps = new ArrayList<String>();
		
		try
		{
			 Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
	         Connection c = DriverManager.getConnection("jdbc:odbc:mobbs", "mobbs", "mobbs");
	         Statement s = c.createStatement();
	         
	         ResultSet r = s.executeQuery("SELECT * FROM Apps");
	         
	         while (r.next())
	         {
	        	 double price = r.getDouble("Price");
	        	 if ((price >= i) && (price < j))
	        	 {
	        		 String appid = r.getString("ID");
	        		 if (isCoded(appid))
	        			 apps.add(appid);
	        	 }
	         }
	         
	         
	         //c.close();
	         return apps;
		}
		catch (Exception e)
		{
			e.printStackTrace();
			return null;
		}
	}
	
        /**
         * @param i int for lowest range
         * @param j int for highest range
         * @return Returns all apps which cost more than i, but less than j
         */
	public static int getTotalAppsForPriceRange(double i, double j)
	{//!!!! optimize
		
		ArrayList<String> apps = new ArrayList<String>();
		
		try
		{
			 Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
	         Connection c = DriverManager.getConnection("jdbc:odbc:mobbs", "mobbs", "mobbs");
	         Statement s = c.createStatement();
	         
	         ResultSet r = s.executeQuery("SELECT * FROM Apps");
	         
	         while (r.next())
	         {
	        	 double price = r.getDouble("Price");
	        	 if ((price >= i) && (price < j))
	        	 {
	        		 String appid = r.getString("ID");
	        		 if (isCoded(appid))
	        			 apps.add(appid);
	        	 }
	         }
	         
	         
	         //c.close();
	         return apps.size();
		}
		catch (Exception e)
		{
			e.printStackTrace();
			return 0;
		}
	}
	
        /**
         * @param i int for lowest range
         * @param j int for highest range
         * @return Returns all apps which cost more than i, but less than j
         */
	public static ArrayList<String> getAppsForRateRange(int i, int j)
	{//!!!! optimize
		
		ArrayList<String> apps = new ArrayList<String>();
		
		try
		{
			 Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
	         Connection c = DriverManager.getConnection("jdbc:odbc:mobbs", "mobbs", "mobbs");
	         Statement s = c.createStatement();
	         
	         ResultSet r = s.executeQuery("SELECT * FROM Apps");
	         
	         while (r.next())
	         {
	        	 double rate = r.getDouble("Rate");
	        	 if ((rate > i) && (rate <= j))
	        	 {
	        		 String appid = r.getString("ID");
	        		 if (isCoded(appid))
	        			 apps.add(appid);
	        	 }
	         }
	         
	         
	         //c.close();
	         return apps;
		}
		catch (Exception e)
		{
			e.printStackTrace();
			return null;
		}
	}
	
        /**
         * @param i int for lowest range
         * @param j int for highest range
         * @return Returns all apps which cost more than i, but less than j
         */
	public static int getTotalAppsForRateRange(int i, int j)
	{//!!!! optimize
		
		ArrayList<String> apps = new ArrayList<String>();
		
		try
		{
			 Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
	         Connection c = DriverManager.getConnection("jdbc:odbc:mobbs", "mobbs", "mobbs");
	         Statement s = c.createStatement();
	         
	         ResultSet r = s.executeQuery("SELECT * FROM Apps");
	         
	         while (r.next())
	         {
	        	 double rate = r.getDouble("Rate");
	        	 if ((rate > i) && (rate <= j))
	        	 {
	        		 String appid = r.getString("ID");
	        		 if (isCoded(appid))
	        			 apps.add(appid);
	        	 }
	         }
	         
	         
	         //c.close();
	         return apps.size();
		}
		catch (Exception e)
		{
			e.printStackTrace();
			return 0;
		}
	}
	
        /**
         * @param codeType Type of code
         * @param code Current code
         * @return Returns the no of reviews coded with class code codetype and refined code code
         */
	public static int getTotalCodesOverallFeedback(String codeType, String code)
	{
		int total = 0;
		
		try
		{
			 Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
	         Connection c = DriverManager.getConnection("jdbc:odbc:mobbs", "mobbs", "mobbs");
	         Statement s = c.createStatement();
	         
	         ResultSet r = s.executeQuery("SELECT * FROM Codes WHERE codeclass='" + codeType + "' AND refinedcode='" + code + "'" );

	         while (r.next())  
       			 total++;
	         
	         c.close();
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		
		return total;
	}
	
        /**
         * @param codeType Type of code
         * @param code Current code
         * @param appid ID of app
         * @return Returns the no of reviews coded with class code codetype and refined code code
         */
	public static int getTotalCodesPerApp(String codeType, String code, String appid)
	{
		int total = 0;
		
		try
		{
			 Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
	         Connection c = DriverManager.getConnection("jdbc:odbc:mobbs", "mobbs", "mobbs");
	         Statement s = c.createStatement();
	         
	         ResultSet r = s.executeQuery("SELECT * FROM Codes WHERE appid='" + appid + "' AND codeclass='" + codeType + "' AND refinedcode='" + code + "'" );

	         while (r.next())  
        		 total++;
	        	 
	         
	         c.close();
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		
		return total;
	}
	
        /**
         * @param codeType Type of code
         * @param appid ID of app
         * @return Returns the no of reviews coded with class code codetype and refined code code
         */
	public static int getTotalClassCodesPerApp(String codeType, String appid)
	{
		int total = 0;
		
		try
		{
			 Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
	         Connection c = DriverManager.getConnection("jdbc:odbc:mobbs", "mobbs", "mobbs");
	         Statement s = c.createStatement();
	         
	         ResultSet r = s.executeQuery("SELECT * FROM Codes WHERE appid='" + appid + "' AND codeclass='" + codeType + "'" );

	         while (r.next())  
        		 total++;
	        	 
	         
	         c.close();
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		
		return total;
	}
        
        /**
         * @param list String list
         * @return Return list of codes
         */
	public static ArrayList<String> getArrayList(String[] list)
	{
		ArrayList<String> codes = new ArrayList<String>();
		int i = 0;
		while (list[i] != null)
		{
			codes.add(list[i]);
			i++;
		}
		return codes;
	}
	
        /**
         * @param appid ID of app
         * @return return Total revs for app
         */
	public static int getTotalRevsForApp(String appid)
	{
		int total = 0;
		try
		{
			 Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
	         Connection c = DriverManager.getConnection("jdbc:odbc:mobbs", "mobbs", "mobbs");
	         Statement s = c.createStatement();
	         ResultSet r = s.executeQuery("SELECT * FROM Norevs WHERE appid='" + appid + "'");;
	         
	         while (r.next())
	        	 if (isCoded(r.getString("appid")))
	        			 total = r.getInt("norevs");
	         
	         c.close();
	        
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		return total;
	}
	
        /**
         * @return Return Array List of apps
         */
	public static ArrayList<String> getAppsCoded()
	{
		ArrayList<String> apps = new ArrayList<String>();
		try
		{
			 Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
	         Connection c = DriverManager.getConnection("jdbc:odbc:mobbs", "mobbs", "mobbs");
	         Statement s = c.createStatement();
	         
	         ResultSet r = s.executeQuery("SELECT * FROM Files WHERE status <> 0");;
	         
	         while (r.next())
	        	 apps.add(r.getString("fileid"));
	         
	         c.close();
	        
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		return apps;
	}
	
        /**
         * @param appid ID of app
         * @return Return boolean answer to the query 'app is coded'
         */
	public static boolean isCoded(String appid)
	{
		ArrayList<String> apps = getAppsCoded();
		
		for (int i = 0; i < apps.size(); i++)
			if (apps.get(i).equals(appid))
				return true;
		return false;
	}
	
        /**
         * @return Return Total revs
         */
	public static int getTotalRevs()
	{
		int total = 0;
		try
		{
			 Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
	         Connection c = DriverManager.getConnection("jdbc:odbc:mobbs", "mobbs", "mobbs");
	         Statement s = c.createStatement();
	         
	         ResultSet r = s.executeQuery("SELECT * FROM Norevs");;
	         
	         while (r.next())
	         {
	        	 String appid = r.getString("appid");
	        	 int totalc = r.getInt("norevs");
	        	 if (isCoded(appid))
	        	 {
	        		 total += totalc;
	        	 }
	         }
	         
	         c.close();
	        
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		return total;
	
	}
	
        /**
         * @param a1 String a1 class code
         * @param a2 String a2 class code
         * @param b1 String b1 class code
         * @param b2 String b2 ref code
         * @return Return the number of revs encoded with both codes (a1, a2) and (b1, b2), where a1, b1 and a2 are the class code, code ref b2
         */
	public static int getNoCodeSeqs(String a1, String a2, String b1, String b2)
	{
		ArrayList<AppRevCode> revs = new ArrayList<AppRevCode>();
        int total = 0;
		
		try
		{
			 Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
	         Connection c = DriverManager.getConnection("jdbc:odbc:mobbs", "mobbs", "mobbs");
	         Statement s = c.createStatement();
	         
      
	         ResultSet r = s.executeQuery("SELECT * FROM Codes WHERE (codeclass='" + a1 + "' AND refinedcode='" + a2 + "') OR (codeclass = '" + b1 + "' AND refinedcode='" + b2 + "')");
	         
	         while (r.next())
	        	 revs.add(new AppRevCode(r.getString("appid"), r.getString("revid"), r.getString("codeclass"), r.getString("refinedcode")));
	         
	         
	         
	         for (int i = 0; i < revs.size() - 1; i++)
		         for (int j = i + 1; j < revs.size(); j++)
		        	 if ((revs.get(i).getAppid() != null) && (revs.get(j).getAppid() != null))
		        	 if ( (revs.get(i).getAppid().equals(revs.get(j).getAppid()) ) && ( 
		        		  (revs.get(i).getRevid().equals(revs.get(j).getRevid()))))
		        		 if ((      (revs.get(i).getClasscode().equals(a1))  && (revs.get(i).getRefcode().equals(a2)) 
		        		 		&& (revs.get(j).getClasscode().equals(b1))  && (revs.get(j).getRefcode().equals(b2))) ||
		        		 		(          (revs.get(i).getClasscode().equals(b1))  && (revs.get(i).getRefcode().equals(b2)) 
				        		 		&& (revs.get(j).getClasscode().equals(a1))  && (revs.get(j).getRefcode().equals(a2))   ))
		        		 			total++;
	         c.close();

		 	        
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		return total;
		
	}
	
        /**
         * @param dev dev name
         * @return Returns all reviews which have the device dev
         */
	public static int getTotalCodesForDevice(String dev)
	{
		ArrayList<Review> ret = new ArrayList<Review>();
		int total = 0;
		try
		{
			 Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
	         Connection c = DriverManager.getConnection("jdbc:odbc:mobbs", "mobbs", "mobbs");
	         Statement s = c.createStatement();
	         
	         ResultSet r = s.executeQuery("SELECT * FROM Codes WHERE device= '" + dev + "'");;
	         
	         while (r.next())
	        	 total++;
	         
	         c.close();
	        
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		return total;
	}
        
        /**
         * @param dev dev name
         * @param cc cc name
         * @param refcode code of ref
         * @return Returns all reviews which have the device dev
         */
	public static int getAllRevsForDeviceWithCodes(String dev, String cc, String refcode)
	{
		ArrayList<Review> ret = new ArrayList<Review>();
		int total = 0;
		try
		{
			 Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
	         Connection c = DriverManager.getConnection("jdbc:odbc:mobbs", "mobbs", "mobbs");
	         Statement s = c.createStatement();
	         
	         ResultSet r = s.executeQuery("SELECT * FROM Codes WHERE device= '" + dev + "' AND codeclass='" + cc + "' AND refinedcode='" + refcode + "'");;
	         
	         while (r.next())
	        	 total++;
	         
	         c.close();
	        
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		return total;
	}

	/**
         * @param appid ID of app
         * @return Returns all revs for an app
         */
	public static ArrayList<Review> getAllRevsForApp(String appid)
	{
		ArrayList<Review> revs = new ArrayList<Review>();
		
		try
		{
			 Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
	         Connection c = DriverManager.getConnection("jdbc:odbc:mobbs", "mobbs", "mobbs");
	         Statement s = c.createStatement();
	         
	         ResultSet r = s.executeQuery("SELECT * FROM Codes WHERE appid= '" + appid + "'");;
	         
	         while (r.next())
	         {
	        	 Review rv = new Review();
	        	 rv.setAppid(appid);
	        	 rv.setRevid(r.getString("revid"));
	        	 revs.add(rv);
	         }
	         c.close();
	        
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		
				
		return revs;
	}
	
	/**
         * @return Returns apps in array list
         */
	public static ArrayList<Application> getApps()
	{
		ArrayList<Application> apps = new ArrayList<Application>();
		try
		{
			 Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
	         Connection c = DriverManager.getConnection("jdbc:odbc:mobbs", "mobbs", "mobbs");
	         Statement s = c.createStatement();
	         
	         ResultSet r = s.executeQuery("SELECT * FROM Apps");;
	         
	         while (r.next())
	         {
	        	 String appid = r.getString("ID");
	        	 if (isCoded(appid))
	        	 {
	        		 Application app = new Application();
	        		 app.setId(appid);
	        		 app.setRating(Double.valueOf(r.getDouble("Rate")));
	        		 app.setPrice(Double.valueOf(r.getDouble("Price")));
	        		 app.setNorates(Double.valueOf(r.getDouble("Norates")));
	        		 apps.add(app);
	        	 }
	         }
	         c.close();
	        
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		
		return apps;
	}

}




























