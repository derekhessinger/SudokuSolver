/*
*File: CellStackTests.java
*Derek Hessinger
*CS231
*10/18/22
*/

public class CellStackTests{

	public static void main(String[] args){

		// case 1: testing CellStack()
		{
			System.out.println("TESTING: CellStack()");

			// setup
			CellStack cs = new CellStack();

			// verify
			System.out.println(cs.head + " == null");
			System.out.println(cs.size + " == 0");

			// test
			assert cs.head == null : "Error in CellStack::CellStack()";
			assert cs.size == 0 : "Error in CellStack::CellStack()";

			System.out.println("Testing complete!");
			System.out.println("");
		}

		// case 2: testing push()
		{
			System.out.println("TESTING: push()");

			// setup
			CellStack cs = new CellStack();
			Cell cell = new Cell();
			cs.push(cell);

			// verify 
			System.out.println(cs.size + " == 1");

			// test 
			assert cs.size == 1 : "Error in CellStack::push()";

			System.out.println("Testing complete!");
			System.out.println("");
		}

		// case 3: testing peek()
		{
			System.out.println("TESTING: peek()");

			// setup
			CellStack cs = new CellStack();
			Cell cell = new Cell();
			cs.push(cell);

			// verify
			System.out.println(cs.peek() + " == 0");

			// test
			assert cs.peek() == cell : "Error in CellStack::peek()";

			System.out.println("Testing complete!");
			System.out.println("");
		}

		// case 4: testing pop()
		{
			System.out.println("TESTING: pop()");

			// setup
			CellStack cs = new CellStack();
			Cell cell1 = new Cell();
			Cell cell2 = new Cell();
			Cell cell3 = new Cell();
			cs.push(cell1);
			cs.push(cell2);
			cs.push(cell3);
			Cell popped = cs.pop();

			// verify
			System.out.println(cs.size + " == 2");
			System.out.println(popped + " == 0");

			// test
			assert cs.size == 2 : "Error in CellStack::pop()";
			assert popped == cell3 : "Error in CellStack::pop()";

			System.out.println("Testing complete!");
			System.out.println("");

			System.out.println("***TESTING FINSIHED***");			
		}
	}
}