// Assignment #: 5
//         Name: Steven Carr
//    StudentID: 
//      Lecture: MWF 11:50
//  Description: This class is to be used as the blueprint for a StaffMember object

import java.io.*;         //to use InputStreamReader and BufferedReader
import java.util.*;       //to use ArrayList
import java.text.NumberFormat;

public abstract class StaffMember
 {
    protected String firstName;
    protected String lastName;
    protected String memberId;
    protected double pay=0.0;

    NumberFormat money = NumberFormat.getCurrencyInstance();

    public StaffMember(String fname, String lname, String id)	//constructor that will be used by every other child class
    {
        firstName=fname;
        lastName=lname;
        memberId=id;
    }

    public String getMemberId()						//gets the member id and returns it 
    {
    return memberId;
    }

    public abstract void computePay();				//computepay method that will be used by child classes

    public String toString()						//prints details of staffmember object
    {
        return ("\nFirst name:\t\t"+firstName+"\n" +
                "Last name:\t\t"+lastName+"\n" +
                "Member ID:\t\t"+memberId+"\n" +
                "Pay:\t\t\t"+money.format(pay)+"\n");
    }

}

