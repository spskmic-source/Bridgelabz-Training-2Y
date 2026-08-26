import java.util.Scanner;

public class BMI {

    public static String[][] calculateBMI(double[][] data) {

        String[][] result = new String[10][4];

        for (int i = 0; i < 10; i++) {

            double weight = data[i][0];
            double heightCm = data[i][1];

            double heightMeter = heightCm / 100.0;

            double bmi = weight / (heightMeter * heightMeter);

            String status;

            if (bmi <= 18.4) {
                status = "Underweight";
            }
            else if (bmi <= 24.9) {
                status = "Normal";
            }
            else if (bmi <= 39.9) {
                status = "Overweight";
            }
            else {
                status = "Obese";
            }

            result[i][0] = String.valueOf(heightCm);
            result[i][1] = String.valueOf(weight);
            result[i][2] = String.valueOf(bmi);
            result[i][3] = status;
        }

        return result;
    }

    public static void display(String[][] result) {

        System.out.println("\nHeight\tWeight\tBMI\tStatus");

        for (int i = 0; i < result.length; i++) {
            System.out.println(
                result[i][0] + "\t" +
                result[i][1] + "\t" +
                result[i][2] + "\t" +
                result[i][3]
            );
        }
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        double[][] data = new double[10][2];

        for (int i = 0; i < 10; i++) {

            System.out.print("Enter weight of person " + (i + 1) + " (kg): ");
            data[i][0] = sc.nextDouble();

            System.out.print("Enter height of person " + (i + 1) + " (cm): ");
            data[i][1] = sc.nextDouble();
        }

        String[][] result = calculateBMI(data);

        display(result);

        sc.close();
    }
}