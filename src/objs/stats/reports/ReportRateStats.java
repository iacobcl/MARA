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

package objs.stats.reports;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.util.ArrayList;

import objs.CodeDistr;
import objs.stats.PosNegCatStats;
import objs.stats.RateStats;

/**
 * Creates and manages a report on rates statistics
 */
public class ReportRateStats 
{
	public static ArrayList<RateStats> report;

	/**
	 * Create the report with an array
	 */
	public ReportRateStats()
	{
		report = new ArrayList<RateStats>();
	}

	/**
	 * Return the classes report
	 * @return The report to return
	 */
	public ArrayList<RateStats> getReport() 
	{
		return report;
	}

	/**
	 * Set this classes report
	 * @param report the new report
	 */
	public void setReport(ArrayList<RateStats> report) 
	{
		this.report = report;
	}

	/**
	 * Write the report to a file
	 */
	public static void print()
	{
		 try
		 {
			  //Try to access the file the stats are going to be written to
			  FileWriter fstream = new FileWriter("reports/rate_range_stats/reportratestats.txt");
	    	  BufferedWriter out = new BufferedWriter(fstream);
	    	  for (int i = 0; i < report.size(); i++)
			  {
					out.write("Class code:" + report.get(i).getStars());
					out.newLine();
					
					ArrayList<CodeDistr> codes = report.get(i).getDist();
					
					for (int j = 0; j < codes.size(); j++)
					{
						if (codes.get(j).getTotal() != 0)
						{
							out.write(codes.get(j).getCode() + "	" + codes.get(j).getTotal() + "	"+ codes.get(j).getPerc() + "	" + codes.get(j).getPercrel());
							out.newLine();
						}
					}

					out.write("----------------------------------------");
					out.newLine();
			  }
			  			  
			  out.close();
		  }
		 catch (Exception e)
		 {//Catch exception if any
			  System.err.println("Error: " + e.getMessage());
		 }
	}

}
