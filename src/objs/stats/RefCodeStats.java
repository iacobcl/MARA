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
 * Deals with the reference code statistics
 */
public class RefCodeStats 
{
	private String classCode;
	private ArrayList<CodeDistr> dist;

	/**
	 * Setup the variables with empty values
	 */
	public RefCodeStats()
	{
		classCode = new String();
		dist = new ArrayList<CodeDistr>();
		
	}

	/**
	 * Setup the variables with default valuse
	 * @param classCode The String for the classCode variable
	 * @param dist The CodeDistr ArrayList for the dist variable
     */
	public RefCodeStats(String classCode, ArrayList<CodeDistr> dist) {
		super(); //pointless super()? This class isn't a child of anything
		this.classCode = classCode;
		this.dist = dist;
	}

	/**
	 * Returns the classCode as a String
	 * @return the classCode String
     */
	public String getClassCode() {
		return classCode;
	}

	/**
	 * Replaces the current classCode variable with a new String
	 * @param classCode The new string
     */
	public void setClassCode(String classCode) {
		this.classCode = classCode;
	}

	/**
	 * Gets the current dist variable as a CodeDistr ArrayList
	 * @return a CodeDistr ArrayList
	 */
	public ArrayList<CodeDistr> getDist() {
		return dist;
	}

	/**
	 * replaces the current dist variable with a new ArrayList of CodeDist objects
	 * @param dist the new ArrayList of CodeDist objects
     */
	public void setDist(ArrayList<CodeDistr> dist) {
		this.dist = dist;
	}
	
	

}
