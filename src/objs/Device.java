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

package objs;

public class Device 
{
	private String device;
	private int count;
	private double perc;
	

	public Device(String device, int count, double perc) {
		super();
		this.device = device;
		this.count = count;
		this.perc = perc;
	}
	/*
	* returns device as string
	*/
	public String getDevice() {
		return device;
	}
	/*
	* sets new device 
	*/
	public void setDevice(String device) {
		this.device = device;
	}
	/*
	* returns count as int
	*/
	public int getCount() {
		return count;
	}
	/*
	* sets new count value
	*/
	public void setCount(int count) {
		this.count = count;
	}
	
	/*
	* sets device as String
	* count is set initially to 0
	* perc is set initially to 0
	*/
	
	public Device()
	{
		device = new String();
		count = 0;
		perc = 0;
	}
	/*
	* returns percentage as double
	*/
	
	public double getPerc() {
		return perc;
	}
	
	/*
	* sets new percentage value
	*/
	
	public void setPerc(double perc) {
		this.perc = perc;
	}

}
