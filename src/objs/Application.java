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
* Returns the rating as a double
* @return rating double -
*/
	public double getRating() {
		return rating;
	}
	/**
	* Returns sets rating to the input
	*/
	public void setRating(double rating) {
		this.rating = rating;
	}
	/**
	* Returns price as a double
	* @returns price double
	*/
	public double getPrice() {
		return price;
	}

	/**
	* this sets the price to that of the parameter of the class
	*/
	public void setPrice(double price) {
		this.price = price;
	}
	/**
	* Returns norates as a double
	* @returns norates double
	*/
	public double getNorates() {
		return norates;
	}
	/**
	* this sets the price to that of the parameter of the class
	*/
	public void setNorates(double norates) {
		this.norates = norates;
	}
	/**
	* Constructor, creates 2 varriables id and no
	*/
	public Application()
	{
		id = new String();
		no = new String();
	}
	public String getId() {
		return id;
	}
	/**
	* this sets the id to that of the parameter of the class
	*/
	public void setId(String id) {
		this.id = id;
	}
	/**
	* Returns no as a double
	* @returns no double
	*/
	public String getNo() {
		return no;
	}
	/**
	* this sets the no to that of the parameter of the class
	*/
	public void setNo(String no) {
		this.no = no;
	}
}
