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

	int rowIDX;
	int colIDX;
	int val;
	Boolean valLock;

	public Cell(){
		rowIDX = 0;
		colIDX = 0;
		val = 0;
		valLock = false;
	}

	public Cell(int row, int col, int value){
		this.rowIDX = row;
		this.colIDX = col;
		this.val = value;
		this.valLock = false;
	}

	public Cell(int row, int col, int value, boolean locked){
		this.rowIDX = row;
		this.colIDX = col;
		this.val = value;
		this.valLock = locked;
	}

	public int getRow(){
		return this.rowIDX;
	}

	public int getCol(){
		return this.colIDX;
	}

	public int getValue(){
		return this.val;
	}

	public void setValue(int newval){
		this.val = newval;
	}

	public boolean isLocked(){
		return this.valLock;
	}

	public void setLocked(boolean lock){
		this.valLock = lock;
	}

	public String toString(){
		return "" + val;
	}

	public void draw(Graphics g, int x, int y, int scale){
    char toDraw = (char) ((int) '0' + getValue());
    g.setColor(isLocked()? Color.BLUE : Color.RED);
    g.drawChars(new char[] {toDraw}, 0, 1, x, y);
	}

}