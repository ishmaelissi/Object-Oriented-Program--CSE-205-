// Assignment #: 10
// Name: Steve Carr
// StudentID: 
// Lab Lecture: MWF 11:50
// Description: The LinkList class provides several different methods
//	that will be used in Assignment 10 class
//  Class Discr: This class defines the pointer like LinkListInterator and also some methods
//               for realizing the use of the data storing structure LinkedList to common
//               methods.

import java.util.NoSuchElementException;

public class LinkedList
{
   //nested class to represent a node
   private class Node
   {
          public Object data;
          public Node next;
   }

   //only instance variable that points to the first node.
   private Node first;

   // Constructs an empty linked list.
   public LinkedList()
   {
      first = null;
   }


   // Returns the first element in the linked list.
   public Object getFirst()
   {
      if (first == null)
       {
         NoSuchElementException ex
             = new NoSuchElementException();
         throw ex;
       }
      else
         return first.data;
   }

   // Removes the first element in the linked list.
   public Object removeFirst()
   {
      if (first == null)
       {
         NoSuchElementException ex
             = new NoSuchElementException();
         throw ex;
       }
      else
       {
         Object element = first.data;
         first = first.next;  
         return element;
       }
   }

   // Adds an element to the front of the linked list.
   public void addFirst(Object element)
   {
      //create a new node
      Node newNode = new Node();
      newNode.data = element;
      newNode.next = first;
      first = newNode;
   }

   // Returns an iterator for iterating through this list.
   public ListIterator listIterator()
   {
      return new LinkedListIterator();
   }


   //prints the data in the list
   public String toString()
   {
	   LinkedListIterator iterator = new LinkedListIterator();
	   String result = "{ ";
	   while(iterator.hasNext())
		   result += (iterator.next()+" ");
	   result += "}\n";
	   return result;
   }

   // Return the size of the list.
   public int size()
   {
	   LinkedListIterator iterator = new LinkedListIterator();
	   int a = 0;
	   while(iterator.hasNext())
	   {
		   iterator.next();
		   a++;
	   }
	   return a;
   }

   // Return a boolean if the list is empty or not.
   public boolean isEmpty()
   {
	   LinkedListIterator it = new LinkedListIterator();

	   if(!it.hasNext())
		   return true;
	   else
		   return false;
   }

   // Return the data at given index
   public Object getElement(int index)
   {
	   LinkedListIterator it = new LinkedListIterator();

	   for(int i = 0; i<index; i++)
		   {it.next();}
	   return it.next();
   }

   public void addElement(int index, Object obj)
   {
	   if(index < 0)
		   {IndexOutOfBoundsException ex = new IndexOutOfBoundsException();
			throw ex;}

	   LinkedListIterator iterator = new LinkedListIterator();

	   for(int i = 0; i<index; i++)
	   {
		   if(iterator.hasNext())
		      iterator.next();
		   else
		{
		NoSuchElementException ex = new NoSuchElementException();
         	throw ex;
		}
	   }

	   if(iterator.hasNext())
	   {
	      Object a = iterator.next();
	      iterator.set(obj);
	      while(iterator.hasNext())
	      {
		      Object b = iterator.next();
		      iterator.set(a);
		      a = b;
	      }
	      iterator.add(a);
	   }
	   else
		   iterator.add(obj);
   }

   // Remove the node at the given index, the following nodes should replace the empty space.
   public Object removeElement(int index)
   {
	   if(index<0)
		   {NoSuchElementException ex = new NoSuchElementException();
         throw ex;}

	   if(index>size()-1)
		{NoSuchElementException ex = new NoSuchElementException();
         throw ex;}

	   Object result = null;

	  LinkedListIterator it = new LinkedListIterator();
	   result = getElement(index);
	   if(index<size()-1)
	   {
		   for(int i = 0; i<index+1; i++)
			   it.next();
		   while(index<size()-2)
		   {
			   it.set(getElement(index+1));
			   it.next();
			   index++;
		   }
		   it.remove();
	   }
	   else
	   {
		   for(int i = 0; i<index+1; i++)
			   it.next();
		   it.remove();
	   }

	  return result;
   }

   // Reverse the order
   public void reverse()
   {
	   LinkedListIterator it = new LinkedListIterator();
	   if(!isEmpty() && size()>1)
	   {
		   int top = size()-1;
		   int bot = 0;
		   it.next();
		   do
		   {
			   LinkedListIterator ti = new LinkedListIterator();

		       Object  one= getElement(bot);
		       Object  two= getElement(top);
			   it.set(two);
		       it.next();
		       for(int i = 0; i<top+1; i++)
				   ti.next();
		       ti.set(one);
		       bot++;
		       top--;
		    }while(top>(size()/2)-1);
	   }

   }


   public void removeDuplicate()
   {

	   if(size()>1)
	   {
		   int b = 0;
		   do
		   {
			  for(int i = 1+b; i<size(); i++)
				  if(getElement(b).equals(getElement(i)))
					  {
					  removeElement(i);
					  i--;
					  }
			  b++;

		   }while(b<size());
	   }
   }

   //nested class to define its iterator
   private class LinkedListIterator implements ListIterator
   {
      private Node position; //current position
      private Node previous; //it is used for remove() method

      // Constructs an iterator that points to the front
      // of the linked list.

      public LinkedListIterator()
      {
         position = null;
         previous = null;
      }

     // Tests if there is an element after the iterator position.
     public boolean hasNext()
      {
         if (position == null) //not traversed yet
          {
             if (first != null)
                return true;
             else
                return false;
          }
         else
           {
              if (position.next != null)
                 return true;
              else
                 return false;
           }
      }

      // Moves the iterator past the next element, and returns
      // the traversed element's data.
      public Object next()
      {
         if (!hasNext())
          {
           NoSuchElementException ex = new NoSuchElementException();
           throw ex;
          }
         else
          {
            previous = position; // Remember for remove

            if (position == null)
               position = first;
            else
               position = position.next;

            return position.data;
          }
      }

      // Adds an element before the iterator position
      // and moves the iterator past the inserted element.
      public void add(Object element)
      {
         if (position == null) //never traversed yet
         {
            addFirst(element);
            position = first;
         }
         else
         {
            //making a new node to add
            Node newNode = new Node();
            newNode.data = element;
            newNode.next = position.next;
            //change the link to insert the new node
            position.next = newNode;
            //move the position forward to the new node
            position = newNode;
         }
         //this means that we cannot call remove() right after add()
         previous = position;
      }

      // Removes the last traversed element. This method may
      // only be called after a call to the next() method.
      public void remove()
      {
         if (previous == position)  //not after next() is called
          {
            IllegalStateException ex = new IllegalStateException();
            throw ex;
          }
         else
          {
           if (position == first)
            {
              removeFirst();
            }
           else
            {
              previous.next = position.next; //removing
            }
           //stepping back
           //this also means that remove() cannot be called twice in a row.
           position = previous;
      }
      }

      // Sets the last traversed element to a different value.
      public void set(Object element)
      {
         if (position == null)
          {
            NoSuchElementException ex = new NoSuchElementException();
            throw ex;
          }
         else
          position.data = element;
      }
   } //end of LinkedListIterator class
} //end of LinkedList class