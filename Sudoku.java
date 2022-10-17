/*
* File: Sudoku.java
* Derek Hessinger
* CS231
* 10/12/22
*/

import java.util.Random;


public class Sudoku extends Board{

	//Fields for Sudoku class
	Board gameBoard;
	LandscapeDisplay ld;

	//Constructor, creates board with pre-determined randomly placed values
	public Sudoku(){

		//Create board
		this.gameBoard = new Board();

		//Randomly lock 9 values
		this.gameBoard.randomLock(9);

		//Create LandscapeDisplay
		this.ld = new LandscapeDisplay(gameBoard);
	}

	public boolean solve(int delay) throws InterruptedException{

		// Allocate a stack, initially empty
		CellStack<Cell> stack = new CellStack<Cell>();

		// While the stack size is less than the number of unspecified cells
		while (stack.size < (this.gameBoard.SIZE*this.gameBoard.SIZE - this.gameBoard.numLocked())){

			if (delay > 0){

    			Thread.sleep(delay);
			}

			if (ld != null){

			    ld.repaint();
			}

			//Select the next cell to check (you'll be calling findNextCell, described below)
			Cell checkCell = this.gameBoard.findNextCell();

			//TODO: fix this, returns all values before executing rest of while loop
			System.out.println(checkCell);

			//If this cell has a valid value to try
			int checkCellRow = checkCell.getRow();
			int checkCellCol = checkCell.getCol();
			int checkCellVal = checkCell.getValue();

			// Variable to hold values being checked
			int validVal = 0;

			if (this.gameBoard.validValue(checkCellRow, checkCellCol, checkCellVal) == true){

			//Push the cell onto the stack
				stack.push(checkCell);

			// Update the board 
				this.gameBoard.set(checkCellRow, checkCellCol, checkCellVal);			
			}
			//Else
			else{

			// While it is possible to backtrack (if the stack is nonempty)
				while (stack.size != 0){

			// Pop a cell off the stack
					stack.pop();

			// Check if there are other untested values this cell could try
					for (int i = 1; i < 10; i++){

						if (gameBoard.validValue(checkCellRow, checkCellCol, i) == true){

							validVal = i;
						}

						else{

							validVal = 0;
						}

					}

			// If there is another valid untested value for this cell
					if (validVal != 0){

						// Push the cell with its new value onto the stack
						checkCell.setValue(validVal);
						stack.push(checkCell);

			// Update the board
						this.gameBoard.set(checkCellRow, checkCellCol, validVal);


			// Break
						break;

					}

			// Else
					else{

			// Set this cell's value to 0 on the board
						checkCell.setValue(0);
						this.gameBoard.set(checkCellRow, checkCellCol, validVal);

					}
				}

			// If the stack size is 0 (no more backtracking possible)
				if (stack.size == 0){

			// Return false: there is no solution
					finished = false;
					return false;
				}
			}
		}

		// Return true: the board contains the solution
		finished = true;
		return true;
	}

	public static void main(String[] args){

		Sudoku sudoku = new Sudoku();

		System.out.println("ORIGINAL BOARD:");
	  	System.out.println(sudoku.toString());
	  	//TODO: Fix interrupted exception
	  	sudoku.solve(10);
	}
}