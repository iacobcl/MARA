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
 *  Deals with the rate statistics
 */
public class RateStats 
{
	private int stars;
	private ArrayList<CodeDistr> dist;

	/**
	 * Setup the class variables with deafult values of 0 and and empty CodeDistr ArrayList
	 */
	public RateStats()
	{
		stars = 0;
		dist = new ArrayList<CodeDistr>();
	}

	/**
	 * Returns the number of stars
	 * @return The number of stars
     */
	public int getStars() {
		return stars;
	}

	/**
	 * Set the stars variable to a new integer
	 * @param stars The new integer
     */
	public void setStars(int stars) {
		this.stars = stars;
	}

	/**
	 * Returns the ArrayList for Distributions
	 * @return the ArrayList for Distributions
     */
	public ArrayList<CodeDistr> getDist() {
		return dist;
	}

	/**
	 * Repalces the current dist with a new ArrayList of CodeDistr objects
	 * @param dist the new ArrayList of CodeDistr objects
     */
	public void setDist(ArrayList<CodeDistr> dist) {
		this.dist = dist;
	}
	
	

}
