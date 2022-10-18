/*
* File: Sudoku.java
* Derek Hessinger
* CS231
* 10/12/22
*/

import java.util.Random;


public class Sudoku{

	//Fields for Sudoku class
	Board gameBoard;
	LandscapeDisplay ld;

	//Constructor, creates board with no pre-determined values
	public Sudoku(){

		//Create board
		this.gameBoard = new Board();

		//Create LandscapeDisplay
		// this.ld = new LandscapeDisplay(gameBoard);
	}

	//Constructor, creates board with pre-determined randomly placed values
	public Sudoku(int numLocked){

		//Create board
		this.gameBoard = new Board(numLocked);

		//Create LandscapeDisplay
		this.ld = new LandscapeDisplay(gameBoard);
	}

	//build method to automate simulations
	public void build(int numLocked){

		gameBoard = new Board(numLocked);
	}


	public boolean solve(int delay) throws InterruptedException{

		// Allocate a stack, initially empty
		CellStack<Cell> stack = new CellStack<Cell>();

		boolean backtrack = false;

		gameBoard.finished = false;

		// While the stack size is less than the number of unspecified cells
		while (stack.size < (this.gameBoard.SIZE*this.gameBoard.SIZE - this.gameBoard.numLocked())){

			if (delay > 0)
    			Thread.sleep(delay);
			// if (ld != null)
   // 			 ld.repaint();

			//Select the next cell to check (you'll be calling findNextCell, described below)
			Cell checkCell = this.gameBoard.findNextCell();

			// System.out.println();

			// Variable to hold values being checked
			int validVal = 0;

			if (checkCell != null){

				//Push the cell onto the stack
				stack.push(checkCell);

				int checkCellRow = checkCell.getRow();
				int checkCellCol = checkCell.getCol();
				int checkCellVal = checkCell.getValue();

				// Update the board 
				this.gameBoard.set(checkCellRow, checkCellCol, checkCellVal, false);			
			}

			//Else
			else{

				backtrack = true;
			// While it is possible to backtrack (if the stack is nonempty)
				while (!stack.empty() && backtrack == true){

			// Pop a cell off the stack
					Cell popped = stack.pop();

			// Check if there are other untested values this cell could try
					for (int i = popped.getValue()+1; i < 10; i++){

						if (gameBoard.validValue(popped.getRow(), popped.getCol(), i) == true){

							validVal = i;
							popped.setValue(validVal);
							stack.push(popped);
							gameBoard.set(popped.getRow(), popped.getCol(), validVal);
							backtrack = false;
							break;
						}
					}

					if(backtrack == true){

						validVal = 0;
						this.gameBoard.set(popped.getRow(), popped.getCol(), validVal);
					}
				}

			// If the stack size is 0 (no more backtracking possible)
				if (stack.empty()){

			// Return false: there is no solution
					return false;
				}
			}
		}

		// Return true: the board contains the solution
		gameBoard.finished = true;
		return true;
	}


	public String toString(){

		return gameBoard.toString();
	}

	public static void main(String[] args) throws InterruptedException{

		int count = 0;
		Sudoku sudoku = new Sudoku();

	 //  	System.out.println(sudoku.solve(0));

		for (int i = 0; i < 75; i++){
			sudoku.build(20);
			System.out.print(sudoku.solve(0));
			if (sudoku.gameBoard.finished)
				count++;
		}
		System.out.print(count);


	}
}