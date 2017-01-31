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

public class PriceWorthStats 
{
	private double min;
	private double max;
	private CodeDistr worth;
	private CodeDistr nworth;
	
	public PriceWorthStats()
	{
		min = 0;
		max = 0;
		worth = new CodeDistr();
		nworth = new CodeDistr();
	}
	
	
	
	public PriceWorthStats(double min, double max, CodeDistr worth,
			CodeDistr nworth) {
		super();
		this.min = min;
		this.max = max;
		this.worth = worth;
		this.nworth = nworth;
	}



	public double getMin() {
		return min;
	}
	public void setMin(double min) {
		this.min = min;
	}
	public double getMax() {
		return max;
	}
	public void setMax(double max) {
		this.max = max;
	}
	public CodeDistr getWorth() {
		return worth;
	}
	public void setWorth(CodeDistr worth) {
		this.worth = worth;
	}
	public CodeDistr getNworth() {
		return nworth;
	}
	public void setNworth(CodeDistr nworth) {
		this.nworth = nworth;
	}
	
	
	

}
