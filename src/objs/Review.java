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


/**
 * Class for review.
 */
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
	 * Constructs the object.
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
	 * Gets the revid.
	 *
	 * @return     The revid.
	 */
	public String getRevid() {
		return revid;
	}

	/**
	 * Sets the revid.
	 *
	 * @param      revid  The revid
	 */
	public void setRevid(String revid) {
		this.revid = revid;
	}

	/**
	 * Gets the appid.
	 *
	 * @return     The appid.
	 */
	public String getAppid() {
		return appid;
	}

	/**
	 * Sets the appid.
	 *
	 * @param      appid  The appid
	 */
	public void setAppid(String appid) {
		this.appid = appid;
	}

	/**
	 * Gets the codes.
	 *
	 * @return     The codes.
	 */
	public ArrayList<Code> getCodes() {
		return codes;
	}

	/**
	 * Sets the codes.
	 *
	 * @param      codes  The codes
	 */
	public void setCodes(ArrayList<Code> codes) {
		this.codes = codes;
	}

	/**
	 * Gets the user.
	 *
	 * @return     The user.
	 */
	public String getUser() {
		return user;
	}

	/**
	 * Sets the user.
	 *
	 * @param      user  The user
	 */
	public void setUser(String user) {
		this.user = user;
	}

	/**
	 * Gets the date.
	 *
	 * @return     The date.
	 */
	public String getDate() {
		return date;
	}

	/**
	 * Sets the date.
	 *
	 * @param      date  The date
	 */
	public void setDate(String date) {
		this.date = date;
	}

	/**
	 * Gets the device.
	 *
	 * @return     The device.
	 */
	public String getDevice() {
		return device;
	}

	/**
	 * Sets the device.
	 *
	 * @param      device  The device
	 */
	public void setDevice(String device) {
		this.device = device;
	}

	/**
	 * Gets the version.
	 *
	 * @return     The version.
	 */
	public String getVersion() {
		return version;
	}

	/**
	 * Sets the version.
	 *
	 * @param      version  The version
	 */
	public void setVersion(String version) {
		this.version = version;
	}

	/**
	 * Gets the title.
	 *
	 * @return     The title.
	 */
	public String getTitle() {
		return title;
	}

	/**
	 * Sets the title.
	 *
	 * @param      title  The title
	 */
	public void setTitle(String title) {
		this.title = title;
	}

	/**
	 * Gets the rate.
	 *
	 * @return     The rate.
	 */
	public String getRate() {
		return rate;
	}

	/**
	 * Sets the rate.
	 *
	 * @param      rate  The rate
	 */
	public void setRate(String rate) {
		this.rate = rate;
	}

	/**
	 * Gets the text.
	 *
	 * @return     The text.
	 */
	public String getText() {
		return text;
	}

	/**
	 * Sets the text.
	 *
	 * @param      text  The text
	 */
	public void setText(String text) {
		this.text = text;
	}
	
	/**
	 * Prints out the review to the console
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
