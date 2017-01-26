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
	* @param id the id for the desired Application
	* @param no a number variable held about the Application
	* @param rating a numerical variable for accessing the rating of this Application
	* @param price a numerical variable for the price of this Application
	* @param norates possible variable for containg no rating information
	*/
	private String id;
	private String no;
	private double rating;
	private double price;
	private double norates;

	/**
	* Returns the current rating held on this application
	* @return rating of this application as double
	*/
	public double getRating() {
		return rating;
	}

	/**
	* Sets the variable rating to the given parameter
	* @param rating the new rating to be set for this application
	*/

	public void setRating(double rating) {
		this.rating = rating;
	}

	/**
	* Returns the current price of this application
	* @return price of this application as double
	*/

	public double getPrice() {
		return price;
	}

	/**
	* Sets the current price of this applicaton
	* @param price the new price to be set for this application
	*/
	public void setPrice(double price) {
		this.price = price;
	}

	/**
	* Returns the current norates value held by this application
	* @return norates value of this application as double
	*/
	public double getNorates() {
		return norates;
	}

	/**
	* Sets the current norate vale of this applicaton
	* @param norate the new price to be set for this application
	*/

	public void setNorates(double norates) {
		this.norates = norates;
	}

	/**
	* constructor method to create id and no values, both as empty strings
	*/
	public Application()
	{
		id = new String();
		no = new String();
	}

	/**
	* Returns the current id value held by this application
	* @return id value of this application as string
	*/
	public String getId() {
		return id;
	}

	/**
	* Sets the current id vale of this applicaton
	* @param id the new price to be set for this application
	*/
	public void setId(String id) {
		this.id = id;
	}

	/**
	* Returns the current no value held by this application
	* @return no value of this application as string
	*/
	public String getNo() {
		return no;
	}

	/**
	* Sets the current no vale of this applicaton
	* @param id the new price to be set for this application
	*/
	public void setNo(String no) {
		this.no = no;
	}
}
