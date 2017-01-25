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
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.Border;

import objs.Review;

import storage.DBStoring;
import storage.FileStoring;


/**
 * GUI Class for assigning code
 */
public class CodeAssigner extends JFrame implements ActionListener, ItemListener
{
	public String fileName; 
	
	public FileStoring fs = new FileStoring();
	
	private ArrayList<Review> revs = new ArrayList<Review>();
	private String[] codeClasses = new String[100];
	private String[] refinedCodes = new String[100];
	private int index = 0;
	
	
	JTextArea titleArea;
	JTextArea textArea;
	JTextArea summaryArea;
	
	JComboBox classes;
	JComboBox refined;
	JTextField raw;

	/**
	 * Creates required buttons and items on the screen
	 *
	 * @param fileName name of the file
	 * @param status status of the file
	 */
	public CodeAssigner (String fileName, int status)
	{

		loadReviews(fileName);
		this.fileName = fileName;
		this.index = status;
	
		setTitle("App id: " + fileName);
		setSize(1000, 400);
		Border line = BorderFactory.createMatteBorder(10, 10, 10, 10, Color.WHITE);
		this.setLayout(new BorderLayout());
	
		JPanel reviewPanel = new JPanel(new GridLayout(1, 2));
		reviewPanel.setBorder(line);
		
		GridLayout descPanelLayout = new GridLayout(6, 1);
		descPanelLayout.setVgap(5);
		JPanel descPanel = new JPanel(descPanelLayout);
		descPanel.setBorder(line);
		
		descPanel.add(new JLabel("Title"));
		titleArea = new JTextArea(5, 100);
		JScrollPane scrollPane = new JScrollPane(titleArea); 
		titleArea.setEditable(false);
		titleArea.setLineWrap(true);
		titleArea.setText(revs.get(index).getTitle());
		descPanel.add(titleArea);
		
		descPanel.add(new JLabel("Review"));
		textArea = new JTextArea(5, 100);
		JScrollPane scrollPane1 = new JScrollPane(textArea); 
		textArea.setEditable(false);
		textArea.setLineWrap(true);
		textArea.setText(revs.get(index).getText());
		descPanel.add(textArea);
		
		descPanel.add(new JLabel("Summary"));
		summaryArea = new JTextArea(2, 100);
		descPanel.add(summaryArea);
		
		//coding panel
		JPanel codingPanel = new JPanel(new BorderLayout());
		
		GridLayout codingLayout = new GridLayout(3,1);
		codingLayout.setVgap(10);
		JPanel coding = new JPanel(codingLayout);
		
		JPanel classesPanel = new JPanel(new GridLayout(2,1));
		classesPanel.add(new JLabel("Code class"));
		classes = new JComboBox(fs.loadCodes("class"));
		classes.setSelectedIndex(0);
		classes.addItemListener(this);
		classesPanel.add(classes);
		coding.add(classesPanel);
		
		JPanel refinedPanel = new JPanel(new GridLayout(2,1));
		refinedPanel.add(new JLabel("Refined code"));
		refined = new JComboBox(fs.loadCodes("positive feedback"));
		refinedPanel.add(refined);
		coding.add(refinedPanel);
		
		JPanel rawPanel = new JPanel(new GridLayout(2,1));
		rawPanel.add(new JLabel("Raw code:"));
		raw = new JTextField();
		rawPanel.add(raw);
		coding.add(rawPanel);
		
		codingPanel.add(coding, BorderLayout.CENTER);
		
		JPanel addPanel = new JPanel();
		JButton addButton = new JButton("Next review");
		addButton.setActionCommand("nextReview");
		addButton.addActionListener(this);
		addPanel.add(addButton);
		
		
		JButton addCodeButton = new JButton("Add code");
		addCodeButton.setActionCommand("addCodeButton");
		addCodeButton.addActionListener(this);
		addPanel.add(addCodeButton);
		
		
		codingPanel.add(addPanel, BorderLayout.SOUTH);
		
		
		
		reviewPanel.add(descPanel); reviewPanel.add(codingPanel);
		
		
		JPanel nextPanel = new JPanel();
		JButton nextButton = new JButton("Next App");
		nextButton.setActionCommand("nextApp");
		nextButton.addActionListener(this);
		nextPanel.add(nextButton);
		
		JButton pauseButton = new JButton("Pause");
		pauseButton.setActionCommand("pause");
		pauseButton.addActionListener(this);
		nextPanel.add(pauseButton);
		
		
		this.add(reviewPanel, BorderLayout.CENTER);
		this.add(nextPanel, BorderLayout.SOUTH);

		setLocationRelativeTo(null);
	    setDefaultCloseOperation(EXIT_ON_CLOSE);
	}

	/**
	 * If button is pressed gets next review, addCodeButton, next app or pause
	 *
	 * @param e instance of action event
	 */
	public void actionPerformed(ActionEvent e) 
	{
		
		if (e.getActionCommand().equals("nextReview"))
		{
			if (index + 1 < revs.size())
			{
				index++;
				titleArea.setText(revs.get(index).getTitle());
				textArea.setText(revs.get(index).getText());
			}
			else
			{
				titleArea.setText(" ");
				textArea.setText(" ");
				
				JOptionPane.showMessageDialog(this, "Reviews finished for this application.");
			}
			
		}
		else
		if (e.getActionCommand().equals("addCodeButton"))
		{
			DBStoring.insertCode(fileName, String.valueOf(index), titleArea.getText().replace("'", " "), "aaa"
					, classes.getSelectedItem().toString(), refined.getSelectedItem().toString(), raw.getText().replace("'", " "));
			raw.setText(" ");
		}
		else
		if (e.getActionCommand().equals("nextApp"))
		{
			//store status complete in db for file 
			DBStoring.setFileStatus(fileName, -1);
			new AppChooser().setVisible(true);
		}	
		else
		if (e.getActionCommand().equals("pause"))
		{
			//store status complete in db for file 
			DBStoring.setFileStatus(fileName, index);
			this.setVisible(false);
		}	
		
	}

	/**
	 *
	 * Updates the item state in the codes array
	 *
	 * @param evt instance of ItemEvent
	 */
	public void itemStateChanged(ItemEvent evt)
	{
		JComboBox classes = (JComboBox)evt.getSource();
		
		if (evt.getStateChange() == ItemEvent.SELECTED) 
		{
			refined.removeAllItems();
			String [] codes = fs.loadCodes(classes.getSelectedItem().toString());
			//loops through the array codes updating items
			for (String s: codes)
				refined.addItem(s);
        }
	
	}


	/**
	 * Loads the reviews of the application
	 * @param fileName name of the file to get reviews
	 */
	public void loadReviews(String fileName)
	{
		
			try
			{
			  FileInputStream fstream = new FileInputStream("output/f_" + fileName + ".txt");
			  DataInputStream in = new DataInputStream(fstream);
			  BufferedReader br = new BufferedReader(new InputStreamReader(in));
			  String strLine;
			  //Read File Line By Line
			  while ((strLine = br.readLine()) != null)
			  {
				  Review r = new Review();
				  r.setDate(strLine.split("&&&")[0]);
				  r.setRate(strLine.split("&&&")[1]);
				  r.setDevice(strLine.split("&&&")[2]);
				  r.setVersion(strLine.split("&&&")[3]);
				  r.setTitle(strLine.split("&&&")[4]);
				  if (strLine.split("&&&").length == 6)
					  r.setText(strLine.split("&&&")[5]);
				  else
					  r.setText("");
				  revs.add(r);
			  }
				
			  in.close();
			}
			catch (Exception e)
			{//Catch exception if any
				  System.err.println("Error: " + e.toString());
			}
	}
	
	
}
