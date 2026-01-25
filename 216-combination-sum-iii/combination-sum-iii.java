class Solution {
    List<List<Integer>> result = new ArrayList<>();
    public List<List<Integer>> combinationSum3(int k, int n) {
        dfs(1, n, new ArrayList<>(), k);
        return result;
    }

    void dfs(int start, int remainingSum, List<Integer> currentList, int count) {
        if(remainingSum == 0 && currentList.size() == count) {
            result.add(new ArrayList<>(currentList));
        }
        
        for(int a = start; a <= 9; a++) {
            if (remainingSum - a < 0) continue;
            currentList.add(a);
            dfs(a + 1, remainingSum - a, currentList, count);
            currentList.removeLast();
        }
    }
}