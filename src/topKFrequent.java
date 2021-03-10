import java.util.*;

public class topKFrequent {
    public List<String> topKFrequent(String[] words, int k) {
        Map<String, Integer> map = new HashMap<>();
        for (String word : words){
            map.put(word, map.getOrDefault(word, 0) + 1);
        }
        List<String> list = new ArrayList<>(map.keySet());
        list.sort((w1, w2) -> map.get(w1).equals(map.get(w2)) ? w1.compareTo(w2) : map.get(w2) - map.get(w1));
        return list.subList(0, k);
    }


    public static void main(String[] args) {
        List<String> list = Arrays.asList("1", "3", "4", "2", "5");
        list.sort((w1, w2) -> w1.compareTo(w2));

        List<Integer> list2 = Arrays.asList(1, 3, 4, 2, 5);
        list2.sort((w1, w2) -> w1 - w2);

        System.out.println(list2);
    }


}
