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

package objs.stats;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.util.ArrayList;

import logic.analysis.DeviceDistrAnalysis;

import objs.CodeDistr;
import objs.Device;

/**
 * Deals with the device statistics
 */
public class DeviceStats 
{
	private String device;
	private ArrayList<CodeDistr> dist;

	/**
	 * Gets the current device
	 * @return The device
     */
	public String getDevice() 
	{
		return device;
	}

	/**
	 * Set the current device of this specific class
	 * @param device The new device
     */
	public void setDevice(String device) 
	{
		this.device = device;
	}

	/**
	 * Gets the current distribution used
	 * @return The arrayList of distributions
     */
	public ArrayList<CodeDistr> getDist() 
	{
		return dist;
	}

	/**
	 * Set the ArrayList of distributions to a new list
	 * @param dist The new Arraylist of Distributions
     */
	public void setDist(ArrayList<CodeDistr> dist) 
	{
		this.dist = dist;
	}

	/**
	 * Setup the class with specific values
	 * @param device A device String
	 * @param dist An arrayList of Distributions
     */
	public DeviceStats(String device, ArrayList<CodeDistr> dist) 
	{
		this.device = device;
		this.dist = dist;
	}

	/**
	 * Setup the class without any specific values and as empty variables
	 */
	public DeviceStats() 
	{
		device = new String();
		dist = new ArrayList<CodeDistr>();
	}
}
