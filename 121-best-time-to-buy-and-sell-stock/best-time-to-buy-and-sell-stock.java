class Solution {
    public int maxProfit(int[] prices) {
        int maxProfit = 0;
        int right = 1;
        int left = 0;

        while (right < prices.length) {
            if (prices[left] < prices[right]) {
                maxProfit = Math.max(maxProfit, prices[right] - prices[left]);
                right++;
            } else {
                left = right;
                right = left + 1;
            }
            
        }
        return maxProfit;
    }
}