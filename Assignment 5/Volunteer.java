// Assignment #: 5
//         Name: Steven Carr
//    StudentID: 
//      Lecture: MWF 11:50
//  Description: Class used to create volunteer object

import java.io.*;         //to use InputStreamReader and BufferedReader
import java.util.*;       //to use ArrayList

public class Volunteer extends StaffMember
 {
    public Volunteer(String a, String b, String c)
    {
    super(a,b,c);					//uses parent class constructor

    }

    public void computePay()		//computepay method for volunteer
     {
     pay = 0.0;
     }

     public String toString()
     {
     return ("\nVolunteer:" +super.toString()+"\n");
     }

}