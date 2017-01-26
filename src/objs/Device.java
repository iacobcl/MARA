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

	/**
	*Constructor for <b>Device</b>
	*default
	*/
	public Device()
	{
		device = new String();
		count = 0;
		perc = 0;
	}

	/**
	*Constructor for <b>Device</b>
	*@param device,count,perc
	*/
	public Device(String device, int count, double perc) {
		super();
		this.device = device;
		this.count = count;
		this.perc = perc;
	}

	/**
	*etGter for <b>Device</b>
	*@ Dreturnevice
	*/
	public String getDevice() {
		return device;
	}

	/**
	*Setter for <b>Device</b>
	*@param Device
	*/
	public void setDevice(String device) {
		this.device = device;
	}

	/**
	*eGtter for <b>Count</b>
	*@ returnCount
	*/
	public int getCount() {
		return count;
	}

	/**
	*Setter for <b>Count</b>
	*@param Count
	*/
	public void setCount(int count) {
		this.count = count;
	}

	/**
	*Getter for <b>Perc</b>
	*@return Perc
	*/
	public double getPerc() {
		return perc;
	}

	/**
	*Setter for <b>Perc</b>
	*@param Perc
	*/
	public void setPerc(double perc) {
		this.perc = perc;
	}

}
