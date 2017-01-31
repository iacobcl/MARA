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

public class DeviceStats 
{
	private String device;
	private ArrayList<CodeDistr> dist;

	public String getDevice() 
	{
		return device;
	}
	
	public void setDevice(String device) 
	{
		this.device = device;
	}
	
	public ArrayList<CodeDistr> getDist() 
	{
		return dist;
	}
	
	public void setDist(ArrayList<CodeDistr> dist) 
	{
		this.dist = dist;
	}
	
	public DeviceStats(String device, ArrayList<CodeDistr> dist) 
	{
		this.device = device;
		this.dist = dist;
	}
	
	public DeviceStats() 
	{
		device = new String();
		dist = new ArrayList<CodeDistr>();
	}
	
	


}
