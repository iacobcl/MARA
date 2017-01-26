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

	/**
	*Constructor for <b>Review</b>
	*Default
	*Set all attributes to new string
	*/
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
	*Getter for <b>Revid</b>
	*@return Revid
	*/
	public String getRevid() {
		return revid;
	}

	/**
	*Setter for <b>Revid</b>
	*@param Revid
	*/
	public void setRevid(String revid) {
		this.revid = revid;
	}

	/**
	*Getter for <b>Appid</b>
	*@return Appid
	*/
	public String getAppid() {
		return appid;
	}

	/**
	*Setter for <b>Appid</b>
	*@param Appid
	*/
	public void setAppid(String appid) {
		this.appid = appid;
	}

	/**
	*Getter for <b>Codes</b>
	*@return Codes
	*/
	public ArrayList<Code> getCodes() {
		return codes;
	}

	/**
	*Setter for <b>Codes</b>
	*@param Codes
	*/
	public void setCodes(ArrayList<Code> codes) {
		this.codes = codes;
	}

	/**
	*Getter for <b>User</b>
	*@return User
	*/
	public String getUser() {
		return user;
	}

	/**
	*Setter for <b>User</b>
	*@param User
	*/
	public void setUser(String user) {
		this.user = user;
	}

	/**
	*Getter for <b>Date</b>
	*@return Date
	*/
	public String getDate() {
		return date;
	}

	/**
	*Setter for <b>Date</b>
	*@param Date
	*/
	public void setDate(String date) {
		this.date = date;
	}

	/**
	*Getter for <b>Device</b>
	*@return Device
	*/
	public String getDevice() {
		return device;
	}

	/**
	*Setter for <b>Device</b>
	*@param Device
	*/
	public void setDevice(String device) {
		this.device = device;
	}

	/**
	*Getter for <b>Version</b>
	*@return Version
	*/
	public String getVersion() {
		return version;
	}

	/**
	*Setter for <b>Version</b>
	*@param Version
	*/
	public void setVersion(String version) {
		this.version = version;
	}

	/**
	*Getter for <b>Title</b>
	*@return Title
	*/
	public String getTitle() {
		return title;
	}

	/**
	*Setter for <b>Title</b>
	*@param Title
	*/
	public void setTitle(String title) {
		this.title = title;
	}

	/**
	*Getter for <b>Rate</b>
	*@return Rate
	*/
	public String getRate() {
		return rate;
	}

	/**
	*Setter for <b>Rate</b>
	*@param Rate
	*/
	public void setRate(String rate) {
		this.rate = rate;
	}

	/**
	*Getter for <b>Text</b>
	*@return Text
	*/
	public String getText() {
		return text;
	}

	/**
	*Setter for <b>Text</b>
	*@param Text
	*/
	public void setText(String text) {
		this.text = text;
	}

	/**
	*@override Print
	*print all the meta data about the code
	*/
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
