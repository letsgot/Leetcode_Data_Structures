class Solution {
    long dp[];
    public long mostPoints(int[][] questions) {
        dp = new long[questions.length];
        return dfs(questions, 0);
    }
    public long dfs(int[][] Q, int i) {
        if (i >= Q.length) return 0;
        if (dp[i] > 0) return dp[i];
        int points = Q[i][0], jump = Q[i][1];
        return dp[i] = Math.max(dfs(Q, i + 1), points + dfs(Q, i + jump + 1));
    }
}