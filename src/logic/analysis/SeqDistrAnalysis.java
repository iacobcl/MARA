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

public class SeqDistrAnalysis 
{

	
	public static ArrayList<String> getCodes(String file)
	{
		ArrayList<String> ret = new ArrayList<String>();
		try
		{
			  FileInputStream fstream = new FileInputStream("conf/" + file + ".txt");
			  DataInputStream in = new DataInputStream(fstream);
			  BufferedReader br = new BufferedReader(new InputStreamReader(in));
			  String strLine;
			  while ((strLine = br.readLine()) != null)
			  {
				  ret.add(strLine);
			  }
			  in.close();
		}
		catch (Exception e)
		{//Catch exception if any
			  //System.err.println("Error: " + e.toString());
		}
		return ret;
	}
	
	
	public static boolean isInClass(String classcode, String refcode)
	{
		String[] ret = FileStoring.loadCodes(classcode);

		for (int i = 0; i < ret.length; i++)
			if (ret[i] != null)
				if (ret[i].equals(refcode))
					return true;
		return false;
	}
	
	
	public static ReportSeqDistr createReportSeqDistr()
	{
		 ReportSeqDistr rep = new ReportSeqDistr();

		 ArrayList<String> cc = getCodes("codeClasses");
		 ArrayList<String> refc = getCodes("refinedCodes");
		 
		 int totalrevs = DBQuerying.getTotalRevs();
		 //int totalCodes = DBQuerying.getTotalCodes();

		 
		 for (int i = 0; i < cc.size(); i++)
			 for (int j = 0; j < refc.size(); j++)
				 for (int k = 0; k < cc.size(); k++)
					 for (int l = 0; l < refc.size(); l++)
						 if (  (isInClass(  cc.get(i), refc.get(j) ) )  && (isInClass(cc.get(k), refc.get(l)))) 
						 {
							 int total = DBQuerying.getNoCodeSeqs(cc.get(i),	refc.get(j), cc.get(k), refc.get(l));
							 double perc = (double)total*100/totalrevs;
							 SeqDistr d = new SeqDistr(cc.get(i), refc.get(j), cc.get(k), refc.get(l), total, perc);
							 System.out.println(cc.get(i) + "	" + refc.get(j) + "	" + cc.get(k) + "	" + refc.get(l) + "	" + perc);
							 rep.distr.add(d);
						 }
		
		
		return rep;
	}
	
	
	public static void main(String[] args)
	{
		SeqDistrAnalysis.createReportSeqDistr().print();
		
		//System.out.println(DBQuerying.getTotalRevs());
	}
	

}
