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


	public String getRevid() {
		return revid;
	}


	public void setRevid(String revid) {
		this.revid = revid;
	}


	public String getAppid() {
		return appid;
	}


	public void setAppid(String appid) {
		this.appid = appid;
	}


	public ArrayList<Code> getCodes() {
		return codes;
	}


	public void setCodes(ArrayList<Code> codes) {
		this.codes = codes;
	}


	public String getUser() {
		return user;
	}


	public void setUser(String user) {
		this.user = user;
	}


	public String getDate() {
		return date;
	}


	public void setDate(String date) {
		this.date = date;
	}


	public String getDevice() {
		return device;
	}


	public void setDevice(String device) {
		this.device = device;
	}


	public String getVersion() {
		return version;
	}


	public void setVersion(String version) {
		this.version = version;
	}


	public String getTitle() {
		return title;
	}


	public void setTitle(String title) {
		this.title = title;
	}


	public String getRate() {
		return rate;
	}


	public void setRate(String rate) {
		this.rate = rate;
	}


	public String getText() {
		return text;
	}


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
