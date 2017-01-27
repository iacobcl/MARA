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
import objs.stats.RefCodeStats;
import objs.stats.reports.ReportClassCodeStats;
import storage.DBQuerying;
import storage.FileStoring;

/**
 * Deals with the analyses of the refined codes statistics
 */
public class RefinedCodesStatsAnalysis 
{
	//Create the classes list
	public static String[] classes = new String[]{"positive feedback", "negative feedback", "comparative feedback", "money feedback", "requirements", "reporting", "usability", "customer support", "versioning"};

	/**
	 * Creates and analyses a report on the class codes
	 * @return The analysed pricing report
     */
	public static ReportClassCodeStats createReportRefinedCodesOverallStats()
	{
		//Setup the report
		ReportClassCodeStats rep = new ReportClassCodeStats();
	
		int totalcode;
		//int totalrevs = DBQuerying.getTotalRevs();
		int totalCodes = DBQuerying.getTotalCodes();

		//Loop through the classes
		for (String cc : classes)
		{
			//Get the total number class codes
			totalcode = DBQuerying.getTotalClassCode(cc);
			//Get the refined codes
			RefCodeStats refcodestats = new RefCodeStats();
			ArrayList<CodeDistr> distcc = new ArrayList<CodeDistr>();
				
			refcodestats.setClassCode(cc);
				
			double perc = (double)totalcode*100/totalCodes;
			distcc.add(new CodeDistr(cc, totalcode, perc, 0, 0)); //add the class code
			
			String[] refcodes = FileStoring.loadCodes(cc);

			//Loop through all the refined code
			for (String refc : refcodes)
			{
				//if ( (cc.equals("positive feedback")) || (cc.equals("negative feedback")))
				//Ensure that the refined code exists
				if (refc != null)
					{
						//Calcuate the averages and statistics
						int totalref = DBQuerying.getTotalRefCode(cc, refc);
						double perct = (double)totalref*100/totalCodes;
						double percr = (double)totalref*100/totalcode;
						distcc.add(new CodeDistr(refc, totalref, perct, 0, percr));
					}
				/*if ((cc.equals("positive feedback") == false) && (cc.equals("negative feedback") == false))
					{
						if (refc != null) 
						{
							int totalref = DBQuerying.getTotalRefCode(cc, refc);
							double perct = (double)totalref*100/totalCodes;
							double percr = (double)totalref*100/totalcode;
							distcc.add(new CodeDistr(refc, totalref, perct, 0, percr));
						}
					}*/
					
			}
			//Add the stats to the report
			refcodestats.setDist(distcc);
			rep.report.add(refcodestats);
		}
		//Return the analysed report
		return rep;
	}
	
	public static void main(String[] args)
	{
		RefinedCodesStatsAnalysis.createReportRefinedCodesOverallStats().print();
		
		//System.out.println(DBQuerying.getTotalRevs());
	}
	
}
