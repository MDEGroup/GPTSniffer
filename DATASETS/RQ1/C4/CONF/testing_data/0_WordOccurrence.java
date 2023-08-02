public class Occurrence {
    public static int count(String word, String sentence) {
        int count = 0;
        int index = 0;
        while (index >= 0) {
            index = sentence.indexOf(word, index);
            if (index >= 0) {
                count++;
                index++;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        String sentence = "This is a test. This is a TEST.";
        String word = "is";
        int count = count(word, sentence);
        System.out.println("The word " + word + " appears " + count + " times in the sentence.");
    }
}

