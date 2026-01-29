class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int low = 1;
        int high = 0;

        for (int pile : piles) {
            if (pile > high) {
                high = pile;
            }   
        }


        while (low < high) {
            int mid = low + (high - low) / 2;
            // validator function 
            int hrs = validK(mid, piles);

            if (hrs > h) {
                // increase k?
                low = mid + 1;
            } else {
                high = mid;
            }
        }
        return low;
    }

    // amount of hours to eat this with k
    private int validK(int k, int[] piles) {
        int totalHrs = 0;
        for (int pile : piles) {
            if (k >= pile) {
                totalHrs ++;
            } else {
                int addedHrs = Math.ceilDiv(pile, k);
                totalHrs += addedHrs;
            }
        }

        return totalHrs;
    }
}