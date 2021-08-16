import java.util.*;

public class wordLadder {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        if (!wordList.contains(endWord)) return 0;
        wordList.add(beginWord);
        Map<String, List<String>> neighbours = new HashMap<>();
        for (int i = 0; i < wordList.size(); i++){
            String cur = wordList.get(i);
            for (int j = i + 1; j < wordList.size(); j++){
                String second = wordList.get(j);
                if (related(cur, second)){
                    List<String> resA = neighbours.getOrDefault(cur, new ArrayList<>());
                    resA.add(second);
                    List<String> resB = neighbours.getOrDefault(second, new ArrayList<>());
                    resA.add(cur);
                    neighbours.put(cur, resA);
                    neighbours.put(second, resB);
                }
            }
        }
        Queue<String> q = new LinkedList<>();
        Set<String> visited = new HashSet<>();
        int step = 0;
        q.offer(beginWord);
        visited.add(beginWord);
        while (!q.isEmpty()){
            int size = q.size();
            for (int i = 0; i < size; i++){
                String cur = q.poll();
                if (cur.equals(endWord)) return step;
                if (neighbours.get(cur) == null) continue;
                for (String s : neighbours.get(cur)){
                    if (!visited.contains(s)){
                        q.offer(s);
                        visited.add(s);
                    }
                }
            }
            step++;
        }
        return 0;
    }

    public boolean related(String a, String b){
        int count = 0;
        for (int i = 0; i < a.length(); i++){
            if (a.charAt(i) != b.charAt(i)) count++;
        }
        return count == 1;
    }
}
