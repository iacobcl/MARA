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
 * Represents a device.
 * @author abc
 */
public class Device 
{       
        /**
         * Holds device name
         */
	private String device;
        
        /**
         * Holds count value
         */
	private int count;
        
        /**
         * Holds perc value
         */
	private double perc;
	
        
        /**
         * Constructs Device object
         * @param device String for device name
         * @param count Integer for count
         * @param perc Double for perc
         */
	public Device(String device, int count, double perc) {
		super();
		this.device = device;
		this.count = count;
		this.perc = perc;
	}
        
        /**
         * Returns value of device field
         * @return String of device field
         */
	public String getDevice() {
		return device;
	}
        
        /**
         * Changes value of device field to new value
         * @param device New value for device field
         */
	public void setDevice(String device) {
		this.device = device;
	}
        
        /**
         * Gets the integer stored in the count field.
         * @return Value of count
         */
	public int getCount() {
		return count;
	}
        
        /**
         * Changes value of count field to new integer.
         * @param count New integer for count field
         */
	public void setCount(int count) {
		this.count = count;
	}
	
        /**
         * Creates empty device object.
         */
	public Device()
	{
		device = new String();
		count = 0;
		perc = 0;
	}
        
        /**
         * Returns value of perc field
         * @return Double value of perc field
         */
	public double getPerc() {
		return perc;
	}
        
        /**
         * Changes value of perc field to new double.
         * @param perc New double for perc field
         */
	public void setPerc(double perc) {
		this.perc = perc;
	}

}
