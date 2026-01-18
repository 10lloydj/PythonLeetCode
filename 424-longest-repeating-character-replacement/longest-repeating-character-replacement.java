class Solution {
    public int characterReplacement(String s, int k) {
        /*
Use a single loop with end pointer
Add s.charAt(end) to frequency map
Check if window is valid using the formula above
If invalid, shrink from left (increment start, remove from map)
If valid, update max length */

        HashMap<Character, Integer> frequencyMap = new HashMap<>();
        int max = 0;
        int start = 0;
        for (int end = 0; end < s.length(); end++) {
            char current = s.charAt(end);
            frequencyMap.put(current, frequencyMap.getOrDefault(current, 0) + 1);
            int maxFreq = Collections.max(frequencyMap.values());
            while((end - start + 1) - maxFreq > k) {
                frequencyMap.put(s.charAt(start), frequencyMap.get(s.charAt(start)) - 1);
                start++;
            }
            max = Math.max(max, (end - start + 1));
        }

        return max;
    }
}