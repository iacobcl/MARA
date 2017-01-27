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


/**
 * GUI frame to select the wanted app
 */
public class AppChooser extends JFrame implements ActionListener
{
	Retrieving boss = new Retrieving();
	public JComboBox files;

	/**
	 * Create, setup and display the GUI
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

	/**
	 * Called whenever an action is performed on the Fram.
	 * @param e The action performed
     */
	public void actionPerformed(ActionEvent e) 
	{
		//The go button was pressed
		if (e.getActionCommand().equals("goButton"))
		{
			new CodeAssigner(files.getSelectedItem().toString(), DBStoring.getFileStatus(files.getSelectedItem().toString())).setVisible(true);
			this.setVisible(false);
		}
		
	}

	/**
	 * Run the application
	 * @param args arguments given by the user
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

	/**
	 * Gets the list of files and converts it to a list of strings
	 * @return Returns the list of filese
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

	//Old unused getFiles() method
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



