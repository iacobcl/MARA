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

public class AppRevCode
{
	private String appid;
	private String revid;
	private String classcode;
	private String refcode;
	/**
	* Blank constructor, creates 4 String varriables called appid, revid, classcode, refcode
	*/
	public AppRevCode()
	{
		appid = new String();
		revid = new String();
		classcode = new String();
		refcode = new String();
	}
	/**
	* constructor
	* @param appid
	* @param revid
	* @param classcode
	* @param refcode
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
	* Returns the rating as a double
	* @return rating double -
	*/
	public String getAppid() {
		return appid;
	}
	/**
	* Returns sets appid to the String parameter
	*/
	public void setAppid(String appid) {
		this.appid = appid;
	}
	/**
	* Returns the revid as a double
	* @return revid double -
	*/
	public String getRevid() {
		return revid;
	}
	/**
	* Returns sets revid to the String parameter
	*/
	public void setRevid(String revid) {
		this.revid = revid;
	}
	/**
	* Returns the classcode as a double
	* @return classcode double -
	*/
	public String getClasscode() {
		return classcode;
	}
	/**
	* Returns sets classcode to the String parameter
	*/
	public void setClasscode(String classcode) {
		this.classcode = classcode;
	}
	/**
	* Returns the refcode as a double
	* @return refcode double -
	*/
	public String getRefcode() {
		return refcode;
	}
		/**
		* Returns sets setRefcode to the String parameter
		*/
	public void setRefcode(String refcode) {
		this.refcode = refcode;
	}
