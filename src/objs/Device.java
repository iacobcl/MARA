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



public class Device 
{
	private String device;
	private int count;
	private double perc;
	
	
	/**
	 * Constructor for creating a device object
	 * @param device
	 * @param count 
	 * @param perc
	 */
	public Device(String device, int count, double perc) {
		super();
		this.device = device;
		this.count = count;
		this.perc = perc;
	}
	
	
	/**
	 * method to return the name of the device
	 * @return device name
	 */
	public String getDevice() {
		return device;
	}
	
	/**
	 * method to set new device name
	 * @param device set the new device name
	 */
	public void setDevice(String device) {
		this.device = device;
	}
	
	/**
	 * method to return the count
	 * @return count
	 */
	public int getCount() {
		return count;
	}
	
	/**
	 * method to set the count
	 * @param count
	 */
	public void setCount(int count) {
		this.count = count;
	}
	
	/**
	 * Constructor for creating a device sets the count and perc to 0 and device name to empty string
	 * 
	 */
	public Device()
	{
		device = new String();
		count = 0;
		perc = 0;
	}
	
	/**
	 * return the perc
	 * @return perc
	 */
	public double getPerc() {
		return perc;
	}
	
	/**
	 * sets the perc
	 * @param perc
	 */
	public void setPerc(double perc) {
		this.perc = perc;
	}

}
