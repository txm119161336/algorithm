package com.pinganfu.test.tree.tree234;
import java.io.*;

class Tree234App
{
public static void main(String[] args) throws IOException
   {
   long value;
   Tree234 theTree = new Tree234();

   int[] data = {12,1,9,2/*,0,11,7,19,4,15,18,5,14,13,10,16,6,3,8,17*/};
   
   
   for (int i = 0; i < data.length; i++) {
	   theTree.insert(data[i]);
    }
   
  
  /* theTree.insert(40);
   theTree.insert(60);
   theTree.insert(30);
   theTree.insert(70);*/

   while(true)
      {
      System.out.print("Enter first letter of ");
      System.out.print("show, insert, or find: ");
      char choice = getChar();
      switch(choice)
         {
         case 's':
            theTree.displayTree();
            break;
         case 'i':
            System.out.print("Enter value to insert: ");
            value = getInt();
            theTree.insert(value);
            break;
         case 'f':
            System.out.print("Enter value to find: ");
            value = getInt();
            int found = theTree.find(value);
            if(found != -1)
               System.out.println("Found "+value);
            else
               System.out.println("Could not find "+value);
            break;
         default:
            System.out.print("Invalid entry\n");
         }  // end switch
      }  // end while
   }  // end main()
//--------------------------------------------------------------
public static String getString() throws IOException
   {
   InputStreamReader isr = new InputStreamReader(System.in);
   BufferedReader br = new BufferedReader(isr);
   String s = br.readLine();
   return s;
   }
//--------------------------------------------------------------
public static char getChar() throws IOException
   {
   String s = getString();
   return s.charAt(0);
   }

//-------------------------------------------------------------
public static int getInt() throws IOException
   {
   String s = getString();
   return Integer.parseInt(s);
   }
//-------------------------------------------------------------
}  // end class Tree234App
////////////////////////////////////////////////////////////////