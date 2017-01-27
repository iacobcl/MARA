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

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;

import objs.CodeDistr;
import objs.SeqDistr;
import objs.stats.RefCodeStats;
import objs.stats.reports.ReportClassCodeStats;
import objs.stats.reports.ReportSeqDistr;
import storage.DBQuerying;
import storage.FileStoring;

/**
 * Deals with the sequence distribution statistics
 */
public class SeqDistrAnalysis 
{

	/**
	 * Create am array list of codes from a file
	 * @param file The file to get codes from
	 * @return the arraylist created
     */
	public static ArrayList<String> getCodes(String file)
	{
		//Setup the array to return
		ArrayList<String> ret = new ArrayList<String>();
		try
		{
			//Try to open the file to read from
			  FileInputStream fstream = new FileInputStream("conf/" + file + ".txt");
			  DataInputStream in = new DataInputStream(fstream);
			  BufferedReader br = new BufferedReader(new InputStreamReader(in));
			  String strLine;
			//Loop while there are still things in the file
			  while ((strLine = br.readLine()) != null)
			  {
				  //Get the line from the file and put it into the array
				  ret.add(strLine);
			  }
			//close the "connection" to the file
			  in.close();
		}
		catch (Exception e)
		{//Catch exception if any
			  //System.err.println("Error: " + e.toString());
		}
		//Return the ArrayList of the codes
		return ret;
	}

	/**
	 * Check if a refined code is in a class code
	 * @param classcode the class code to analyse
	 * @param refcode The refined code to compare
     * @return True if the refined code is in the class code, otherwise false
     */
	public static boolean isInClass(String classcode, String refcode)
	{
		String[] ret = FileStoring.loadCodes(classcode);
		//Loop through the loaded codes
		for (int i = 0; i < ret.length; i++)
			//Make sure it exists
			if (ret[i] != null)
				if (ret[i].equals(refcode))
					return true;
		return false;
	}

	/**
	 * Create and analyse a report on the sequence distribution
	 * @return The analysed sequence report
     */
	public static ReportSeqDistr createReportSeqDistr()
	{
		//Setup the report
		 ReportSeqDistr rep = new ReportSeqDistr();

		//Get class and refined codes in an array
		 ArrayList<String> cc = getCodes("codeClasses");
		 ArrayList<String> refc = getCodes("refinedCodes");
		 
		 int totalrevs = DBQuerying.getTotalRevs();
		 //int totalCodes = DBQuerying.getTotalCodes();

		 //Loop through both class and refined codes
		 for (int i = 0; i < cc.size(); i++)
			 for (int j = 0; j < refc.size(); j++)
				 for (int k = 0; k < cc.size(); k++)
					 for (int l = 0; l < refc.size(); l++)
						 //Checks if the refined code is in the class code
						 if (  (isInClass(  cc.get(i), refc.get(j) ) )  && (isInClass(cc.get(k), refc.get(l)))) 
						 {
							 int total = DBQuerying.getNoCodeSeqs(cc.get(i),	refc.get(j), cc.get(k), refc.get(l));
							 double perc = (double)total*100/totalrevs;
							 SeqDistr d = new SeqDistr(cc.get(i), refc.get(j), cc.get(k), refc.get(l), total, perc);
							 //Prints the stats to the console log
							 System.out.println(cc.get(i) + "	" + refc.get(j) + "	" + cc.get(k) + "	" + refc.get(l) + "	" + perc);
							 //Add the stats to the report
							 rep.distr.add(d);
						 }
		//Return the analysed report
		return rep;
	}
	
	
	public static void main(String[] args)
	{
		SeqDistrAnalysis.createReportSeqDistr().print();
		
		//System.out.println(DBQuerying.getTotalRevs());
	}
	

}
