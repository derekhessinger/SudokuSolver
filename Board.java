/*
*Board.java
*Derek Hessinger
*CS231
*10/4/22
*/

import java.io.FileReader;
import java.io.BufferedReader;
import java.io.*;

public class Board{

	public boolean read(String filename) {
    try {
      // assign to a variable of type FileReader a new FileReader object, passing filename to the constructor
      FileReader fr = new FileReader(filename);

      // assign to a variable of type BufferedReader a new BufferedReader, passing the FileReader variable to the constructor
      BufferedReader br = new BufferedReader(fr);

      // assign to a variable of type String line the result of calling the readLine method of your BufferedReader object.
      String line = br.readLine();

      // start a while loop that loops while line isn't null
      while(line != null){
        // assign to an array of type String the result of calling split on the line with the argument "[ ]+"
      	String[] arr = line.split("[ ]+");

          // print the String (line)
      	System.out.println(line);

          // print the size of the String array (you can use .length)
      	System.out.println(arr.length);

          // assign to line the result of calling the readLine method of your BufferedReader object.
      	line = br.readLine();

      }
      // call the close method of the BufferedReader
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

  public static void main(String[] args){

  	Board board = new Board();

  	board.read(args[0]);
  }

}