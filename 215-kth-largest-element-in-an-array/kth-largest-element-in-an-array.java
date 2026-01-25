class Solution {
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();

        for (int x: nums) {
            pq.add(-x);
        }

        for(int a = 1; a < k; a++) {
            pq.remove();
        }
        return pq.remove()* -1;
    }
}