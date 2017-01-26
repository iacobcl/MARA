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
 * Stores information about application and review
 * 
 * @author iacobcl
 */
public class AppRevCode 
{
	private String appid;
	private String revid;
	private String classcode;
	private String refcode;
	
    /**
     * Constructor - Sets fields to new String
     */
	public AppRevCode()
	{
		appid = new String();
		revid = new String();
		classcode = new String();
		refcode = new String();
	}

    /**
     * Constructor - sets fields to parameters
     * @param appid ID of the application
     * @param revid ID of the review
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
     * gets applications ID
     * @return applications ID
     */
	public String getAppid() {
		return appid;
	}

    /**
     * set applications ID
     * @param appid applications id
     */
	public void setAppid(String appid) {
		this.appid = appid;
	}

    /**
     * gets reviews ID
     * @return reviews ID
     */
	public String getRevid() {
		return revid;
	}

    /**
    * sets reviews ID
    * @param revid reviews id
    */
	public void setRevid(String revid) {
		this.revid = revid;
	}

    /**
     * gets classcode
     * @return classcode
     */
	public String getClasscode() {
		return classcode;
	}

    /**
     * sets classcode
     * @param classcode 
     */
	public void setClasscode(String classcode) {
		this.classcode = classcode;
	}

	/**
	 * gets refcode
	 * @return refcode
	 */
	public String getRefcode() {
		return refcode;
	}

	/**
	 * sets refcode
	 * @param refcode
	 */
	public void setRefcode(String refcode) {
		this.refcode = refcode;
	}
	
	

}
