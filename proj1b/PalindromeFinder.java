import java.util.HashMap;
import java.util.Arrays;

/** This class outputs all palindromes in the words file in the current directory. */
public class PalindromeFinder {
    public static void main(String[] args) {
        int minLength = 4;
        In in = new In("../library-sp18/data/words.txt");
        Palindrome palindrome = new Palindrome();
        HashMap<Integer, Integer> wordsSum = new HashMap<Integer, Integer>();
        while (!in.isEmpty()) {
            String word = in.readString();
            if (word.length() >= minLength
                    && palindrome.isPalindrome(word, new OffByN(2))) {
                wordsSum.put(2, wordsSum.getOrDefault(2, 0) + 1);
            } else if (word.length() >= minLength
                    && palindrome.isPalindrome(word, new OffByN(3))) {
                wordsSum.put(3, wordsSum.getOrDefault(3, 0) + 1);
            } else if (word.length() >= minLength
                    && palindrome.isPalindrome(word, new OffByN(4))) {
                wordsSum.put(4, wordsSum.getOrDefault(4, 0) + 1);
            } else if (word.length() >= minLength
                    && palindrome.isPalindrome(word, new OffByN(5))) {
                wordsSum.put(5, wordsSum.getOrDefault(5, 0) + 1);
            } else if (word.length() >= minLength
                    && palindrome.isPalindrome(word, new OffByN(6))) {
                wordsSum.put(6, wordsSum.getOrDefault(6, 0) + 1);
            } else if (word.length() >= minLength
                    && palindrome.isPalindrome(word, new OffByN(7))) {
                wordsSum.put(7, wordsSum.getOrDefault(7, 0) + 1);
            } else if (word.length() >= minLength
                    && palindrome.isPalindrome(word, new OffByN(8))) {
                wordsSum.put(8, wordsSum.getOrDefault(8, 0) + 1);
            } else if (word.length() >= minLength
                    && palindrome.isPalindrome(word, new OffByN(9))) {
                wordsSum.put(9, wordsSum.getOrDefault(9, 0) + 1);
            } else if (word.length() >= minLength
                    && palindrome.isPalindrome(word, new OffByN(10))) {
                wordsSum.put(10, wordsSum.getOrDefault(10, 0) + 1);
            }
        }
        System.out.println(Arrays.asList(wordsSum));
    }
}
