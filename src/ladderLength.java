public class ladderLength {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        int count = 1;
        Queue<String> que = new LinkedList<>();
        que.add(beginWord);
        boolean[] visited = new boolean[wordList.size()];
        while(!que.isEmpty()) {
            int levelSize = que.size();
            while (levelSize > 0) {
                String curr = que.poll();
                for (int i=0; i<wordList.size(); i++) {
                    if (!visited[i] && isAdjacent(curr, wordList.get(i))) {
                        if (wordList.get(i).contentEquals(endWord)) {
                            return count + 1;
                        }
                        que.add(wordList.get(i));
                        visited[i] = true;
                    }
                }
                levelSize--;
            }
            count++;
        }
        return 0;
    }

    public boolean isAdjacent(String curr, String word) {
        int diff = 0;
        for (int i=0; i<curr.length(); i++) {
            if (curr.charAt(i) != word.charAt(i)) {
                if (diff == 1) return false;
                diff++;
            }
        }
        return true;
    }
}
