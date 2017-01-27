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

import objs.Review;
import objs.stats.AvgDistrPriceStats;
import objs.stats.reports.ReportAvgDistrStats;
import storage.DBQuerying;

/**
 * Deals with analysing the average Distribution rate statistics
 */
public class AvgDistrRateStatsAnalysis 
{
	public static int[] stars = new int[]{0, 1, 2, 3, 4, 5};

	/**
	 * analyses and returns a report for the average DistrStats
	 * @return a ReportAvgDistrStat object
	 */
	public static ReportAvgDistrStats createReportAvgDistrRateStats()
	{//the average number of codes/review for each price range
		ReportAvgDistrStats rep = new ReportAvgDistrStats();

		//Loop through all the stars
		for (int i = 0; i < stars.length - 1; i++)
		{
			//Create a new stats object
			AvgDistrPriceStats avg = new AvgDistrPriceStats();
			avg.setMin(stars[i]);
			avg.setMax(stars[i + 1]);
			
			int totalrevs = 0;

			//Create arraylists of variables we are using
			ArrayList<String> apps = DBQuerying.getAppsForRateRange(stars[i], stars[i + 1]);
			ArrayList<Review> revs = new ArrayList<Review>();
			ArrayList<Integer> totalCodes = new ArrayList<Integer>();
			
			
			for (String appid : apps)
			{//create revs - list of all reviews of the apps in the price range
				ArrayList<Review> revsapp = DBQuerying.getAllRevsForApp(appid);
				for (Review r : revsapp)
					revs.add(r);
			}
			

			//Loop through all the apps
			for (String appid : apps)
			{
				int T = DBQuerying.getTotalRevsForApp(appid);
				for (int index = 0; index < T; index++)
				{
					int trel = countCodesPerReview(revs, appid, ""+index);
					totalCodes.add(Integer.valueOf(trel)); //total codes for review index of appid
					System.out.println("Appid:" + appid + " rev index: " + index + " total codes: " + trel);
				}
			}

			//Loop through the code
			int sum = 0;
			for (int k = 0; k < totalCodes.size(); k++)
				//Add the codes to the sum of codes
				sum += totalCodes.get(k);
			//Get the average of the codes
			avg.setAvg((double)sum/totalCodes.size());

			//Add the average to the report
			rep.report.add(avg);
		}
		//Return our analysed report
		return rep;
	}

	/**
	 * Return the total number of reviews in an app
	 * @param revs the list of reviews
	 * @param appid the app we are looking at
	 * @param revid the id of the reviews
	 * @return The total number of reviews in an app
	 */
	public static int countCodesPerReview(ArrayList<Review> revs, String appid, String revid)
	{
		int total = 0;
		for (Review r : revs)
		{
			if ((r.getAppid().equals(appid)) && (r.getRevid().equals(revid)))
				total++;
		}
		return total;
	}
	
	public static void main(String[] args)
	{
		AvgDistrRateStatsAnalysis.createReportAvgDistrRateStats().print();
	}
}
