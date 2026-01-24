class Solution {
    public int subarraySum(int[] nums, int k) {
        Map<Integer, Integer> frequencyMap = new HashMap<>();
        int count = 0, sum = 0;
        frequencyMap.put(0, 1);
        for (int curr: nums) {
            sum += curr;
            if (frequencyMap.containsKey(sum - k)) {
                count += frequencyMap.get(sum - k);
            }
            frequencyMap.put(sum, frequencyMap.getOrDefault(sum, 0) + 1);
        }

        return count;
    }
}