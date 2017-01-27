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

package logic.analysis;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.util.ArrayList;

import objs.CodeDistr;
import objs.Device;
import objs.Range;
import objs.stats.PriceWorthStats;
import objs.stats.RateStats;
import objs.stats.RefCodeStats;
import objs.stats.reports.ReportPriceRangeWorthStats;
import objs.stats.reports.ReportRateStats;
import storage.DBQuerying;
import storage.FileQuerying;
import storage.FileStoring;

/**
 * Deals with the analysing of the rate statistics
 */
public class RateStatsAnalysis 
{
	//Create the lists of stars and classes
	public static int[] stars = new int[]{0, 1, 2, 3, 4, 5};
	public static String[] classes = new String[]{"positive feedback", "negative feedback", "comparative feedback", "money feedback", "requirements", "reporting", "usability", "customer support", "versioning"};

	/**
	 * Creates an ArrayList of rate distributions
	 * @return The ArrayList of rate Distributions
	 */
	public static ArrayList<Range> createRateDistr()
	{
		ArrayList<Range> devDistr = new ArrayList<Range>();
		
		int totalRevs = DBQuerying.getAppsCoded().size();
		//Loop through all stars
		for (int i = 0; i < stars.length - 1; i++)
		{
			Range d = new Range();
			d.setMin(stars[i]);
			d.setMax(stars[i + 1]);
			int total = DBQuerying.getTotalAppsForRateRange(stars[i], stars[i + 1]);
			double perc = (double)100*total/totalRevs; //Get the average number of reviews
			d.setCount(total);
			d.setPerc(perc);

			//Print stats to console
  			System.out.println("[" + d.getMin() + ", " + d.getMax() + "]" + "	" + d.getCount() + "	" + d.getPerc());

			//Add to the ArrayList
			devDistr.add(d);
		}
		//Return the ArrayList of rate
		return devDistr;
	}

	/**
	 * Writes the rate distribution to a file
	 */
	public static void printRateDistr()
	{
		//Get the rate distribution ArrayList
		 ArrayList<Range> devDistr = RateStatsAnalysis.createRateDistr();

		 try
		 {
			 //Try to open the file we are writing to
				FileWriter fstream = new FileWriter("reports/rate_range_stats/report_appsdist_over_raterange.txt");
		    	BufferedWriter out = new BufferedWriter(fstream);

			 //Loop through the distributions
		  		for (Range d : devDistr)
		  		{
					//Write the stats to the file
		  			out.write("[" + d.getMin() + ", " + d.getMax() + "]" + "	" + d.getCount() + "	" + d.getPerc());
		  			out.newLine();
		  		}
			 	//Close the "connection" to the file
				out.close();
		  }
		  catch (Exception e)
		  {//Catch exception if any
		 	  System.err.println("Error: " + e.getMessage());
    	  }
	}

	/**
	 * Creates and analyses a report on the rate statistics
	 * @return The analysed rate report
	 */
	public static ReportRateStats createReportRateStats()
	{
		//setup the report
		ReportRateStats rep = new ReportRateStats();
		
		//Loop through all stars
		for (int star : stars)
		{
		
			RateStats ratest = new RateStats();
			ratest.setStars(star);
			ArrayList<CodeDistr> distst = new ArrayList<CodeDistr>();
			//int totalrevs = 0;
			int totalCodes = 0;

			//Get the ArrayList of the apps used by this star
			ArrayList<String> apps = DBQuerying.getAppsForRateRange(star, star + 1); //all apps with rate between star and star + 1

			//Loop through the apps
			for (String app : apps)
				//totalrevs += DBQuerying.getTotalRevsForApp(app);
				totalCodes += DBQuerying.getTotalCodesForApp(app);
			
			try
			{
				//Try to loop through the classes
				for (String cc : classes)
				{
					String[] refcodes = FileStoring.loadCodes(cc);
					
					//for (String refcode : refcodes)
					//{
						
						//if (refcode != null)
						//{
							int totalcode = 0;

							//Loop through the apps
							for (String app : apps)
							{
								//totalcode += DBQuerying.getTotalCodesPerApp(cc, refcode, app);
								totalcode += DBQuerying.getTotalClassCodesPerApp(cc, app);
//System.out.println(DBQuerying.getTotalCodesPerApp(cc, refcode, app));
							}
							double perc = (double)100*totalcode/totalCodes;
							//CodeDistr calfa = new CodeDistr(cc + "  " + refcode, totalcode, perc, 0, 0);
							CodeDistr calfa = new CodeDistr(cc + "  " + " ", totalcode, perc, 0, 0);
							
System.out.println(Integer.toString(star) + "  " + Integer.toString(star + 1) + "	" + totalcode + "	" + perc + "  " + totalCodes);
							
							distst.add(calfa);
						//}
					//}
				}
				//Add the stats to the report
				ratest.setDist(distst);
				rep.report.add(ratest);
				
					
			}
			catch (Exception ex)
			{
				ex.printStackTrace();
			}
			
		}
		//return the analysed report
		return rep;
	}
	
	
	public static void main(String[] args)
	{
		RateStatsAnalysis.createReportRateStats();
		RateStatsAnalysis.createReportRateStats().print();
		
		//System.out.println("no. apps. " + DBQuerying.getAppsCoded().size());
		//System.out.println("no. revs. " + DBQuerying.getTotalRevs());
		
		
		/*ArrayList<String> apps = DBQuerying.getAppsForRateRange(4, 5);
		for (String app : apps)
		{
			int totalCodes = DBQuerying.getTotalCodesForApp(app);
			int totalPos = DBQuerying.getTotalCodesPerApp("positive feedback", "overall", app);
			double perc = (double)totalPos/totalCodes*100;
			System.out.print(Double.toString(perc) + ", ");
		}*/
		
		
		
	}

}
