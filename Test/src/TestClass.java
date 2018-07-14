import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;

public class TestClass {

	public static void main(String[] args) throws IOException {
		System.out.print(harmonicRecursive(4));
	}
	
	public static double harmonicRecursive(double x) {
		System.out.println("Method call -- " +
                "calculating " +
                "Factorial of: " + x);
		   if(x==1) {
			   return 1;
		   }else {
			   return (1/x) * (harmonicRecursive(x-1));
		   }
	   }
}
