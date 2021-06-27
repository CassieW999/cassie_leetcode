import java.util.*;

public class openLock {
    public int openLock(String[] deadends, String target) {
        String start = "0000";
        Queue<String> q = new LinkedList<>();
        Set<String> visited = new HashSet<>();
        List<String> deadendsList = Arrays.asList(deadends);
        int pathCount = 0;
        q.offer(start);
        visited.add(start);
        while (!q.isEmpty()){
            int size = q.size();
            for (int i = 0; i < size; i++){
                String cur = q.poll();
                if (cur.equals(target)){
                    return pathCount;
                }
                for (int j = 0; j < 4; j++){
                    String up = turnup(cur, j);
                    String down = turndown(cur, j);
                    if (!deadendsList.contains(up) && !visited.contains(up)){
                        q.offer(up);
                        visited.add(up);
                    }
                    if (!deadendsList.contains(down) && !visited.contains(down)){
                        q.offer(down);
                        visited.add(down);
                    }
                }
            }
        }
        return -1;
    }

    private String turnup(String cur, int index) {
        StringBuilder sb = new StringBuilder(cur);
        if (sb.charAt(index) == '9'){
            sb.setCharAt(index, '0');
        }else{
            char newChar = (char) (sb.charAt(index) + 1);
            sb.setCharAt(index, newChar);
        }
        return sb.toString();
    }

    private String turndown(String cur, int index) {
        StringBuilder sb = new StringBuilder(cur);
        if (sb.charAt(index) == '0'){
            sb.setCharAt(index, '9');
        }else{
            char newChar = (char) (sb.charAt(index) - 1);
            sb.setCharAt(index, newChar);
        }
        return sb.toString();
    }

}
