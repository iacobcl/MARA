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
	private String device; /* these are the  variables set as int and double  */
	private int count;
	private double perc;
	
	public Device(String device, int count, double perc) {  /* parameters of the device is  string meaning it does not allow integers and floats, count allow integer(whole numbers) and perc allow double( decimal) */
		super();
		this.device = device;
		this.count = count;
		this.perc = perc;
	}
	public String getDevice() { /* returns the value of  the device */
		return device;
	}
	public void setDevice(String device) {
		this.device = device;
	}
	public int getCount() {  /* returns the value of  the count */
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}
	
	public Device()
	{
		device = new String();  /* sets the initial values for the  variables of the device */
		count = 0;
		perc = 0;
	}
	public double getPerc() {  /* returns the value of  perc */
		return perc;
	}
	public void setPerc(double perc) {
		this.perc = perc;
	}

}
