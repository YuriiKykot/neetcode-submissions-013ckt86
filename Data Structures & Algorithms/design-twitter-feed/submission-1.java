class Twitter {

    private int time;
    Map<Integer,List<int[]>> userTweets;
    Map<Integer,Set<Integer>> userFollowings;

    public Twitter() {
        time = 0;
        this.userTweets = new HashMap<>();
        this.userFollowings = new HashMap<>();
    }
    
    public void postTweet(int userId, int tweetId) {
        userTweets.putIfAbsent(userId, new ArrayList<>());
        userTweets.get(userId).add(new int[]{time++,tweetId});
    }
    
    public List<Integer> getNewsFeed(int userId) {
        List<Integer> res = new ArrayList<>();
        PriorityQueue<int[]> minHeap = new PriorityQueue<>(Comparator.comparingInt(a -> a[0]));

        Set<Integer> users = userFollowings.getOrDefault(userId,new HashSet<>());
        users.add(userId);

        for(Integer user : users){
            if(userTweets.containsKey(user)){
                for (int[] tweet : userTweets.get(user)) {
                    minHeap.offer(tweet);
                    if(minHeap.size() > 10) minHeap.poll();
                }
            }       
        }

        while(!minHeap.isEmpty()){
            res.add(minHeap.poll()[1]);
        }

        Collections.reverse(res);
        return res;
    }
    
    public void follow(int followerId, int followeeId) {
        userFollowings.putIfAbsent(followerId, new HashSet<>());
        userFollowings.get(followerId).add(followeeId);
    }
    
    public void unfollow(int followerId, int followeeId) {
        userFollowings.getOrDefault(followerId, new HashSet<>()).remove(followeeId);
    }
}
