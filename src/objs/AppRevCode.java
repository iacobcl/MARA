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
	*Constructor for <b>AppRecCode</b>
	*Set all attributes to new string
	*default
	*/
	public AppRevCode()
	{
		appid = new String();
		revid = new String();
		classcode = new String();
		refcode = new String();
	}

	/**
	*Constructor for <b>AppRecCode</b>
	*@param appid
	*@param revid
	*@param classcode
	*@param refcode
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
	*Getter for <b>Appid</b>
	*@return appid
	*/
	public String getAppid() {
		return appid;
	}

	/**
	*Setter for <b>Appid</b>
	*@param appid
	*/
	public void setAppid(String appid) {
		this.appid = appid;
	}

	/**
	*Getter for <b>Revid</b>
	*@return revid
	*/
	public String getRevid() {
		return revid;
	}

	/**
	*Setter for <b>Revid</b>
	*@param revid
	*/
	public void setRevid(String revid) {
		this.revid = revid;
	}

	/**
	*Getter for <b>Classcode</b>
	*@return classcode
	*/
	public String getClasscode() {
		return classcode;
	}

	/**
	*Setter for <b>Classcode</b>
	*@param classcode
	*/
	public void setClasscode(String classcode) {
		this.classcode = classcode;
	}

	/**
	*Getter for <b>Refcode</b>
	*@return refcode
	*/
	public String getRefcode() {
		return refcode;
	}

	/**
	*Setter for <b>Refcode</b>
	*@param refcode
	*/
	public void setRefcode(String refcode) {
		this.refcode = refcode;
	}

}
