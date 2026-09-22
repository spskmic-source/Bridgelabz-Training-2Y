import java.util.Scanner;

public class LinearSearch {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int[] arr = {8, 61, 2, 3, 4, 0};

        System.out.print("Enter target value: ");
        int target = sc.nextInt();

        int position = -1;

        for (int i = 0; i < arr.length; i++) {

            if (arr[i] == target) {
                position = i;
                break;
            }
        }

        if (position != -1) {
            System.out.println("Element found at index: " + position);
        } else {
            System.out.println("Element not found");
        }

        sc.close();
    }
}