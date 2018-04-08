class Solution {
    public int numTrees(int n) {
        //if (n == 0) return 1; // doesnt make any sense
        // dp[i] represents the number of different binary search trees generated by i + 1 numbers
        int[] dp = new int[n];
        dp[0] = 1;
        for (int i = 1; i < dp.length; i++) {
            for (int j = 0; j <= i; j++) {
                if (j == 0 || j == i) {
                    dp[i] += dp[i - 1];
                } else {
                    dp[i] += dp[j - 1] * dp[i - j - 1];
                }
            }
        }
        return dp[n - 1];
    }
}