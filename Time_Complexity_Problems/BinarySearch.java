import java.util.Scanner;

public class BinarySearch {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int[] arr = {0, 2, 3, 4, 8, 61};

        System.out.print("Enter target value: ");
        int target = sc.nextInt();

        int low = 0;
        int high = arr.length - 1;

        int position = -1;

        while (low <= high) {

            int mid = (low + high) / 2;

            if (arr[mid] == target) {

                position = mid;
                break;

            } else if (arr[mid] < target) {

                low = mid + 1;

            } else {

                high = mid - 1;
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