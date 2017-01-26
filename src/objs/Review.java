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
import java.util.ArrayList;



public class Review 
{

	private String appid;
	private String user;
	private String date;
	private String device;
	private String version;
	public String title;
	private String text;
	private String rate;
	private ArrayList<Code> codes;
	private String revid;
	
	
	public Review()
	{
		appid = new String();
		user = new String();
		date = new String();
		device = new String();
		version = new String();
		title = new String();
		text = new String();
		rate = new String();
		codes = new ArrayList<Code>();
		revid = new String();
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
         * @return Return array list of codes
         */
	public ArrayList<Code> getCodes() {
		return codes;
	}

        /**
         * @param codes array list of codes
         */
	public void setCodes(ArrayList<Code> codes) {
		this.codes = codes;
	}

        /**
         * @return Return name of user
         */
	public String getUser() {
		return user;
	}

        /**
         * @param user name of user
         */
	public void setUser(String user) {
		this.user = user;
	}

        /**
         * @return Return string date
         */
	public String getDate() {
		return date;
	}

        /**
         * @param date String date
         */
	public void setDate(String date) {
		this.date = date;
	}

        /**
         * @return Return name of device
         */
	public String getDevice() {
		return device;
	}

        /**
         * @param device name of device
         */
	public void setDevice(String device) {
		this.device = device;
	}

        /**
         * @return Return name of version
         */
	public String getVersion() {
		return version;
	}

        /**
         * @param version name of version
         */
	public void setVersion(String version) {
		this.version = version;
	}

        /**
         * @return Return name of title
         */
	public String getTitle() {
		return title;
	}

        /**
         * @param title name of title
         */
	public void setTitle(String title) {
		this.title = title;
	}

        /**
         * @return Return string rate
         */
	public String getRate() {
		return rate;
	}

        /**
         * @param rate string rate
         */
	public void setRate(String rate) {
		this.rate = rate;
	}

        /**
         * @return Return string text
         */
	public String getText() {
		return text;
	}

        /**
         * @param text string text
         */
	public void setText(String text) {
		this.text = text;
	}
	
	public void print()
	{
		System.out.println("date:" + date);
		System.out.println("rate: " + rate);
		System.out.println("device: " + device);
		System.out.println("version: " + version);
		System.out.println("title:" + title);
		System.out.println("text:" + text);
		System.out.println();
	}
	
}
