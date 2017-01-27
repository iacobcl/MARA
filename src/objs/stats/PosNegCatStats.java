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

public class PosNegCatStats 
{
	private String cat;
	private CodeDistr pos;
	private CodeDistr neg;

	/**
	 * Setup the class without and specific values and as empty variables
	 */
	public PosNegCatStats()
	{
		cat = new String();
		pos = new CodeDistr();
		neg = new CodeDistr();
	}

	/**
    * Setup the class with specific values
	* @param cat A String for category
	* @param pos CodeDistr of Positive values
    * @param neg CodeDistr of Negative values
	*/
	public PosNegCatStats(String cat, CodeDistr pos, CodeDistr neg) {
		super(); //Seems obsoulete since this isn't a child class
		this.cat = cat;
		this.pos = pos;
		this.neg = neg;
	}

	/**
	 * Returns the category of the code
	 * @return the category
	 */
	public String getCat() {
		return cat;
	}

	/**
	 * Sets the category for this specific class
	 * @param cat the new category
	 */
	public void setCat(String cat) {
		this.cat = cat;
	}

	/**
	 * gets the CodeDistr of positive values
	 * @return the CodeDistr of positive values
     */
	public CodeDistr getPos() {
		return pos;
	}

	/**
	 * Sets the codeDistr of positive values to a new set
	 * @param pos The new CodeDistr
     */
	public void setPos(CodeDistr pos) {
		this.pos = pos;
	}

	/**
	 * gets the CodeDistr of negative values
	 * @return the CodeDistr of negative values
	 */
	public CodeDistr getNeg() {
		return neg;
	}

	/**
	 * Sets the codeDistr of negative values to a new set
	 * @param neg The new CodeDistr
	 */
	public void setNeg(CodeDistr neg) {
		this.neg = neg;
	}
	
	
	
	
}
