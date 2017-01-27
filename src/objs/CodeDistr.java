
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
 * The Code distribution class, Stores the code, total code and per category
 */
public class CodeDistr 
{

	private String code;
	private int total;
	private double perc;
	private int totalrel;
	private double percrel;

	/**
	 * Setup the class with default values
	 * 0 for ints
	 * empty string for String
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
	 * Setup the class with specifcly defined values
	 * @param c the code, String
	 * @param t Total amount of code, Int
	 * @param p code per category, double
	 * @param totalr total rel, Int
     * @param perrel percrel, Int
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
	 * Gets the current code
	 * @return String, the code
     */
	public String getCode() {
		return code;
	}

	/**
	 * Replaces the current code with a new String variable
	 * @param code the new String variable
     */
	public void setCode(String code) {
		this.code = code;
	}

	/**
	 * Gets the current code total
	 * @return Int, the total
	 */
	public int getTotal() {
		return total;
	}

	/**
	 * Replaces the current total with a new Int variable
	 * @param total the new Int variable
	 */
	public void setTotal(int total) {
		this.total = total;
	}

	/**
	 * Gets the current perc variable
	 * @return Double, the perc variable
	 */
	public double getPerc() {
		return perc;
	}

	/**
	 * Replaces the current perc with a new double variable
	 * @param perc the new double variable
	 */
	public void setPerc(double perc) {
		this.perc = perc;
	}

	/**
	 * Gets the current totalrel
	 * @return Int, the totalRel
	 */
	public int getTotalrel() {
		return totalrel;
	}

	/**
	 * Replaces the current totalrel with a new Int variable
	 * @param totalrel the new Int variable
	 */
	public void setTotalrel(int totalrel) {
		this.totalrel = totalrel;
	}

	/**
	 * Gets the current percrel
	 * @return double, the percrel
	 */
	public double getPercrel() {
		return percrel;
	}

	/**
	 * Replaces the current percrel with a new double variable
	 * @param percrel the new souble variable
	 */
	public void setPercrel(double percrel) {
		this.percrel = percrel;
	}
}
