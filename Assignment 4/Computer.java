// Assignment #: 4
// Name: Steven Carr    
// StudentID: 
// Lecture: MWF 11:50
// Description: The Computer class describes a computer that a customer can buy

import java.io.*;
import java.util.*;
import java.text.NumberFormat;

public class Computer {
    private String brandName;
    private int memory;
    private double price;
    private CPU cpu= new CPU(); 
    
// Constructor -- initializes brandName, memory, price, and CPU    

    public Computer() {
    brandName= "?";
    memory= 0;
    price= 0.0;
    CPU cpu= new CPU(); 
    }
        //sets the brandname of the computer  
     public void setBrandName(String BrandName) {
     brandName= BrandName;
     }
        //sets the cpu type and cpu speed using the methods declared in CPU class
     public void setCPU(String cpuType, int cpuSpeed) {
     cpu.setType(cpuType);
     cpu.setSpeed(cpuSpeed);
     }
        //sets computer memory
     public void setMemory(int memoryAmount) {
     memory= memoryAmount;
     }
        //sets coputer price
     public void setPrice(double price) {
     this.price= price;
     }
        //returns computer brandname
     public String getBrandName() {
     return brandName;
     }
        //returns cpu speed and type
     public CPU getCPU() {
     return cpu;
     }
        //returns computer memory
     public int getMemory() {
     return memory;
     }
        //returns computer price
     public double getPrice() {
     return price;
     }
        //prints selected information about computer
     public String toString() {
     NumberFormat money = NumberFormat.getCurrencyInstance();
     
     return ("\nBrandName:\t"+brandName+"\n"+
              "CPU:\t\t"+cpu+"\n"+
              "Memory:\t\t"+memory+"M\n" +
              "Price:\t\t"+money.format(price)+"\n\n");
    }
    
}
     
    
    

