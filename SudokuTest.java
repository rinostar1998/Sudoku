// CS 143
// Daniel Rice
// Sudoku Assignment Part I
// Sudoku Testing Facility

import java.util.*;
import java.io.FileNotFoundException;
import java.io.File;

public class SudokuTest
{
   // Pre : ur computer is setup to run java
   // Post : reads from an existing file and prints to console
   public static void main(String[] args)
   {
      try
      {
         SudokuBoard board = new SudokuBoard("data1-1-1.sdk");
         System.out.println(board.toString());
      }
      catch(FileNotFoundException e)
      {
         
      }
   }
}

/*

 ----jGRASP exec: java SudokuTest
2 * * 1 * 5 * * 3 
* 5 4 * * * 7 1 * 
* 1 * 2 * 3 * 8 * 
6 * 2 8 * 7 3 * 4 
* * * * * * * * * 
1 * 5 3 * 9 8 * 6 
* 2 * 7 * 1 * 6 * 
* 8 1 * * * 2 4 * 
7 * * 4 * 2 * * 1 


 ----jGRASP: Operation complete.
*/