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
 * Definition for class Application that contains 5 attributes.
 */
public class Application
{
	private String id;
	private String no;
	private double rating;
	private double price;
	private double norates;

/**
 * Get method for rating, returns rating as double.
 * @return rating
 */
	public double getRating() {
		return rating;
	}
/**
 * Set method for rating, assigns the parsed parameter to variable rating.
 * @param double rating
 */
	public void setRating(double rating) {
		this.rating = rating;
	}
/**
 * Get method for price, returns price as double.
 * @return price
 */
	public double getPrice() {
		return price;
	}
/**
 * Set method for price, assigns the parsed parameter to variable price.
 * @param double price
 */
	public void setPrice(double price) {
		this.price = price;
	}
/**
 * Get method for norates, returns norates as double.
 * @return norates
 */
	public double getNorates() {
		return norates;
	}
	/**
	 * Set method for norates, assigns the parsed parameter to variable norates
	 * @param double norates
	 */
	public void setNorates(double norates) {
		this.norates = norates;
	}
/**
 */
	public Application()
	{
		id = new String();
		no = new String();
	}
/**
 * Get method for id
 * @return id
 */
	public String getId() {
		return id;
	}
/**
 * Set method for id, assigns the parsed parameter to variable id.
 * @param String id
 */
	public void setId(String id) {
		this.id = id;
	}
	/**
	 * Get method for no, returns no as String
	 * @return no
	 */
	public String getNo() {
		return no;
	}
	/**
	 * Set method for no, assigns the parsed parameter to variable no
	 * @param String no
	 */
	public void setNo(String no) {
		this.no = no;
	}
}
