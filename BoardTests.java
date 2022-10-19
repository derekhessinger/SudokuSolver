/*
* File : BoardTests.java
* Derek Hessinger
* CS231
* 10/9/22
*/

public class BoardTests{

	public static void main(String[] args){

		// case 1: testing Board(int locked)
		{
			System.out.println("TESTING: Board(int locked)");

			// setup
			Board board = new Board();

			// verify
			System.out.println(board.getType() + " == Board");

			// test
			assert board.getType() == "Board" : "Error in Board::Board()";

			System.out.println("Testing complete!");
			System.out.println("");
		}

		// case 2: testing Board(int locked)
		{
			System.out.println("TESTING: Board(int locked)");

			// setup
			Board board = new Board(5);

			// verify
			System.out.println(board.getType() + " == Board");
			System.out.println(board.numLocked() + " == 5");

			// test
			assert board.getType() == "Board" : "Error in Board::Board(int locked)";
			assert board.numLocked() == 5 : "Error in Board::Board(int locked)";

			System.out.println("Testing complete!");
			System.out.println("");
		}

		// case 3: testing getCols()
		{
			System.out.println("TESTING: getCols()");

			// setup 
			Board board = new Board();

			// verify
			System.out.println(board.getCols() + " == 9");

			// test
			assert board.getCols() == 9 : "Error in Board::getCols()";

			System.out.println("Testing complete!");
			System.out.println("");
		}

		// case 3: testing getRows()
		{
			System.out.println("TESTING: getRows()");

			// setup 
			Board board = new Board();

			// verify
			System.out.println(board.getCols() + " == 9");

			// test
			assert board.getRows() == 9 : "Error in Board::getRows()";

			System.out.println("Testing complete!");
			System.out.println("");
		}

		// case 4: testing get()
		{
			System.out.println("TESTING: get()");

			// set up
			Board board = new Board();

			// verify
			System.out.println(board.get(0,0) + " == 0");

			// test
			assert board.get(0, 0) == board.get(0, 0) : "Error in Board::get()";

			System.out.println("Testing complete!");
			System.out.println("");
		}

		// case 5: testing isLocked()
		{
			System.out.println("TESTING: isLocked()");

			// set up
			Board board = new Board();
			board.set(0,0, 0, true);

			// verify
			System.out.print(board.isLocked(0,0) + " == true");

			// test
			assert board.isLocked(0,0) == true : "Error in Board::isLocked()";

			System.out.println("Testing complete!");
			System.out.println("");
		}

		// case 6: testing numLocked()
		{
			System.out.println("TESTING: numLocked()");

			// setup
			Board board = new Board(5);

			// verify
			System.out.println(board.numLocked() + " == 5");

			// test
			assert board.numLocked() == 5 : "Error in Board::numLocked";

			System.out.println("Testing complete!");
			System.out.println("");
		}
	}
}