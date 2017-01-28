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

public class PriceStatsAnalysis 
{
	//public static double[] prices = new double[]{0, 1, 2, 3, 4, 5, 25};
	//public static double[] prices = new double[]{0.50, 0.63, 0.75, 1, 1.25, 1.75, 3, 20};
	public static double[] prices = new double[]{0.50, 0.60, 1.20, 2.25, 3.5, 5, 20};

	public static String[] classes = new String[]{"positive feedback", "negative feedback", "comparative feedback", "money feedback", "requirements", "reporting", "usability", "customer support", "versioning"};

	//creates an arraylist that holds the price distribution
	public static ArrayList<Range> createPriceDistr()
	{
		ArrayList<Range> devDistr = new ArrayList<Range>();
		
		int totalRevs = DBQuerying.getAppsCoded().size();
	
		for (int i = 0; i < prices.length - 1; i++)
		{
			Range d = new Range();
			d.setMin(prices[i]);
			d.setMax(prices[i + 1]);
			int total = DBQuerying.getTotalAppsForPriceRange(prices[i], prices[i + 1]);
			double perc = (double)100*total/totalRevs;
			d.setCount(total);
			d.setPerc(perc);
			
  			System.out.println("[" + d.getMin() + ", " + d.getMax() + "]" + "	" + d.getCount() + "	" + d.getPerc());
			
			devDistr.add(d);
		}
		return devDistr;
	}
	
	public static void printPriceDistr()
	{
		 ArrayList<Range> devDistr = PriceStatsAnalysis.createPriceDistr();

		 try
		 {
				FileWriter fstream = new FileWriter("reports/price_range_stats/report_appsdist_over_pricerange.txt");
		    	BufferedWriter out = new BufferedWriter(fstream);
		  		
		  		for (Range d : devDistr)
		  		{
		  			out.write("[" + d.getMin() + ", " + d.getMax() + "]" + "	" + d.getCount() + "	" + d.getPerc());
		  			out.newLine();
		  		}
				  			  
				out.close();
		  }
		  catch (Exception e)
		  {//Catch exception if any
		 	  System.err.println("Error: " + e.getMessage());
    	  }
	}
	
	
//////////////////////////////////////////////////////////////////////////////////////
	
	
	public static ReportPriceStats createReportPriceStats()
	{
		ReportPriceStats rep = new ReportPriceStats();
		
				
		for (int index = 0; index < prices.length - 1; index++)
		{
		
			PriceStats ratest = new PriceStats();
			ratest.setMin(prices[index]);
			ratest.setMax(prices[index + 1]);
			ArrayList<CodeDistr> distst = new ArrayList<CodeDistr>();
			int totalCodes = 0;
			
			ArrayList<String> apps = DBQuerying.getAppsForPriceRange(prices[index], prices[index + 1]); //all apps with rate between star and star + 1
			
			
			for (String app : apps)
				//totalrevs += DBQuerying.getTotalRevsForApp(app);
				totalCodes += DBQuerying.getTotalCodesForApp(app);
			
			
			try
			{
				for (String cc : classes)
				{
					String[] refcodes = FileStoring.loadCodes(cc);
					
					for (String refcode : refcodes)
					{
						
						if (refcode != null)
						{
							int totalcode = 0;

							for (String app : apps)
								totalcode += DBQuerying.getTotalCodesPerApp(cc, refcode, app);
							
							double perc = (double)100*totalcode/totalCodes;
							CodeDistr calfa = new CodeDistr(cc + "  " + refcode, totalcode, perc, 0, 0);
							
System.out.println(Double.toString(prices[index]) + "  " + Double.toString(prices[index + 1]) + "  " + refcode + "  " + totalcode + "   " + perc + "   " + totalCodes);						
							
							distst.add(calfa);
						}
					}
				}
				
				ratest.setDist(distst);
				rep.report.add(ratest);
				
					
			}
			catch (Exception ex)
			{
				ex.printStackTrace();
			}
		
		}
		return rep;
	}
	
	
	public static void main(String[] args)
	{
		//printPriceDistr();
		PriceStatsAnalysis.createReportPriceStats().print();
	}

}
