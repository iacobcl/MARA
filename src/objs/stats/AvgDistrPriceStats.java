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

package objs.stats;


/**
 * Calculates the average Distr price statistics
 */
public class AvgDistrPriceStats 
{

	private double min;
	private double max;
	private double avg;

	/**
	 * Setup the class with defaults all set to 0
	 */
	public AvgDistrPriceStats()
	{
		min = 0;
		max = 0;
		avg = 0;
	}

	/**
	 * Set this specific classes values
	 * @param min The minimum value
	 * @param max The maximum value
	 * @param avg The average value
     */
	public AvgDistrPriceStats(double min, double max, double avg) 
	{
		this.min = min;
		this.max = max;
		this.avg = avg;
	}


	/**
	 * Returns the minimum value
	 * @return the minimum value
     */
	public double getMin() {
		return min;
	}

	/**
	 * Sets the minumum value
	 * @param min The new minimum value
     */
	public void setMin(double min) {
		this.min = min;
	}

	/**
	 * Gets the maximum value
	 * @return The maximum value
     */
	public double getMax() {
		return max;
	}

	/**
	 * Sets the maximum value
	 * @param max The new maximum value
     */
	public void setMax(double max) {
		this.max = max;
	}

	/**
	 * Gets the average value
	 * @return The average value
     */
	public double getAvg() {
		return avg;
	}

	/**
	 * Sets the average value
	 * @param avg The new average value
     */
	public void setAvg(double avg) {
		this.avg = avg;
	}
	
	
	
}
