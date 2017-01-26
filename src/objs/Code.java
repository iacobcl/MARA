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
	
	public Code() 
	{
		this.classCode = new String();
		this.refinedCode = new String();
		this.rawCode = new String();
	}
        
        /**
         * @return Return code of class
         */
	public String getClassCode() {
		return classCode;
	}

        /**
         * @param classCode Code of class
         */
	public void setClassCode(String classCode) {
		this.classCode = classCode;
	}

        /**
         * @return Return code of refined
         */
	public String getRefinedCode() {
		return refinedCode;
	}

        /**
         * @param refinedCode Code of refined
         */
	public void setRefinedCode(String refinedCode) {
		this.refinedCode = refinedCode;
	}

        /**
         * @return Return code of raw
         */
	public String getRawCode() {
		return rawCode;
	}

        /**
         * @param rawCode Code of raw
         */
	public void setRawCode(String rawCode) {
		this.rawCode = rawCode;
	}
	
	
	
	
	
	
}
