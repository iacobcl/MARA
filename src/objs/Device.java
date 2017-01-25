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
* This class creates a device containing three attributes; device (String), count (integer) and perc (double).
*/

public class Device
{
	private String device;
	private int count;
	private double perc;


/**
 * Constructor for class Device.
 * @param  String device
 * @param  int    count
 * @param  double perc
 */
	public Device(String device, int count, double perc) {
		super();
		this.device = device;
		this.count = count;
		this.perc = perc;
	}
	/**
	 * Get method for device, returns device as String.
	 * @return device
	 */
	public String getDevice() {
		return device;
	}
	/**
	 * Set method for device, assigns the parsed parameter to variable device.
	 * @param String device
	 */
	public void setDevice(String device) {
		this.device = device;
	}
	/**
	 * Get method for count, returns count as integer
	 * @return count
	 */
	public int getCount() {
		return count;
	}
	/**
	 * Set method for count, assigns the parsed parameter to variable count.
	 * @param String count
	 */
	public void setCount(int count) {
		this.count = count;
	}
	/**
	 */
	public Device()
	{
		device = new String();
		count = 0;
		perc = 0;
	}
	/**
	 * Get method for perc, returns perc as double.
	 * @return perc
	 */
	public double getPerc() {
		return perc;
	}
	/**
	 * Set method for perc, assigns the parsed parameter to variable perc.
	 * @param double perc
	 */
	public void setPerc(double perc) {
		this.perc = perc;
	}

}
