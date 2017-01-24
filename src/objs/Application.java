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
 * 
 * @author Claudia Iacob
 */
public class Application 
{
	private String id;
	private String no;
	private double rating;
	private double price;
	private double norates;
	

        /**
         * A method to return the double value of "rating"
         *
         * @return the value in the double "rating"
         */
	public double getRating() {
		return rating;
	}

        /**
         * A method to assign a double value to "rating"
         * 
         * @param rating stores the double to be stored into the variable "rating"
         */
	public void setRating(double rating) {
		this.rating = rating;
	}

        /**
         * A method to return the double value of "price"
         * 
         * @return the value in double "price"
         */
	public double getPrice() {
		return price;
	}

        /**
         * A method to assign a double value to "price"
         * 
         * @param price stores the double to to be stored in double "price"
         */
	public void setPrice(double price) {
		this.price = price;
	}

        /**
         * A method to return the double value of "norates"
         * 
         * @return the double value in "norates"
         */
	public double getNorates() {
		return norates;
	}

        /**
         * A method to assign a double value to "norates"
         * 
         * @param norates stores the double to be stored in double "norates"
         */
	public void setNorates(double norates) {
		this.norates = norates;
	}

        /**
         * A method to create a new "id" and new "no" as String variables         * 
         */
	public Application()
	{
		id = new String();
		no = new String();
	}

        /**
         * A method to return the string value of "id"
         * 
         * @return the String value in "id"
         */
	public String getId() {
		return id;
	}

        /**
         * A method to store a new value in string "id"
         * 
         * @param id stores the value which will go into the variable "id"
         */
	public void setId(String id) {
		this.id = id;
	}

        /**
         * A method to return the value in "no"
         * 
         * @return the String value in "no"
         */
	public String getNo() {
		return no;
	}

        /**
         * A method to store a new value of no
         * 
         * @param no stores the value which will go into String "no"
         */
	public void setNo(String no) {
		this.no = no;
	}
}
