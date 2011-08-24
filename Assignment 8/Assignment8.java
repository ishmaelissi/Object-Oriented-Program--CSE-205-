// Assignment #: 8
//         Name: Steve Carr
//    StudentID: 
//  Lab Lecture: MWF 11:50
//  Description: The Assignment 8 class displays a menu of choices to a user
//               and performs the chosen task. It will keep asking a user to
//               enter the next choice until the choice of 'Q' (Quit) is
//               entered. It will create an object of Store containing a list
//               of computers and customers, and perform insertion, deletion,
//               search, sorting, displaying, closing, serialization,
//               deserialization, writing to a file, and reading from a file.

import java.io.*;

public class Assignment8 implements Serializable
 {
  public static void main (String[] args)
   {
     char input1;
     String inputInfo = new String(), inputInfo2 = new String();
     String inputInfo3 = new String(), inputInfo4 = new String();
     boolean operation = false;
     int operation2 = 0;
     int speed, memory;
     String line = new String();
     String customerInfo = new String(), computerInfo = new String();
     String filename = new String();

     // create a Store object. This is used throughout this class.
     Store store1 = new Store();

     try
      {
       // print out the menus
       printMenu();

       // create a BufferedReader object to read input from a keyboard
       InputStreamReader isr = new InputStreamReader (System.in);
       BufferedReader stdin = new BufferedReader (isr);

       do
        {
         System.out.print("What action would you like to perform?\n");
         line = stdin.readLine().trim();  //read a line
         input1 = line.charAt(0);
         input1 = Character.toUpperCase(input1);

         if (line.length() == 1)          //check if a user entered only one character
          {
           switch (input1)
            {
             case 'A':   //Add Customer
               System.out.print("Please enter the customer information to add:\n");
               inputInfo = stdin.readLine().trim();
/************************************************************************************
***  ADD your code to add a Customer object
***********************************************************************************/
               operation=store1.addCustomer(inputInfo);

               if (operation == true)
                System.out.print("customer added\n");
               else
                System.out.print("customer exists\n");
               break;
             case 'B':   //Add Computer
               System.out.print("Please enter the computer information to add:\n");
               inputInfo = stdin.readLine().trim();

/************************************************************************************
***  ADD your code to add a Computer object
***********************************************************************************/
               operation= store1.addComputer(inputInfo);

               if (operation == true)
                 System.out.print("computer added\n");
               else
                 System.out.print("computer exists\n");
               break;
             case 'D':   //Search for Customerr
               System.out.print("Please enter the customerID of a customer to search:\n");
               inputInfo = stdin.readLine().trim();
/************************************************************************************
***  ADD your code to check the existence of a Customer object
***********************************************************************************/
              operation2=store1.customerExists(inputInfo);

              if (operation2 > -1)
                 System.out.print("customer found\n");
               else
                 System.out.print("customer not found\n");
               break;
             case 'E':  //Search for Computer
               System.out.print("Please enter the computer's brand name to search:\n");
               inputInfo = stdin.readLine().trim();
               System.out.print("Please enter the computer's cpu type to search:\n");
               inputInfo2 = stdin.readLine().trim();
               System.out.print("Please enter the computer's cpu speed to search:\n");
               inputInfo3 = stdin.readLine().trim();
               speed = Integer.parseInt(inputInfo3);
               System.out.print("Please enter the computer's memory to search:\n");
               inputInfo4 = stdin.readLine().trim();
               memory = Integer.parseInt(inputInfo4);
/************************************************************************************
***  ADD your code to check the existence of a Computer object
***********************************************************************************/
                operation2=store1.computerExists(inputInfo,inputInfo2,speed,memory);

               if (operation2 > -1)
                 System.out.print("computer found\n");
               else
                 System.out.print("computer not found\n");
               break;
             case 'L':   //List Customers
/************************************************************************************
***  ADD your code to print out the list of Customers
***********************************************************************************/
               store1.listCustomers();
               break;
             case 'M':   //List Computers
/************************************************************************************
***  ADD your code to print out the list of Computers
***********************************************************************************/
              store1.listComputers();
              break;
             case 'O':  // Sort Customers
/************************************************************************************
***  ADD your code to sort the list of Customers
***********************************************************************************/
               store1.sortCustomers();

               System.out.print("customers sorted\n");
               break;
             case 'P':  // Sort Computers
/************************************************************************************
***  ADD your code to sort the list of Computers
***********************************************************************************/
               store1.sortComputers();

               System.out.print("computers sorted\n");
               break;
             case 'Q':   //Quit
               break;
             case 'R':  //Remove Customer
               System.out.print("Please enter the customerID to remove:\n");
               inputInfo = stdin.readLine().trim();
/************************************************************************************
***  ADD your code to remove a Customer
************************************************************************************/
               operation=store1.removeCustomer(inputInfo);

               if (operation == true)
                 System.out.print("customer removed\n");
               else
                 System.out.print("customer not found\n");
               break;
             case 'S':  //Remove Computer
               System.out.print("Please enter the computer's brand name to remove:\n");
               inputInfo = stdin.readLine().trim();
               System.out.print("Please enter the computer's cpu type to remove:\n");
               inputInfo2 = stdin.readLine().trim();
               System.out.print("Please enter the computer's cpu speed to remove:\n");
               inputInfo3 = stdin.readLine().trim();
               speed = Integer.parseInt(inputInfo3);
               System.out.print("Please enter the computer's memory to remove:\n");
               inputInfo4 = stdin.readLine().trim();
               memory = Integer.parseInt(inputInfo4);
/************************************************************************************
***  ADD your code to remove a Computer
************************************************************************************/
               operation=store1.removeComputer(inputInfo,inputInfo2,speed,memory);

               if (operation == true)
                 System.out.print("computer removed\n");
               else
                 System.out.print("computer not found\n");
               break;
             case 'T':  //Close Store
/************************************************************************************
***  ADD your code to close the store
***********************************************************************************/
               store1.closeStore();

               System.out.print("store closed\n");
               break;
             case 'U':  //Write Text to a File
               System.out.print("Please enter the file name to write:\n");
               filename = stdin.readLine().trim();
/************************************************************************************
***  ADD your code to write a text (string) to the specified file. Catch exceptions.
************************************************************************************/
                      String fileName = "test.txt";

                      System.out.print("Please enter a string to write in the file:\n");

                      FileWriter fw = new FileWriter (fileName);
                      BufferedWriter bw = new BufferedWriter (fw);
                      PrintWriter outFile = new PrintWriter (bw);

                      for (int i=1; i <= 10; i++)
                      {
                        outFile.print ("The value is " + i );
                        outFile.println ();
                      }

                      outFile.close();

               break;
             case 'V':  //Read Text from a File
               System.out.print("Please enter the file name to read:\n");
/************************************************************************************
***  ADD your code to read a text (string) from the specified file. Catch exceptions.
************************************************************************************/
                  FileReader fr=null;
                  BufferedReader inFile=null;
                  String aline;
                  filename="input.txt";

                  try
                    {
                        fr = new FileReader (filename);
                       inFile = new BufferedReader (fr);

                       aline = inFile.readLine();
                       while (aline != null)
                       {
                         System.out.println(line + "was read/n");
                         aline = inFile.readLine();
                         System.out.println("The first line of the file is:\n" + line + "/n");
                       }

                       inFile.close();
                     }
                    catch (FileNotFoundException exception)
                    {
                       System.out.println (filename + " was not found/n");
                    }
                    catch (IOException exception)
                    {
                       System.out.println (exception);
                    }
                    finally
                    {
                        try
                        {
                            if (inFile != null)
                                inFile.close();
                        }
                        catch (IOException ex)
                        {
                            System.out.println(ex);
                         }
                    }





              break;
             case 'W':  //Serialize Store to a File
               System.out.print("Please enter the file name to write:\n");
               filename = stdin.readLine().trim();
/************************************************************************************
***  ADD your code to write the store object to the specified file. Catch exceptions.
************************************************************************************/

                     FileOutputStream file1 = null;
                     ObjectOutputStream outStream = null;
                     try
                      {
                        file1 = new FileOutputStream (filename);
                        outStream = new ObjectOutputStream (file1);

                        // Serialize this above object to a file
                       outStream.writeObject(store1);
                       }
                   catch (NotSerializableException exception)
                      {
                         System.out.println("NotSerializableException");
                      }
                     catch (IOException exception)
                      {
                         System.out.println("IOExceotion");
                       }
                    finally
                      {
                           try
                             {    if (outStream != null) outStream.close();    }
                           catch (IOException exc)
                              {   System.out.println(exc);      }
                       }

               break;
              case 'X':  //Deserialize Store from a File
               System.out.print("Please enter the file name to read:\n");
               filename = stdin.readLine().trim();
/************************************************************************************
***  ADD your code to read a store object from the specified file. Catch exceptions.
***********************************************************************************/
                   FileInputStream file2 = null;
                   ObjectInputStream inStream = null;
                   try
                    {
                      file2 = new FileInputStream (filename);
                      inStream = new ObjectInputStream (file2);

                      // Deserialize the objects
                      Object obj1 = inStream.readObject();

                      if (obj1 instanceof Store)
                         {
                             store1 = (Store) obj1;

                              // Print the object
                              System.out.println (filename+" was read");
                         }
                    }
                  catch (ClassNotFoundException exception)
                    {
                     System.out.println("Class was not found");
                    }
                  catch (FileNotFoundException exception)
                    {
                     System.out.println( filename + " was not found");
                    }
                  catch (IOException exception)
                    {
                     System.out.println("IOException has occured.");
                    }
                  finally
                    {
                       try
                         {
                             if (inStream != null)
                                 inStream.close();
                         }
                       catch (IOException exc)
                         {
                             System.out.println(exc);
                         }
                    }


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
        } while (input1 != 'Q' || line.length() != 1);
      }
     catch (IOException exception)
      {
        System.out.print("IO Exception\n");
      }
   }

  /** The method printMenu displays the menu to a user **/
  public static void printMenu()
   {
     System.out.print("Choice\t\tAction\n" +
                      "------\t\t------\n" +
                      "A\t\tAdd Customer\n" +
                      "B\t\tAdd Computer\n" +
                      "D\t\tSearch for Customer\n" +
                      "E\t\tSearch for Computer\n" +
                      "L\t\tList Customers\n" +
                      "M\t\tList Computers\n" +
                      "O\t\tSort Customers\n" +
                      "P\t\tSort Computers\n" +
                      "Q\t\tQuit\n" +
                      "R\t\tRemove Customer\n" +
                      "S\t\tRemove Computer\n" +
                      "T\t\tClose Store\n" +
                      "U\t\tWrite Text to File\n" +
                      "V\t\tRead Text from File\n" +
                      "W\t\tSerialize Store to File\n" +
                      "X\t\tDeserialize Store from File\n" +
                      "?\t\tDisplay Help\n\n");
  }
} // end of Assignment8 class


