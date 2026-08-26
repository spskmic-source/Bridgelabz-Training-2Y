import java.util.Scanner;

public class CompareStrings {

    public static boolean compareUsingCharAt(String str1, String str2) {

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

        System.out.print("Enter first string: ");
        String str1 = sc.next();

        System.out.print("Enter second string: ");
        String str2 = sc.next();

        boolean userResult = compareUsingCharAt(str1, str2);

        boolean builtInResult = str1.equals(str2);

        System.out.println("\nResult using charAt(): " + userResult);

        System.out.println("Result using equals(): " + builtInResult);

        System.out.println("Both results are same: "
                + (userResult == builtInResult));

        sc.close();
    }
}