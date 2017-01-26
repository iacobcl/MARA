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
	/*These fields are used to define the qualities of the app*/
	private String id;
	private String no;
	private double rating; /*Rating is important*/
	private double price;
	private double norates;

	/**
	*Get method for accessing the private value of 'rating'.
	*@return The application rating
	*/
	public double getRating() {
		return rating;
	}

	/**
	*Sets the argument as the current 'rating' for this app.
	*@param rating The new 'rating' value
	*/
	public void setRating(double rating) {
		this.rating = rating;
	}

	/**
	*Get method for the private 'price' value.
	*@return The 'price' of the application
	*/
	public double getPrice() {
		return price;
	}

	/**
	*Set method for 'price' value.
	*@param price Sets the new 'price' as the argument value
	*/
	public void setPrice(double price) {
		this.price = price;
	}

	/**
	*Get method for the private 'norates' value.
	*@return The 'norates' current value
	*/
	public double getNorates() {
		return norates;
	}

	/**
	*Set method for 'norates'.
	*@param norates The new 'norates' value
	*/
	public void setNorates(double norates) {
		this.norates = norates;
	}

	/**
	*Constructor for the Application class.
	*Initialises the 'id' and 'no' fields as empty strings.
	*/
	public Application()
	{
		id = new String();
		no = new String();
	}

	/**
	*Get method for the private id variable.
	*@return The value of 'id'
	*/
	public String getId() {
		return id;
	}

	/**
	*Set method for the 'id' variable.
	*@param id Sets the new value of 'id' as the argument given
	*/
	public void setId(String id) {
		this.id = id;
	}

	/**
	*Get method for the private variable 'no'.
	*@return Returns the value of 'no'
	*/
	public String getNo() {
		return no;
	}

	/**
	*Set method for the variable 'no'.
	*@param no The new value of 'no'
	*/
	public void setNo(String no) {
		this.no = no;
	}
}
