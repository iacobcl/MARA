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
	private String id;
	private String no;
	private double rating;
	private double price;
	private double norates;

	/**
	*Consructor for <b>Application</b>
	*Set all attributes to new string
	*/
	public Application()
	{
		id = new String();
		no = new String();
	}

	/**
	*Getter for <b>Rating</b>
	*@return Rating
	*/
	public double getRating() {
		return rating;
	}

	/**
	*Setter for <b>Rating</b>
	*@param Rating
	*/
	public void setRating(double rating) {
		this.rating = rating;
	}

	/**
	*Getter for <b>Price</b>
	*@return Price
	*/
	public double getPrice() {
		return price;
	}

	/**
	*Setter for <b>Price</b>
	*@param Price
	*/
	public void setPrice(double price) {
		this.price = price;
	}

	/**
	*Getter for <b>Norates</b>
	*@return Norates
	*/
	public double getNorates() {
		return norates;
	}

	/**
	*Setter for <b>Norates</b>
	*@param Norates
	*/
	public void setNorates(double norates) {
		this.norates = norates;
	}

	/**
	*Getter for <b>Id</b>
	*@return Id
	*/
	public String getId() {
		return id;
	}

	/**
	*Setter for <b>Id</b>
	*@param Id
	*/
	public void setId(String id) {
		this.id = id;
	}

	/**
	*Getter for <b>No</b>
	*@return No
	*/
	public String getNo() {
		return no;
	}

	/**
	*Setter for <b>No</b>
	*@param No
	*/
	public void setNo(String no) {
		this.no = no;
	}
}
