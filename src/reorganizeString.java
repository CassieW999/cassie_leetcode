import java.util.Comparator;
import java.util.PriorityQueue;

public class reorganizeString {
    public String reorganizeString(String S) {
        if (S.length() <= 1){
            return S;
        }
        int[] counts = new int[26];
        int max = 0;
        int length = S.length();
        for (int i = 0; i < length; i++) {
            char c = S.charAt(i);
            counts[c - 'a']++;
            max = Math.max(max, counts[c - 'a']);
        }
        if (max > (length + 1)/2){
            return "";
        }
        PriorityQueue<Character> queue = new PriorityQueue<Character>(new Comparator<Character>() {
            public int compare(Character letter1, Character letter2) {
                return counts[letter2 - 'a'] - counts[letter1 - 'a'];
            }
        });
        for (char c = 'a'; c <= 'z'; c++) {
            if (counts[c - 'a'] > 0) {
                queue.offer(c);
            }
        }
        StringBuilder sb = new StringBuilder();
        while (queue.size() > 1){
            char letter1 = queue.poll();
            char letter2 = queue.poll();
            sb.append(letter1);
            sb.append(letter2);
            int index1 = letter1 - 'a', index2 = letter2 - 'a';
            counts[index1] --;
            counts[index2] --;
            if (counts[index1] > 0){
                queue.offer(letter1);
            }
            if (counts[index2] > 0){
                queue.offer(letter2);
            }
        }
        if (queue.size() > 0){
            sb.append(queue.poll());
        }
        return sb.toString();
    }

    public static void main(String[] args) {

    }
}
