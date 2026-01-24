class Solution {
    public boolean closeStrings(String word1, String word2) {
        if (word1.length() != word2.length()) return false;

        // true if (key length + # values are equal) we can use operation 1

        Map<Character, Integer> word1Map = new HashMap<>();
        Map<Character, Integer> word2Map = new HashMap<>();

        // fill frequencyMaps
        for (int curr = 0; curr < word1.length(); curr++) {
            char word1Curr = word1.charAt(curr);
            char word2Curr = word2.charAt(curr);
            word1Map.put(word1Curr, word1Map.getOrDefault(word1Curr, 0) + 1);
            word2Map.put(word2Curr, word2Map.getOrDefault(word2Curr, 0) + 1);
        }

        if (word1Map.size() != word2Map.size()) return false;

        // check the content of chars are the same
        List<Character> word1KeySet = new ArrayList<>(word1Map.keySet());
        List<Character> word2KeySet = new ArrayList<>(word2Map.keySet());
        Collections.sort(word1KeySet);
        Collections.sort(word2KeySet);

        if(!word1KeySet.equals(word2KeySet)) return false;

        // operation 1 possible
        if(word1Map.equals(word2Map)) return true;

        List<Integer> word1ValueSet = new ArrayList<>(word1Map.values());
        List<Integer> word2ValueSet = new ArrayList<>(word2Map.values());
        
        Collections.sort(word1ValueSet);
        Collections.sort(word2ValueSet);

        return word1ValueSet.equals(word2ValueSet);
    }
}