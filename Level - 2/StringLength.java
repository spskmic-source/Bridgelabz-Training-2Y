import java.util.Scanner;

public class StringLength {

    public static int findLength(String text) {

        int count = 0;

        try {

            while (true) {
                text.charAt(count);
                count++;
            }

        }
        catch (StringIndexOutOfBoundsException e) {
            return count;
        }
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter a string: ");
        String text = sc.nextLine();

        int userLength = findLength(text);

        System.out.println("Length using user-defined method = " + userLength);

        // Built-in method
        System.out.println("Length using length() = " + text.length());

        sc.close();
    }
}