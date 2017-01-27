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

package storage;
import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.InputStreamReader;

/**
 * Deals with storing data within files
 */
public class FileStoring 
{

	/**
	 * Reads the codeclasses from the file and returns it in a String[]
	 * @param type The type to get codes from
	 * @return A String[] of codes
     */
	public static String[] loadCodes(String type)
	{
		//Setup the list to return
		String[] codeClasses = new String[100]; //give is a limit of 100 elements
		int i = -1;
		//Get the file codes to look for
		String fileName = getFileCodes(type);
		
		try
		{
			//Open the file
		  FileInputStream fstream = new FileInputStream("conf/" + fileName + ".txt");
			//initlialize the reader
		  DataInputStream in = new DataInputStream(fstream);
		  BufferedReader br = new BufferedReader(new InputStreamReader(in));
		  String strLine;
		  //Read File Line By Line
		  while ((strLine = br.readLine()) != null)
		  {
			  //move to the next element in the String[]
			  i++;
			  codeClasses[i] = strLine; //Add the code to the List
		  }
			//Close the file
		  in.close();
		}
		catch (Exception e)
		{//Catch exception if any
			  System.err.println("Error: " + e.toString());
		}
		//Return the list of codeclasses
		return codeClasses;
	}

	/**
	 * Get the file code type
	 * @param type the type given
	 * @return the code of the given type
     */
	public static String getFileCodes(String type)
	{
		//A nice long nested if
		if (type.equals("class")) return "codeClasses";
		else
			if (type.equals("positive feedback")) return "refinedCodes_posnegfeed";
			else
				if (type.equals("negative feedback")) return "refinedCodes_posnegfeed";
				else
					if (type.equals("comparative feedback")) return "refinedCodes_compfeed";
					else
						if (type.equals("money feedback")) return "refinedCodes_moneyfeed";
						else
							if (type.equals("requirements")) return "refinedCodes_requirements";
							else
								if (type.equals("reporting")) return "refinedCodes_reporting";
								else
									if (type.equals("usability")) return "refinedCodes_usability";
									else
										if (type.equals("customer support")) return "refinedCodes_custsupp";
										else
											if (type.equals("versioning")) return "refinedCodes_versioning";
												else return null;//Finally through that and its not here... great
	}
}
