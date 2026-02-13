package queue.heap.designTwitter;

import java.util.List;

public class TwitterTest {

    public static void main(String[] args) {

        Twitter twitter = new Twitter();

        // User 1 posts tweet 10
        twitter.postTweet(1, 10);

        // User 2 posts tweet 20
        twitter.postTweet(2, 20);

        // News feed for user 1
        System.out.println("User 1 feed: " + twitter.getNewsFeed(1)); // [10]

        // News feed for user 2
        System.out.println("User 2 feed: " + twitter.getNewsFeed(2)); // [20]

        // User 1 follows user 2
        twitter.follow(1, 2);

        System.out.println("User 1 follows 2");

        // Now user 1 should see both tweets
        System.out.println("User 1 feed: " + twitter.getNewsFeed(1)); // [20, 10]

        // User 2 still sees only their own
        System.out.println("User 2 feed: " + twitter.getNewsFeed(2)); // [20]

        // User 1 unfollows user 2
        twitter.unfollow(1, 2);

        System.out.println("User 1 unfollows 2");

        // User 1 should now only see own tweets
        System.out.println("User 1 feed: " + twitter.getNewsFeed(1)); // [10]
    }
}
