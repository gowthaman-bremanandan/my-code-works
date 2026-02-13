package queue.heap.designTwitter;

import java.util.*;

public class Twitter {

    private static int timestamp = 0;

    private static class Tweet {
        int id;
        int time;
        Tweet next;

        Tweet(int id) {
            this.id = id;
            this.time = timestamp++;
        }
    }

    private Map<Integer, Set<Integer>> followMap;
    private Map<Integer, Tweet> tweetMap;

    public Twitter() {
        followMap = new HashMap<>();
        tweetMap = new HashMap<>();
    }

    public void postTweet(int userId, int tweetId) {

        Tweet newTweet = new Tweet(tweetId);

        newTweet.next = tweetMap.get(userId);
        tweetMap.put(userId, newTweet);
    }

    public List<Integer> getNewsFeed(int userId) {

        List<Integer> result = new ArrayList<>();

        PriorityQueue<Tweet> maxHeap = new PriorityQueue<>(
                (a, b) -> b.time - a.time
        );

        // Add user's own tweets
        if (tweetMap.containsKey(userId)) {
            maxHeap.offer(tweetMap.get(userId));
        }

        // Add followed users' tweets
        Set<Integer> followees = followMap.getOrDefault(userId, new HashSet<>());

        for (int followee : followees) {
            if (tweetMap.containsKey(followee)) {
                maxHeap.offer(tweetMap.get(followee));
            }
        }

        // Extract top 10 tweets
        while (!maxHeap.isEmpty() && result.size() < 10) {

            Tweet tweet = maxHeap.poll();
            result.add(tweet.id);

            if (tweet.next != null) {
                maxHeap.offer(tweet.next);
            }
        }

        return result;
    }

    public void follow(int followerId, int followeeId) {

        if (followerId == followeeId) return;

        followMap
                .computeIfAbsent(followerId, k -> new HashSet<>())
                .add(followeeId);
    }

    public void unfollow(int followerId, int followeeId) {

        if (followMap.containsKey(followerId)) {
            followMap.get(followerId).remove(followeeId);
        }
    }
}
