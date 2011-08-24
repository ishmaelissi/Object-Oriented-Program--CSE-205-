// Assignment #: 5
//         Name: Steven Carr
//    StudentID: 
//      Lecture: MWF 11:50
//  Description: Class used to create HourlyEmployee object 

import java.io.*;         //to use InputStreamReader and BufferedReader
import java.util.*;       //to use ArrayList
import java.text.NumberFormat;



public class HourlyEmployee extends StaffMember
 {
    private double rate;
    private int hoursWorked;

    NumberFormat money = NumberFormat.getCurrencyInstance();

    public HourlyEmployee(String a, String b, String c, double d, int e)
    {
    super(a,b,c);					//uses parent constructor as well as local variables 
    rate= d;
    hoursWorked=e;
    }

    public void computePay()		//computePay method for hourlyemployee
    {
    pay= rate*hoursWorked;
    }

    public String toString()
    {
    return ("\nHourly Employee:" + super.toString() + "Rate:\t\t\t"+money.format(rate)+"\n"+
                                                        "Hours:\t\t\t"+ hoursWorked+"\n\n");
    }

}
