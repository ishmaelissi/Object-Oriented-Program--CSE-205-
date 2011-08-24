// Assignment #: 7
//         Name: Steve Carr
//    StudentID: 
//      Lecture: MWF 11:50
//  Description: this class is used to create the "Undo" button and
//					set the position and color of the letter being
//					entered on the keyboard.

import java.awt.*;
import javax.swing.*;
import java.awt.event.*; // to use listener interfaces
import javax.swing.event.*;
import java.util.ArrayList;

public class WholePanel extends JPanel
{
   private ArrayList letterList;
   private Color currentColor;
   private char currentChar;
   private JPanel topPanel;
   private JButton undo;
   private CanvasPanel canvas;
   private JComboBox list;
   Point p;
   private String [] clist={"black", "red", "blue", "green", "orange"};


   public WholePanel()
    {
      // here we use black to draw a letter
      currentColor = Color.black;

      // set the default character to 'A'
      currentChar = 'A';
      p=null;

      letterList = new ArrayList();
      topPanel=new JPanel();
      list = new JComboBox(clist);      //dropdown box that contains colors
      list.addActionListener(new ComboBoxDemo());   //listener for selecting color
      undo = new JButton("Undo");           
      undo.addActionListener(new ButtonListener()); //adds undo operation to undo button
      topPanel.add(undo);
      topPanel.add(list);


      canvas = new CanvasPanel();

      // make this canvas panel listen to keys
      canvas.addKeyListener (new LetterListener());
      // make this canvas panel listen to mouse
      canvas.addMouseListener(new PointListener());

      canvas.setBackground(Color.white);

      //This method needs to be called for this panel to listen to keys
      //When panel listens to other things, and go back to listen
      //to keys, this method needs to be called again.
      canvas.requestFocus();

      JSplitPane sp = new JSplitPane(JSplitPane.VERTICAL_SPLIT, topPanel, canvas);

      setLayout(new BorderLayout());
      add(sp);

      //to be completed
  }

	private class ComboBoxDemo implements ActionListener
	  {

	    public void actionPerformed(ActionEvent e)
	     {
			 if(list.getSelectedIndex()==0)      //conditions for selecting the color
			 	currentColor=Color.black;
			 else if(list.getSelectedIndex()==1)
			 	currentColor=Color.red;
			 else if(list.getSelectedIndex()==2)
			 	currentColor=Color.blue;
			 else if(list.getSelectedIndex()==3)
			 	currentColor=Color.green;
			 else
			 	currentColor=Color.orange;
		 }

     }

     	private class ButtonListener implements ActionListener
	 	  {

	 	    public void actionPerformed(ActionEvent e)
	 	     {
	 			 if(!letterList.isEmpty())
	 			 {
	 			 	letterList.remove(letterList.size()-1);  //removes the last letter in the array
	 			 	canvas.repaint();
				}
	 		 }

     }

    public class CanvasPanel extends JPanel
     {

       //This method needs to be defined to draw in this panel
       public void paintComponent(Graphics page)
        {
          super.paintComponent(page);

          for(int i=0; i<letterList.size(); i++)
          	((Letter)letterList.get(i)).draw(page);  //paints the letters stored in aray
        }

       // This method was needed to be defined in the panel that
       // listens to keys to enable keyboard focus
       public boolean isFocusable()
        {
           return true;
        }
    } //end of CanvasPanel class

    //LetterListener class received the letter typed by a user
    //when a key is pressed.
    private class LetterListener implements KeyListener
      {

         public void keyReleased(KeyEvent e)
           {
           }

          public void keyTyped(KeyEvent e)
           {
           }

          public void keyPressed(KeyEvent e)
           {
             // get a letter(key) pressed by a user
             currentChar = e.getKeyChar();
			if(p!=null)
			{
				Letter newLetter=new Letter(p.x, p.y, currentChar, currentColor);
				letterList.add(newLetter);          //creates new Letter object and adds it to array
			}
             // call paintComponent method indirectly
             canvas.repaint();
           }

      } // end of Key Listener


    private class PointListener implements MouseListener
     {
                // when a user clicks the panel (applet),
                // KeyListener is focused in it.
         public void mousePressed(MouseEvent event)
          {
              canvas.requestFocus();
              p= event.getPoint();      //gets coordinates of position of mousePressed
          }

         public void mouseReleased(MouseEvent event)
         {
		 }

         public void mouseClicked(MouseEvent event)
         {
		 }

         public void mouseEntered(MouseEvent event)
         {
		 }
         public void mouseExited(MouseEvent event) {}

     } //end of PointListener

} // end of Whole Panel Class
