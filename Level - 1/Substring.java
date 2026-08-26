import java.util.Scanner;

public class Substring {

    public static String createSubstring(String text, int start, int end) {

        String result = "";

        for (int i = start; i < end; i++) {
            result = result + text.charAt(i);
        }

        return result;
    }

    public static boolean compareStrings(String str1, String str2) {

        int length1 = 0;
        int length2 = 0;

        try {
            while (true) {
                str1.charAt(length1);
                length1++;
            }
        }
        catch (StringIndexOutOfBoundsException e) {
        }

        try {
            while (true) {
                str2.charAt(length2);
                length2++;
            }
        }
        catch (StringIndexOutOfBoundsException e) {
        }

        if (length1 != length2) {
            return false;
        }

        for (int i = 0; i < length1; i++) {

            if (str1.charAt(i) != str2.charAt(i)) {
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter a string: ");
        String text = sc.next();

        System.out.print("Enter start index: ");
        int start = sc.nextInt();

        System.out.print("Enter end index: ");
        int end = sc.nextInt();

        String userSubstring =
                createSubstring(text, start, end);

        String builtInSubstring =
                text.substring(start, end);

        System.out.println("\nSubstring using charAt(): "
                + userSubstring);

        System.out.println("Substring using substring(): "
                + builtInSubstring);

        System.out.println("Both are same: "
                + compareStrings(userSubstring, builtInSubstring));

        sc.close();
    }
}