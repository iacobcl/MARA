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

import objs.stats.PriceWorthStats;

public class ReportPriceRangeWorthStats 
{

	public ArrayList<PriceWorthStats> report;
	
	
	public ReportPriceRangeWorthStats()
	{
		report = new ArrayList<PriceWorthStats>();
	}


	public ArrayList<PriceWorthStats> getReport() 
	{
		return report;
	}


	public void setReport(ArrayList<PriceWorthStats> report) 
	{
		this.report = report;
	}
	
	
	public void print()
	{
		 try
		 {
			  FileWriter fstream = new FileWriter("reports/price_range_stats/reportpricerangeworthstats.txt");
	    	  BufferedWriter out = new BufferedWriter(fstream);
	  		  for (int i = 0; i < report.size(); i++)
			  {
					out.write("[" + report.get(i).getMin() + ", " + report.get(i).getMax() + "]" + "	" + report.get(i).getWorth().getTotal() + "	" + report.get(i).getWorth().getPerc() + "	" + report.get(i).getNworth().getTotal() + "	" + report.get(i).getNworth().getPerc());
					out.newLine();
					System.out.println("[" + report.get(i).getMin() + ", " + report.get(i).getMax() + "]" + "	" + report.get(i).getWorth().getPerc() + "	"  + report.get(i).getNworth().getPerc());
			  }
			  out.close();
		  }
		 catch (Exception e)
		 {//Catch exception if any
			  System.err.println("Error: " + e.getMessage());
		 }
		
	}
	
}
