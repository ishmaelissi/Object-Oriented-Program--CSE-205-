// Assignment #: 5
//         Name: Steven Carr
//    StudentID: 
//      Lecture: MWF 11:50
//  Description: The Assignment 5 class displays a menu of choices
//               (add volunteers, full time employees, or hourly employees,
//               compute their pay, search a member, list members,
//               quit, display menu) to a user.
//               Then it performs the chosen task. It will keep asking a user to
//               enter the next choice until the choice of 'Q' (Quit) is
//               entered.

import java.io.*;         //to use InputStreamReader and BufferedReader
import java.util.*;       //to use ArrayList

public class Assignment5
 {
  public static void main (String[] args)
   {
     char input1;
     String inputInfo = new String();
     String line = new String();
     boolean found = false;

     // ArrayList object is used to store member objects
     ArrayList <StaffMember> memberList = new ArrayList <StaffMember>();

     try
      {
       printMenu();     // print out menu

       // create a BufferedReader object to read input from a keyboard
       InputStreamReader isr = new InputStreamReader (System.in);
       BufferedReader stdin = new BufferedReader (isr);

       do
        {
         System.out.println("What action would you like to perform?");
         line = stdin.readLine().trim();
         input1 = line.charAt(0);
         input1 = Character.toUpperCase(input1);

         if (line.length() == 1)
          {
           switch (input1)
            {
             case 'A':   //Add Member
               System.out.print("Please enter a member information to add:\n");
               inputInfo = stdin.readLine().trim();
               StaffMember m = StaffMemberParser.StringToMember(inputInfo); //creates staffmember object and passes string from inputinfo into StringToMember method
               memberList.add(m);											//adds object from staffmember to memberList array
  /***********************************************************************************
  ***  ADD your code here to create an object of one of child classes of StaffMember class
  ***  and add it to the memberList
  ***********************************************************************************/
               break;
             case 'C':   //Compute Pay
             for(int i=0; i<memberList.size(); i++)							//computes pay for different objects that are held in memberList
             {
				 memberList.get(i).computePay();
			 }
  /***********************************************************************************
  ***  ADD your code here to compute the pay for all members the memberList.
  ***********************************************************************************/
                System.out.print("pay computed\n");
               break;
             case 'D':   //Search for Member
             found=false;
               System.out.print("Please enter a memberID to search:\n");
               inputInfo = stdin.readLine().trim();
               for(int i=0; i<memberList.size(); i++)						//reads string from user and compares it against known member ids
               {
				   if(memberList.get(i).getMemberId().equalsIgnoreCase(inputInfo))
				   {
					   found=true ; break;									//sets found to true if member id is found
				   }
			   }
  /***********************************************************************************
  ***  ADD your code here to search a given memberID. If found, set "found" true,
  ***  and set "found" false otherwise.
  ***********************************************************************************/
                if (found == true)
                 System.out.print("member found\n");
                else
                 System.out.print("member not found\n");
               break;
             case 'L':   //List Members
             for(int i=0; i<memberList.size(); i++)							//prints all details about member objects
             {
             	System.out.print(memberList.get(i));
		 	 }

  /***********************************************************************************
  ***  ADD your code here to print out all member objects. If there is no member,
  ***  print "no member\n"
  ***********************************************************************************/
               break;
             case 'Q':   //Quit
               break;
             case '?':   //Display Menu
               printMenu();
               break;
             default:
               System.out.print("Unknown action\n");
               break;
            }
         }
        else
         {
           System.out.print("Unknown action\n");
          }
        } while (input1 != 'Q'); // stop the loop when Q is read
      }
     catch (IOException exception)
      {
        System.out.println("IO Exception");
      }
  }

  /** The method printMenu displays the menu to a user **/
  public static void printMenu()
   {
     System.out.print("Choice\t\tAction\n" +
                      "------\t\t------\n" +
                      "A\t\tAdd Member\n" +
                      "C\t\tCompute Pay\n" +
                      "D\t\tSearch for Member\n" +
                      "L\t\tList Members\n" +
                      "Q\t\tQuit\n" +
                      "?\t\tDisplay Help\n\n");
  }
}



