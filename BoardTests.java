/*
* File : BoardTests.java
* Derek Hessinger
* CS231
* 10/19/22
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

		// case 7: testing value()
		{
			System.out.println("TESTING: value()");

			// setup
			Board board = new Board();

			// verify
			System.out.println(board.value(0,0) + " == 0");

			// test
			assert board.value(0,0) == 0 : "Error in Board::value()";

			System.out.println("Testing complete!");
			System.out.println("");
		}

		// case 8: testing set()
		{
			System.out.println("TESTING: set()");

			// setup
			Board board = new Board();
			board.set(0, 0, 5, true);

			// verify
			System.out.println(board.value(0,0) + " == 5");
			System.out.println(board.isLocked(0,0) + " == true");

			// test
			assert board.value(0,0) == 5 : "Error in Board::set()";
			assert board.isLocked(0,0) == true : "Error in Board::set()";

			System.out.println("Testing complete!");
			System.out.println("");
		}

		// case 9: testing validValue()
		{
			System.out.println("TESTING: validValue()");

			// setup
			Board board1 = new Board();
			Board board2 = new Board();
			Board board3 = new Board();
			Board board4 = new Board();
			board2.set(0,1,1);
			board3.set(1,0,1);
			board4.set(3,3,1);

			// test
			System.out.println(board1.validValue(0,0,1) + " == true");
			System.out.println(board2.validValue(0,0,1) + " == false");
			System.out.println(board3.validValue(0,0,1) + " == false");
			System.out.println(board4.validValue(0,0,1) + " == false");

			System.out.println("Testing complete!");
			System.out.println("");
		}

		// case 11: testing findNextCell()
		{
			System.out.println("TESTING: findNextCell()");

			// setup
			Board board = new Board();

			// verify
			System.out.print(board.findNextCell() + " == 1");

			// test
			assert board.findNextCell() == board.findNextCell() : "Error in Board::findNextCell()";

			System.out.println("Testing complete!");
			System.out.println("");
		}

		// case 10: testing validSolution()
		// I put this test last because it may take awhile for the board to come up with a random solved board
		{
			System.out.println("TESTING: validSolution()");

			// setup
			Board board1 = new Board(81);

			// verify
			System.out.println(board1.validSolution() + " == true");

			// test
			assert board1.validSolution() == true : "Error in Board::validSolution";

			System.out.println("Testing complete!");
			System.out.println("");

			System.out.println("***TESTING FOR BOARD COMPLETE***");
		}
	}
}