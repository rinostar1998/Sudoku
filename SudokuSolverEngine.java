// CS 143
// Daniel Rice
// Sudoku Solver Assignment Tester File
// Sudoku Product Board Thingy #3 : Solve() is implemented, sort of

import java.io.FileNotFoundException;
import java.io.File;

public class SudokuSolverEngine {

   public static void main(String[] args) {
      // Here I have called my class `MySudokuBoard` if you named your class
      // differently, modify the line below to use your own class name
      try
      {
         SudokuBoard board = new SudokuBoard("boards/very-fast-solve-1.sdk");
         System.out.println("Initial board");
         System.out.println(board);
         System.out.println();
   
         System.out.print("Solving board...");
         long start = System.currentTimeMillis();
         board.solve();
         long stop = System.currentTimeMillis();
         System.out.printf("SOLVED in %.3f seconds.\n", ((stop-start)/1000.0));
         System.out.println();
         System.out.println(board);
      }
      catch(FileNotFoundException e)
      {
      }
   }
}

/*
 ----jGRASP exec: java -ea SudokuSolverEngine
 ----   at: 2026-10-28 18:26:15.820 GMT-7
 ----jGRASP wedge: pid for process is 70272  pids for wedge are 70266 and 70271.
 ----jGRASP wedge: CLASSPATH is ":.:::/home/rinostar/jgrasp/extensions/classes".
 ----jGRASP wedge: working directory is /home/rinostar/CS143/Sudoku
 ----jGRASP wedge2: actual command sent [/usr/lib/jvm/jdk-27-oracle-x64/bin/java -ea SudokuSolverEngine].
Initial board
* 3 4 6 7 8 9 1 2 
* 7 2 1 9 5 3 4 8 
1 9 8 3 4 2 5 6 7 
* * 9 * 6 1 4 2 3 
* 2 6 8 5 3 7 9 1 
* 1 3 9 2 4 * 5 6 
* 6 1 5 3 7 2 8 4 
* 8 * 4 1 9 6 3 5 
3 4 5 * 8 6 1 7 9 


Solving board...SOLVED in 0.011 seconds.

5 3 4 6 7 8 9 1 2 
6 7 2 1 9 5 3 4 8 
1 9 8 3 4 2 5 6 7 
8 5 9 7 6 1 4 2 3 
4 2 6 8 5 3 7 9 1 
7 1 3 9 2 4 8 5 6 
9 6 1 5 3 7 2 8 4 
2 8 7 4 1 9 6 3 5 
3 4 5 2 8 6 1 7 9 


 ----jGRASP wedge: exit code for process is 0.
 ----jGRASP: Operation complete.
 ----   at: 2026-10-28 18:26:16.265 GMT-7   elapsed: 0.444 seconds
*/