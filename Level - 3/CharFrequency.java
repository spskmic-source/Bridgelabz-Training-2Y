import java.util.Scanner;

public class CharFrequency {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter a string: ");
        String text = sc.nextLine();

        int[] freq = new int[256]; // 256 ASCII characters

        for (int i = 0; i < text.length(); i++) {
            char ch = text.charAt(i);
            freq[ch]++;
        }

        char[][] result = new char[text.length()][2];
        int count = 0;

        boolean[] visited = new boolean[256];
        for (int i = 0; i < text.length(); i++) {
            char ch = text.charAt(i);
            if (!visited[ch]) {
                result[count][0] = ch;
                result[count][1] = (char) (freq[ch] + '0');
                count++;
                visited[ch] = true;
            }
        }

        System.out.println("Character\tFrequency");
        for (int i = 0; i < count; i++) {
            char ch = result[i][0];
            int frequency = freq[ch];
            System.out.println(ch + "\t\t" + frequency);
        }

        sc.close();
    }
}