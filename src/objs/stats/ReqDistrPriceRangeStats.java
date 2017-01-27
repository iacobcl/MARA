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
 * Deals with the Required Distributions price range statistics
 */
public class ReqDistrPriceRangeStats 
{
	
	private float min;
	private float max;
	private CodeDistr req;

	/**
	 * Setup the class with default values, floats to 0 and req to a CodeDistr
	 */
	public ReqDistrPriceRangeStats()
	{
		min = 0;
		max = 0;
		req = new CodeDistr();
	}

	/**
	 * Returns the minimum value
	 * @return the minimum value
	 */
	public float getMin() {
		return min;
	}

	/**
	 * Sets the minumum value
	 * @param min The new minimum value
	 */
	public void setMin(float min) {
		this.min = min;
	}

	/**
	 * Gets the maximum value
	 * @return The maximum value
	 */
	public float getMax() {
		return max;
	}

	/**
	 * Sets the maximum value
	 * @param max The new maximum value
	 */
	public void setMax(float max) {
		this.max = max;
	}

	/**
	 * Returns a CodeDistr object for the req variable
	 * @return The req CodeDistr object
     */
	public CodeDistr getReq() {
		return req;
	}

	/**
	 * Replace the current req variable with a new CodeDistr object
	 * @param req The new CodeDistr object to give req
     */
	public void setReq(CodeDistr req) {
		this.req = req;
	}
	
	
	
	
	

}
