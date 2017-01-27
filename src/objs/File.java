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
 * The file class/object, stores the files that the program will be using
 */
public class File 
{

	private String fileName = new String();
	private int status;

	/**
	 * Setup the class with default variables
	 */
	public File()
	{
		fileName = new String();
		status = 0;
	}

	/**
	 * Setup the class with specific variable vales
	 * @param f String, the file name
	 * @param s Int, the status of the file
     */
	public File(String f, int s)
	{
		fileName = f;
		status = s;
	}

	/**
	 * Get the file name of the file
	 * @return String, the filename
     */
	public String getFileName() {
		return fileName;
	}

	/**
	 * Replace the current file name with a new String variable
	 * @param fileName the new String variable
     */
	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	/**
	 * Get the current status of the file
	 * @return Int, the status of the file
     */
	public int getStatus() {
		return status;
	}

	/**
	 * Change the current status of the file
	 * @param status Int, the new status
     */
	public void setStatus(int status) {
		this.status = status;
	}
}
