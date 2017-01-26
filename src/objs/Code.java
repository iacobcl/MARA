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


public class Code
{

	private String classCode;
	private String refinedCode;
	private String rawCode;

	/**
	*Constructor for <b>Code</b>
	*Set all attributes to new string
	*/
	public Code()
	{
		this.classCode = new String();
		this.refinedCode = new String();
		this.rawCode = new String();
	}

	/**
	*Getter for <b>ClassCode</b>
	*@return classCode
	*/
	public String getClassCode() {
		return classCode;
	}

	/**
	*Setter for <b>ClassCode</b>
	*@param classCode
	*/
	public void setClassCode(String classCode) {
		this.classCode = classCode;
	}

	/**
	*Getter for <b>RefinedCode</b>
	*@return refinedCode
	*/
	public String getRefinedCode() {
		return refinedCode;
	}

	/**
	*Setter for <b>RefinedCode</b>
	*@param refinedCode
	*/
	public void setRefinedCode(String refinedCode) {
		this.refinedCode = refinedCode;
	}

	/**
	*Getter for <b>RawCode</b>
	*@return rawCode
	*/
	public String getRawCode() {
		return rawCode;
	}

	/**
	*Setter for <b>RawCode</b>
	*@param rawCode
	*/
	public void setRawCode(String rawCode) {
		this.rawCode = rawCode;
	}
}
