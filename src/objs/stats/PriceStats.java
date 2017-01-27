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

import java.util.ArrayList;

import objs.CodeDistr;

/**
 * Deals with the Price statistics
 */
public class PriceStats 
{
	private double min;
	private double max;
	private ArrayList<CodeDistr> dist;

	/**
	 * Setup the class with defaults all set to 0 and dist to a CodeDistr ArrayList
	 */
	public PriceStats()
	{
		min = 0;
		max = 0;
		dist = new ArrayList<CodeDistr>();
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
	 * Gets the current distribution used
	 * @return The arrayList of distributions
	 */
	public ArrayList<CodeDistr> getDist() {
		return dist;
	}

	/**
	 * Set the ArrayList of distributions to a new list
	 * @param dist The new Arraylist of Distributions
	 */
	public void setDist(ArrayList<CodeDistr> dist) {
		this.dist = dist;
	}
	

	
	

}
