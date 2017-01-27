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

import java.util.ArrayList;

import objs.CodeDistr;

/**
 * Deals with the code per category statistics
 */
public class CodesPerCatStats 
{
	private String cat;
	private ArrayList<CodeDistr> distr;

	/**
	 * Setup the class variables, category (String) and the distr (arrayList)
	 */
	public CodesPerCatStats()
	{
		cat = new String();
		distr = new ArrayList<CodeDistr>();
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
	 * Gets the arraylist of the Distr
	 * @return The list of Distrs
     */
	public ArrayList<CodeDistr> getDistr() {
		return distr;
	}

	/**
	 * Sets the Distr array list to a new one
	 * @param distr New arraylist of Distrs
     */
	public void setDistr(ArrayList<CodeDistr> distr) {
		this.distr = distr;
	}
	
	

}
