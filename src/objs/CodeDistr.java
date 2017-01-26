
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

	private String code;
	private int total;
	private double perc;
	private int totalrel;
	private double percrel;

	/**
	*Constructor for <b>CodeDistributer(codeDistr)</b>
	*default
	*/
	public CodeDistr()
	{
		code = new String();
		total = 0;
		perc = 0;
		totalrel = 0;
		percrel = 0;
	}

	/**
	*Constructor for <b>CodeDistributer(codeDistr)</b>
	*@param c,t,p,totalr,parrel
	*/
	public CodeDistr(String c, int t, double p, int totalr, double perrel)
	{
		code = c;
		total = t;
		perc = p;
		totalrel = totalr;
		percrel = perrel;
	}

	/**
	*Getter for <b>Code</b>
	*@return Code
	*/
	public String getCode() {
		return code;
	}

	/**
	*Setter for <b>Code</b>
	*@param Code
	*/
	public void setCode(String code) {
		this.code = code;
	}

	/**
	*Getter for <b>Total</b>
	*@return Total
	*/
	public int getTotal() {
		return total;
	}

	/**
	*Setter for <b>Total</b>
	*@param Total
	*/
	public void setTotal(int total) {
		this.total = total;
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

	/**
	*Getter for <b>Totalrel</b>
	*@return Totalrel
	*/
	public int getTotalrel() {
		return totalrel;
	}

	/**
	*Setter for <b>Totalrel</b>
	*@param Totalrel
	*/
	public void setTotalrel(int totalrel) {
		this.totalrel = totalrel;
	}

	/**
	*Getter for <b>Percrel</b>
	*@return Percrel
	*/
	public double getPercrel() {
		return percrel;
	}

	/**
	*Setter for <b>Percrel</b>
	*@param Percrel
	*/
	public void setPercrel(double percrel) {
		this.percrel = percrel;
	}


}
