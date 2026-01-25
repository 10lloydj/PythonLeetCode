class Solution {
    Set<Integer> seen = new HashSet<>();
    Map<Integer, HashSet<Integer>> adj = new HashMap<>();

    public int findCircleNum(int[][] isConnected) {
        for (int x = 0; x < isConnected.length; x++) {
            adj.put(x, new HashSet<>());
        }

        // create adj
        for (int a = 0; a < isConnected.length; a++) {
            for (int b = 0; b < isConnected.length; b++) {
                if (a == b) continue;

                if (isConnected[a][b] == 1) {
                    adj.get(a).add(b);
                }
            }
        }
        int result = 0;
        for (int city = 0; city < adj.size(); city++) {
            if (!seen.contains(city)) {
                dfs(city);
                result++;
            }
        }
        return result;
    }

    private void dfs(int city) {
        seen.add(city);
        for (int neighbour : adj.get(city)) {
            if (!seen.contains(neighbour)) {
                dfs(neighbour);
            }
        }
    }
}