import java.util.Scanner;

public class ArrayInput {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        double[] numbers = new double[10];

        double total = 0.0;
        int index = 0;

        while (true) {

            if (index == 10) {
                break;
            }

            System.out.print("Enter a positive number: ");
            double num = sc.nextDouble();

            if (num <= 0) {
                break;
            }

            // Store number in array
            numbers[index] = num;

            // Move to next index
            index++;
        }

        System.out.println("\nNumbers entered:");

        for (int i = 0; i < index; i++) {
            System.out.println(numbers[i]);
            total = total + numbers[i];
        }

        System.out.println("Sum of all numbers = " + total);

        sc.close();
    }
}