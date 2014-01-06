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

import objs.CodeDistr;

public class PosNegCatStats 
{
	private String cat;
	private CodeDistr pos;
	private CodeDistr neg;
	

	public PosNegCatStats()
	{
		cat = new String();
		pos = new CodeDistr();
		neg = new CodeDistr();
	}


	public PosNegCatStats(String cat, CodeDistr pos, CodeDistr neg) {
		super();
		this.cat = cat;
		this.pos = pos;
		this.neg = neg;
	}


	public String getCat() {
		return cat;
	}


	public void setCat(String cat) {
		this.cat = cat;
	}


	public CodeDistr getPos() {
		return pos;
	}


	public void setPos(CodeDistr pos) {
		this.pos = pos;
	}


	public CodeDistr getNeg() {
		return neg;
	}


	public void setNeg(CodeDistr neg) {
		this.neg = neg;
	}
	
	
	
	
}
