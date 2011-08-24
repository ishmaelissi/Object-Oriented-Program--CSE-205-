// Assignment #: 7
//         Name: Steve Carr
//    StudentID: 
//      Lecture: MWF 11:50
//  Description: this class is used to create a letter and store information(position, color)
//					about that letter so in can be drawn.

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import javax.swing.event.*;
import java.util.ArrayList;

public class Letter
{
  private int x;
  private int y;
  private Color color;
  private String testString;
 public Letter( int x, int y, char character, Color color)  //constructor that takes position, color, and character
 	{
		this.x = x;
		this.y = y;
		this.color = color;
		testString = new String(String.valueOf(character));
	}

 public void draw(Graphics page)            //draws letter on screen
 	{

		page.setColor(color);
		page.setFont (new Font ("TimesRoman",Font.PLAIN, 24));
		page.drawString(testString, x, y);
	}

 }
