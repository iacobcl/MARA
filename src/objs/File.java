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
        /**
         * Holds filename.
         */
	private String fileName = new String();
        
        /**
         * Holds status value
         */
	private int status;
	
        
        /**
         * Constructs empty File object
         */
	public File()
	{
		fileName = new String();
		status = 0;
	}

        /**
         * Constructs new File object based on parameters.
         * @param f value for filename field
         * @param s value for status field
         */
	public File(String f, int s)
	{
		fileName = f;
		status = s;
	}
	
        /**
         * Returns value stored in filename field.
         * @return value of filename field
         */
	public String getFileName() {
		return fileName;
	}

        /**
         * Changes value of filename field
         * @param fileName new value for filename field
         */
	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

        /**
         * Returns value stored in status field.
         * @return value of status field.
         */
	public int getStatus() {
		return status;
	}

        /**
         * Changes value of status field.
         * @param status new value for status field
         */
	public void setStatus(int status) {
		this.status = status;
	}
}
