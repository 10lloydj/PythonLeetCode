class Solution {
    public int maxProfit(int[] prices) {
        int maxProfit = Integer.MIN_VALUE;
        int right = 1;
        int left = 0;
        while (left < prices.length - 1 && right < prices.length) {
            while (right < prices.length && left < prices.length - 1 && prices[left] < prices[right]) {
                maxProfit = Math.max(maxProfit, prices[right] - prices[left]);
                right++;
            }
            // skip left values larger than previous
            while(left < prices.length - 1 && prices[left] < prices[left + 1]) {
                left++;
            }
            left++;
            right = left + 1;
        }
        return maxProfit == Integer.MIN_VALUE ? 0 : maxProfit;
    }
}