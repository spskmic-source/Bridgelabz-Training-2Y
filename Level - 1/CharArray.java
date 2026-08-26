import java.util.Scanner;

public class CharArray {

    public static char[] getCharacters(String text) {

        int length = 0;

        try {
            while (true) {
                text.charAt(length);
                length++;
            }
        }
        catch (StringIndexOutOfBoundsException e) {
        }

        char[] result = new char[length];

        for (int i = 0; i < length; i++) {
            result[i] = text.charAt(i);
        }

        return result;
    }

    public static boolean compareArrays(char[] a, char[] b) {

        if (a.length != b.length) {
            return false;
        }

        for (int i = 0; i < a.length; i++) {

            if (a[i] != b[i]) {
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter a string: ");
        String text = sc.next();

        char[] userArray = getCharacters(text);

        char[] builtInArray = text.toCharArray();

        System.out.print("\nCharacters using user-defined method: ");

        for (int i = 0; i < userArray.length; i++) {
            System.out.print(userArray[i] + " ");
        }

        System.out.print("\nCharacters using toCharArray(): ");

        for (int i = 0; i < builtInArray.length; i++) {
            System.out.print(builtInArray[i] + " ");
        }

        System.out.println("\n\nBoth arrays are same: "
                + compareArrays(userArray, builtInArray));

        sc.close();
    }
}