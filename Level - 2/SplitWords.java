import java.util.Scanner;

public class SplitWords {

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

    public static String[] splitWords(String text) {

        int len = findLength(text);

        int wordCount = 1;

        for (int i = 0; i < len; i++) {
            if (text.charAt(i) == ' ') {
                wordCount++;
            }
        }

        int[] spaces = new int[wordCount - 1];

        int spaceIndex = 0;

        for (int i = 0; i < len; i++) {
            if (text.charAt(i) == ' ') {
                spaces[spaceIndex] = i;
                spaceIndex++;
            }
        }

        String[] words = new String[wordCount];

        int start = 0;
        int wordIndex = 0;

        for (int i = 0; i < spaces.length; i++) {

            int end = spaces[i];

            String word = "";

            for (int j = start; j < end; j++) {
                word = word + text.charAt(j);
            }

            words[wordIndex] = word;
            wordIndex++;

            start = end + 1;
        }

        String word = "";

        for (int i = start; i < len; i++) {
            word = word + text.charAt(i);
        }

        words[wordIndex] = word;

        return words;
    }

    public static boolean compare(String[] a, String[] b) {

        if (a.length != b.length) {
            return false;
        }

        for (int i = 0; i < a.length; i++) {

            if (!a[i].equals(b[i])) {
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter a sentence: ");
        String text = sc.nextLine();

        String[] userWords = splitWords(text);

        String[] builtInWords = text.split(" ");

        System.out.println("\nWords using user-defined method:");

        for (int i = 0; i < userWords.length; i++) {
            System.out.println(userWords[i]);
        }

        System.out.println("\nWords using split():");

        for (int i = 0; i < builtInWords.length; i++) {
            System.out.println(builtInWords[i]);
        }

        System.out.println("\nBoth results are same: "
                + compare(userWords, builtInWords));

        sc.close();
    }
}