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
 * The device class, stores the device count and perc
 */
public class Device 
{
	private String device;
	private int count;
	private double perc;

	/**
	 * Setup the class with specifically defined variables
	 * @param device String, the device name
	 * @param count Int, how many of this device
	 * @param perc double, how many per category
     */
	public Device(String device, int count, double perc) {
		super();
		this.device = device;
		this.count = count;
		this.perc = perc;
	}

	/**
	 * Gets the current device name
	 * @return String, the device name
     */
	public String getDevice() {
		return device;
	}

	/**
	 * Replace the current device name with a new String variable
	 * @param device the new String variable
     */
	public void setDevice(String device) {
		this.device = device;
	}

	/**
	 * Get the count of this device
	 * @return the number of this device
     */
	public int getCount() {
		return count;
	}

	/**
	 * Replace the current device count variable with a new Int
	 * @param count the new int Variable
     */
	public void setCount(int count) {
		this.count = count;
	}

	/**
	 * Setup class with default values
	 * Int/double = 0
	 * string = empty string
	 */
	public Device()
	{
		device = new String();
		count = 0;
		perc = 0;
	}

	/**
	 * Returns the current perc
	 * @return double | The perc
	 */
	public double getPerc() {
		return perc;
	}

	/**
	 * set the current perc varaible to a new double variable
	 * @param perc The new double variable
	 */
	public void setPerc(double perc) {
		this.perc = perc;
	}

}
