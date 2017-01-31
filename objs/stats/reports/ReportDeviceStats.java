
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
import objs.Device;
import objs.stats.DeviceStats;

public class ReportDeviceStats 
{

	public static ArrayList<DeviceStats> report;
	
	
	public ReportDeviceStats()
	{
		report = new ArrayList<DeviceStats>();
	}


	public ArrayList<DeviceStats> getReport() 
	{
		return report;
	}


	public void setReport(ArrayList<DeviceStats> report) 
	{
		this.report = report;
	}

	
	public static void printCode(String code)
	{
		try
		 {
				FileWriter fstream = new FileWriter("reports/device_stats/reportdevicestatspercode.txt");
		    	BufferedWriter out = new BufferedWriter(fstream);
		  		
		  		for (DeviceStats ds : report)
		  		{
		  			out.write(ds.getDevice() + "	");
		  			
					ArrayList<CodeDistr> codes = ds.getDist();
					
					for (int j = 0; j < codes.size(); j++)
					{
						if ((codes.get(j).getTotal() != 0) && (codes.get(j).getCode().equals(code)))
						{
							out.write(codes.get(j).getCode() + "	" + codes.get(j).getTotal() + "	"+ codes.get(j).getPerc() + "	" + codes.get(j).getPercrel());
System.out.println(ds.getDevice() + "	" + codes.get(j).getCode() + "	" + codes.get(j).getTotal() + "	"+ codes.get(j).getPerc() + "	" + codes.get(j).getPercrel());
							out.newLine();
						}
					}

		  		}
				  			  
				out.close();
		  }
		  catch (Exception e)
		  {//Catch exception if any
		 	  System.err.println("Error: " + e.getMessage());
   	  }
	}
	
	
	public static void print()
	{
		 try
		 {
				FileWriter fstream = new FileWriter("reports/device_stats/reportdevicestats.txt");
		    	BufferedWriter out = new BufferedWriter(fstream);
		  		
		  		for (DeviceStats d : report)
		  		{
		  			out.write(d.getDevice());
		  			out.newLine();
		  			
					ArrayList<CodeDistr> codes = d.getDist();
					
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
