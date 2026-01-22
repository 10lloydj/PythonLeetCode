class Solution {
    private Map<Character, Set<Character>> adj;
    private Map<Character, Boolean> visited;
    private List<Character> result;

    public String alienOrder(String[] words) {
        // iterate over each word and c

        // When comparing words - while loop until characters !=, the select the left char and add it to the result

        // create an adjacency list (HashMap of each character with a set in it)

        adj = new HashMap<>();
        // Initialise the adj with every character
        for (String word : words) {
            for (char c : word.toCharArray()) {
                adj.putIfAbsent(c, new HashSet<>());
            }
        } 

        for(int x = 0; x < words.length - 1; x++) {
            String word1 = words[x];
            String word2 = words[x + 1];

            int minLen = Math.min(word1.length(), word2.length());

            // Error case
            if(word1.length() > word2.length() && word1.substring(0, minLen).equals(word2.substring(0, minLen))) {
                return "";
            }

            // first different letter add to the HashMap then break
            for (int index = 0; index < minLen; index++) {
                // between words letter comparison
                if(word1.charAt(index) != word2.charAt(index)) {
                    adj.get(word1.charAt(index)).add(word2.charAt(index));
                    break;
                }
            }
        }

        // DFS 
        // False == visited, True == visited && current path
        visited = new HashMap<>();
        result = new ArrayList<>();

        for (char c : adj.keySet()) {
            if(dfs(c)) {
                return "";
            }
        }
        Collections.reverse(result);
        StringBuilder sb = new StringBuilder();
        for (char c : result) {
            sb.append(c);
        }
        return sb.toString();
    }

    private boolean dfs(char c) {
        // If its been visited, return the value - true if theirs cycles, false if not
        if (visited.containsKey(c)) {
            return visited.get(c);
        }
        visited.put(c, true);

        for (char n : adj.get(c)) {
            if (dfs(n)) {
                return true;
            }
        }

        visited.put(c, false);
        result.add(c);
        return false;
    }
    
}
