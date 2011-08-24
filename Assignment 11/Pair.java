// Assignment #: 11
// Name: Steven Carr
// StudentID: 
// Lecture: MWF 10:45am-11:45am
// Description: The pair class pairs a row number and a column number.

public class Pair
 {
  private int row;
  private int col;

  //Initializes the pair object using two parameters
  public Pair(int row, int col)
   {
     this.row = row;
     this.col = col;
   }

  //Accessor method for the row number
  public int getRow()
   {
     return row;
   }

  //Accessor method for the column number
  public int getColumn()
   {
     return col;
   }
 }
