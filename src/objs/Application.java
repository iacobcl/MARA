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

public class Application
{
/**
 * @param id identification for the application
 * @param no unsure on its use (possibly short for number)
 * @param rating the rating of the application
 * @param price cost of the application
 * @param norates unsure on its use
 */
	private String id;
	private String no;
	private double rating;
	private double price;
	private double norates;

	/**
	 * Returns the rating of the application
	 * @return rating of the application
	 */
	public double getRating() {
		return rating;
	}

	/**
	 * Sets a new rating for the application
	 * @param rating new rating for the application
	 */
	public void setRating(double rating) {
		this.rating = rating;
	}

	/**
	 * Returns the price of the application
	 * @return price of the applicaprice
	 */
	public double getPrice() {
		return price;
	}

	/**
	 * Sets a new price for the application
	 * @param price new price for the application
	 */
	public void setPrice(double price) {
		this.price = price;
	}

	/**
	 * Returns the norates value of the application
	 * @return norates value of the application
	 */
	public double getNorates() {
		return norates;
	}

	/**
	 * Sets a new norates value for the application
	 * @param norates new norates value for the application
	 */
	public void setNorates(double norates) {
		this.norates = norates;
	}

	/**
	 * Constructor that sets the id and no feilds of the application to empty strings
	 */
	public Application()
	{
		id = new String();
		no = new String();
	}

	/**
	 * Returns the id of the application
	 * @return id of the application
	 */
	public String getId() {
		return id;
	}

	/**
	 * Sets a new id for the application
	 * @param id new id for the application
	 */
	public void setId(String id) {
		this.id = id;
	}
	/**
	 * Returns the no value of the application
	 * @return no value of the application
	 */
	public String getNo() {
		return no;
	}

	/**
	 * Sets a new no value for the application
	 * @param no new no value for the application
	 */
	public void setNo(String no) {
		this.no = no;
	}
}
