class Solution {
    private List<List<Integer>> result = new ArrayList<>();

    public List<List<Integer>> combinationSum3(int k, int n) {
        backtrack(1, n, k, new ArrayList<>());
        return result;
    }

    private void backtrack(int start, int remaining, int k, List<Integer> path) {
        // If we picked k numbers, we can only accept if remaining == 0
        if (path.size() == k) {
            if (remaining == 0) result.add(new ArrayList<>(path));
            return; // either way, stop exploring
        }

        // Try picking the next number from start..9
        for (int num = start; num <= 9; num++) {
            if (num > remaining) break; // pruning (numbers only get bigger)

            path.add(num);
            backtrack(num + 1, remaining - num, k, path); // num+1 prevents reuse
            path.remove(path.size() - 1); // undo
        }
    }
}
