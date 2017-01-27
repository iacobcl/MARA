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

import objs.CodeDistr;

/**
 * Deals with the price worth statistics
 */
public class PriceWorthStats 
{
	private double min;
	private double max;
	private CodeDistr worth;
	private CodeDistr nworth;

	/**
	 * Setup the class with defaults all set to 0 or to a CodeDistr object
	 */
	public PriceWorthStats()
	{
		min = 0;
		max = 0;
		worth = new CodeDistr();
		nworth = new CodeDistr();
	}


	/**
	 * Setup the class using specific values
	 * @param min The minimum as a double
	 * @param max The maximum as a double
	 * @param worth The worth as a CodeDistr
	 * @param nworth the nWorth as a CodeDistr
     */
	public PriceWorthStats(double min, double max, CodeDistr worth,
			CodeDistr nworth) {
		super();
		this.min = min;
		this.max = max;
		this.worth = worth;
		this.nworth = nworth;
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
	 * Gets the worth as a CodeDistr object
	 * @return Worth variable
     */
	public CodeDistr getWorth() {
		return worth;
	}

	/**
	 * Sets the current Worth variable to a new CodeDistr
	 * @param worth the new CodeDistr for worth
     */
	public void setWorth(CodeDistr worth) {
		this.worth = worth;
	}

	/**
	 * Gets the net worth as a CodeDistr object
	 * @return
     */
	public CodeDistr getNworth() {
		return nworth;
	}

	/**
	 * Sets the current new worth variable to a new CodeDistr
	 * @param nworth the new CodeDistr for net worth
     */
	public void setNworth(CodeDistr nworth) {
		this.nworth = nworth;
	}
	
	
	

}
