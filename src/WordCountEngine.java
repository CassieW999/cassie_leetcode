import java.util.*;

public class WordCountEngine {
    static String[][] wordCountEngine(String doc) {
        // your code goes here
        // requirements:
        //  1. sort by  freq
        //  2. if same, keep original order
        //  3. case INsensitive
        doc = doc.replaceAll("[\\pP\\p{Punct}]","");
        Map<String, Integer> wordMap = new HashMap<>();
        String[] wordList = doc.split(" ");

        for (String word : wordList){
            word = word.toLowerCase();
            wordMap.put(word, wordMap.getOrDefault(word, 0) + 1);
        }

        List<String> uniqueWordInSentenceOrder = new ArrayList<>();
        List<String>[] wordFreqList = new List[wordMap.size()];
        String[][] ans = new String[wordMap.size()][2];

        for (int i = 0; i < wordMap.size(); i++){
            wordFreqList[i] = new ArrayList<>();
        }

        for (String word : wordList){
            word = word.toLowerCase();
            if (!uniqueWordInSentenceOrder.contains(word)){
                int freq  = wordMap.get(word);
                List<String> curListForFreq = wordFreqList[freq];
                curListForFreq.add(word);
                wordFreqList[freq] = curListForFreq;
                uniqueWordInSentenceOrder.add(word);
            }
        }

        int count = 0;
        for (int i = wordFreqList.length - 1; i > 0; i--) {
            if (wordFreqList[i].size() != 0){
                for (int j = 0; j < wordFreqList[i].size(); j++){
                    ans[count++] = new String[]{wordFreqList[i].get(j), i + ""};
                }
            }
        }
        return ans;
    }

    public static void main(String[] args) {
//        String doc = "Practice makes perfect. you'll only get Perfect by practice. just practice!";
//        String[][] ans = wordCountEngine(doc);
//        isValid(2, 5, 2, 9);

        String a = "act car";
        String b = "off key dog";

        System.out.println(a.compareTo(b));
    }

    private static boolean isValid(int m, int i, int j, int n){
        int row_start = i / 3 * 3;
        int col_start = j / 3 * 3;
        for (int x = row_start; x < row_start + 3; x++){
            for (int y = col_start; y < col_start + 3; y++){
                System.out.println(x + "," + y);
            }
        }
        return true;
    }
}
