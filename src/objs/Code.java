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
//create private variables for section of application
	private String classCode;
	private String refinedCode;
	private String rawCode;

	public Code()
	{
//set all of the variables to empty strings
		this.classCode = new String();
		this.refinedCode = new String();
		this.rawCode = new String();
	}
//return the value of classCode variable
	public String getClassCode() {
		return classCode;
	}
//set the value of the classCode variable
	public void setClassCode(String classCode) {
		this.classCode = classCode;
	}
//return the variable of the refinedCode variable
	public String getRefinedCode() {
		return refinedCode;
	}
//set the value of the refinedCode variable
	public void setRefinedCode(String refinedCode) {
		this.refinedCode = refinedCode;
	}
//return the value of the rawCode variable
	public String getRawCode() {
		return rawCode;
	}
//set the value of the rawCode variable
	public void setRawCode(String rawCode) {
		this.rawCode = rawCode;
	}






}
