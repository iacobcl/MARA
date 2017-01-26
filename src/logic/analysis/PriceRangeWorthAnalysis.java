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

import java.sql.ResultSet;
import java.util.ArrayList;

import objs.CodeDistr;
import objs.stats.PosNegCatStats;
import objs.stats.PriceWorthStats;
import objs.stats.reports.ReportPosNegCatStats;
import objs.stats.reports.ReportPriceRangeWorthStats;
import storage.DBQuerying;
import storage.FileQuerying;

public class PriceRangeWorthAnalysis 
{

	//public static double[] prices = new double[]{0, 1, 2, 3, 4, 5, 25};
	public static double[] prices = new double[]{0.50, 0.60, 1.20, 2.25, 3.5, 5, 20};
	//public static double[] prices = new double[]{0.50, 0.63, 0.75, 1, 1.25, 1.75, 3, 20};

        /**
         * @return Return Report showing money feedback
         */
	public static ReportPriceRangeWorthStats createReportPriceRangeWorthStats()
	{
		ReportPriceRangeWorthStats rep = new ReportPriceRangeWorthStats();
		
		for (int index = 0; index < prices.length - 1; index++)
		{
			int totalworth = 0;
			int totalnworth = 0;
			int totalCodes = 0;
			
			ArrayList<String> apps = DBQuerying.getAppsForPriceRange(prices[index], prices[index + 1]);
			
			try
			{
				for (int i = 0; i < apps.size(); i++)
				{
					String appid = apps.get(i);
					
					totalworth += DBQuerying.getTotalCodesPerApp("money feedback", "worth the money", appid); 
					totalnworth += DBQuerying.getTotalCodesPerApp("money feedback", "not worth the money", appid);
					
					//totalrevs += DBQuerying.getTotalRevsForApp(appid);
					totalCodes += DBQuerying.getTotalCodesForApp(appid);
				}
				
	
				double percpos = (double)totalworth*100/totalCodes;
				double percneg = (double)totalnworth*100/totalCodes;
				
				CodeDistr worth = new CodeDistr("worth the money", totalworth, percpos, 0, 0);
				CodeDistr nworth = new CodeDistr("not worth the money", totalnworth, percneg, 0, 0);
						
				PriceWorthStats stats = new PriceWorthStats(prices[index], prices[index + 1], worth, nworth);
				
				rep.report.add(stats);
							
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
		PriceRangeWorthAnalysis.createReportPriceRangeWorthStats().print();
	}
	
}
