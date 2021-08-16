import java.util.*;

public class Twitter {
    public Map<Integer, List<Integer>> followList;
    public LinkedList<int[]> messages;

    /** Initialize your data structure here. */
    public Twitter() {
        followList = new HashMap<>();
        messages = new LinkedList<>();
    }

    /** Compose a new tweet. */
    public void postTweet(int userId, int tweetId) {
        messages.addFirst(new int[]{userId, tweetId});
    }

    /** Retrieve the 10 most recent tweet ids in the user's news feed. Each item in the news feed must be posted by users who the user followed or by the user herself. Tweets must be ordered from most recent to least recent. */
    public List<Integer> getNewsFeed(int userId) {
        List<Integer> news = new ArrayList<>();
        List<Integer> follows = followList.get(userId);
        for (int i = 0; i < messages.size(); i++) {
            int postUser = messages.get(i)[0];
            if (postUser == userId || follows.contains(postUser)){
                news.add(messages.get(i)[1]);
            }
            if (news.size() == 10){
                return news;
            }
        }
        return news;
    }

    /** Follower follows a followee. If the operation is invalid, it should be a no-op. */
    public void follow(int followerId, int followeeId) {
        List<Integer> curList = followList.getOrDefault(followerId, new ArrayList<>());
        curList.add(followeeId);
        followList.put(followerId, curList);
    }

    /** Follower unfollows a followee. If the operation is invalid, it should be a no-op. */
    public void unfollow(int followerId, int followeeId) {
        List<Integer> curList = followList.getOrDefault(followerId, new ArrayList<>());
        if (curList.contains(followeeId)){
            for (int i = 0; i < curList.size(); i++){
                if (curList.get(i) == followeeId){
                    curList.remove(i);
                }
            }
        }
        followList.put(followerId, curList);
    }
}
