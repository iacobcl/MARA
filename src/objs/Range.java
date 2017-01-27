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
 * Stores the values for ranges
 */
public class Range 
{
	private double min;
	private double max;
	private int count;
	private double perc;

	/**
	 * Setup the class with specific values
	 * @param min the minimum value
	 * @param max the maximum value
	 * @param count the number of ranges
     * @param perc the number of ranges per category
     */
	public Range(double min, double max, int count, double perc) {
		super();
		this.min = min;
		this.max = max;
		this.count = count;
		this.perc = perc;
	}

	/**
	 * Get the minimum value
	 * @return double, the smallest value
     */
	public double getMin() {
		return min;
	}

	/**
	 * Set the minimum value to a new double value
	 * @param min the new minimum value
     */
	public void setMin(double min) {
		this.min = min;
	}

	/**
	 * Get the maximum value
	 * @return double, the largest value
	 */
	public double getMax() {
		return max;
	}

	/**
	 * set the maximum value to a new double variable
	 * @param max the new largest value
     */
	public void setMax(double max) {
		this.max = max;
	}
	/**
	 * Get the total number of ranges
	 * @return int, the count of ranges
	 */
	public int getCount() {
		return count;
	}

	/**
	 * set the number of ranges to a new count
	 * @param count the new count
     */
	public void setCount(int count) {
		this.count = count;
	}

	/**
	 * Get the per category value
	 * @return double, the perc variable
	 */
	public double getPerc() {
		return perc;
	}

	/**
	 * set the number of ranges per category to a new value
	 * @param perc the new perc value
     */
	public void setPerc(double perc) {
		this.perc = perc;
	}

	/**
	 * setup the class with default values
	 * set everything to = 0
	 */
	public Range()
	{
		min = 0;
		max = 0;
		count = 0;
		perc = 0;
	}

}
