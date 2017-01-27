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

import java.util.ArrayList;

import objs.stats.CodesPerCatStats;

/**
 * Creates a report on the code per category stats
 */
public class ReportCodesPerCatStats 
{
	
	public ArrayList<CodesPerCatStats> report;

	/**
	 * Create the report with an array
	 */
	public ReportCodesPerCatStats()
	{
		report = new ArrayList<CodesPerCatStats>();
	}

	/**
	 * Return the classes report
	 * @return The report to return
	 */
	public ArrayList<CodesPerCatStats> getReport() 
	{
		return report;
	}

	/**
	 * Set this classes report
	 * @param report the new report
	 */
	public void setReport(ArrayList<CodesPerCatStats> report) 
	{
		this.report = report;
	}

}
