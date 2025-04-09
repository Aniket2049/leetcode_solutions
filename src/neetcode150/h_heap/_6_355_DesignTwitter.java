package neetcode150.h_heap;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Set;

// https://leetcode.com/problems/design-twitter/
// https://www.youtube.com/watch?v=pNichitDD2E
// https://algo.monster/liteproblems/355
public class _6_355_DesignTwitter {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}

class Twitter {
	private Map<Integer, List<Integer>> userTweetListMap;
	private Map<Integer, Set<Integer>> userFollowsMap;
	private Map<Integer, Integer> tweetIdToTimestampMap;
	private int timestamp;

	/** Initialize your data structure for the Twitter class. */
	public Twitter() {
		userTweetListMap = new HashMap<>();
		userFollowsMap = new HashMap<>();
		tweetIdToTimestampMap = new HashMap<>();
		timestamp = 0;
	}

	/**
	 * Compose a new tweet.
	 * @param userId The ID of the user posting the tweet.
	 * @param tweetId The ID of the tweet.
	 */
	public void postTweet(int userId, int tweetId) {
		// Add tweet to the user's list of tweets
		userTweetListMap.computeIfAbsent(userId, k -> new ArrayList<>()).add(tweetId);
		// Map the tweetId to the current timestamp
		tweetIdToTimestampMap.put(tweetId, ++timestamp);
	}

	/**
	 * Retrieve the 10 most recent tweet IDs in the user's news feed. Each item
	 * in the news feed must be posted by users who the user followed or by the
	 * user themself. Tweets must be ordered from most recent to least recent.
	 * @param userId The ID of the user whose news feed is retrieved.
	 * @return A list of tweet IDs in the news feed.
	 */
	public List<Integer> getNewsFeed(int userId) {
		// Get the set of all users the given user is following
		Set<Integer> following = userFollowsMap.getOrDefault(userId, new HashSet<>());
		// Include the user's own ID to include their tweets as well
		following.add(userId);

		// Priority Queue to store tweets by recency
		PriorityQueue<Integer> minHeap = new PriorityQueue<>(
				(tweetId1, tweetId2) -> tweetIdToTimestampMap.get(tweetId2) - tweetIdToTimestampMap.get(tweetId1));

		// Collect the tweets from each user's tweet list, but restrict to the 10 most recent tweets per user
		for (Integer user : following) {
			List<Integer> tweets = userTweetListMap.get(user);
			if (tweets != null) {
				int tweetCount = tweets.size();
				for (int i = tweetCount - 1, tweetLimit = 10; i >= 0 && tweetLimit > 0; --i, --tweetLimit) {
					minHeap.offer(tweets.get(i));
				}
			}
		}

		// Retrieve the 10 most recent tweets for the news feed
		List<Integer> feed = new ArrayList<>();
		int feedSize = 10;
		while (!minHeap.isEmpty() && feed.size() < feedSize) {
			feed.add(minHeap.poll());
		}

		return feed;
	}

	/**
	 * Follower follows a followee. If the operation is invalid (i.e., already following), it should be a no-op.
	 * @param followerId The ID of the follower.
	 * @param followeeId The ID of the followee.
	 */
	public void follow(int followerId, int followeeId) {
		userFollowsMap.computeIfAbsent(followerId, k -> new HashSet<>()).add(followeeId);
	}

	/**
	 * Follower unfollows a followee. If the operation is invalid (i.e., not following), it should be a no-op.
	 * @param followerId The ID of the follower.
	 * @param followeeId The ID of the followee.
	 */
	public void unfollow(int followerId, int followeeId) {
		if (userFollowsMap.containsKey(followerId)) {
			userFollowsMap.get(followerId).remove(followeeId);
		}
	}
}