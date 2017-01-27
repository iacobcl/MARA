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
 * Stores data about each review
 */
public class Review 
{

	//setup all required variables for a review
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
	 * Setup the class with everything set to an empty variable
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
	 * get the ID for this review
	 * @return String, the ID for this review
     */
	public String getRevid() {
		return revid;
	}

	/**
	 * Set this reviews ID to a new String value
	 * @param revid the new String value
     */
	public void setRevid(String revid) {
		this.revid = revid;
	}

	/**
	 * Get the application ID for the current review
	 * @return String, the ID for the app
     */
	public String getAppid() {
		return appid;
	}

	/**
	 * Set this spplication ID to a new String value
	 * @param appid the new String value
	 */
	public void setAppid(String appid) {
		this.appid = appid;
	}

	/**
	 * Get an arraylist of code that is part of this review
	 * @return The ArrayList of code
     */
	public ArrayList<Code> getCodes() {
		return codes;
	}

	/**
	 * replace the current code for this review with a new list
	 * @param codes The new ArrayList of code
     */
	public void setCodes(ArrayList<Code> codes) {
		this.codes = codes;
	}

	/**
	 * Get the user that is reviewing this review
	 * @return The user
     */
	public String getUser() {
		return user;
	}

	/**
	 * Change the user to a new String value
	 * @param user The new string value
     */
	public void setUser(String user) {
		this.user = user;
	}

	/**
	 * get the date of the review
	 * @return the date of the review as a String
     */
	public String getDate() {
		return date;
	}

	/**
	 * Change the date of the review
	 * @param date the new date String
     */
	public void setDate(String date) {
		this.date = date;
	}

	/**
	 * Get the device used in the review
	 * @return the device String
     */
	public String getDevice() {
		return device;
	}

	/**
	 * Change the device for the review to a new String variable
	 * @param device the new String, device
     */
	public void setDevice(String device) {
		this.device = device;
	}

	/**
	 * Get the version of the review
	 * @return String, the review version
     */
	public String getVersion() {
		return version;
	}

	/**
	 * Change the review version
	 * @param version The new review version, String
     */
	public void setVersion(String version) {
		this.version = version;
	}

	/**
	 * Get the title for this review
	 * @return String, the review title
     */
	public String getTitle() {
		return title;
	}

	/**
	 * Change the title for the review
	 * @param title The new String title
     */
	public void setTitle(String title) {
		this.title = title;
	}

	/**
	 * Get the rating of the review
	 * @return String, the rating
     */
	public String getRate() {
		return rate;
	}

	/**
	 * Set the rating of the review to a String
	 * @param rate String, the new rating
     */
	public void setRate(String rate) {
		this.rate = rate;
	}

	/**
	 * Get the text/description of the review
	 * @return the String of the text
     */
	public String getText() {
		return text;
	}

	/**
	 * Change the text/description of the review
	 * @param text String, the text for the review
     */
	public void setText(String text) {
		this.text = text;
	}

	/**
	 * print out the review data to the console
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
