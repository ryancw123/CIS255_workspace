import java.util.Scanner;

/**
   This program calculates the geometric and
   harmonic progression for a number entered
   by the user.
*/

public class Progression
{
   public static void main(String[] args)
   {
      Scanner keyboard = new Scanner (System.in);

      System.out.println("This program will calculate " +
                         "the geometric and harmonic " +
                         "progression for the number " +
                         "you enter.");
                         
      System.out.print("Enter an integer that is " +
                       "greater than or equal to 1: ");
                       
      int input = keyboard.nextInt();

      // Match the method calls with the methods you write
      int geomAnswer = geometricRecursive(input);
      double harmAnswer = harmonicRecursive(input);

      System.out.println("Using recursion:");
      
      System.out.println("The geometric progression of " +
                         input + " is " + geomAnswer);
                         
      System.out.println("The harmonic progression of " +
                         input + " is " + harmAnswer);

      // Match the method calls with the methods you write
      geomAnswer = geometricIterative(input);
      harmAnswer = harmonicIterative(input);

      System.out.println("Using iteration:");
      System.out.println("The geometric progression of " +
                         input + " is " + geomAnswer);
                         
      System.out.println("The harmonic progression of " +
                         input + " is " + harmAnswer);
   }

   // ADD LINES FOR TASK #2 HERE
   // Write the geometricRecursive method
   /*
    * This method geometric recursive calls on itself
    * causing a loop. It performs the same mathematic algorithm 
    * to every call. The break condition is when the parameter is 
    * equal to one.
    */
   public static int geometricRecursive(int x) {
	   int result;
	   if(x==0 || x ==1) {
		   return 1;
	   }else {
		   result=geometricRecursive(x-1)*x;
	   }
	   return result;
   }
   
   // Write the geometricIterative method
   /*
    * performs the same action but uses a loop instead of
    * calling itself.
    */
   public static int geometricIterative(int x) {
	   int result=1;
	   if(x==1) {
		   return result;
	   }else {
		   for(int i=1; i<=x; i++) {
			   result*=i;
		   }
	   }
	   return result;
   }
   
   // Write the harmonicRecursive method
   /*
    * Uses recursion to find the harmonic proggression 
    */
   public static double harmonicRecursive(double x) {
	   if(x==1) {
		   return 1;
	   }else {
		   return (1/x) * (harmonicRecursive(x-1));//algorithm for finding the harmonic progression
	   }
   }
   
   // Write the harmonicIterative method
   
   //uses a for loop to find the harmonic progression
   public static double harmonicIterative(double x) {
	   double result=1;
	   double temp;
	   if(x==1) {
		   return result;
	   }else {
		   for(int i=1; i<=x; i++) {
			   temp=i;
			   result*=(1/temp);
		   }
	   }
	   return result;
   }
}