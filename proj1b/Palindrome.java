/**
 * Created by YukiTang on $(DATE).
 */
public class Palindrome {
    public Deque<Character> wordToDeque(String word) {
        Deque deque = new LinkedListDeque();
        for(int i = 0; i < word.length(); i++) {
            deque.addLast(word.charAt(i));
        }
        return deque;
    }

    public boolean isPalindrome(String word) {
        Deque wordDeque =  wordToDeque(word);
        while (wordDeque.size() > 1) {
            if (wordDeque.removeFirst() != wordDeque.removeLast()) {
                return false;
            }
        }
        return true;
    }

    public boolean isPalindrome(String word, CharacterComparator cc) {
        Deque wordDeque =  wordToDeque(word);
        while (wordDeque.size() > 1) {
            if(!cc.equalChars((char)wordDeque.removeFirst(), (char)wordDeque.removeLast())) {
                return false;
            }
        }
        return true;
    }
}
