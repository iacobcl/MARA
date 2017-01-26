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
	* Initialises variabes
	*/
	public AppRevCode()
	{
		appid = new String();
		revid = new String();
		classcode = new String();
		refcode = new String();
	}

	/**
	* Assigns values to variables
	* @param appid - a value
	* @param revid - a value
	* @param classcode - a value
	* @param string - a value
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
	* Returns the applicated id
	* @return appid - a value
	*/
	public String getAppid() {
		return appid;
	}

	/**
	* Sets the value of application id variable
	* @param appid - a value
	*/
	public void setAppid(String appid) {
		this.appid = appid;
	}

	/**
	* Returns the review id
	* @return revid - a value
	*/
	public String getRevid() {
		return revid;
	}

	/**
	* Sets the value of review id variable
	* @param revid - a value
	*/
	public void setRevid(String revid) {
		this.revid = revid;
	}

	/**
	* Returns the classcode
	* @return classcode - a value
	*/
	public String getClasscode() {
		return classcode;
	}

	/**
	* Sets the value of classcode variable
	* @param classcode - a value
	*/
	public void setClasscode(String classcode) {
		this.classcode = classcode;
	}

	/**
	* Returns the refcode
	* @return refcode - a value
	*/
	public String getRefcode() {
		return refcode;
	}

	/**
	* Sets the value of refcode variable
	* @param refcode - a value
	*/
	public void setRefcode(String refcode) {
		this.refcode = refcode;
	}



}
