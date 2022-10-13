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
		while (stack.size < (gameBoard.size*gameBoard.size - gameBoard.numLocked()){

			//     select the next cell to check (you'll be calling findNextCell, described below)

			//     if this cell has a valid value to try
			//         push the cell onto the stack
			//         update the board
			//     else
			//         while it is possible to backtrack (if the stack is nonempty)
			//             pop a cell off the stack
			//             check if there are other untested values this cell could try
			//             if there is another valid untested value for this cell
			//                  push the cell with its new value onto the stack
			//                  update the board
			//                  break
			//             else
			//                 set this cell's value to 0 on the board
			//         if the stack size is 0 (no more backtracking possible)
			//             return false: there is no solution

		}

		// return true: the board contains the solution
		// 	}
}