
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

public class CodeDistr
{
//create private variables for section of application
	private String code;
	private int total;
	private double perc;
	private int totalrel;
	private double percrel;

	public CodeDistr()
	{
//give all the variables an applicable value
		code = new String();
		total = 0;
		perc = 0;
		totalrel = 0;
		percrel = 0;
	}
//assign all the variables a value based on parsed in data
	public CodeDistr(String c, int t, double p, int totalr, double perrel)
	{
		code = c;
		total = t;
		perc = p;
		totalrel = totalr;
		percrel = perrel;
	}

//return the value of code variable
	public String getCode() {
		return code;
	}

//set the value of the code variable
	public void setCode(String code) {
		this.code = code;
	}

//return the value of the total variable
	public int getTotal() {
		return total;
	}

//set the value of the total variable
	public void setTotal(int total) {
		this.total = total;
	}

//return the value of the perc variable
	public double getPerc() {
		return perc;
	}

//set the value of the perc variable
	public void setPerc(double perc) {
		this.perc = perc;
	}
//return the value of the totalrel variable
	public int getTotalrel() {
		return totalrel;
	}
//set the value of the totalrel variable
	public void setTotalrel(int totalrel) {
		this.totalrel = totalrel;
	}
//return the value of the percrel variable
	public double getPercrel() {
		return percrel;
	}
//set the value of the percrel variable
	public void setPercrel(double percrel) {
		this.percrel = percrel;
	}


}
