package exceptionHandling;

public class Main {
	  public static void main(String[ ] args) {
//	    int[] myNumbers = {1, 2, 3};
//	    System.out.println(myNumbers[10]);
	    
	    // error!
	    //output:- ArrayIndexOutOfBoundsException
	    //Note: ArrayIndexOutOfBoundsException occurs when you try to
	    //access an index number that does not exist.
	    
	    try {
	        int[] myNumbers = {1, 2, 3};
	        System.out.println(myNumbers[10]);
	      } catch (Exception e) {
	        System.out.println("Something went wrong.");
	      }
	    
	    
	    try {
	        int[] myNumbers = {1, 2, 3};
	        System.out.println(myNumbers[10]);
	      } catch (Exception e) {
	        System.out.println("Something went wrong.");
	      } finally {
	        System.out.println("The 'try catch' is finished.");
	      }
	    }
	  
	  
	  }
	
