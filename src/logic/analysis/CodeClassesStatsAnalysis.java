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


public class CodeClassesStatsAnalysis 
{
	
	public static String[] classes = new String[]{"positive feedback", "negative feedback", "comparative feedback", "money feedback", "requirements", "reporting", "usability", "customer support", "versioning"};
	
	/**
         * @return Report of class code stats
         */	
	public static ReportClassCodeStats createReportClassCodeStats()
	{
		ReportClassCodeStats rep = new ReportClassCodeStats();
		int totalcode;
		
		for (String cc : classes)
		{
			//if (cc.equals("positive feedback"))
				//totalcode = DBQuerying.getTotalCodesOverallFeedback("positive feedback", "overall");
			//else
			//if (cc.equals("negative feedback"))
				//totalcode = DBQuerying.getTotalCodesOverallFeedback("negative feedback", "overall");
			//else
				totalcode = DBQuerying.getTotalClassCode(cc);
			
			//int totalrevs = DBQuerying.getTotalRevs();
			int totalCodes = DBQuerying.getTotalCodes();
			double perc = (double)totalcode*100/totalCodes;
			
System.out.println(totalCodes);			
				
				
			ArrayList<CodeDistr> dist = new ArrayList<CodeDistr>();
			dist.add(new CodeDistr(cc, totalcode, perc, 0, 0));
						
			RefCodeStats stats = new RefCodeStats(cc, dist);
				
			rep.report.add(stats);
		}
		return rep;
	}
	
	/**
         * @param args Array of string arguments
         */
	public static void main(String[] args)
	{
		CodeClassesStatsAnalysis.createReportClassCodeStats().print();
		
		//System.out.println(DBQuerying.getTotalRevs());
	}
	
	

}
