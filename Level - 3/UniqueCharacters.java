import java.util.Scanner;

public class UniqueCharacters {

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

    public static char[] findUniqueCharacters(String text) {

        int len = findLength(text);

        char[] unique = new char[len];

        int uniqueIndex = 0;

        for (int i = 0; i < len; i++) {

            boolean isUnique = true;

            for (int j = 0; j < len; j++) {

                if (i != j && text.charAt(i) == text.charAt(j)) {
                    isUnique = false;
                    break;
                }
            }

            if (isUnique) {
                unique[uniqueIndex] = text.charAt(i);
                uniqueIndex++;
            }
        }

        char[] result = new char[uniqueIndex];

        for (int i = 0; i < uniqueIndex; i++) {
            result[i] = unique[i];
        }

        return result;
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter a string: ");
        String text = sc.nextLine();

        char[] result = findUniqueCharacters(text);

        System.out.print("Unique characters: ");

        for (int i = 0; i < result.length; i++) {
            System.out.print(result[i] + " ");
        }

        sc.close();
    }
}