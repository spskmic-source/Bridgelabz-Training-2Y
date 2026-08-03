import java.util.Scanner;
public class AverageOfThreeNumbers {
	public static void main(String[] args) {
	    Scanner sc = new Scanner(System.in);
	    
	System.out.print("Enter 1st no : ");
	double num1 = sc.nextDouble();
	
	System.out.print("Enter 2nd no : ");
	double num2 = sc.nextDouble();
	
	System.out.print("Enter 3nd no : ");
	double num3 = sc.nextDouble();
	
	double average = (num1 + num2 + num3) / 3;
	
	System.out.print("Average = " + average);
	
	sc.close();
	}
}