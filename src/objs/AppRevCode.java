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
//create private variables for section of application
	private String appid;
	private String revid;
	private String classcode;
	private String refcode;
//set the value of variables as strings.
	public AppRevCode()
	{
		appid = new String();
		revid = new String();
		classcode = new String();
		refcode = new String();
	}
//parse in strings for each variable and set the parsed data as the value of variables.
	public AppRevCode(String appid, String revid, String classcode,
			String refcode) {
		super();
		this.appid = appid;
		this.revid = revid;
		this.classcode = classcode;
		this.refcode = refcode;
	}
//return value of appid.
	public String getAppid() {
		return appid;
	}
//set value of appid via parsed in string.
	public void setAppid(String appid) {
		this.appid = appid;
	}
//return value of revid.
	public String getRevid() {
		return revid;
	}
//set value of rev id via parsed in string.
	public void setRevid(String revid) {
		this.revid = revid;
	}
//return value of classcode.
	public String getClasscode() {
		return classcode;
	}
//set value of classcode via parsed in string.
	public void setClasscode(String classcode) {
		this.classcode = classcode;
	}
//return value of refcode.
	public String getRefcode() {
		return refcode;
	}
//set value of refcode via parsed in string.
	public void setRefcode(String refcode) {
		this.refcode = refcode;
	}



}
