/*
*Cell.java
*Derek Hessinger
*CS231
*10/4/22
*/


//TODO: remove unnecessary packages
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.JPanel;


public class Cell{

	//Fields for Cell class
	int rowIDX;
	int colIDX;
	int val;
	Boolean valLock;

	//Standard Constructor
	public Cell(){
		rowIDX = 0;
		colIDX = 0;
		val = 0;
		valLock = false;
	}

	//Constructor with arguments passed
	public Cell(int row, int col, int value){
		this.rowIDX = row;
		this.colIDX = col;
		this.val = value;
		this.valLock = false;
	}

	//Constructor with arguments passed, including locked
	public Cell(int row, int col, int value, boolean locked){
		this.rowIDX = row;
		this.colIDX = col;
		this.val = value;
		this.valLock = locked;
	}

	//Returns the row of cell
	public int getRow(){
		return this.rowIDX;
	}

	//Returns the column of cell
	public int getCol(){
		return this.colIDX;
	}

	//Returns the value of cell
	public int getValue(){
		return this.val;
	}

	//Sets value of cell
	public void setValue(int newval){
		this.val = newval;
	}

	//Returns if cell is locked
	public boolean isLocked(){
		return this.valLock;
	}

	//Sets locked value of cell
	public void setLocked(boolean lock){
		this.valLock = lock;
	}

	//Returns value of cell as string
	public String toString(){
		return "" + val;
	}

	//Draw method
	public void draw(Graphics g, int x, int y, int scale){

	    char toDraw = (char) ((int) '0' + getValue());
	    g.setColor(isLocked()? Color.BLUE : Color.RED);
	    g.drawChars(new char[] {toDraw}, 0, 1, x, y);
	}

	public static void main(String[] args){

		Cell test = new Cell();

		//Tests

		System.out.println(test.getRow());

		System.out.println(test.getCol());

		System.out.println(test.getValue());

		System.out.println(test.isLocked());



	}

}