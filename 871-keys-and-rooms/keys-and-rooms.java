class Solution {
    Set<Integer> visited = new HashSet<>();
    List<List<Integer>> rooms = new ArrayList<>();
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        // DFS - iterate over the rooms 
        // count === n if we can get in all of them
        this.rooms = rooms;
        visited.add(0);
        dfs(rooms.get(0));
        return visited.size() == rooms.size() ? true : false;
    }

    private void dfs(List<Integer> room) {
        for(int door : room) {
            if (visited.contains(door)) continue;
            visited.add(door);
            dfs(rooms.get(door));
        }
    }
}