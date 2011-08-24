// Assignment #: 8
//         Name: Steve Carr
//    StudentID: 
//  Lab Lecture: MWF 11:50
// This file is given by the instructor.
//  Description: The ComputerParser class contains a static
//               method parseStringToPet that takes a string
//               containing a computer's information and
//               create a computer object from it.

public class ComputerParser {

 public static Computer parseStringToComputer(String lineToParse)
  {
     String brandName = new String("?");
     String price = new String("0.00");
     String memory = new String();
     String cpu = new String();
     String cpuType = new String("?");
     String cpuSpeed = new String("0");

     String[] tokens = lineToParse.split(":");

     //create a Computer object using extracted information.
     Computer computer = new Computer();


     //get the brandName
     if (tokens[0].length() > 0)
      {
       brandName = tokens[0].trim();
       computer.setBrandName(brandName);
      }

     //get the cpu
     if (tokens[1].length() > 0)
      {
       cpu = tokens[1].trim();
       String[] tokens2 = cpu.split(",");

       //get the cpu type and speed
       if (tokens2[0].length() > 0)
          cpuType = tokens2[0].trim();
       if (tokens2[1].length() > 0)
          cpuSpeed = tokens2[1].trim();

       computer.setCPU(cpuType, Integer.parseInt(cpuSpeed));
      }

     //get the memory
     if (tokens[2].length() > 0)
      {
       memory = tokens[2].trim();
       computer.setMemory(Integer.parseInt(memory));
      }

     //get the price
     if (tokens[3].length() > 0)
      {
       price = tokens[3].trim();
       computer.setPrice(Double.parseDouble(price));
      }


     return computer;
  } //end of parseStringToComputer

} //end of ComputerParser class


