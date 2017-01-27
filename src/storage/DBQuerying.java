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

/**
 * Deals with querying the database to manipulate/get specific data within the database
 */
public class DBQuerying 
{

	/**
	 * Get the total number of code stored within the database
	 * @return Int, the number of code that is in the database
     */
	public static int getTotalCodes()
	{
		{
			int total = 0;
			try
			{
				//Try to connect to the database
				 Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
		         Connection c = DriverManager.getConnection("jdbc:odbc:mobbs", "mobbs", "mobbs");
		         Statement s = c.createStatement();
		         ResultSet r = s.executeQuery("SELECT * FROM Codes");//Run the query
		         
		         while (r.next())
		        	 total++;
		         c.close();//Close the connection to the database
			}
			catch (Exception e)
			{
				//Something threw an error if we got here
				e.printStackTrace();
			}
			//Return the total amount of code
			return total;
		}
	}

	/**
	 * Get the total amount of code for a specific application
	 * @param appid The app to check
	 * @return int, The total amount of code for tha application
     */
	public static int getTotalCodesForApp(String appid)
	{
		{
			int total = 0;
			try
			{
				//Try to connect to the database
				 Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
		         Connection c = DriverManager.getConnection("jdbc:odbc:mobbs", "mobbs", "mobbs");
		         Statement s = c.createStatement();
				//Run the query to get our values
		         ResultSet r = s.executeQuery("SELECT * FROM Codes WHERE appid='" + appid + "'");;
		         
		         while (r.next())
					 //Count the number of codes
		        	 total++;
		         c.close(); //Close the connection to the database
			}
			catch (Exception e)
			{
				//Something threw an error
				e.printStackTrace();
			}
			//Return the number of codes for the application
			return total;
		}
	}

	/**
	 * Get the total number of codes for a specific class
	 * @param classcode The class we want to get code from
	 * @return the total number of codes within the class
     */
	public static int getTotalClassCode(String classcode)
	{
		int total = 0;
		try
		{
			//Try to connect to the database
			 Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
	         Connection c = DriverManager.getConnection("jdbc:odbc:mobbs", "mobbs", "mobbs");
	         Statement s = c.createStatement();
			//Run our query
	         ResultSet r = s.executeQuery("SELECT * FROM Codes WHERE codeclass='" + classcode + "'");;
	         
	         while (r.next())
				 //Count the number of codes in a class
	        	 total++;
			 c.close(); //Close the connection to the database
		}
		catch (Exception e)
		{
			//Something threw an error
			e.printStackTrace();
		}
		//Return the number of codes within the class
		return total;
	}

	/**
	 * Get the amount of refined code for a class
	 * @param classcode The class code to compare
	 * @param refcode the refined code
     * @return The total number of refined codes
     */
	public static int getTotalRefCode(String classcode, String refcode)
	{
		int total = 0;
		try
		{
			//Try to connect to the database
			 Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
	         Connection c = DriverManager.getConnection("jdbc:odbc:mobbs", "mobbs", "mobbs");
	         Statement s = c.createStatement();
			//Run the query
	         ResultSet r = s.executeQuery("SELECT * FROM Codes WHERE codeclass='" + classcode + "' AND refinedcode='" + refcode + "'");;
	         
	         while (r.next())
				 //Count the total number of refined codes
	        	 total++;
	         c.close();//Close the connection to the database
		}
		catch (Exception e)
		{
			//An error was thrown
			e.printStackTrace();
		}
		//Return the total number of refined codes
		return total;
	}

	/**
	 * Get the applications for a category
	 * @param cat The category to check
	 * @return a set of applications
     */
	public static ResultSet getAppsForCat(String cat)
	{//returns all apps from a category cat
		try
		{
			//Try to connect to the database
			 Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
	         Connection c = DriverManager.getConnection("jdbc:odbc:mobbs", "mobbs", "mobbs");
	         Statement s = c.createStatement();
			//Run the query
	         ResultSet r = s.executeQuery("SELECT * FROM Apps WHERE Cat='" + cat + "'");
	         //c.close();
	         return r; //Return the set
		}
		catch (Exception e)
		{
			//Something threw an error
			e.printStackTrace();
			return null; //Return null as an error occurred
		}
	}

	/**
	 * returns all apps which have the no of rates assigned to them between i anf j
	 * @param i minimum int
	 * @param j maximum int
     * @return the apps within the range
     */
	public static ArrayList<String> getAppsForNoRatesRange(int i, int j)
	{
		//setup the output ArrayList
		ArrayList<String> apps = new ArrayList<String>();
		System.out.println(i + "  " + j);	 //print the range to the debug console
		try
		{
			//Try to connect to the database
			 Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
	         Connection c = DriverManager.getConnection("jdbc:odbc:mobbs", "mobbs", "mobbs");
	         Statement s = c.createStatement();
	         //Run the query
	         ResultSet r = s.executeQuery("SELECT * FROM Apps");

			//Loop through all apps
	         while (r.next())
	         {
	        	 int norates = r.getInt("Norates");
				 //Check if the number or rates of the app is within the range
	        	 if ((norates >= i) && (norates < j))
	        	 {
	        		 String appid = r.getString("ID");
	        		 if (isCoded(appid))
						 //Add the app to the ArrayList
	        			 apps.add(appid);
	        	 }
	         }
	         //c.close();
	         return apps; //Return the ArrayList of apps
		}
		catch (Exception e)
		{
			//An error was thrown
			e.printStackTrace();
			return null;
		}
	}

	/**
	 * returns all apps which cost more than i, but less than j
	 * @param i The minimum Int
	 * @param j the maximum int
     * @return an ArrayList of apps within the range
	 *
	 * Requires Optimization
     */
	public static ArrayList<String> getAppsForPriceRange(double i, double j)
	{

		//Setup the ArrayList that will be returned
		ArrayList<String> apps = new ArrayList<String>();
		
		try
		{
			//Try to connect to the database
			 Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
	         Connection c = DriverManager.getConnection("jdbc:odbc:mobbs", "mobbs", "mobbs");
	         Statement s = c.createStatement();
	         //Run the query
	         ResultSet r = s.executeQuery("SELECT * FROM Apps");

			//Loop through ALL the apps
	         while (r.next())
	         {
	        	 double price = r.getDouble("Price");
				 //Check if the apps are within the range
	        	 if ((price >= i) && (price < j))
	        	 {
	        		 String appid = r.getString("ID");
	        		 if (isCoded(appid))
						 //Add the apps to the ArrayList
	        			 apps.add(appid);
	        	 }
	         }
	         //c.close();
			//Return the ArrayList
	         return apps;
		}
		catch (Exception e)
		{
			//An error was thrown
			e.printStackTrace();
			return null;
		}
	}

	/**
	 * returns all apps which cost more than i, but less than j
	 * @param i the minimum value
	 * @param j the maximum value
     * @return the number of apps within the price range
	 *
	 * Requires Optimization
     */
	public static int getTotalAppsForPriceRange(double i, double j)
	{
		//Setup the ArrayList used to store the apps
		ArrayList<String> apps = new ArrayList<String>();
		
		try
		{
			//Try to connect to the database
			 Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
	         Connection c = DriverManager.getConnection("jdbc:odbc:mobbs", "mobbs", "mobbs");
	         Statement s = c.createStatement();
	         //Run the query
	         ResultSet r = s.executeQuery("SELECT * FROM Apps");

			//Loop through ALL apps
	         while (r.next())
	         {
	        	 double price = r.getDouble("Price");
				 //If the app falls within the range
	        	 if ((price >= i) && (price < j))
	        	 {
	        		 String appid = r.getString("ID");
	        		 if (isCoded(appid))
						 //Add the app to the arraylist
	        			 apps.add(appid);
	        	 }
	         }
	         //c.close();
			//Return the number of apps in the ArrayList
	         return apps.size();
		}
		catch (Exception e)
		{
			//An error was thrown
			e.printStackTrace();
			return 0;
		}
	}

	/**
	 * returns all apps which cost more than i, but less than j
	 * @param i the minimum value
	 * @param j the maximum value
     * @return an ArrayList of apps within the range
	 *
	 * Optimization required!
     */
	public static ArrayList<String> getAppsForRateRange(int i, int j)
	{
		//Setup the arraylist used to store the apps
		ArrayList<String> apps = new ArrayList<String>();
		
		try
		{
			//Try to connect to the database
			 Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
	         Connection c = DriverManager.getConnection("jdbc:odbc:mobbs", "mobbs", "mobbs");
	         Statement s = c.createStatement();
	         //Run the query
	         ResultSet r = s.executeQuery("SELECT * FROM Apps");

			//Loop through ALL apps
	         while (r.next())
	         {
	        	 double rate = r.getDouble("Rate");
				 //If the app falls within the range
	        	 if ((rate > i) && (rate <= j))
	        	 {
	        		 String appid = r.getString("ID");
	        		 if (isCoded(appid))
						 //Add the app to the arraylist
	        			 apps.add(appid);
	        	 }
	         }
	         //c.close();
			//Return the ArrayList
	         return apps;
		}
		catch (Exception e)
		{
			//An error was thrown
			e.printStackTrace();
			return null;
		}
	}

	/**
	 * returns all apps which cost more than i, but less than j
	 * @param i the minimum value
	 * @param j the maximum value
     * @return the number of apps within the range
	 *
	 * Optimization required!
     */
	public static int getTotalAppsForRateRange(int i, int j)
	{
		//setup the arrayList used
		ArrayList<String> apps = new ArrayList<String>();
		
		try
		{
			//Try to connect to the database
			 Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
	         Connection c = DriverManager.getConnection("jdbc:odbc:mobbs", "mobbs", "mobbs");
	         Statement s = c.createStatement();
	         //Run the query
	         ResultSet r = s.executeQuery("SELECT * FROM Apps");

			//Loop through ALL apps
	         while (r.next())
	         {
	        	 double rate = r.getDouble("Rate");
				 //If the app falls within the range
	        	 if ((rate > i) && (rate <= j))
	        	 {
	        		 String appid = r.getString("ID");
	        		 if (isCoded(appid))
						 //Add the app to the ArrayList
	        			 apps.add(appid);
	        	 }
	         }
	         //c.close();
			//Return the number of apps in the array
	         return apps.size();
		}
		catch (Exception e)
		{
			//An error was thrown
			e.printStackTrace();
			return 0;
		}
	}

	/**
	 * For appid, returns the no of reviews coded with class code codetype and refined code code
	 * @param codeType The code type to check
	 * @param code The code to compare
     * @return the number of reviews coded
     */
	public static int getTotalCodesOverallFeedback(String codeType, String code)
	{
		int total = 0;
		try
		{
			//Try to connect to the Database
			 Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
	         Connection c = DriverManager.getConnection("jdbc:odbc:mobbs", "mobbs", "mobbs");
	         Statement s = c.createStatement();
	         //Run the query
	         ResultSet r = s.executeQuery("SELECT * FROM Codes WHERE codeclass='" + codeType + "' AND refinedcode='" + code + "'" );

			//Count the number of codes
	         while (r.next())  
       			 total++;
	         //Close the connection with the database
	         c.close();
		}
		catch (Exception e)
		{
			//An error was thrown
			e.printStackTrace();
		}
		//Return the total number of codes
		return total;
	}

	/**
	 * for appid, returns the no of reviews coded with class code codetype and refined code code in a specific app
	 * @param codeType the class code to be comparing
	 * @param code the code to be checking through
	 * @param appid The app to check
     * @return The number of reviews coded per app
     */
	public static int getTotalCodesPerApp(String codeType, String code, String appid)
	{
		int total = 0;
		
		try
		{
			//Try to connect to the database
			 Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
	         Connection c = DriverManager.getConnection("jdbc:odbc:mobbs", "mobbs", "mobbs");
	         Statement s = c.createStatement();
	         //Run the query
	         ResultSet r = s.executeQuery("SELECT * FROM Codes WHERE appid='" + appid + "' AND codeclass='" + codeType + "' AND refinedcode='" + code + "'" );

			//Count the number for coded reviews
	         while (r.next())  
        		 total++;
			//Close the connection to the database
	         c.close();
		}
		catch (Exception e)
		{
			//An exception was caught
			e.printStackTrace();
		}
		//Return the total number of coded reviews per app
		return total;
	}

	/**
	 * Returns the total number of class codes for a specific app
	 * @param codeType The code type to check
	 * @param appid the app we are checking
     * @return the number of class codes in the app
     */
	public static int getTotalClassCodesPerApp(String codeType, String appid)
	{
		int total = 0;
		
		try
		{
			//Try to connect to the database
			 Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
	         Connection c = DriverManager.getConnection("jdbc:odbc:mobbs", "mobbs", "mobbs");
	         Statement s = c.createStatement();
	         //Run the query
	         ResultSet r = s.executeQuery("SELECT * FROM Codes WHERE appid='" + appid + "' AND codeclass='" + codeType + "'" );

			//Count all the classcodes
	         while (r.next())  
        		 total++;
			 //Close the connection to the database
	         c.close();
		}
		catch (Exception e)
		{
			//An error was thrown
			e.printStackTrace();
		}
		//Return the total number of class codes for the app
		return total;
	}

	/**
	 * Put a list of strings into an ArrayList
	 * @param list the list of Strings
	 * @return The completed ArrayList
     */
	public static ArrayList<String> getArrayList(String[] list)
	{
		//Create the arraylist
		ArrayList<String> codes = new ArrayList<String>();
		int i = 0;
		//Make sure the element exists
		while (list[i] != null)
		{
			//Add the element to the arraylist
			codes.add(list[i]);
			i++;
		}
		//Return the arraylist
		return codes;
	}

	/**
	 * Get the total number of reviews for a specific app
	 * @param appid the app to check
	 * @return the number of reviews for the app
     */
	public static int getTotalRevsForApp(String appid)
	{
		int total = 0;
		try
		{
			//Try to connect to the database
			 Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
	         Connection c = DriverManager.getConnection("jdbc:odbc:mobbs", "mobbs", "mobbs");
	         Statement s = c.createStatement();
			//Run the query
	         ResultSet r = s.executeQuery("SELECT * FROM Norevs WHERE appid='" + appid + "'");;

			//Count the number of reviews in the app
	         while (r.next())
	        	 if (isCoded(r.getString("appid")))
	        			 total = r.getInt("norevs");
	         //Close the connection to the database
	         c.close();
	        
		}
		catch (Exception e)
		{
			//An error was thrown
			e.printStackTrace();
		}
		//return the total number of reviews
		return total;
	}

	/**
	 * Get all apps that are coded
	 * @return An ArrayList of app names
     */
	public static ArrayList<String> getAppsCoded()
	{
		//Setup the arraylist to return
		ArrayList<String> apps = new ArrayList<String>();
		try
		{
			//Try to connect to the database
			 Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
	         Connection c = DriverManager.getConnection("jdbc:odbc:mobbs", "mobbs", "mobbs");
	         Statement s = c.createStatement();
	         //Run the query
	         ResultSet r = s.executeQuery("SELECT * FROM Files WHERE status <> 0");;

			//Add the apps file name to the arraylist
	         while (r.next())
	        	 apps.add(r.getString("fileid"));
	         //close the connection to the database
	         c.close();
	        
		}
		catch (Exception e)
		{
			//an exception was thrown
			e.printStackTrace();
		}
		//Return the arraylist of apps
		return apps;
	}

	/**
	 * Returns if the app has been coded
	 * @param appid The app to check
	 * @return True/False if it is coded
     */
	public static boolean isCoded(String appid)
	{
		//Get the apps
		ArrayList<String> apps = getAppsCoded();

		//Loop through the apps
		for (int i = 0; i < apps.size(); i++)
			//Is the app coded?
			if (apps.get(i).equals(appid))
				return true;
		return false;
	}

	/**
	 * Get the total number of reviews
	 * @return the total number of reviews
     */
	public static int getTotalRevs()
	{
		int total = 0;
		try
		{
			//Try to connect to the database
			 Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
	         Connection c = DriverManager.getConnection("jdbc:odbc:mobbs", "mobbs", "mobbs");
	         Statement s = c.createStatement();
	         //run the query
	         ResultSet r = s.executeQuery("SELECT * FROM Norevs");;

			//Loop through all apps that have reviews
	         while (r.next())
	         {
	        	 String appid = r.getString("appid");
	        	 int totalc = r.getInt("norevs");
	        	 if (isCoded(appid)) //If the app is coded
	        	 {
	        		 total += totalc; //Add the number of reviews to the total
	        	 }
	         }
	         //Close the connection to the database
	         c.close();
	        
		}
		catch (Exception e) {
			//We caught a little exception here...
			e.printStackTrace();
		}
		//Returns how many reviews there are
		return total;
	
	}

	/**
	 * Get the total number of code sequences
	 * @param a1
	 * @param a2
	 * @param b1
	 * @param b2
     * @return the number of CodeSeqs
     */
	public static int getNoCodeSeqs(String a1, String a2, String b1, String b2)
	{//ret numarul de revs codate cu ambele coduri (a1, a2) si (b1, b2), unde a1, b1 sunt class code si a2, b2 ref code
		ArrayList<AppRevCode> revs = new ArrayList<AppRevCode>();
        int total = 0;
		
		try
		{
			//Try to connect to the database
			 Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
	         Connection c = DriverManager.getConnection("jdbc:odbc:mobbs", "mobbs", "mobbs");
	         Statement s = c.createStatement();
      		//Run the query
	         ResultSet r = s.executeQuery("SELECT * FROM Codes WHERE (codeclass='" + a1 + "' AND refinedcode='" + a2 + "') OR (codeclass = '" + b1 + "' AND refinedcode='" + b2 + "')");
	         
	         while (r.next())
	        	 revs.add(new AppRevCode(r.getString("appid"), r.getString("revid"), r.getString("codeclass"), r.getString("refinedcode")));

			//Loop through all reviews
	         for (int i = 0; i < revs.size() - 1; i++)
		         for (int j = i + 1; j < revs.size(); j++)
		        	 if ((revs.get(i).getAppid() != null) && (revs.get(j).getAppid() != null))
		        	 if ( (revs.get(i).getAppid().equals(revs.get(j).getAppid()) ) && ( 
		        		  (revs.get(i).getRevid().equals(revs.get(j).getRevid()))))
		        		 if ((      (revs.get(i).getClasscode().equals(a1))  && (revs.get(i).getRefcode().equals(a2)) 
		        		 		&& (revs.get(j).getClasscode().equals(b1))  && (revs.get(j).getRefcode().equals(b2))) ||
		        		 		(          (revs.get(i).getClasscode().equals(b1))  && (revs.get(i).getRefcode().equals(b2)) 
				        		 		&& (revs.get(j).getClasscode().equals(a1))  && (revs.get(j).getRefcode().equals(a2))   ))
		        		 			total++; //increment the total
	         //Close the connection with the database
			c.close();
		}
		catch (Exception e)
		{
			//Catching bad things here
			e.printStackTrace();
		}
		//Return the total number of codeseqs
		return total;
	}

	/**
	 * Get the total number of codes for a device
	 * @param dev the device
	 * @return The number of codes
     */
	public static int getTotalCodesForDevice(String dev)
	{
		//Setup the array
		ArrayList<Review> ret = new ArrayList<Review>();
		int total = 0;
		try
		{
			//Try to connect to the database
			 Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
	         Connection c = DriverManager.getConnection("jdbc:odbc:mobbs", "mobbs", "mobbs");
	         Statement s = c.createStatement();
	         //Run the query
	         ResultSet r = s.executeQuery("SELECT * FROM Codes WHERE device= '" + dev + "'");;

			//loop through all the codes
	         while (r.next())
				 //Increment total
	        	 total++;
	         //Close the connection with the database
	         c.close();
	        
		}
		catch (Exception e)
		{
			//Caught an exception
			e.printStackTrace();
		}
		//Return the total number of codes for this device
		return total;
	}

	/**
	 * Return the number of reviews for a device with specific codes
	 * @param dev the device
	 * @param cc the class code
	 * @param refcode the refined code
     * @return the number of reviews
     */
	public static int getAllRevsForDeviceWithCodes(String dev, String cc, String refcode)
	{
		//Setup the array
		ArrayList<Review> ret = new ArrayList<Review>();
		int total = 0;
		try
		{
			//Try to connect to the database
			 Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
	         Connection c = DriverManager.getConnection("jdbc:odbc:mobbs", "mobbs", "mobbs");
	         Statement s = c.createStatement();
	         //Run the query
	         ResultSet r = s.executeQuery("SELECT * FROM Codes WHERE device= '" + dev + "' AND codeclass='" + cc + "' AND refinedcode='" + refcode + "'");;

			//Count the number of reviews
	         while (r.next())
	        	 total++;
	         //Close the connection to the database
	         c.close();
	        
		}
		catch (Exception e)
		{
			//Catch an exception
			e.printStackTrace();
		}
		//Return the number of reviews
		return total;
	}

	/**
	 * Return all reviews for an app
	 * @param appid The app to get reviews from
	 * @return an ArrayList off reviews
     */
	public static ArrayList<Review> getAllRevsForApp(String appid)
	{
		//setup the arraylist to return
		ArrayList<Review> revs = new ArrayList<Review>();
		
		try
		{
			//Try to connect to the database
			 Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
	         Connection c = DriverManager.getConnection("jdbc:odbc:mobbs", "mobbs", "mobbs");
	         Statement s = c.createStatement();
	         //Run the query
	         ResultSet r = s.executeQuery("SELECT * FROM Codes WHERE appid= '" + appid + "'");;

			//Loop through all revuews for the application
	         while (r.next())
	         {
	        	 Review rv = new Review();
	        	 rv.setAppid(appid);
	        	 rv.setRevid(r.getString("revid"));
				 //Add the review to the ArrayList
	        	 revs.add(rv);
	         }
			//Close the connection with the database
	         c.close();
		}
		catch (Exception e)
		{
			//Catching an Exception
			e.printStackTrace();
		}
		//Return the ArrayList of reviews
		return revs;
	}

	/**
	 * Returns an ArrayList of all Apps
	 * @return ArrayList of all Apps
     */
	public static ArrayList<Application> getApps()
	{
		//Setup the ArrayList to return
		ArrayList<Application> apps = new ArrayList<Application>();
		try
		{
			//Try to connect to the database
			 Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
	         Connection c = DriverManager.getConnection("jdbc:odbc:mobbs", "mobbs", "mobbs");
	         Statement s = c.createStatement();
	         //Run the query
	         ResultSet r = s.executeQuery("SELECT * FROM Apps");;

			//Loop through all the apps
	         while (r.next())
	         {
	        	 String appid = r.getString("ID");
	        	 if (isCoded(appid)) //Make sure the app is coded
	        	 {
	        		 Application app = new Application(); //Create a new app object
	        		 app.setId(appid);
	        		 app.setRating(Double.valueOf(r.getDouble("Rate")));
	        		 app.setPrice(Double.valueOf(r.getDouble("Price")));
	        		 app.setNorates(Double.valueOf(r.getDouble("Norates")));
					 //Add the app to the ArrayList
	        		 apps.add(app);
	        	 }
	         }
			//Close the connection
	         c.close();
	        
		}
		catch (Exception e)
		{
			//An exception was thrown
			e.printStackTrace();
		}
		//Return the ArrayList of all apps.
		return apps;
	}

}