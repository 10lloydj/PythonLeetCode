class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        // Bottom - up: start from the last char and work back seeing if any words are in the current character
        boolean[] dp = new boolean[s.length() + 1];
        for (int x = 0; x < dp.length; x++) {
            dp[x] = false;
        }

        dp[s.length()] = true;

        for (int i = s.length() - 1; i >= 0; i--) {
            for (String word : wordDict) {
                if (i + word.length() <= s.length() && s.substring(i, i + word.length()).equals(word)) {
                    dp[i] = dp[i + word.length()];
                }
                if (dp[i]) {
                    break;
                }
            }
        }
        return dp[0];
    }
}