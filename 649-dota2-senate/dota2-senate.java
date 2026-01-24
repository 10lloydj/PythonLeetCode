class Solution {
    public String predictPartyVictory(String senate) {

        Deque<Character> queue = new ArrayDeque<>();
        int countD = 0, countR = 0, removeD = 0, removeR = 0;
        for(char c: senate.toCharArray()) {
            queue.add(c);
            if (c == 'D') countD++;
            else countR++;
        }

        while(countD > 0 && countR > 0) {
            char current = queue.removeFirst();

            if (current == 'D') {
                // if D has been banned just remove from the queue
                if (removeD > 0) {
                    removeD--;
                    countD--;
                    continue;
                } else {
                    // vote to ban R
                    removeR++;
                    queue.addLast(current);
                }
            } else {
                if (removeR > 0) {
                    removeR--;
                    countR--;
                    continue;
                } else {
                    // vote to ban D
                    removeD++;
                    queue.addLast(current);
                }
            }
        }

        return countD == 0 ? "Radiant" : "Dire";
    }
}