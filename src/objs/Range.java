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
	*Constructor for <b>Range</b>
	*Default
	*Set all attributes to 0
	*/
	public Range()
	{
		min = 0;
		max = 0;
		count = 0;
		perc = 0;
	}
	/**
	*Constructor for <b>Range</b>
	*@param min
	*@param max
	*@param count
	*@param perc
	*/
	public Range(double min, double max, int count, double perc) {
		super();
		this.min = min;
		this.max = max;
		this.count = count;
		this.perc = perc;
	}

	/**
	*Getter for <b>Min</b>
	*@return Min
	*/
	public double getMin() {
		return min;
	}

	/**
	*Setter for <b>Min</b>
	*@param Min
	*/
	public void setMin(double min) {
		this.min = min;
	}

	/**
	*Getter for <b>Max</b>
	*@return Max
	*/
	public double getMax() {
		return max;
	}

	/**
	*Setter for <b>Max</b>
	*@param Max
	*/
	public void setMax(double max) {
		this.max = max;
	}

	/**
	*Getter for <b>Count</b>
	*@return Count
	*/
	public int getCount() {
		return count;
	}

	/**
	*Setter for <b>Count</b>
	*@param Count
	*/
	public void setCount(int count) {
		this.count = count;
	}

	/**
	*Getter for <b>Perc</b>
	*@return Perc
	*/
	public double getPerc() {
		return perc;
	}

	/**
	*Setter for <b>Perc</b>
	*@param Perc
	*/
	public void setPerc(double perc) {
		this.perc = perc;
	}


}
