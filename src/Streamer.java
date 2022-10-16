import java.util.*;

public class Streamer {
    private List<String> ans;
    public List<String> streamDecode(List<String> list){
        if (list == null || list.size() == 0) return null;

        ans = new ArrayList<>();
        Map<String, Set<String>> categoryMap = new HashMap<>();
        Map<String, Integer> streamerWithViewer = new HashMap<>();

        int idx = 0;
        while (idx < list.size() - 3){
            String command = list.get(idx);
            String streamer = list.get(idx + 1);
            String category;
            int viewers;
            String updatedCategory;
            switch (command){
                case "StreamerOnline":
                    category = list.get(idx + 3);
                    viewers = Integer.parseInt(list.get(idx + 2));
                    streamerWithViewer.put(streamer, viewers);
                    Set<String> curr = categoryMap.getOrDefault(category, new HashSet<>());
                    curr.add(streamer);
                    categoryMap.put(streamer, curr);
                    idx += 4;
                case "UpdateViews":
                    category = list.get(idx + 3);
                    viewers = Integer.parseInt(list.get(idx + 2));
                    if (categoryMap.get(category).contains(streamer)){
                        streamerWithViewer.put(streamer, viewers);
                    }
                    idx += 4;
                case "UpdateCategory":
                    category = list.get(idx + 2);
                    if (categoryMap.get(category).contains(streamer)){
                        updatedCategory = list.get(idx + 3);
                    }
                    idx += 4;
                case "StreamerOffline":
                    category = list.get(idx + 2);
                    if (categoryMap.get(category).contains(streamer)){
                        Set<String> currSet = categoryMap.get(category);
                        currSet.remove(streamer);
                        categoryMap.put(category, currSet);
                    }
                    streamerWithViewer.remove(streamer);
                case "ViewsInCategory":

            }
        }
        return ans;
    }
}
