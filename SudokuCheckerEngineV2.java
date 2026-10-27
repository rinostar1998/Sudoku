// CS 143
// Daniel Rice
// Sudoku Assignment Part I
// Sudoku Product Board Thingy #2 : isValid and isSolved

import java.util.*;
import java.io.FileNotFoundException;
import java.io.File;

// Pre : have a computer
// Post : main entry point to program that tests functionality of SudokuBoard
public class SudokuCheckerEngineV2 {
   public static void main(String[] args) {
      // Note that here I am calling the board object SudokuBoard
      // if you named your class something different, you should
      // find and replace all `SudokuBoard` with your class name
      boolean allTests = true;
      
      // an empty board is valid, but not solved
      System.out.print("Checking empty board...");
      try
      {
         SudokuBoard board1 = new SudokuBoard("boards/empty.sdk");
         assert board1.isValid() : "isValid: should be true";
         assert !board1.isSolved() : "isSolved: should be false";
         if(board1.isValid() && !board1.isSolved()) 
            System.out.println("passed.");
         else
         {
            System.out.println("failed.");
            allTests = false;
         }

      }
      catch(FileNotFoundException e)
      {
         
      }
   
      // an incomplete, valid board is valid, but not solved
      System.out.print("Checking incomplete, valid board...");
      try
      {
         SudokuBoard board2 = new SudokuBoard("boards/valid-incomplete.sdk");
         assert board2.isValid() : "isValid: should be true";
         assert !board2.isSolved() : "isSolved: should be false";
         if(board2.isValid() && !board2.isSolved()) 
            System.out.println("passed.");
         else {
            System.out.println("failed.");
            allTests = false;
         }
      }
      catch(FileNotFoundException e)
      {
         
      }
      
      // a complete, valid board is valid and solved
      try
      {
         System.out.print("Checking complete, valid board...");
         SudokuBoard board3 = new SudokuBoard("boards/valid-complete.sdk");
         assert board3.isValid() : "isValid: should be true";
         assert board3.isSolved() : "isSolved: should be true";
         if(board3.isValid() && board3.isSolved()) 
            System.out.println("passed.");
         else
         {
            System.out.println("failed.");
            allTests = false;
         }
      }
      catch(FileNotFoundException e)
      {
      }
      
      // a board with dirty data is not valid and not solved
      try
      {
         System.out.print("Checking dirty data board...");
         SudokuBoard board4 = new SudokuBoard("boards/dirty-data.sdk");
         assert !board4.isValid() : "isValid: should be false";
         assert !board4.isSolved() : "isSolved: should be false";
         if(!board4.isValid() && !board4.isSolved()) 
            System.out.println("passed.");
         else {
            System.out.println("failed.");
            allTests = false;
         }
      }
      catch(FileNotFoundException e)
      {
      }
      
      // a board with a row violation is not valid and not solved
      try
      {
         System.out.print("Checking row violating board...");
         SudokuBoard board5 = new SudokuBoard("boards/row-violation.sdk");
         assert !board5.isValid() : "isValid: should be false";
         assert !board5.isSolved() : "isSolved: should be false";
         if(!board5.isValid() && !board5.isSolved()) 
            System.out.println("passed.");
         else {
            System.out.println("failed.");
            allTests = false;
         }
      }
      catch(FileNotFoundException e)
      {
      }
      
      // a board with a column violation is not valid and not solved
      try
      {
         System.out.print("Checking col violating board...");
         SudokuBoard board6 = new SudokuBoard("boards/col-violation.sdk");
         assert !board6.isValid() : "isValid: should be false";
         assert !board6.isSolved() : "isSolved: should be false";
         if(!board6.isValid() && !board6.isSolved()) 
            System.out.println("passed.");
         else {
            System.out.println("failed.");
            allTests = false;
         }
      }
      catch(FileNotFoundException e)
      {
      }
      
      // a board with both a row and a column violation is not valid and not solved
      try
      {
         System.out.print("Checking row&col violating board...");
         SudokuBoard board7 = new SudokuBoard("boards/row-and-col-violation.sdk");
         assert !board7.isValid() : "isValid: should be false";
         assert !board7.isSolved() : "isSolved: should be false";
         if(!board7.isValid() && !board7.isSolved()) 
            System.out.println("passed.");
         else {
            System.out.println("failed.");
            allTests = false;
         }
      }
      catch(FileNotFoundException e)
      {
      }
      
      // a board with a mini-square violation is not valid and not solved
      try
      {
         System.out.print("Checking mini-square violating board...");
         SudokuBoard board8 = new SudokuBoard("boards/grid-violation.sdk");
         assert !board8.isValid() : "isValid: should be false";
         assert !board8.isSolved() : "isSolved: should be false";
         if(!board8.isValid() && !board8.isSolved()) 
            System.out.println("passed.");
         else {
            System.out.println("failed.");
            allTests = false;
         }
      }
      catch(FileNotFoundException e)
      {
      } 
      
      if(allTests)
         System.out.println("**** HORRAY: ALL TESTS PASSED ****");
   }
}

/*

 ----jGRASP exec: java -ea SudokuCheckerEngineV2
 ----   at: 2026-10-22 16:30:39.434 GMT-7
 ----jGRASP wedge: pid for process is 11858  pids for wedge are 11852 and 11857.
 ----jGRASP wedge: CLASSPATH is ":.:::/home/rinostar/jgrasp/extensions/classes".
 ----jGRASP wedge: working directory is /home/rinostar/CS143/Sudoku
 ----jGRASP wedge2: actual command sent [/usr/lib/jvm/jdk-27-oracle-x64/bin/java -ea SudokuCheckerEngineV2].
Checking empty board...
* * * * * * * * * 
* * * * * * * * * 
* * * * * * * * * 
* * * * * * * * * 
* * * * * * * * * 
* * * * * * * * * 
* * * * * * * * * 
* * * * * * * * * 
* * * * * * * * * 


* * * * * * * * * 
* * * * * * * * * 
* * * * * * * * * 
* * * * * * * * * 
* * * * * * * * * 
* * * * * * * * * 
* * * * * * * * * 
* * * * * * * * * 
* * * * * * * * * 


* * * * * * * * * 
* * * * * * * * * 
* * * * * * * * * 
* * * * * * * * * 
* * * * * * * * * 
* * * * * * * * * 
* * * * * * * * * 
* * * * * * * * * 
* * * * * * * * * 


* * * * * * * * * 
* * * * * * * * * 
* * * * * * * * * 
* * * * * * * * * 
* * * * * * * * * 
* * * * * * * * * 
* * * * * * * * * 
* * * * * * * * * 
* * * * * * * * * 

passed.
Checking incomplete, valid board...
5 3 * * 7 * * * * 
6 * * 1 9 5 * * * 
* 9 8 * * * * 6 * 
8 * * * 6 * * * 3 
4 * * 8 * 3 * * 1 
7 * * * 2 * * * 6 
* 6 * * * * 2 8 * 
* * * 4 1 9 * * 5 
* * * * 8 * * 7 9 


5 3 * * 7 * * * * 
6 * * 1 9 5 * * * 
* 9 8 * * * * 6 * 
8 * * * 6 * * * 3 
4 * * 8 * 3 * * 1 
7 * * * 2 * * * 6 
* 6 * * * * 2 8 * 
* * * 4 1 9 * * 5 
* * * * 8 * * 7 9 


5 3 * * 7 * * * * 
6 * * 1 9 5 * * * 
* 9 8 * * * * 6 * 
8 * * * 6 * * * 3 
4 * * 8 * 3 * * 1 
7 * * * 2 * * * 6 
* 6 * * * * 2 8 * 
* * * 4 1 9 * * 5 
* * * * 8 * * 7 9 


5 3 * * 7 * * * * 
6 * * 1 9 5 * * * 
* 9 8 * * * * 6 * 
8 * * * 6 * * * 3 
4 * * 8 * 3 * * 1 
7 * * * 2 * * * 6 
* 6 * * * * 2 8 * 
* * * 4 1 9 * * 5 
* * * * 8 * * 7 9 

passed.
Checking complete, valid board...
5 3 4 6 7 8 9 1 2 
6 7 2 1 9 5 3 4 8 
1 9 8 3 4 2 5 6 7 
8 5 9 7 6 1 4 2 3 
4 2 6 8 5 3 7 9 1 
7 1 3 9 2 4 8 5 6 
9 6 1 5 3 7 2 8 4 
2 8 7 4 1 9 6 3 5 
3 4 5 2 8 6 1 7 9 


5 3 4 6 7 8 9 1 2 
6 7 2 1 9 5 3 4 8 
1 9 8 3 4 2 5 6 7 
8 5 9 7 6 1 4 2 3 
4 2 6 8 5 3 7 9 1 
7 1 3 9 2 4 8 5 6 
9 6 1 5 3 7 2 8 4 
2 8 7 4 1 9 6 3 5 
3 4 5 2 8 6 1 7 9 


5 3 4 6 7 8 9 1 2 
6 7 2 1 9 5 3 4 8 
1 9 8 3 4 2 5 6 7 
8 5 9 7 6 1 4 2 3 
4 2 6 8 5 3 7 9 1 
7 1 3 9 2 4 8 5 6 
9 6 1 5 3 7 2 8 4 
2 8 7 4 1 9 6 3 5 
3 4 5 2 8 6 1 7 9 


5 3 4 6 7 8 9 1 2 
6 7 2 1 9 5 3 4 8 
1 9 8 3 4 2 5 6 7 
8 5 9 7 6 1 4 2 3 
4 2 6 8 5 3 7 9 1 
7 1 3 9 2 4 8 5 6 
9 6 1 5 3 7 2 8 4 
2 8 7 4 1 9 6 3 5 
3 4 5 2 8 6 1 7 9 

passed.
Checking dirty data board...
* * * * * * * * * 
1 6 7 9 8 5 4 2 3 
* * -9999 * * * * * * 
* * * * * * * * * 
* * * -9999 * * * * * 
* * * * * * * * * 
* * * * * 2 * * * 
* * -9999 * * * * * * 
* * * * * * * * * 


* * * * * * * * * 
1 6 7 9 8 5 4 2 3 
* * -9999 * * * * * * 
* * * * * * * * * 
* * * -9999 * * * * * 
* * * * * * * * * 
* * * * * 2 * * * 
* * -9999 * * * * * * 
* * * * * * * * * 


* * * * * * * * * 
1 6 7 9 8 5 4 2 3 
* * -9999 * * * * * * 
* * * * * * * * * 
* * * -9999 * * * * * 
* * * * * * * * * 
* * * * * 2 * * * 
* * -9999 * * * * * * 
* * * * * * * * * 


* * * * * * * * * 
1 6 7 9 8 5 4 2 3 
* * -9999 * * * * * * 
* * * * * * * * * 
* * * -9999 * * * * * 
* * * * * * * * * 
* * * * * 2 * * * 
* * -9999 * * * * * * 
* * * * * * * * * 

passed.
Checking row violating board...
7 * * * * * * 1 * 
2 * * * * * * * * 
* * * * * * * * * 
* * 4 * 3 * 4 * * 
* * * * * * * * * 
* * * * * * * * * 
* * * * 6 * * * * 
* * * * * * * 3 * 
* * * * * * * * * 


7 * * * * * * 1 * 
2 * * * * * * * * 
* * * * * * * * * 
* * 4 * 3 * 4 * * 
* * * * * * * * * 
* * * * * * * * * 
* * * * 6 * * * * 
* * * * * * * 3 * 
* * * * * * * * * 


7 * * * * * * 1 * 
2 * * * * * * * * 
* * * * * * * * * 
* * 4 * 3 * 4 * * 
* * * * * * * * * 
* * * * * * * * * 
* * * * 6 * * * * 
* * * * * * * 3 * 
* * * * * * * * * 


7 * * * * * * 1 * 
2 * * * * * * * * 
* * * * * * * * * 
* * 4 * 3 * 4 * * 
* * * * * * * * * 
* * * * * * * * * 
* * * * 6 * * * * 
* * * * * * * 3 * 
* * * * * * * * * 

passed.
Checking col violating board...
9 * * * * * * * * 
* * * * * * * * * 
6 * * * * * * * * 
* * * * * * * * * 
4 * * * * * * * * 
3 * * * * * * * * 
* * * * * * * * * 
9 * * * * * * * * 
* * * * * * * * * 


9 * * * * * * * * 
* * * * * * * * * 
6 * * * * * * * * 
* * * * * * * * * 
4 * * * * * * * * 
3 * * * * * * * * 
* * * * * * * * * 
9 * * * * * * * * 
* * * * * * * * * 


9 * * * * * * * * 
* * * * * * * * * 
6 * * * * * * * * 
* * * * * * * * * 
4 * * * * * * * * 
3 * * * * * * * * 
* * * * * * * * * 
9 * * * * * * * * 
* * * * * * * * * 


9 * * * * * * * * 
* * * * * * * * * 
6 * * * * * * * * 
* * * * * * * * * 
4 * * * * * * * * 
3 * * * * * * * * 
* * * * * * * * * 
9 * * * * * * * * 
* * * * * * * * * 

passed.
Checking row&col violating board...
* * * * 4 * * * * 
* * * * 3 * * * * 
* * * * 1 * 2 * * 
* * * * 6 * * * * 
* 3 * * 2 * 3 * * 
* * * * 7 * * * * 
* * * * 8 * 2 * * 
* * 3 * 5 * * * * 
* * * * 9 * * * * 


* * * * 4 * * * * 
* * * * 3 * * * * 
* * * * 1 * 2 * * 
* * * * 6 * * * * 
* 3 * * 2 * 3 * * 
* * * * 7 * * * * 
* * * * 8 * 2 * * 
* * 3 * 5 * * * * 
* * * * 9 * * * * 


* * * * 4 * * * * 
* * * * 3 * * * * 
* * * * 1 * 2 * * 
* * * * 6 * * * * 
* 3 * * 2 * 3 * * 
* * * * 7 * * * * 
* * * * 8 * 2 * * 
* * 3 * 5 * * * * 
* * * * 9 * * * * 


* * * * 4 * * * * 
* * * * 3 * * * * 
* * * * 1 * 2 * * 
* * * * 6 * * * * 
* 3 * * 2 * 3 * * 
* * * * 7 * * * * 
* * * * 8 * 2 * * 
* * 3 * 5 * * * * 
* * * * 9 * * * * 

passed.
Checking mini-square violating board...
* * * * * * * * * 
* * * * * * * * * 
* * * * * * * * * 
* * * * * * * * * 
* * * * * * * * * 
* * * * * * * * * 
* * * * * * 1 2 * 
* * * * * * * 3 2 
* * * * * * 5 4 * 


* * * * * * * * * 
* * * * * * * * * 
* * * * * * * * * 
* * * * * * * * * 
* * * * * * * * * 
* * * * * * * * * 
* * * * * * 1 2 * 
* * * * * * * 3 2 
* * * * * * 5 4 * 


* * * * * * * * * 
* * * * * * * * * 
* * * * * * * * * 
* * * * * * * * * 
* * * * * * * * * 
* * * * * * * * * 
* * * * * * 1 2 * 
* * * * * * * 3 2 
* * * * * * 5 4 * 


* * * * * * * * * 
* * * * * * * * * 
* * * * * * * * * 
* * * * * * * * * 
* * * * * * * * * 
* * * * * * * * * 
* * * * * * 1 2 * 
* * * * * * * 3 2 
* * * * * * 5 4 * 

passed.
**** HORRAY: ALL TESTS PASSED ****

 ----jGRASP wedge: exit code for process is 0.
 ----jGRASP: Operation complete.
 ----   at: 2026-10-22 16:30:39.878 GMT-7   elapsed: 0.444 seconds

*/