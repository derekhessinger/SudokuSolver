/*
*Board.java
*Derek Hessinger
*CS231
*10/4/22
*/

import java.io.FileReader;
import java.io.BufferedReader;
import java.io.*;
import java.util.Random;

public class Board{

  //Fields for Board
  private Cell[][] board;
  public static final int SIZE = 9;

  public Board(){

    //Create 2D array of cells that is board.size x board.size
    this.board = new Cell[Board.SIZE][Board.SIZE];

    //For loop to set each of the cells to 0
    for (int i = 0; i < Board.SIZE; i++){

      for (int j = 0; j < Board.SIZE; j++){

        this.board[i][j] = new Cell(i,j, 0);
      }
    }
  }

    public String toString(){

      //Initialize string
      String bstring = "";

      //For loop to print out each cell
      for (int i = 0; i < Board.SIZE; i++){

        for (int j = 0; j < Board.SIZE; j++){

          bstring += this.board[i][j].getValue();

          //To add space when printing, add a space at the end of every 3rd column
          if ((j+1)%3 == 0){
            bstring += "\t";
          }
        }

        bstring += "\n";
        //To add space when printing, add a line at the end of every 3rd row
        if ((i+1)%3 == 0){
          bstring += "\n";
        }
      }return bstring;
    } 

  //Returns number of columns
  public int getCols(){

    return this.SIZE;
  }

  //Returns number of rows
  public int getRows(){

    return this.SIZE;
  }

  //Returns cell at [r,c]
  public Cell get(int r, int c){

    return board[r][c];
  }

  //Returns if cell at [r][c] is locked
  public boolean isLocked(int r, int c){

    return this.board[r][c].isLocked();
  }

  //Returns the total number of locked cells on the board
  public int numLocked(){

    //Initialize counter
    int counter = 0;

    //Loop through board and count locked cells
    for(int i = 0; i < this.SIZE; i++){

      for(int j = 0; j < this.SIZE; j++){

        if (this.board[i][j].isLocked()){

          counter += 1;
        }
      }
    } return counter;
  }

  //Returns the value of the cell at [r][c]
  public int value(int r, int c){

    return this.board[r][c].getValue();
  }

  //Sets the value at cell [r][c]
  public void set(int r, int c, int value){

    this.board[r][c].setValue(value);
  }

  //Sets the value at cell [r][c] and if it is locked
  public void set(int r, int c, int value, boolean locked)
  {
    this.board[r][c].setValue(value);
    this.board[r][c].setLocked(locked);
  }


  //Tests if value passed is valid for the row, column, and 3x3 square it is in
  public boolean validValue(int row, int col, int value){

    //Check if value is 1-9    

    if(value < 1 || value > 9){

      return false;
    }

    //For loop to go over each item in board
    for (int i = 0; i < this.SIZE; i++){


      //If the value is already in the row, return false
      if (this.board[row][i].getValue() == value && i != col){

        return false;
      }


      //If the value is already in the column, return false
      if (this.board[i][col].getValue() == value && i != row){

        return false;
      }
    }

    //To locate which 3x3 box the guess is in, store integer division in variables
    int boxR = row/3;
    boxR = boxR*3;
    int boxC = col/3;
    boxC = boxC*3;

    //For loop to check if the value is valid in the 3x3 square on board
    for (int a = boxR; a < boxR + 3; a++){

      for (int b = boxC; b < boxC + 3; b++){

        if (this.board[a][b].getValue() == value){

          if (a != row){

            return false;
          }

          if (b != col){

            return false;
        }

          else{

            return true;
          }
      }
    }
  } return true;
}


  //Checks if the board is solved
  public boolean validSolution(){

    for (int i = 0; i < Board.SIZE; i++){

      for (int j = 0; j < Board.SIZE; j++){

        if (this.board[i][j].getValue() == 0){

          return false;
        }

        if (this.validValue(i, j, this.board[i][j].getValue()) == false){

          return false;
        }
        else{

          return true;
        }
      }
    }
  return true;
  }

  //Check this tomorrow!
  public void randomLock(int locked){

    Random ran = new Random();

    for (int i = 0; i < locked - 1; i++){

      int x = ran.nextInt(9);
      int y = ran.nextInt(9);
      int val = this.board[x][y].getValue();
      this.set(x, y, val, true);
    }


  }

  //Reads file and prints out board
	public boolean read(String filename) {

    try {
      // assign to a variable of type FileReader a new FileReader object, passing filename to the constructor
      FileReader fr = new FileReader(filename);

      // assign to a variable of type BufferedReader a new BufferedReader, passing the FileReader variable to the constructor
      BufferedReader br = new BufferedReader(fr);

      // assign to a variable of type String line the result of calling the readLine method of your BufferedReader object.
      String line = br.readLine();

      //Variables for while loop
      int row = 0;
      int col = 0;


      // start a while loop that loops while line isn't null
      while(line != null){

        // assign to an array of type String the result of calling split on the line with the argument "[ ]+"
      	String[] arr = line.split("[ ]+");

        for (int i = 0; i < arr.length; i++){

          if (Integer.parseInt(arr[col]) != 0){

            this.set(row, col, Integer.parseInt(arr[col]), true);
          }

          else{

            this.set(row, col, Integer.parseInt(arr[col]), false);
          }
          col++;
        } 
        line = br.readLine();
        row += 1;
        col = 0;
      }

      br.close();
      return true;
    }
    catch(FileNotFoundException ex) {
      System.out.println("Board.read():: unable to open file " + filename );
    }
    catch(IOException ex) {
      System.out.println("Board.read():: error reading file " + filename);
    }

    return false;
  }

  public static void main(String[] argv){

  	Board board = new Board();

    board.read(argv[0]);

    System.out.println(board);

    System.out.println(board.validSolution());

  }

}