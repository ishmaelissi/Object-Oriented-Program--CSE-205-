// Assignment #: 11
// Name: Steven Carr
// StudentID: 
// Lecture: MWF 10:45am-11:45am
// Description: The NQueenSolver class solves the number of queens on the board
import java.util.Stack;

public class NQueenSolver
 {
  private Answer answer1;
  private int boardSize; //This is N in the assignment description.

  //Constructor to initialize the boardSize, which is also the number of
  //queens to be placed. Also create an answer object.
  public NQueenSolver(int queenNum)
   {
     answer1 = new Answer(queenNum);
     boardSize = queenNum; //This is N in the assignment description.
   }

  //Return an answer -- accessor of the answer1
  public Answer returnAnswer()
   {
     return answer1;
   }

  //The findSolution will return true if a solution is found,
  //false otherwise. Please see the pseudo-code of the assignment 11 statement
  public boolean findSolution()
   {
    Stack<Pair> stackSoln = new Stack<Pair>();

    //back-up stack
    Stack<Pair> stackSoln2 = new Stack<Pair>();

    boolean success = false;
    boolean conflict = false;

    //Push information onto the stack indicating the first choice
    //is a queen in row 0 and column 0.

    stackSoln.push(new Pair(0,0));

    while (!success && !stackSoln.isEmpty())
     {
		//Check whether the most recent choice (on top of the stack) is in the same row, same column,
		//or same diagonal as any other choices in the stack.
		//If so, there is a conflict; otherwise, there is no conflict.
		//Note that to check if two pairs (row1,col1) and (row2,col2) are in the same diagonal,
		//you just need to check if row1-col1 == row2-col2 or row1+col1 == row2+col2

		//Also note that, to check this, you need to pop all items in the stack.
		//When you finish it, you need to push them back onto the stack,
        //so you will need a back-up stack.

		Pair pair= stackSoln.pop();
		int row=pair.getRow();
		int column=pair.getColumn();

		stackSoln2.push(pair);
		conflict= false;

		while(!stackSoln.isEmpty())
		{
			Pair pair2 = stackSoln.pop();
			int row2 = pair2.getRow();
			int column2 = pair2.getColumn();

			stackSoln2.push(pair2);

			if(row == row2 || column == column2 || row + column == row2 + column2 || row -column ==row2-column2)
			conflict = true;
		}

		while(!stackSoln2.isEmpty())
		{
			stackSoln.push(stackSoln2.pop());
		}

        System.out.println("Trying to place a queen in row "
                           + stackSoln.peek().getRow()
                           + " in column "
                           + stackSoln.peek().getColumn() );

        if (conflict == true)
         {
            //1. Pop items off the stack until the stack becomes empty or
            //the top of the stack is a choice whose column is not N-1 (boardSize-1).
            //(i.e., pop items off the stack while the stack is not empty AND the top of the stack has the column that is N-1.)

            //2. If the stack is now not empty after popping items,
            //then increase the column number of the top choice by 1.
            //That is, pop the top choice, and increase its column, then push it back.

            while(!stackSoln.isEmpty() && stackSoln.peek().getColumn() == boardSize-1)
			{
				stackSoln.pop();
			}

			if(!stackSoln.isEmpty())
			{
				Pair pair3 = stackSoln.pop();
				stackSoln.push(new Pair(pair3.getRow(),pair3.getColumn()+1));
			}

         }
        else if (conflict == false && stackSoln.size() == boardSize)
         {
           success = true;

           //Since a solution is found, copy the stack info into the answer
           //so that it can print them.
           //(you don't need to add more code here, this part is given.)
           answer1.copySolution(stackSoln);
         }
        else //no conflict, and it has not finished finding a solution yet
         {
            //The next choice is to place a queen at row number stackSoln.size()
            //(one more than the current choice's row) and column number 0.
            //So push (stackSoln.size(), 0) onto the stack

            stackSoln.push(new Pair(stackSoln.size(),0));
         }
     } //end of while loop

    return success;

   }//end of findSolution method

}//end of the NQueenSolver class

