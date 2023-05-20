/*
*File: CellStack.java
*Derek Hessinger
*CS231
*10/26/22
*/

public class CellStack<T>{

	// Node class 
	private class Node{
		Cell cell;
		Node next;

		public Node(Cell cell){
	      this.cell = cell;
	      this.next = null;
	    }

	    public Node(Cell cell, Node next){
	      this.cell = cell;
	      this.next = next;
	    }

	    public Cell getCell(){
	      return cell;
	    }

	    public void setNext(Node newNext){
	      this.next = newNext;
	    }

	    public Node getNext(){
	      return next;
	    }
	}

	Node head;	//the top of the stack

	int size; //number of items in stack

	// Constructor for CellStack
	public CellStack(){

		this.head = null;
		this.size = 0;
	}
	
	// Pushes cell c onto the stack
	public void push(Cell c){

		//Make new node to store data`
    	Node newNode = new Node(c);
		//set new node next to whatever first item was
		newNode.setNext(head);
		//set the first item to be this new node
		head = newNode;
		//increment size
		size++;
	}

	// Returns the cell at the top of the stack
	public Cell peek(){

		return head.getCell();
	}

	// Removes the cell at the top of the stack and returns it
	public Cell pop(){

		Node deleted = head;
    	head = head.getNext();
    	--size;
    	return deleted.getCell();
	}

	// Returns the size of the stack
	public int size(){

		return this.size;
	}

	// Returns if the cell is empty
	public boolean empty(){
		if (size == 0){
			return true;
		}
		else{
			return false;
		}
	}
}
