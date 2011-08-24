// Assignment #: 7
//         Name: Steve Carr
//    StudentID: 
//      Lecture: MWF 11:50
//  Description: creates wholepanel object and displays it within content pane

import javax.swing.*;

public class Assignment7 extends JApplet
{

 public void init()
  {
    // create a WholePanel object and add it to the applet
    WholePanel wholePanel = new WholePanel();
    getContentPane().add(wholePanel);

    //set applet size to 400 X 400
    setSize (400, 400);
  }

}





