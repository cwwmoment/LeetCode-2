/**
 * Created on 11 Nov 2018 by happygirlzt
 *
 * LeetCode #355. Design Twitter
 *
 */

class WrongTwitter {
    private HashMap<Integer, LinkedList<Integer>> users;
    private HashMap<Integer, HashSet<Integer>> follow;

    /** Initialize your data structure here. */
    public Twitter() {
        users = new HashMap<>();
        follow = new HashMap<>();
    }

    /** Compose a new tweet. */
    public void postTweet(int userId, int tweetId) {
        if (!users.containsKey(userId)) {
            LinkedList<Integer> ts = new LinkedList<>();
            ts.add(tweetId);
            users.put(userId, ts);
        } else {
            LinkedList<Integer> ts = users.get(userId);
            ts.addFirst(tweetId);
            users.put(userId, ts);
        }
    }

    /** Retrieve the 10 most recent tweet ids in the user's news feed. Each item in the news feed must be posted by users who the user followed or by the user herself. Tweets must be ordered from most recent to least recent. */
    public List<Integer> getNewsFeed(int userId) {
        if (!users.containsKey(userId) && !follow.containsKey(userId)) return new ArrayList<>();

        // have no followers
        if (!follow.containsKey(userId)) {
            // if his tweets > 10
            if (users.get(userId).size() > 10) {
                return users.get(userId).subList(0, 10);
            } else {
                return users.get(userId);
            }
        } else {
            LinkedList<Integer> tweets = new LinkedList<>();
            HashSet<Integer> set = follow.get(userId);
            set.add(userId);
            // System.out.println(set);
            for (Integer i : set) {
                LinkedList<Integer> tmp = users.get(i);
                if (tmp == null) continue;
                int count = 0;
                for (Integer t : tmp) {
                    // for (int j = 0; j < 10 && j < tmp.size(); j++) {
                    if (count < 10 && count < tmp.size()) {
                        tweets.add(tmp.get(count));
                        count++;
                    } else {
                        break;
                    }
                }
            }

            Collections.sort(tweets, Collections.reverseOrder());
            if (tweets.size() > 10) {
                return tweets.subList(0, 10);
            } else {
                return tweets;
            }
        }
    }

    /** Follower follows a followee. If the operation is invalid, it should be a no-op. */
    public void follow(int followerId, int followeeId) {
        if (!follow.containsKey(followerId)) {
            HashSet<Integer> uf = new HashSet<>();
            uf.add(followeeId);
            follow.put(followerId, uf);
            return;
        }

        if (!follow.get(followerId).contains(followeeId)) {
            HashSet<Integer> uf = follow.get(followerId);

            uf.add(followeeId);

            follow.put(followerId, uf);
        }
    }

    /** Follower unfollows a followee. If the operation is invalid, it should be a no-op. */
    public void unfollow(int followerId, int followeeId) {
        if (!follow.containsKey(followerId)) return;

        HashSet<Integer> uf = follow.get(followerId);
        if (uf.contains(followeeId)) {
            uf.remove(followeeId);

            follow.put(followerId, uf);
        }
    }
}

// Refer to the discussion
public class Twitter {

    private static int clock = 0;

    private Map<Integer, User> users;

    class Tweet {
        int id;
        int time;
        Tweet next;

        Tweet(int id) {
            this.id = id;
            time = clock++;
            next = null;
        }
    }
    class User {
        int id;
        Set<Integer> followed;
        Tweet tweet_head;

        User(int id) {
            this.id = id;
            followed = new HashSet<>();
            follow(id);
            tweet_head = null;
        }

        void follow(int id) {
            followed.add(id);
        }

        void unfollow(int id) {
            followed.remove(id);
        }

        void post(int id) {
            Tweet t = new Tweet(id);
            t.next  = tweet_head;
            tweet_head = t;
        }
    }

    public Twitter() {
        users = new HashMap<Integer, User>();
    }

    public void postTweet(int userId, int tweetId) {
        if (!users.containsKey(userId)) {
            User u = new User(userId);
            users.put(userId, u);
        }

        users.get(userId).post(tweetId);
    }

    public List<Integer> getNewsFeed(int userId) {
        List<Integer> res = new LinkedList<>();

        if (!users.containsKey(userId)) return res;

        Set<Integer> foll = users.get(userId).followed;
        PriorityQueue<Tweet> q = new PriorityQueue<Tweet>(foll.size(), (a, b) -> (b.time - a.time));
        for (int user : foll) {
            Tweet t = users.get(user).tweet_head;

            if (t != null) {
                q.add(t);
            }
        }

        int n = 0;
        while (!q.isEmpty() && n < 10) {
            Tweet t = q.poll();
            res.add(t.id);
            n++;

            if (t.next != null) {
                q.add(t.next);
            }
        }

        return res;
    }

    public void follow(int followerId, int followeeId) {
        if (!users.containsKey(followerId)) {
            User u = new User(followerId);
            users.put(followerId, u);
        }

        if (!users.containsKey(followeeId)) {
            User u = new User(followeeId);
            users.put(followeeId, u);
        }

        users.get(followerId).follow(followeeId);
    }

    public void unfollow(int followerId, int followeeId) {
        if (!users.containsKey(followerId) || followerId == followeeId) return;

        users.get(followerId).unfollow(followeeId);
    }
}
