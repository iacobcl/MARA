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
	/**
	* @param device name of the device
	* @param count number of the device
	* @param perc percentage in double
	*/
	private String device;
	private int count;
	private double perc;

	/**
	* Construstor that sets field value to corresponding parameter
	* @param device name of the device
	* @param count number of the device
	* @param perc percentage in double
	*/
	public Device(String device, int count, double perc) {
		super();
		this.device = device;
		this.count = count;
		this.perc = perc;
	}

	/**
	* returns the device name
	* @return device name
	*/
	public String getDevice() {
		return device;
	}

	/**
	* sets the device name
	* @param device new device name
	*/
	public void setDevice(String device) {
		this.device = device;
	}

	/**
	* get number of devices
	*@param count count the device
	*/
	public int getCount() {
		return count;
	}

	/**
	* sets new count value
	*@param count new count
	*/
	public void setCount(int count) {
		this.count = count;
	}

	/**
	* Construstor that sets field value to corresponding parameter
	*@param device to String
	*@param count to 0
	*@param perc to 0
	*/
	public Device()
	{
		device = new String();
		count = 0;
		perc = 0;
	}

	/**
	* Retunn percentage
	* @return percentage
	*/
	public double getPerc() {
		return perc;
	}

	/**
	* sets the new percentage
	*@param perc new percentage
	*/
	public void setPerc(double perc) {
		this.perc = perc;
	}

}
