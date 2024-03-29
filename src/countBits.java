import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class countBits {
    public int[] countBits(int num) {
        int[] ans = new int[num + 1];
        for (int i = 0; i <= num; i++){
            int curr = 0;
            String binaryStr = Integer.toBinaryString(i);
            for (char a : binaryStr.toCharArray()){
                if (a == '1')
                    curr++;
            }
            ans[i] = curr;
        }
        return ans;
    }

    public static void main(String[] args) {
        String doc = "Practice makes perfect. you'll only get Perfect by practice. just practice!";
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
        System.out.println(ans);
    }
}
