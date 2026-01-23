class Solution {
    public int maxVowels(String s, int k) {
        Set<Character> vowels = new HashSet<>(Arrays.asList('a', 'e', 'i', 'o', 'u'));
        int count = 0;
        int bestCount = 0;
        int l = 0;
        if (s.length() == 1 && vowels.contains(s.charAt(0))) {
            return 1;
        }

        for(int r = 0; r < s.length(); r++) {
            count += vowels.contains(s.charAt(r)) ? 1 : 0;

            if (r - l + 1 > k) {
                count -= vowels.contains(s.charAt(l)) ? 1 : 0;
                l++;
            }
            bestCount = Math.max(bestCount, count);
        }

        return bestCount;
    }
}