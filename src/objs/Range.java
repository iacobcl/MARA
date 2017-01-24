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

public class Range 
{
	private double min;
	private double max;
	private int count;
	private double perc;
	public Range(double min, double max, int count, double perc) { /*  This is the constructor which sets all the variable a dataype and a name" */
		super();
		this.min = min; 
		this.max = max;
		this.count = count;
		this.perc = perc;
	}
	public double getMin() {
		return min; /* returns the minimum of the range */
	}
	public void setMin(double min) { /* sets the minimum and makes sure that the minimum is set to 0*/
		this.min = min;
	}
	public double getMax() {
		return max; /* returns the maximum of the range */
	}
	public void setMax(double max) {
		this.max = max;
	}
	public int getCount() { /* returns the count*/
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}
	public double getPerc() {
		return perc;
	}
	public void setPerc(double perc) {
		this.perc = perc;
	}
	/* The code below shows the range of all the variables it also shows that the variables are set to 0 */
	public Range()
	{
		min = 0;
		max = 0;
		count = 0;
		perc = 0;
	}

}
