class Solution {
    public String removeStars(String s) {
        Deque<Character> queue = new ArrayDeque<>();

        for (char c: s.toCharArray()) {
            if (c != '*') {
                queue.push(c);
            } else {
                queue.pop();
            }
        }
        StringBuilder result = new StringBuilder();
        Iterator<Character> iterator = queue.descendingIterator();
        while (iterator.hasNext()) {
            result.append(iterator.next());
        }

        return result.toString();
    }
}