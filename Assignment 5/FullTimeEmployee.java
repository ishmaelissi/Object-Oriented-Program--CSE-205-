// Assignment #: 5
//         Name: Steven Carr
//    StudentID: 
//      Lecture: MWF 11:50
//  Description: Class that is used to create FullTimeEmployee object

import java.io.*;         //to use InputStreamReader and BufferedReader
import java.util.*;       //to use ArrayList
import java.text.NumberFormat;



public class FullTimeEmployee extends StaffMember
 {
    private double rate;
    private double bonus;

    NumberFormat money = NumberFormat.getCurrencyInstance();

    public FullTimeEmployee(String a, String b, String c, double d, double e)
    {
    super(a,b,c);				//uses parent constructor as well as local variables
    rate = d;
    bonus= e;
    }

    public void computePay()	//method for fulltimeemployee to compute pay
    {
    pay=rate+bonus;
    }

    public String toString()
    {
    return ("\nFull Time Employee:"+super.toString()+"Rate:\t\t\t"+money.format(rate)+"\n"+
                                                        "Bonus:\t\t\t"+money.format(bonus)+"\n\n");
    }


}
