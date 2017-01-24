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
 * 
 * @author Claudia Iacob
 */

public class Code 
{

	private String classCode;
	private String refinedCode;
	private String rawCode;
	
	/**
	 * Constructor method
	 */
	public Code() 
	{
		this.classCode = new String();
		this.refinedCode = new String();
		this.rawCode = new String();
	}
	
    	/**
    	 * A get method which returns the class code
    	 * 
    	 * @return a string consisting of the class's code
    	 */
	public String getClassCode() {
		return classCode;
	}
	
	/**
	 * A set method to assign a string to the instance variable of "classCode"
	 * 
	 * @param classCode stores the string of code into the instance variable "classCode"
	 */
	public void setClassCode(String classCode) {
		this.classCode = classCode;
	}

	/**
	 * A get method which returns the refined code
	 * 
	 * @return  a string consisting of refined code
	 */
	public String getRefinedCode() {
		return refinedCode;
	}

	/**
	 * A set method which assigns a string to the instance variable of "refinedCode"
	 * 
	 * @param refinedCode stores the parameter input into the instance variable "classCode"
	 */
	public void setRefinedCode(String refinedCode) {
		this.refinedCode = refinedCode;
	}

	/**
	 * A get method to return the instance variable "rawCode"
	 * 
	 * @return the instance variable string "rawCode"
	 */
	public String getRawCode() {
		return rawCode;
	}

	/**
	 * A set method which assigns the parameter input string to the instance variable "rawCode"
	 * 
	 * @param rawCode stores the parameter input into the instance variable "rawCode"
	 */
	public void setRawCode(String rawCode) {
		this.rawCode = rawCode;
	}	
}
