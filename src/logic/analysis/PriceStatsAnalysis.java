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
import objs.Range;
import objs.stats.PriceStats;
import objs.stats.RateStats;
import objs.stats.reports.ReportPriceStats;
import objs.stats.reports.ReportRateStats;
import storage.DBQuerying;
import storage.FileStoring;

/**
 * Deals with the analysing of the pricing statistics
 */
public class PriceStatsAnalysis 
{
	//Creates various lists
	//public static double[] prices = new double[]{0, 1, 2, 3, 4, 5, 25};
	//public static double[] prices = new double[]{0.50, 0.63, 0.75, 1, 1.25, 1.75, 3, 20};
	public static double[] prices = new double[]{0.50, 0.60, 1.20, 2.25, 3.5, 5, 20};
	public static String[] classes = new String[]{"positive feedback", "negative feedback", "comparative feedback", "money feedback", "requirements", "reporting", "usability", "customer support", "versioning"};

	/**
	 * Creates an ArrayList of price distributions
	 * @return The ArrayList of price Distributions
     */
	public static ArrayList<Range> createPriceDistr()
	{
		ArrayList<Range> devDistr = new ArrayList<Range>();
		
		int totalRevs = DBQuerying.getAppsCoded().size();

		//Loops through all prices
		for (int i = 0; i < prices.length - 1; i++)
		{
			Range d = new Range(); //Create a new range object
			d.setMin(prices[i]);
			d.setMax(prices[i + 1]);
			//Get total apps for this price range
			int total = DBQuerying.getTotalAppsForPriceRange(prices[i], prices[i + 1]);
			double perc = (double)100*total/totalRevs;
			d.setCount(total);
			d.setPerc(perc);

			//Print stats to the console
  			System.out.println("[" + d.getMin() + ", " + d.getMax() + "]" + "	" + d.getCount() + "	" + d.getPerc());

			//Add the range stats to the ArrayList
			devDistr.add(d);
		}
		//Return the ArrayList
		return devDistr;
	}

	/**
	 * Writes the price distribution to a file
	 */
	public static void printPriceDistr()
	{
		//Get the price distribution ArrayList
		 ArrayList<Range> devDistr = PriceStatsAnalysis.createPriceDistr();

		 try
		 {
			 //Try to open the file we are writing to
				FileWriter fstream = new FileWriter("reports/price_range_stats/report_appsdist_over_pricerange.txt");
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
	 * Creates and analyses a report on the pricing statistics
	 * @return The analysed pricing report
     */
	public static ReportPriceStats createReportPriceStats()
	{
		//Setup the report
		ReportPriceStats rep = new ReportPriceStats();

		//Loop through all the prices

		for (int index = 0; index < prices.length - 1; index++)
		{
			//Create a new price stat
			PriceStats ratest = new PriceStats();
			ratest.setMin(prices[index]);
			ratest.setMax(prices[index + 1]);
			ArrayList<CodeDistr> distst = new ArrayList<CodeDistr>();
			int totalCodes = 0;

			//Get an ArrayList of the apps used by this price
			ArrayList<String> apps = DBQuerying.getAppsForPriceRange(prices[index], prices[index + 1]); //all apps with rate between star and star + 1
			
			//Loop through all the apps
			for (String app : apps)
				//totalrevs += DBQuerying.getTotalRevsForApp(app);
				totalCodes += DBQuerying.getTotalCodesForApp(app);
			
			
			try
			{
				//Loop through the classes
				for (String cc : classes)
				{
					String[] refcodes = FileStoring.loadCodes(cc);
					//Loop through the references of the code
					for (String refcode : refcodes)
					{
						//Make sure there is a reference
						if (refcode != null)
						{
							int totalcode = 0;
							//Loop through the apps used by the code reference and price
							for (String app : apps)
								//Add the codes per app to the total
								totalcode += DBQuerying.getTotalCodesPerApp(cc, refcode, app);
							
							double perc = (double)100*totalcode/totalCodes;
							CodeDistr calfa = new CodeDistr(cc + "  " + refcode, totalcode, perc, 0, 0);
							
System.out.println(Double.toString(prices[index]) + "  " + Double.toString(prices[index + 1]) + "  " + refcode + "  " + totalcode + "   " + perc + "   " + totalCodes);						

							//Add to the ArrayList
							distst.add(calfa);
						}
					}
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
		//Return the analysed report
		return rep;
	}
	
	
	public static void main(String[] args)
	{
		//printPriceDistr();
		PriceStatsAnalysis.createReportPriceStats().print();
	}

}
