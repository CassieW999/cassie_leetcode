import java.util.*;

public class mostVisitedPattern {
    class Log{
        String username;
        int timestamp;
        String website;
        public Log (String username, int timestamp, String website){
            this.username = username;
            this.timestamp = timestamp;
            this.website = website;
        }
    }

    public List<String> mostVisitedPattern(String[] username, int[] timestamp, String[] website) {
        int n = username.length;
        List<Log> logs = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            logs.add(new Log(username[i], timestamp[i], website[i]));
        }
        Collections.sort(logs, new Comparator<Log>() {
            @Override
            public int compare(Log o1, Log o2) {
                return o1.timestamp - o2.timestamp;
            }
        });
        Map<String, List<String>> userPath = new HashMap<>();
        Map<List<String>, Integer> pathUsers = new HashMap<>();
        for (int i = 0; i < n; i++){
            List<String> curPath = userPath.getOrDefault(logs.get(i).username, new ArrayList<>());
            curPath.add(logs.get(i).website);
            userPath.put(logs.get(i).username, curPath);
        }
        int max = 0;
        List<String> maxPattern = new ArrayList<>();
        for(String user : userPath.keySet()){
            List<String> pattern = userPath.get(user);
            HashSet<List<String>> set = new HashSet<>();
            int size = pattern.size();
            for (int i = 0; i < size - 2; i++){
                for (int j = i+1; j < size-1; j++) {
                    for (int k = j+1; k < size; k++) {
                        List<String> threePattern = new ArrayList<>();
                        threePattern.add(pattern.get(i));
                        threePattern.add(pattern.get(j));
                        threePattern.add(pattern.get(k));
                        if (!set.contains(threePattern)){
                            set.add(threePattern);
                            pathUsers.put(threePattern, pathUsers.getOrDefault(threePattern, 0) + 1);
                            if (pathUsers.get(threePattern) > max){
                                max = pathUsers.get(threePattern);
                                maxPattern = new ArrayList<>(threePattern);
                            }else if (pathUsers.get(threePattern) == max){
                                maxPattern = getAlphabeticalPattern(maxPattern, threePattern);
                            }
                        }
                    }
                }
            }
        }
        return maxPattern;
    }

    private List<String> getAlphabeticalPattern(List<String> maxPattern, List<String> threePattern) {
        for (int i = 0; i < 3; i++) {
            String a = maxPattern.get(i);
            String b = threePattern.get(i);
            if (a.compareTo(b) > 0){
                return threePattern;
            }else if (a.compareTo(b) < 0){
                return maxPattern;
            }
        }
        return maxPattern;
    }
}
