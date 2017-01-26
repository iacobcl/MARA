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

import java.util.ArrayList;

import objs.CodeDistr;
import objs.stats.NoRatesDistrStats;
import objs.stats.PriceStats;
import objs.stats.RateStats;
import objs.stats.reports.ReportNoRatesDistrStats;
import objs.stats.reports.ReportRateStats;
import storage.DBQuerying;
import storage.FileStoring;

public class NoRatesDistrStatsAnalysis 
{
	public static int[] rates = new int[]{0, 100, 200, 300, 400, 500, 600, 700, 800, 900, 1000, 2000};
	public static String[] classes = new String[]{"positive feedback", "negative feedback", "comparative feedback", "money feedback", "requirements", "reporting", "usability", "customer support", "versioning"};

	/**
         * @return Return Report for the distribution of codes for each range of number of total reviews
         */
	public static ReportNoRatesDistrStats createReportNoRatesDistrStats()
	{//computes the distribution of codes for each range of number of total reviews
		ReportNoRatesDistrStats rep = new ReportNoRatesDistrStats();
		

		for (int index = 0; index < rates.length - 1; index++)
		{
		
			NoRatesDistrStats ratest = new NoRatesDistrStats();
			ratest.setMin(rates[index]);
			ratest.setMax(rates[index + 1]);
			ArrayList<CodeDistr> distst = new ArrayList<CodeDistr>();
			int totalCodes = 0;
			
			ArrayList<String> apps = DBQuerying.getAppsForNoRatesRange(rates[index], rates[index + 1]); //all apps with rate between star and star + 1
			
			
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
							
System.out.println(Integer.toString(rates[index]) + "  " + Integer.toString(rates[index + 1]) + "  " + refcode + "  " + totalcode + "   " + perc + "   " + totalCodes);						
							
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
	
	/**
         * @param args Array of string arguments
         */
	public static void main(String[] args)
	{
		NoRatesDistrStatsAnalysis.createReportNoRatesDistrStats().print();
		//System.out.println(DBQuerying.getTotalRevs());
	}

}
