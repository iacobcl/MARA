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
         * @param device device name
         * @param count int count
         * @param perc double perc
         */
	public Device(String device, int count, double perc) {
		super();
		this.device = device;
		this.count = count;
		this.perc = perc;
	}
        
        /**
         * @return Return device name
         */
	public String getDevice() {
		return device;
	}
        
        /**
         * @param device Device name
         */
	public void setDevice(String device) {
		this.device = device;
	}
        
        /**
         * @return Return int count
         */
	public int getCount() {
		return count;
	}
        
        /**
         * @param count int count
         */
	public void setCount(int count) {
		this.count = count;
	}
	
	public Device()
	{
		device = new String();
		count = 0;
		perc = 0;
	}
        
        /**
         * @return Return double perc
         */
	public double getPerc() {
		return perc;
	}
        
        /**
         * @param perc double perc
         */
	public void setPerc(double perc) {
		this.perc = perc;
	}

}
