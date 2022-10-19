/*
*File: CellTests.java
*Derek Hessinger
*CS231
*10/18/22
*/

public class CellTests{

	public static void main(String[] args){

		// case 1: testing Cell()
		{
			System.out.println("TESTING: Cell()");

			// setup
			Cell cell1 = new Cell();

			// verify
			System.out.println(cell1.rowIDX + " == 0");
			System.out.println(cell1.colIDX + " == 0");
			System.out.println(cell1.val + " == 0");
			System.out.println(cell1.valLock + " == false");

			// test
			assert cell1.rowIDX == 0 : "Error in Cell::Cell()";
			assert cell1.colIDX == 0 : "Error in Cell::Cell()";
			assert cell1.val == 0 : "Error in Cell::Cell()";
			assert cell1.valLock == false : "Error in Cell::Cell()";

			System.out.println("Testing complete!");
			System.out.println("");
		}

		// case 2: testing Cell(int row, int col, int value)
		{
			System.out.println("TESTING: Cell(int row, int col, int value)");

			// setup
			Cell cell1 = new Cell(1, 1, 1);

			// verify
			System.out.println(cell1.rowIDX + " == 1");
			System.out.println(cell1.colIDX + " == 1");
			System.out.println(cell1.val + " == 1");
			System.out.println(cell1.valLock + " == false");

			// test
			assert cell1.rowIDX == 1 : "Error in Cell::Cell()";
			assert cell1.colIDX == 1 : "Error in Cell::Cell()";
			assert cell1.val == 1 : "Error in Cell::Cell()";
			assert cell1.valLock == false : "Error in Cell::Cell()";

			System.out.println("Testing complete!");
			System.out.println("");
		}

		// case 3: testing Cell(int row, int col, int value, boolean locked)
		{
			System.out.println("TESTING: Cell(int row, int col, int value, boolean locked");

			// setup
			Cell cell1 = new Cell(1, 1, 1, true);

			// verify
			System.out.println(cell1.rowIDX + " == 1");
			System.out.println(cell1.colIDX + " == 1");
			System.out.println(cell1.val + " == 1");
			System.out.println(cell1.valLock + " == true");

			// test
			assert cell1.rowIDX == 1 : "Error in Cell::Cell()";
			assert cell1.colIDX == 1 : "Error in Cell::Cell()";
			assert cell1.val == 1 : "Error in Cell::Cell()";
			assert cell1.valLock == true : "Error in Cell::Cell()";

			System.out.println("Testing complete!");
			System.out.println("");
		}

		// case 4: testing getRow()
		{
			System.out.println("TESTING: getRow()");

			// setup
			Cell cell1 = new Cell(1, 1, 1, true);

			// verify
			System.out.println(cell1.getRow() + " == 1");

			// test
			assert cell1.getRow() == 1 : "Error in Cell::getRow()";

			System.out.println("Testing complete!");
			System.out.println("");
		}

		// case 5: testing getCol()
		{
			System.out.println("TESTING: getCol()");

			// setup
			Cell cell1 = new Cell(1, 1, 1, true);

			// verify
			System.out.println(cell1.getCol() + " == 1");

			// test
			assert cell1.getCol() == 1 : "Error in Cell::getCol()";

			System.out.println("Testing complete!");
			System.out.println("");
		}

		// case 6: testing getValue()
		{
			System.out.println("TESTING: getValue()");

			// setup
			Cell cell1 = new Cell(1, 1, 1, true);

			// verify
			System.out.println(cell1.getValue() + " == 1");

			// test
			assert cell1.getValue() == 1 : "Error in Cell::getValue()";

			System.out.println("Testing complete!");
			System.out.println("");
		}

		// case 7: testing setValue()
		{
			System.out.println("TESTING: setValue()");

			// setup
			Cell cell1 = new Cell();
			cell1.setValue(2);

			// verify
			System.out.println(cell1.getValue() + " == 2");

			// test
			assert cell1.getValue() == 2 : "Error in Cell::setValue()";

			System.out.println("Testing complete!");
			System.out.println("");
		}

		// case 8: testing isLocked()
		{
			System.out.println("TESTING: isLocked()");

			// setup
			Cell cell1 = new Cell(1, 1, 1, true);

			// verify
			System.out.println(cell1.isLocked() + " == true");

			// test
			assert cell1.isLocked() == true : "Error in Cell::isLocked()";

			System.out.println("Testing complete!");
			System.out.println("");
		}

		// case 9: testing setLocked()
		{
			System.out.println("TESTING: setLocked()");

			// setup
			Cell cell1 = new Cell();
			cell1.setLocked(true);

			// verify
			System.out.println(cell1.isLocked() + " == true");

			// test
			assert cell1.isLocked() == true : "Error in Cell::setLocked()";

			System.out.println("Testing complete!");
			System.out.println("");

			System.out.println("***TESTING FINSIHED FOR: Cell.java***");
		}


	}
}