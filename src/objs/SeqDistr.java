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

/**
 *  Stores the Class and refined code, along with the total count
 */
public class SeqDistr 
{
	private String codeA1; //class code for code 1
	private String codeA2; //refined code for code 1
	private String codeB1; //class code for code 2
	private String codeB2; //refined code for code 2
	private int total;
	private double perc;

	/**
	 * Setup the class with empty variables
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
	 * Setup the class with specifically defined variable values
	 * @param codeA1 String, Class code 1
	 * @param codeA2 String, refined code 1
	 * @param codeB1 String, class code 2
	 * @param codeB2 String, refined code 2
	 * @param total int, The total amount of code
     * @param perc double, the total per category
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
	 * Get the String for the refined code 1
	 * @return String, refCode
     */
	public String getCodeA2() {
		return codeA2;
	}

	/**
	 * Set the refCode 1 to a new String Value
	 * @param codeA2 The new String value
	 */
	public void setCodeA2(String codeA2) {
		this.codeA2 = codeA2;
	}
	/**
	 * Get the String for the refined code 2
	 * @return String, refCode
	 */
	public String getCodeB2() {
		return codeB2;
	}

	/**
	 * Set the refCode 2 to a new String Value
	 * @param codeB2 The new String value
	 */
	public void setCodeB2(String codeB2) {
		this.codeB2 = codeB2;
	}
	/**
	 * Get the String for the ClassCode 1
	 * @return String, ClassCode
	 */
	public String getCodeA1() 
	{
		return codeA1;
	}

	/**
	 * Set the classCode 1 to a new String Value
	 * @param codeA1 The new String value
	 */
	public void setCodeA(String codeA1) 
	{
		this.codeA1 = codeA1;
	}
	/**
	 * Get the String for the ClassCode 1
	 * @return String, ClassCode
	 */
	public String getCodeB1() 
	{
		return codeB1;
	}

	/**
	 * Set the classCode 2 to a new String Value
	 * @param codeB1 The new String value
     */
	public void setCodeB(String codeB1) 
	{
		this.codeB1 = codeB1;
	}

	/**
	 * Get the total number of code in the class
	 * @return Int, the amount of code
     */
	public int getTotal() 
	{
		return total;
	}

	/**
	 * Set the total amount of code in the class
	 * @param total the new Int total
     */
	public void setTotal(int total) 
	{
		this.total = total;
	}

	/**
	 * Get the amount of code per category
	 * @return The amount of code per category
     */
	public double getPerc() 
	{
		return perc;
	}

	/**
	 * Change the value of the perc variable to a new double variable
	 * @param perc the new double variable to change to
     */
	public void setPerc(double perc) 
	{
		this.perc = perc;
	}
	
	

}
