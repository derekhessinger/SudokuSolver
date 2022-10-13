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

	//Constructor, creates board with pre-determined randomly placed values
	public Sudoku(){

		//Create board
		this.gameBoard = new Board();

		//Randomly lock 9 values
		this.gameBoard.randomLock(9);
	}

	public boolean solve(){

		// Allocate a stack, initially empty

		CellStack<Cell> stack = new CellStack<Cell>();

		// while the stack size is less than the number of unspecified cells
		while (stack.size < (gameBoard.SIZE*gameBoard.SIZE - gameBoard.numLocked())){

			//     select the next cell to check (you'll be calling findNextCell, described below)
			Cell checkCell = gameBoard.findNextCell();

			//     if this cell has a valid value to try
			int checkCellRow = checkCell.getRow();
			int checkCellCol = checkCell.getCol();
			int checkCellVal = checkCell.getValue();

			int validVal;

			if (gameBoard.validValue(checkCellRow, checkCellCol, checkCellVal) == true){

			//    push the cell onto the stack
				stack.push(checkCell);
			//         update the board TODO: Figure out how to update board

			}
			//     else
			else{

			//         while it is possible to backtrack (if the stack is nonempty)
				while (stack.size != 0){
			//             pop a cell off the stack
					stack.pop();
			//             check if there are other untested values this cell could try
					for (int i = 1; i < 10; i++){

						if (gameBoard.validValue(checkCellRow, checkCellCol, i) == true){

							validVal = i;
						}

						else{

							validVal = 0;
						}

					}

			//             if there is another valid untested value for this cell
					if (validVal != 0){

			//                  push the cell with its new value onto the stack
						checkCell.setValue(validVal);
						stack.push(checkCell);
			//                  update the board
						//dont know how to do this
			//                  break
						break;

					}

			//             else
					else{

			//                 set this cell's value to 0 on the board
						checkCell.setValue(0);

					}
				}

			//         if the stack size is 0 (no more backtracking possible)
				if (stack.size == 0){

			//             return false: there is no solution
					return false;
				}
		}

		}
				// return true: the board contains the solution
		return true;
	}
}