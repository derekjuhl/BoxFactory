package com.spconger.Boxes;
import javax.swing.*;

import java.awt.GridLayout;
import java.awt.event.*;

public class MainForm {
	
	//declare all the form elements
	private JFrame frame;
	private JPanel panel;
	private JLabel lblHeight;
	private JTextField txtHeight;
	private JLabel lblWidth;
	private JTextField txtWidth;
	private JLabel lblDepth;
	private JTextField txtDepth;
	private JLabel lblVolume;
	private JButton btnAdd;
	private JButton btnGetVolume;
	private JTextField txtBoxNumber;
	private JButton btnExit;
	//declare the Box manager class
	private BoxManager bxManager;
	
	public MainForm(){
		//constructor
		//call makeFrame
		createFrame();
		//initialize the BoxManager class
		bxManager=new BoxManager();
	}
	
	//create the frame
	private void createFrame(){
		frame = new JFrame();
		frame.setSize(300,300);
		createPanel();
		frame.add(panel);
		frame.setVisible(true);
	}
	
	//create the panel
	private void createPanel(){
		panel = new JPanel();
		panel.setLayout(new GridLayout(6,2,5,5));
		
		//make all the objects new
		lblHeight=new JLabel("Enter the Height");
		txtHeight=new JTextField();
		lblWidth=new JLabel("Enter the Width");
		txtWidth=new JTextField();
		lblDepth=new JLabel("Enter the Depth");
		txtDepth=new JTextField();
		btnAdd = new JButton("Add");
		btnAdd.addActionListener(new AddBox());
		btnGetVolume = new JButton("Get Volume");
		btnGetVolume.addActionListener(new GetBoxVolumes());
		txtBoxNumber = new JTextField();
		btnExit = new JButton("Exit");
		btnExit.addActionListener(new ExitEvent());
		lblVolume = new JLabel();
		
		//add them all to the panel
		panel.add(lblHeight);
		panel.add(txtHeight);
		panel.add(lblWidth);
		panel.add(txtWidth);
		panel.add(lblDepth);
		panel.add(txtDepth);
		panel.add(btnAdd);
		panel.add(btnGetVolume);
		panel.add(txtBoxNumber);
		panel.add(btnExit);
		panel.add(lblVolume);
		
	}
	//private classes to implement button actions
	private class ExitEvent implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent arg0) {
			System.exit(0);
			
		}
		
	}
	
	private class AddBox implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			Box b = new Box();
			//there should be more validation here
			//if the values are not proper ints it will cast an error
			b.setWidth(Integer.parseInt(txtWidth.getText()));
			b.setDepth(Integer.parseInt(txtDepth.getText()));
			b.setHeight(Integer.parseInt(txtHeight.getText()));
			bxManager.add(b);
			//empty the text for the next entry
			txtHeight.setText("");
			txtWidth.setText("");
			txtDepth.setText("");
			
		}
		
	}
	
	private class GetBoxVolumes implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			int volume = 0;
			//thanks to Mitchel for fixing this
			//if there is not text in the txtBoxNumber
			//call the empty constructor
			if (txtBoxNumber.getText().equals( "" )){
			 volume=bxManager.getVolume();
			}
			//otherwise pass the box number
			else{
			 int boxIndex=Integer.parseInt(txtBoxNumber.getText());
			 volume = bxManager.getVolume(boxIndex);
			}
			lblVolume.setText("the volume is: " + volume);
		}
		
	}

}
