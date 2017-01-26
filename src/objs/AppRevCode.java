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
	
        
	public AppRevCode()
	{
		appid = new String();
		revid = new String();
		classcode = new String();
		refcode = new String();
	}

        /**
         * @param appid ID of app
         * @param revid ID of rev
         * @param classcode Code of class
         * @param refcode Code of ref
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
         * @return Return ID of app
         */
	public String getAppid() {
		return appid;
	}

        /**
         * @param appid ID of app
         */
	public void setAppid(String appid) {
		this.appid = appid;
	}

        /**
         * @return Return ID of rev
         */
	public String getRevid() {
		return revid;
	}

        /**
         * @param revid ID of rev
         */
	public void setRevid(String revid) {
		this.revid = revid;
	}

        /**
         * @return Return code of class
         */
	public String getClasscode() {
		return classcode;
	}

        /**
         * @param classcode code of class
         */
	public void setClasscode(String classcode) {
		this.classcode = classcode;
	}

        /**
         * @return Return code of ref
         */
	public String getRefcode() {
		return refcode;
	}

        /**
         * @param refcode Code of ref
         */
	public void setRefcode(String refcode) {
		this.refcode = refcode;
	}
	
	

}
