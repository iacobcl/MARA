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
//create private variables for section of application.
	private String id;
	private String no;
	private double rating;
	private double price;
	private double norates;

//return value of rating variable
	public double getRating() {
		return rating;
	}
//set the value of the rating variable
	public void setRating(double rating) {
		this.rating = rating;
	}
//return the value of the price variable
	public double getPrice() {
		return price;
	}
//set the value of the price variable
	public void setPrice(double price) {
		this.price = price;
	}
//return value of the norates variable
	public double getNorates() {
		return norates;
	}
//set value of the norates variable
	public void setNorates(double norates) {
		this.norates = norates;
	}
//create 2 new variables and set them as strings.
	public Application()
	{
		id = new String();
		no = new String();
	}
//return value of id variable.
	public String getId() {
		return id;
	}
//set value of id variable.
	public void setId(String id) {
		this.id = id;
	}
//return value of no variable.
	public String getNo() {
		return no;
	}
//set value of no variable.
	public void setNo(String no) {
		this.no = no;
	}
}
