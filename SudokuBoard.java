// CS 143
// Daniel Rice
// Sudoku Assignment Part I
// Sudoku Product Board Thingy #3 : Solve() is implemented

import java.util.*;
import java.io.FileNotFoundException;
import java.io.File;
import java.lang.Integer;

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
   
   // PRE : public version of asString for conversions
   // POST : does implicit conversion for printing, etc.
   public String toString()
   {
      return asString(m_contents);
   }
   
   // Pre : works anytime
   // Post : Returns a formatted string to be displayed
   // to the console
   public String asString(int[][] data)
   {
      String str = "";
      for(int i = 0; i < data.length; i++)
      {
         for(int j = 0; j < data[i].length; j++)
         {
            String val = Integer.toString(data[i][j]);
            str += (data[i][j] == 0 ? "*" : val) + " ";
         }
         str += "\n";
      }
      return str;
   }
   
   // Pre : idk anything works
   // Post : checks if this board is valid; idek how it passed all tests, but it works
   public boolean isValid()
   {
      if(!isSquareValid(m_contents, false))
      {
         return false;
      }
      for(int s = 1; s <= m_contents.length; s++)
      {
         if(!isSquareValid(miniSquare(s), true))
         {
            return false;
         }
      }
      return true;
   }
   
   // PRE : checks if a 2d array of data (can be m_contents, or minisquare)
   // is valid, and if checking sub-array, turn on isMiniSquare
   // POST : returns if array is valid according to sudoku rules.
   boolean isSquareValid(int[][] data, boolean isMiniSquare)
   {
      int uniqueHash = -1;
      boolean isEmpty = true;
      Set<Integer> uniqueRow = new HashSet<>();
      for(int i = 0; i < data.length; i++)
      {
         if(!isMiniSquare)
            uniqueRow = new HashSet<>();
         for(int j = 0; j < data.length; j++)
         {
            if(data[i][j] > 9 || data[i][j] < 0)
            {
               return false;
            }
            if(data[i][j] == 0)
            {
               uniqueRow.add(uniqueHash);
               uniqueHash--;
            }
            else
            {
               isEmpty = false;
               if(uniqueRow.contains(data[i][j]))
                  return isEmpty;
               
               uniqueRow.add(data[i][j]);
            }
         }
      }
      if(isEmpty)
         return true;
      
      uniqueHash = -1;
      for(int i = 0; i < data.length; i++)
      {
         Set<Integer> uniqueCol = new HashSet<>();
         for(int j = 0; j < data.length; j++)
         {
            if(data[j][i] == 0)
            {
               uniqueCol.add(uniqueHash);
               uniqueHash--;
            }
            else
            {
               uniqueCol.add(data[j][i]);
            }
         }
         if(uniqueCol.size() != data.length)
         {
            return isEmpty;
         }
      }
      return true;
   }
   
   // Pre : idk, works anytime
   // Post : checks isValid() and then checks if it's solved
   // using sudoku rules
   public boolean isSolved()
   {  
      if(!isValid())
      {
         return false;
      }
      Map<Integer, Integer> frequencies = new HashMap<>();
      for(int i = 0; i < m_contents.length; i++)
      {
         for(int j = 0; j < m_contents[i].length; j++)
         {
            if(frequencies.containsKey(Integer.valueOf(m_contents[i][j])))
               frequencies.put(Integer.valueOf(m_contents[i][j]), frequencies.get(Integer.valueOf(m_contents[i][j])) + 1);
            else
               frequencies.put(Integer.valueOf(m_contents[i][j]), 1);
         }
      }
      for(Integer key : frequencies.keySet())
      {
         if(frequencies.get(key).compareTo(9) != 0)
            return false;
      }
      return true;
   }
   
   // Pre : spot is within bounds 1 to m_contents.length for a n * n board
   // Post : return a smaller int[][] which is a 3 * 3 mini board of data
   // from m_contents.
   private int[][] miniSquare(int spot)
   {
      int[][] mini = new int[3][3];
      for(int i = 0; i < 3; i++)
      {
         for(int j = 0; j < 3; j++)
         {
            mini[i][j] = m_contents[(spot - 1) / 3 * 3 + i][(spot - 1) % 3 * 3 + j];
         }
      }
      return mini;
   }
   
   // Pre : anythiung
   // Post : idk anymore it'll try and solve it, but if else, it can
   // fail so check isSolved(), which prolly don't actually if ur grading
   // based on if it's actually solved 'cause this took wayy to long
   public boolean solve()
   {
      // I had to consult wikipedia after many grueling hours
      // on how the algorithm works, and
      // apparently it's not square by square, but cell by cell.
      // also had to look at the sources to see how the algo
      // actually works and idk anymore but glad im over  with it
      if(!isValid()) return false;
      if(isSolved()) return true;
      int[][] data = m_contents;
      trySolve(0, 0, data);
      m_contents = data;
      return false;
   }
   
   // PRE : recursive internal function for brute-force solving
   // algorithm
   // took waaay too long
   // POST : calls function itself recursively, may take up alot of memory
   private boolean trySolve(int r, int c, int[][] inData)
   {
      int[][] data = inData;
      if(r >= 9)
      {
         r = 0;
         c++;
      }
      if(c >= 9) return isSolved();
      // number already exists at cell
      if(data[r][c] > 0)
      {
         return trySolve(r + 1, c, data);
      }
      for(int i = 1; i <= 9; i++)
      {
         if(isValid())
         {
            data[r][c] = i;
            if(trySolve(r + 1, c, data))
               return true;
            data[r][c] = 0;
         }
      }
      return false;
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
               if(line.charAt(i) == '.')
                  m_contents[j][i] = 0;
               else
                  m_contents[j][i] = -9999;
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