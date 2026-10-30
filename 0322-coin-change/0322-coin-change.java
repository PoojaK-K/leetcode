class Solution {
    public int coinChange(int[] coins, int amount) {
        int [] dp = new int[amount+1];
        Arrays.fill(dp,amount+1);
        dp[0] = 0;
        for(int a = 1;a <= amount;a++){
            for(int i=0;i<coins.length;i++){
                if(coins[i]<=a){
                    dp[a] = Math.min(dp[a],dp[a-coins[i]]+1);
                }
            }
        }
        return dp[amount]>amount?-1:dp[amount];
    }
}