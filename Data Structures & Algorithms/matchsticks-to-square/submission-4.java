class Solution {
    public boolean makesquare(int[] matchsticks) {
        int sum = Arrays.stream(matchsticks).sum();
        if (sum % 4 != 0) return false;
        int t = sum / 4;

        int[] sides = new int[4];
        return dfs(matchsticks, sides, 0,t);
    }

    private boolean dfs(int[] matchsticks, int[] sides, int i,int target){
        if(i == matchsticks.length){
            return sides[0] == sides[1] && sides[1] == sides[2] && sides[2] == sides[3];
        }
 
        for(int j = 0; j < 4; j++){
            if(sides[j] + matchsticks[i] > target) continue;

            sides[j] += matchsticks[i];
            if (dfs(matchsticks, sides, i+1,target)) return true;
            sides[j] -= matchsticks[i];
        }

        return false;
    }
}