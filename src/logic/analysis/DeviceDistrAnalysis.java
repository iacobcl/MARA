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

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.util.ArrayList;

import objs.CodeDistr;
import objs.Device;
import objs.Review;
import objs.stats.DeviceStats;
import objs.stats.reports.ReportDeviceStats;

import storage.DBQuerying;
import storage.FileQuerying;
import storage.FileStoring;

/**
 * Deals with analysing the device Distr statistics
 */
public class DeviceDistrAnalysis 
{
	public static String[] classes = new String[]{"positive feedback", "negative feedback", "comparative feedback", "money feedback", "requirements", "reporting", "usability", "customer support", "versioning"};

	/**
	 * Creates an array list of analysed device distribution
	 * @return The list of device Distribution
     */
	public static ArrayList<Device> createDeviceDistr()
	{
		//Get all the devices
		ArrayList<String> devs = FileQuerying.getDevices();
		ArrayList<Device> devDistr = new ArrayList<Device>();
		
		int totalRevs = DBQuerying.getTotalCodes();

		//List through all devices
		for (String dev : devs)
		{
			//Create a new device for each existing one
			Device d = new Device();
			d.setDevice(dev);
			int total = DBQuerying.getTotalCodesForDevice(dev);
			//Calculate the total reviews
			double perc = (double)100*total/totalRevs;
			d.setCount(total);
			d.setPerc(perc);
			devDistr.add(d);
		}
		//Return the list of analysed devices
		return devDistr;
	}

	/**
	 *Writes the list of devices out to a file
	 */
	public static void printDeviceDistr()
	{
		//Get the list of devices
		 ArrayList<Device> devDistr = DeviceDistrAnalysis.createDeviceDistr();

		 try
		 {
			//Try to open a file
			FileWriter fstream = new FileWriter("reports/device_stats/reportdevicedistr.txt");
			BufferedWriter out = new BufferedWriter(fstream);

			 //Loop through the devices
			for (Device d : devDistr)
			{
				//Write each device to the file
				out.write(d.getDevice() + "	" + d.getCount() + "	" + d.getPerc());
				out.newLine();
			}

			 //End the "connection" with the file
			out.close();
		  }
		  catch (Exception e)
		  {//Catch exception if any
		 	  System.err.println("Error: " + e.getMessage());
    	  }
	}

	/**
	 * Analyses and returns a report for the device statistics
	 * @return The report on device statistics
     */
	public static ReportDeviceStats createReportDeviceStats()
	{
		//Get the devices
		ReportDeviceStats rep = new ReportDeviceStats();
		ArrayList<String> devs = FileQuerying.getDevices();

		//Loop through all the devices
		for (String dev : devs)
		{
			//Set the current device
			DeviceStats devstats = new DeviceStats();
			devstats.setDevice(dev);
						
			ArrayList<CodeDistr> distst = new ArrayList<CodeDistr>();

			int totalCodes = DBQuerying.getTotalCodesForDevice(dev);
			
			try
			{
				//Loop through the classes
				for (String cc : classes)
				{
					String[] refcodes = FileStoring.loadCodes(cc);

					//Loop through the reference codes
					for (String refcode : refcodes)
					{
						
						if (refcode != null)
						{

							int totalcode = DBQuerying.getAllRevsForDeviceWithCodes(dev, cc, refcode);
							
							double perc = (double)100*totalcode/totalCodes;
							CodeDistr calfa = new CodeDistr(cc + "  " + refcode, totalcode, perc, 0, 0);
//if ((cc.equals("positive feedback")) && (refcode.equals("device")))							
System.out.println(dev + "	" + cc + "	" + refcode + "	" + totalcode + "	" + perc + "	" + totalCodes);						
							
							distst.add(calfa);
						}
					}
				}
				//Add the analysed stats to the report
				devstats.setDist(distst);
				rep.report.add(devstats);
			}
			catch (Exception ex)
			{
				ex.printStackTrace();
			}
				
		}
		//Return the complted report
		return rep;
	}

	
	public static void main(String[] args)
	{
		//createReportDeviceStats().printCode("reporting  major bug");
		createReportDeviceStats().print();
		printDeviceDistr();
	}
	
}
