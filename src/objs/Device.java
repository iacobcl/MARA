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
/**
*This Class creates a device with three attributes of type String, integer and double.
*/
public class Device 
{
	private String device;
	private int count;
	private double perc;
	
	/**
	*This method sets the device attributes to the device paramaters.
	*@param device This is a string value.
	*@param count  This is an integer value.
	*@param perc  This is a double value.
	*/
	public Device(String device, int count, double perc) {
		super();
		this.device = device;
		this.count = count;
		this.perc = perc;
	}
	
	/**
	*This method returns the device as a String.
	*@return device
	*/
	public String getDevice() {
		return device;
	}
	/**
	*This method sets the device attribute to the device paramater.
	*@param device This is a string value.
	*/
	public void setDevice(String device) {
		this.device = device;
	}
	/**
	*This method returns the count as an integer.
	*@return count
	*/
	public int getCount() {
		return count;
	}
	/**
	*This method sets the count attribute to the count paramater.
	*@param count This is an integer value.
	*/
	public void setCount(int count) {
		this.count = count;
	}
	/**
	*This method creates a new device. 
	*@modifies device This is a string value.
	*@modifies count  This is an integer value.
	*@modifies perc  This is a double value.
	*/
	public Device()
	{
		device = new String();
		count = 0;
		perc = 0;
	}
	/**
	*This method returns the perc value of the device.
	*@return perc
	*/
	public double getPerc() {
		return perc;
	}
	/**
	*This method sets the perc attribute to the perc paramater.
	*@param perc This is a double value.
	*/
	public void setPerc(double perc) {
		this.perc = perc;
	}

}
