/*
* File : SudokuTests.java
* Derek Hessinger
* CS231
* 10/19/22
*/

public class SudokuTests{

	public static void main(String[] args) throws InterruptedException{

		// case 1: testing Sudoku
		{
			System.out.println("TESTING: Sudoku()");

			// setup
			Sudoku sudoku = new Sudoku();

			// verify
			System.out.println(sudoku.getType() + " == Sudoku");

			// test
			assert sudoku.getType() == "Sudoku" : "Error in Sudoku::Sudoku()";

			System.out.println("Testing complete!");
			System.out.println("");
		}

		// case 2: testing solve()
		{
			System.out.println("TESTING: solve()");

			// setup
			Sudoku sudoku1 = new Sudoku();
			Sudoku sudoku2 = new Sudoku();


			// verify
			System.out.println(sudoku1.solve(0) + " == true");

			// test
			assert sudoku2.solve(0) == true : "Error in Sudoku::solve()";

			System.out.println("Testing complete!");
			System.out.println("");

			System.out.println("***TESTING FOR SUDOKU COMPLETE***")
		}
	}
}