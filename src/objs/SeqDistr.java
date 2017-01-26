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

public class SeqDistr
{
	private String codeA1; //class code for code 1
	private String codeA2; //refined code for code 1
	private String codeB1; //class code for code 2
	private String codeB2; //refined code for code 2
	private int total;
	private double perc;

	/**
	*Constructor for <b>SeqDistr</b>
	*Default
	*/
	public SeqDistr()
	{
		codeA1 = new String();
		codeB1 = new String();
		codeA2 = new String();
		codeB2 = new String();
		total = 0;
		perc = 0;
	}

	/**
	*Constructor for <b>SeqDistr</b>
	*@param codeA1
	*@param codeA2
	*@param codeB1
	*@param codeB2
	*@param total
	*@param perc
	*/
	public SeqDistr(String codeA1, String codeA2, String codeB1, String codeB2, int total, double perc)
	{
		super();
		this.codeA1 = codeA1;
		this.codeB1 = codeB1;
		this.codeA2 = codeA2;
		this.codeB2 = codeB2;
		this.total = total;
		this.perc = perc;
	}

	/**
	*Getter for <b>CodeA2</b>
	*@return CodeA2
	*/
	public String getCodeA2() {
		return codeA2;
	}

	/**
	*Setter for <b>CodeA2</b>
	*@param CodeA2
	*/
	public void setCodeA2(String codeA2) {
		this.codeA2 = codeA2;
	}

	/**
	*Getter for <b>CodeB2</b>
	*@return CodeB2
	*/
	public String getCodeB2() {
		return codeB2;
	}

	/**
	*Setter for <b>CodeB2</b>
	*@param CodeB2
	*/
	public void setCodeB2(String codeB2) {
		this.codeB2 = codeB2;
	}

	/**
	*Getter for <b>CodeA1</b>
	*@return CodeA1
	*/
	public String getCodeA1()
	{
		return codeA1;
	}

	/**
	*Setter for <b>CodeA</b>
	*@param CodeA
	*/
	public void setCodeA(String codeA1)
	{
		this.codeA1 = codeA1;
	}

	/**
	*Getter for <b>CodeB1</b>
	*@return CodeB1
	*/
	public String getCodeB1()
	{
		return codeB1;
	}

	/**
	*Setter for <b>CodeB</b>
	*@param CodeB
	*/
	public void setCodeB(String codeB1)
	{
		this.codeB1 = codeB1;
	}

	/**
	*Getter for <b>Total</b>
	*@return Total
	*/
	public int getTotal()
	{
		return total;
	}

	/**
	*Setter for <b>Total</b>
	*@param Total
	*/
	public void setTotal(int total)
	{
		this.total = total;
	}

	/**
	*Getter for <b>Perc</b>
	*@return Perc
	*/
	public double getPerc()
	{
		return perc;
	}

	/**
	*Setter for <b>Perc</b>
	*@param Perc
	*/
	public void setPerc(double perc)
	{
		this.perc = perc;
	}
}
