// CS 143
// Daniel Rice
// Sudoku Assignment Part I
// Sudoku Product Board Thingy

import java.util.*;
import java.io.FileNotFoundException;
import java.io.File;

public class SudokuBoard
{
   // Pre : filePath is valid
   // Post : if filePath isn't valid, throws exception for
   // client to deal with
   SudokuBoard(String filePath) throws FileNotFoundException
   {
      m_contents = new int[9][9];
      loadFromFile(new File(filePath));
   }
   
   // Pre : works anytime
   // Post : Returns a formatted string to be displayed
   // to the console
   public String toString()
   {
      String str = "";
      for(int i = 0; i < m_contents.length; i++)
      {
         for(int j = 0; j < m_contents[i].length; j++)
         {
            String val = Integer.toString(m_contents[i][j]);
            str += (m_contents[i][j] == 0 ? "*" : val) + " ";
         }
         str += "\n";
      }
      return str;
   }
   
   // Pre : inFile is valid
   // Post : scanner throws fileNotFound if inFile isn't valid
   void loadFromFile(File inFile) throws FileNotFoundException
   {
      
      Scanner scan = new Scanner(inFile);
      int j = 0;
      while(scan.hasNextLine())
      {
         String line = scan.nextLine();
         for(int i = 0; i < line.length(); i++)
         {
            if(Character.isDigit(line.charAt(i)))
            {
               m_contents[j][i] = (int)(line.charAt(i) - '0');
            }
            else
            {
               m_contents[j][i] = 0;
            }
         }
         j++;
      }
   }
   
   // I put my private stuff down here, so anyone
   // who's looking though the code can easily get to
   // the stuff that actually matters and doesn't
   // have to skip though the variables that
   // don't apply to them on the calling sites.
   private int[][] m_contents;
}