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

package objs.stats;

import java.util.ArrayList;

import objs.CodeDistr;

public class CodesPerCatStats 
{
	private String cat;
	private ArrayList<CodeDistr> distr;
	
	
	public CodesPerCatStats()
	{
		cat = new String();
		distr = new ArrayList<CodeDistr>();
	}
	
	public String getCat() {
		return cat;
	}
	public void setCat(String cat) {
		this.cat = cat;
	}
	public ArrayList<CodeDistr> getDistr() {
		return distr;
	}
	public void setDistr(ArrayList<CodeDistr> distr) {
		this.distr = distr;
	}
	
	

}
