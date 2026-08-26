import java.util.Scanner;

public class EmployeeBonus {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        double[] salary = new double[10];
        double[] years = new double[10];
        double[] bonus = new double[10];
        double[] newSalary = new double[10];

        double totalBonus = 0.0;
        double totalOldSalary = 0.0;
        double totalNewSalary = 0.0;

        int index = 0;

        while (index < 10) {

            System.out.print("Enter salary of employee " + (index + 1) + ": ");
            double sal = sc.nextDouble();

            System.out.print("Enter years of service: ");
            double service = sc.nextDouble();

            if (sal < 0 || service < 0) {
                System.out.println("Invalid input. Please enter again.");
                continue;
            }

            salary[index] = sal;
            years[index] = service;

            index++;
        }

        for (int i = 0; i < 10; i++) {

            if (years[i] > 5) {
                bonus[i] = salary[i] * 0.05;
            }
            else {
                bonus[i] = salary[i] * 0.02;
            }

            newSalary[i] = salary[i] + bonus[i];

            totalBonus = totalBonus + bonus[i];
            totalOldSalary = totalOldSalary + salary[i];
            totalNewSalary = totalNewSalary + newSalary[i];
        }

        System.out.println("\nEmployee Details:");

        for (int i = 0; i < 10; i++) {
            System.out.println("Employee " + (i + 1));
            System.out.println("Old Salary = " + salary[i]);
            System.out.println("Years of Service = " + years[i]);
            System.out.println("Bonus = " + bonus[i]);
            System.out.println("New Salary = " + newSalary[i]);
            System.out.println();
        }

        System.out.println("Total Old Salary = " + totalOldSalary);
        System.out.println("Total Bonus = " + totalBonus);
        System.out.println("Total New Salary = " + totalNewSalary);

        sc.close();
    }
}