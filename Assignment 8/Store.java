// Assignment #: 8
//         Name: Steve Carr
//    StudentID: 
//  Lab Lecture: MWF 11:50
//  Description: The Store class performs several different tasks depending on what the user enters using the Assignment 8 class.

import java.text.*;
import java.io.*;
import java.lang.*;
import java.util.*;
import java.util.ArrayList;
import java.util.Collections;

public class Store implements Serializable
{
    private ArrayList computerList;
    private ArrayList customerList;

   public Store()
   {
     ArrayList<Customer> computerList = new ArrayList<Customer>();
     ArrayList<Computer> customerList = new ArrayList<Computer>();
   }

   public int customerExists(String a)
   {
      for (int i=0; i<customerList.size(); i++)
      {
          if(((Customer)customerList.get(i)).getCustomerID().equals(a))
          return i;
       }
          return -1;

    }


   public boolean addCustomer(String b)
   {
        Object addC=(Customer)CustomerParser.parseStringToCustomer(b);

        if(customerExists(b)!=-1)
        {
            customerList.add(addC);
            return true;
        }
        else
            return false;

   }

   public boolean removeCustomer(String c)
   {

        if(customerExists(c)==-1)
            return false;
        else
        {
            customerList.remove(customerExists(c));
            return true;
        }
   }

   public void sortCustomers()
   {
        Sorts.sort(customerList);
   }

   public String listCustomers()
   {
        String list="";
        if(customerList.isEmpty())
            list="no customer\n";
        else
        {
            for(int i=0; i<customerList.size(); i++)
                list=list+((Customer)customerList.get(i)).toString();
        }
        return list;
   }

   public int computerExists(String brandName, String cpuType, int cpuSpeed, int memory)
   {

      for (int i=0; i<computerList.size(); i++)
      {
          if((((Computer)computerList.get(i)).getBrandName()).equalsIgnoreCase(brandName) && (((Computer)computerList.get(i)).getCPU()).equals(cpuType) && ((((Computer)computerList.get(i)).getCPU()).getSpeed())==cpuSpeed && ((Computer)computerList.get(i)).getMemory()==memory)
          return i;
      }

   return (-1);
    }

  public boolean addComputer(String c)
   {
        Computer addCm=(Computer)ComputerParser.parseStringToComputer(c);
        String b=addCm.getBrandName();
        String t=(addCm.getCPU()).getType();
        int s=(addCm.getCPU()).getSpeed();
        int m=addCm.getMemory();
        if(computerExists(b, t, s, m)==-1)
        {
            customerList.add(addCm);
            return true;
        }

        return false;

   }

   public boolean removeComputer(String brandName, String cpuType, int cpuSpeed, int memory)
   {
    if(computerExists(brandName,cpuType,cpuSpeed,memory)!=-1)
        return false;

    else
        {
        customerList.remove(computerExists(brandName,cpuType,cpuSpeed,memory));
        return true;
        }
   }

   public void sortComputers()
   {
        Sorts.sort(computerList);
   }

   public String listComputers()
   {
       String list="";
    for(int i=0; i<computerList.size(); i++)
        {
          list=list+(computerList.get(i)).toString();
        }
        return list;
   }

   public void closeStore()
   {
       computerList.clear();
       customerList.clear();
    return ;
   }
}