public class ConcatenateStrings {

    static String concatenateStrings(String[] words) {
        StringBuffer sbf = new StringBuffer();

        for (String word : words) {
            sbf.append(word);
        }

        return sbf.toString();
    }

    public static void main(String[] args) {
        String[] words = {"Hello", " ", "this", " ", "is", " ", "Java"};

        String result = concatenateStrings(words);

        System.out.println("Concatenated string: " + result);
    }
}