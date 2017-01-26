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

public class File 
{

	private String fileName = new String();
	private int status;
	
	public File()
	{
		fileName = new String();
		status = 0;
	}

        /**
         * @param f String initial file name
         * @param s int initial status
         */
	public File(String f, int s)
	{
		fileName = f;
		status = s;
	}
	
        /**
         * @return Return name of file
         */
	public String getFileName() {
		return fileName;
	}

        /**
         * @param fileName Name of file
         */
	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

        /**
         * @return Return numerical status
         */
	public int getStatus() {
		return status;
	}

        /**
         * @param status Numerical status
         */
	public void setStatus(int status) {
		this.status = status;
	}
}
