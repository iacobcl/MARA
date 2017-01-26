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
        
        /**
         * @param min double min value
         * @param max double max value
         * @param count int count value
         * @param perc double perc
         */
	public Range(double min, double max, int count, double perc) {
		super();
		this.min = min;
		this.max = max;
		this.count = count;
		this.perc = perc;
	}
        
        /**
         * @return Return min value
         */
	public double getMin() {
		return min;
	}
        
        /**
         * @param min double min value
         */
	public void setMin(double min) {
		this.min = min;
	}
        
        /**
         * @return Return max value
         */
	public double getMax() {
		return max;
	}
        
        /**
         * @param max double max value
         */
	public void setMax(double max) {
		this.max = max;
	}
        
        /**
         * @return Return count value
         */
	public int getCount() {
		return count;
	}
        
        /**
         * @param count int count value
         */
	public void setCount(int count) {
		this.count = count;
	}
        
        /**
         * @return Return perc
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
	
	public Range()
	{
		min = 0;
		max = 0;
		count = 0;
		perc = 0;
	}

}
