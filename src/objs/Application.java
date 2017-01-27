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
 * The application class, Stores the ratings, number of ratings and prices.
 */
public class Application 
{
	//Setup private variables
	private String id;
	private String no;
	private double rating;
	private double price;
	private double norates;

	/**
	 * Returns the current rating
	 * @return Double | The rating
     */
	public double getRating() {
		return rating;
	}

	/**
	 * Sets the current rating to a new double variable
	 * @param rating A new double rating
     */
	public void setRating(double rating) {
		this.rating = rating;
	}

	/**
	 * Returns the current price
	 * @return double | The price
     */
	public double getPrice() {
		return price;
	}

	/**
	 * set the current price to a new double variable
	 * @param price The new double price
     */
	public void setPrice(double price) {
		this.price = price;
	}

	/**
	 * returns the current number of rates
	 * @return double | the number of rates
     */
	public double getNorates() {
		return norates;
	}

	/**
	 * set the current number of rates to a new double variable
	 * @param norates the new double variable
     */
	public void setNorates(double norates) {
		this.norates = norates;
	}

	/**
	 * Initialize the class with empty strings
	 */
	public Application()
	{
		id = new String();
		no = new String();
	}

	/**
	 * gets the current ID as a string
	 * @return string | the id
     */
	public String getId() {
		return id;
	}

	/**
	 * Sets the current ID to a new string variable
	 * @param id the new string ID
     */
	public void setId(String id) {
		this.id = id;
	}

	/**
	 * Gets the current number
	 * @return String | the number
     */
	public String getNo() {
		return no;
	}

	/**
	 * Sets the current number to a new string variable
	 * @param no the new string number
     */
	public void setNo(String no) {
		this.no = no;
	}
}
