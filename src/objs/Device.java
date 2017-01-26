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
 * @author Iacob
 * A class representing a device
 */
public class Device 
{
	private String device;
	private int count;
	private double perc;
	
        /**
         * Constructor
         * @param device the device name
         * @param count the device number
         * @param perc the percentage
         */
	public Device(String device, int count, double perc) {
		super();
		this.device = device;
		this.count = count;
		this.perc = perc;
	}
        
        /**
         * @return the device name 
         */
	public String getDevice() {
		return device;
	}
        /**
         * set the device name
         * @param device the device name 
         */
	public void setDevice(String device) {
		this.device = device;
	}
        /**
         * @return the device number
         */
	public int getCount(){
		return count;
	}
        
        /**
         * set the device number
         * @param count the device number
         */
	public void setCount(int count) {
		this.count = count;
	}
	
        /**
         * Constructor
         */
	public Device()
	{
		device = new String();
		count = 0;
		perc = 0;
	}
        
        /**
         * @return the percentage 
         */
	public double getPerc() {
		return perc;
	}
        
        /**
         * set the percentage
         * @param perc the percentage 
         */
	public void setPerc(double perc) {
		this.perc = perc;
	}

}

