// Assignment #: 2
//         Name: Steven Carr
//    StudentID: 
//      Lecture: MWF 11:50
//  Description: This class reads an integer from a keyboard and prints it out
//               along with other messages.

import java.util.Scanner;

public class Assignment2
 {
  public static void main (String[] args)
   {
     int odd=0;       //variable to store sum of odd integers
     int nnum=0;	  //variable to store sum of negative integers
     int count=0;	  //variable for positive integers count
     int max=0;		  
     int num;		  //variable to store keybaord input

     Scanner scan = new Scanner(System.in);

    do {num = scan.nextInt();

	if (num%2!= 0 && num<0)   //finds odd and negative integers and adds to odd and nnum
	{
	odd+=num;
	nnum+=num;
	if (max < num)
	{max = num;}
	}

	else if (num < 0)			//finds negative integers and adds to nnum
	{
	nnum+=num;
	if (max < num)
	{max = num;}
	}

	else if (num%2!= 0 && num>0)	//finds odd and positive integers and adds to count and odd
	{
	count++;
	odd +=num;
	if (max < num)
	{max = num;}
	}

	else					//finds any other positive integer and adds to count
	{
	count++;
	if (max < num)
	{max = num;}
	}
	}
	 while (num!=0);


	 System.out.println("The maximum integer is " + max);
	 System.out.println("The sum of the negative integers is " + nnum);
	 System.out.println("The sum of the odd integers is " + odd);
	 System.out.println("The count of positive integers in the sequence is " + (count-1));   //had to subtract one because count would always come up 1 over 

	}
}