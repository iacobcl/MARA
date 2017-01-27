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
 * Reviewed application code object
 */
public class AppRevCode 
{
	private String appid;
	private String revid;
	private String classcode;
	private String refcode;

	/**
	 * Setup the class with empty variables
	 */
	public AppRevCode()
	{
		appid = new String();
		revid = new String();
		classcode = new String();
		refcode = new String();
	}

	/**
	 * Ssetup the class with defined variables
	 * @param appid String, the appID
	 * @param revid String the review ID
	 * @param classcode String, the class code thats reviewed
     * @param refcode String, the refined code to compare with the classcode
     */
	public AppRevCode(String appid, String revid, String classcode,
			String refcode) {
		super();
		this.appid = appid;
		this.revid = revid;
		this.classcode = classcode;
		this.refcode = refcode;
	}

	/**
	 * Get the application ID
	 * @return String, the current appID
     */
	public String getAppid() {
		return appid;
	}

	/**
	 * Replaces the current appID with a new String
	 * @param appid The new string to replace appId
     */
	public void setAppid(String appid) {
		this.appid = appid;
	}

	/**
	 * Get the current reviewID
	 * @return String, the review ID
     */
	public String getRevid() {
		return revid;
	}

	/**
	 * replace the current revID with a new string
	 * @param revid the new string to replace revID with
     */
	public void setRevid(String revid) {
		this.revid = revid;
	}

	/**
	 * Get the current ClassCode
	 * @return String, the current class code
     */
	public String getClasscode() {
		return classcode;
	}

	/**
	 * Replace the current ClassCode with a new String
	 * @param classcode the new String to replace ClassCode
     */
	public void setClasscode(String classcode) {
		this.classcode = classcode;
	}

	/**
	 * Get the current refined code
	 * @return String, the refined code
     */
	public String getRefcode() {
		return refcode;
	}

	/**
	 * Replace the current refined code with a new String
	 * @param refcode the new String to replace Refined code.
     */
	public void setRefcode(String refcode) {
		this.refcode = refcode;
	}
}
