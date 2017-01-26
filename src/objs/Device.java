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

	/**
	* Returns the device value
	* @return device - a string
	*/
	public String getDevice() {
		return device;
	}

	/**
	* Sets the string value of device variable
	* @param device - a string value
	*/
	public void setDevice(String device) {
		this.device = device;
	}

	/**
	* Returns the count variable
	* @return count - a value
	*/
	public int getCount() {
		return count;
	}
	/**
	* Sets the value of count variable
	* @param count - a value
	*/
	public void setCount(int count) {
		this.count = count;
	}
	/**
	* Initialises blank variables for device, count and perc.
	* @param device - a string value
	* @param count - a value
	* @param perc - a value
	*/
	public Device()
	{
		device = new String();
		count = 0;
		perc = 0;
	}

	/**
	* Returns the perc variable
	* @return perc - a value
	*/
	public double getPerc() {
		return perc;
	}

	/**
	* Sets the value of perc variable
	* @param perc - a double value
	*/
	public void setPerc(double perc) {
		this.perc = perc;
	}

}
