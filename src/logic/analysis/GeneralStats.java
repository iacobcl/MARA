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

package logic.analysis;

import java.util.ArrayList;

import objs.Application;
import storage.DBQuerying;

/**
 * Analyses general statistics
 * Avg - Rating, Price and no. of rates
 */
public class GeneralStats 
{
	/**
	 * Prints general statistics
	 * @param args user given arguments
     */
	public static void main(String[] args)
	{
		//initialize variables we need to use
		double rating = 0;
		double price = 0;
		int norates = 0;

		//Get all apps
		ArrayList<Application> apps = DBQuerying.getApps();
		//Loop through the apps
		for (Application app : apps)
		{
			rating += app.getRating();
			price += app.getPrice();
			norates += app.getNorates();
		}
		
		//Print out the averages to the console
		System.out.println("Average rating: " + (double)rating/apps.size());
		System.out.println("Average price: " + (double)price/apps.size());
		System.out.println("Average no of rates: " + (double)norates/apps.size());
	}

}
