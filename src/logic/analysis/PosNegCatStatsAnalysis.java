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

import objs.CodeDistr;
import objs.stats.PosNegCatStats;
import objs.stats.reports.ReportPosNegCatStats;
import storage.DBQuerying;
import storage.FileQuerying;

/**
 * Deals with the analysing of the positives and negatives in categories statistics
 */
public class PosNegCatStatsAnalysis 
{

	//Create a list of categories
	public static String[] cats = new String[]{"Health", "Personalization", "Tools", "Books", "Education", "Productivity"};

	/**
	 * Creates and analyses a report on the positives and negatives in categories statistics
	 * @return the report on the positives and negatives in categories
     */
	public static ReportPosNegCatStats createReportPosNegCatStats()
	{
		//setup the report
		ReportPosNegCatStats rep = new ReportPosNegCatStats();

		//Loop through the categories
		for (String cat : cats)
		{
			//Initialize variables
			int totalpos = 0;
			int totalneg = 0;
			int totalCodes = 0;
			
			ResultSet apps = DBQuerying.getAppsForCat(cat);
			
			int totalapps = 0;
			
			try
			{
				//While there is a next app
				while (apps.next())
				{
					String appid = apps.getString("ID");
					
					//Add positives and negatives to the variables
					totalpos += DBQuerying.getTotalCodesPerApp("positive feedback", "overall", appid);; 
					totalneg += DBQuerying.getTotalCodesPerApp("negative feedback", "overall", appid);;
					
					//totalrevs += DBQuerying.getTotalRevsForApp(appid);;
					totalCodes += DBQuerying.getTotalCodesForApp(appid);
					
					if (DBQuerying.isCoded(appid))
					totalapps++; //Add 1 to the total apps
				}

				//Print the total apps for the category
				System.out.println(totalapps + "  " + cat);
	
				double percpos = (double)totalpos*100/totalCodes;
				double percneg = (double)totalneg*100/totalCodes;
				
				CodeDistr pos = new CodeDistr("positive overall feedback", totalpos, percpos, 0, 0);
				CodeDistr neg = new CodeDistr("negative overall feedback", totalneg, percneg, 0, 0);
						
				PosNegCatStats stats = new PosNegCatStats(cat, pos, neg);

				//Add the stats to the report
				rep.report.add(stats);
				
				
			}
			catch (Exception ex)
			{
				ex.printStackTrace();
			}
			
		}
		//Return the report
		return rep;
	}
	
	
	public static void main(String[] args)
	{
		//PosNegCatStatsAnalysis.createReportPosNegCatStats().print();
		
		System.out.println(DBQuerying.getTotalRevs());
	}
	
	
}
