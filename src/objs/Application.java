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
 * Stores information about Application
 * 
 * @author iacobcl
 */
public class Application 
{
	private String id;
	private String no;
	private double rating;
	private double price;
	private double norates;
	
    /**
     * Get applications rating
     * @return applications rating
     */
	public double getRating() {
		return rating;
	}

    /**
     * sets the rating of the application
     * @param rating of the application
     */
	public void setRating(double rating) {
		this.rating = rating;
	}

    /**
     * Get applications price
     * @return applications price
     */
	public double getPrice() {
		return price;
	}

    /**
     * Sets the price of the Application
     * @param price 
     */
	public void setPrice(double price) {
		this.price = price;
	}

    /**Get applications norates
     * 
     * @return norates
     */
	public double getNorates() {
		return norates;
	}

    /**
     * Sets norates
     * @param norates 
     */	
	public void setNorates(double norates) {
		this.norates = norates;
	}

    /**
     * Constructor - sets id and no
     */
	public Application()
	{
		id = new String();
		no = new String();
	}

    /**
     * Gets ID of application
     * @return id
     */
	public String getId() {
		return id;
	}

    /**
     * Sets id of application
     * @param id 
     */
	public void setId(String id) {
		this.id = id;
	}

    /**
     * gets no of application
     * @return no
     */
	public String getNo() {
		return no;
	}

    /**
     * sets no of application
     * @param no 
     */
	public void setNo(String no) {
		this.no = no;
	}
}
