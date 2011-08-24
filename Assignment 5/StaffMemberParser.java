// Assignment #: 5 
// Name: Steven Carr 
// StudentID:  
// Lecture: MWF 11:50 
/* Description: This class contains a method which is used to compare what the user
types in against the different types of objects that can be created.*/

import java.io.*; //to use InputStreamReader and BufferedReader 
import java.util.*; //to use ArrayList 

public class StaffMemberParser 
	{ 
		public static StaffMember StringToMember(String lineToParse) 
		{ 
			StaffMember m = null; //creates staffmember object to hold child classes 
			String []info = new String[6]; //string array to hold StringToMember argument 
			info = lineToParse.split("/"); 
			if(info[0].equalsIgnoreCase("Volunteer")) 
				m = new Volunteer(info[1], info[2], info[3]); //creates and adds volunteer object to staffmember object 
			
			if(info[0].equalsIgnoreCase("fulltimeemployee")) 
				m = new FullTimeEmployee(info[1], info[2], info[3], 
										 Double.parseDouble(info[4]), Double.parseDouble(info[5])); //creates and adds fulltimeemployee object to staffmember object 
			
			if(info[0].equalsIgnoreCase("hourlyemployee")) 
				m = new HourlyEmployee(info[1], info[2], info[3], 
									   Double.parseDouble(info[4]), Integer.parseInt(info[5])); //creates and adds hourlyemployee object to staffmember object 
			
			return m; 
		} 
	} 