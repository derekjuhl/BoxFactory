package com.spconger.Boxes;

import java.util.ArrayList;

public class BoxManager {
	/****
	 * this class handles boxes. It has
	 * an ArrayList that stores any number
	 * of boxes, a method to add boxes
	 * to the list and an overloaded method
	 * to get either the combined volume 
	 * of all the boxes in the list, or
	 * the volume of an individual box.
	 */
	private ArrayList<Box> boxList;
	
	public BoxManager(){
		//constructor initialze the ArrayList
		boxList=new ArrayList<Box>();
	}
	
	//add box to list
	public void add(Box b){
		boxList.add(b);
	}
	
	//calcualte total box
	public int getVolume(){
		int volume=0;
		int h=0, w=0, d=0;
		for(Box b:boxList){
			h = b.getHeight();
			w = b.getWidth();
			d = b.getDepth();
			volume += h * w * d;
		}
		
		return volume;
	}
	
	//calculate individual box volume
	public int getVolume(int boxNumber){
		
		int volume=0;
		if (boxNumber <= boxList.size()){
		Box b = boxList.get(boxNumber);
		volume =b.getDepth() * b.getHeight() * b.getWidth();
		}
		return volume;
	}

}

