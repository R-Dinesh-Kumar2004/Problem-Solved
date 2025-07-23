class Twitter {
    int stack[][];
    int top;
    HashMap<Integer,Set<Integer>> hm;

    public Twitter() {
        stack  = new int[20000][2];
        top = -1;
        hm = new HashMap<>();
    }
    
    public void postTweet(int userId, int tweetId) {
        stack[++top][0] = userId;
        stack[top][1] = tweetId;
    }
    
    public List<Integer> getNewsFeed(int userId) {
        Set<Integer> hs = hm.getOrDefault(userId,null);
        List<Integer> recentTweet = new ArrayList<>();

        for(int i=top;i>=0;i--){
            if(userId == stack[i][0] || (hs != null && hs.contains(stack[i][0]))){
                recentTweet.add(stack[i][1]);

                if(recentTweet.size() == 10) break;
            }
        }

        return recentTweet;
    }
    
    public void follow(int followerId, int followeeId) {
        hm.putIfAbsent(followerId,new HashSet());

        hm.get(followerId).add(followeeId);
    }
    
    public void unfollow(int followerId, int followeeId) {
        if(hm.containsKey(followerId))
            hm.get(followerId).remove(followeeId);
    }
}

/**
 * Your Twitter object will be instantiated and called as such:
 * Twitter obj = new Twitter();
 * obj.postTweet(userId,tweetId);
 * List<Integer> param_2 = obj.getNewsFeed(userId);
 * obj.follow(followerId,followeeId);
 * obj.unfollow(followerId,followeeId);
 */