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
	
        /**
         * Default Constructor method
         */
	public File()
	{
		fileName = new String();
		status = 0;
	}
        /**
         * Constructor method
         * @param f the name of the file
         * @param s the status of the file
         */
	public File(String f, int s)
	{
		fileName = f;
		status = s;
	}
	
        /**
         * Returns the name of a file
         * 
         * @return filename the name of the file
         */
	public String getFileName() {
		return fileName;
	}

        /**
         * Assigns a the instance variable of "fileName" to a string
         * 
         * @param fileName the name of the file
         */
	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

        /**
         * Returns the state of a file
         * 
         * @return status the status of the file
         */
	public int getStatus() {
		return status;
	}

        /**
         * Assigns a the instance variable of "status" to a integer
         * 
         * @param status the status of the file
         */
	public void setStatus(int status) {
		this.status = status;
	}
}
