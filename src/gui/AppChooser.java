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

package gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.nio.file.Files;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import javax.swing.border.Border;

import objs.File;
import storage.DBStoring;

import logic.Retrieving;




public class AppChooser extends JFrame implements ActionListener
{
	Retrieving boss = new Retrieving();
	public JComboBox files;

	/* Setting up the GUI interface
	Creating a new GUI with buttons borders and jPanel
	*/
	public AppChooser()
	{
		setTitle("File name");
		setSize(300, 150);
		Border line = BorderFactory.createMatteBorder(10,10,10,10, Color.WHITE);
			
	
		files = new JComboBox(getFiles());
		files.setSize(150, 10);
		JPanel combo = new JPanel(new BorderLayout());
		combo.add(files, BorderLayout.CENTER);
		combo.setBorder(line);
		
		JPanel go = new JPanel(new BorderLayout());
		JButton goButton = new JButton("Go!"); 
		go.add(goButton, BorderLayout.CENTER);
		goButton.addActionListener(this);
		goButton.setActionCommand("goButton");
		go.setBorder(line);
	
		this.add(combo, BorderLayout.CENTER);
		this.add(go, BorderLayout.SOUTH);

		setLocationRelativeTo(null);
	    setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
	

	/* Checks for any actionPerformed
	This method checks if the go button as been pressed.
	Once pressed, will retrieve the file status.
	*/
	public void actionPerformed(ActionEvent e) 
	{
		
		if (e.getActionCommand().equals("goButton"))
		{
			new CodeAssigner(files.getSelectedItem().toString(), DBStoring.getFileStatus(files.getSelectedItem().toString())).setVisible(true);
			this.setVisible(false);
		}
		
	}	

	/* 
	Main method which runs on startup 
	*/
	public static void main(String[] args)
	{
		SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                AppChooser ex = new AppChooser();
                ex.setVisible(true);
            }
        });
	}
	
	/* This method gets called upon by another method.
	Retrieves file information E.G Size and FileName
	*/
	public String[] getFiles()
	{//loads all files which are not completely coded
		String[] fileNames = new String[30000];
		int j = -1;
		
		ArrayList<File> files = DBStoring.getFiles();
		
		for (int i = 0; i < files.size(); i++)
		{
			if (files.get(i).getStatus() != -1)
			{
				j++;
				fileNames[j] = files.get(i).getFileName();
			}
		}
		
		return fileNames;
	}
		
/*	public String[] getFiles()
	{
		boss.createAppsMap();
		String[] fileNames = new String[30000];
		int i = -1;
		for (String s: boss.ids)
		{
			i++;
			fileNames[i] = new String(s);
		}
		return fileNames;
	}
*/	
	
}



