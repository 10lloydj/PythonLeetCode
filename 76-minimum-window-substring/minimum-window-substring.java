class Solution {
    public String minWindow(String s, String t) {
        // the sliding window is always min t.length()
        if (s.length() == 1 && s.equals(t)){
            return s;
        }
        if (s.length() < t.length()) {
            return "";
        }

        if (t.isEmpty()) {
            return "";
        }

        int best = Integer.MAX_VALUE;
        int[] bestIndicies = {-1, -1};
        int l = 0, have = 0;
        //  create a hashmap count of t

        HashMap<Character, Integer> countT = new HashMap<>();
        HashMap<Character, Integer> window = new HashMap<>();

        for (char c: t.toCharArray()) {
            countT.put(c, countT.getOrDefault(c, 0) + 1);
        }

        int need = countT.size();

        for (int r = 0; r < s.length(); r++) {
            char currentChar = s.charAt(r);
            // add to the map
            window.put(currentChar, window.getOrDefault(currentChar, 0) + 1);

            // check if its in T and the count is correct
            if (countT.containsKey(currentChar) && window.get(currentChar).equals(countT.get(currentChar))) {
                have++;
            }

            while (have == need) {
                // check length is best
                if((r - l + 1) < best) {
                    best = r - l + 1;
                    bestIndicies[0] = l;
                    bestIndicies[1] = r;
                }
                // reduce left until its the smallest valid substring
                char left = s.charAt(l);

                window.put(left, window.get(left) - 1);

                if(countT.containsKey(left) && window.get(left) < countT.get(left)) {
                    have--;
                }
                l++;
            }
        }
        return best < Integer.MAX_VALUE ? s.substring(bestIndicies[0], bestIndicies[1] + 1) : "";
    }
}