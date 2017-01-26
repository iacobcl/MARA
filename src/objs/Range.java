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
/**
 * @param min minimum for the range
 * @param max maximum for the range
 * @param count unsure on its use
 * @param perc unsure on its use
 */

	private double min;
	private double max;
	private int count;
	private double perc;

	/**
	 * Constructor that sets the fields to corresponding parameters
	 * @param min minimum for the range
	 * @param max maximum for the range
	 * @param count unsure on its use
	 * @param perc unsure on its use
	 */
	public Range(double min, double max, int count, double perc) {
		super();
		this.min = min;
		this.max = max;
		this.count = count;
		this.perc = perc;
	}

/**
 * Returns the minimum value for the range
 * @return minimum value for the range
 */
	public double getMin() {
		return min;
	}

	/**
	 * Sets a new minimum value for the range
	 * @param min new value for the range
	 */
	public void setMin(double min) {
		this.min = min;
	}

	/**
	 * Returns the maximum value for the range
	 * @return maximum value for the range
	 */
	public double getMax() {
		return max;
	}

	/**
	 * Sets a new maximum value for the range
	 * @param max new value for the range
	 */
	public void setMax(double max) {
		this.max = max;
	}

	/**
	 * Returns the count value for the range
	 * @return count value for the range
	 */
	public int getCount() {
		return count;
	}

/**
 * Sets a new count value for the range
 * @param count new value for the range
 */
	public void setCount(int count) {
		this.count = count;
	}

	/**
	 * Returns the perc value for the range
	 * @return perc value for the range
	 */
	public double getPerc() {
		return perc;
	}

	/**
	 * Sets a new perc value for the range
	 * @param perc new value for the range
	 */
	public void setPerc(double perc) {
		this.perc = perc;
	}

/**
 * Constructor sets all parameters to zero
 */
	public Range()
	{
		min = 0;
		max = 0;
		count = 0;
		perc = 0;
	}

}
