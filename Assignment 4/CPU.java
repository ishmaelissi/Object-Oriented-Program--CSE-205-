// Assignment #: 4
// Name: Steven Carr    
// StudentID: 
// Lecture: MWF 11:50
// Description: The CPU class describes cpu of a computer.

public class CPU {
    private String type;
    private int speed;
    
// Constructor -- initializes type and speed

  public CPU() {
    type = "?";
    speed= 0;
    
    }

  // sets the cpu type of the computer  
  public void setType(String type) {
    this.type = type;
    }
  
  //sets the speed of the CPU  
  public void setSpeed(int speed) {
    this.speed=speed;
    }
  
  //returns the type of the computer
  public String getType() {
  return type;
  }
  
  //returns the speed of the CPU
  public int getSpeed() {
  return speed;
  }
 
  //returns the type of CPU and the speed
  public String toString() {
  
  return (type + "," + speed + "HZ");
  }

}
  
