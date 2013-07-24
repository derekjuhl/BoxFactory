package com.spconger.Boxes;

public class Box {
	/**
	 * This is a very simple class. It defines
	 * the dimensions of a box
	 * it has 3 fields and provides
	 * sets and gets for each
	 */
	private int height;
	private int width;
	private int depth;
	
	public void setHeight(int height){
		this.height=height;
	}
	
	public int getHeight(){
		return height;
	}

	public int getWidth() {
		return width;
	}

	public void setWidth(int width) {
		this.width = width;
	}

	public int getDepth() {
		return depth;
	}

	public void setDepth(int depth) {
		this.depth = depth;
	}
	
	@Override
	public String toString() {
		//this is an example of an overriden method
		// every object has a toSting method
		//you can over write it to make it do
		//what you want
		return "height: " + getHeight() + ", width: " + getWidth()
				+ ", depth: " + getDepth();
	}
	
}
