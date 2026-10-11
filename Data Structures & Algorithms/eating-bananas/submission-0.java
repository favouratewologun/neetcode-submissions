class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int max = 0;
        int sum = 0;
        for (int n : piles) {
            if (max < n)
                max = n;
        }

        int l = 1;
        int r = max;
        int m = 0;

        while (l < r) {
            m = l + (r-l) / 2;
            if (canFinish(m, piles, h))
                r = m;
            else
                l = m + 1;
        }
        
        return l;
        
    }

    public boolean canFinish(int m, int[] piles, int h) {
        int sum = 0;

        for (int i = 0; i < piles.length; i++) {
            int div = piles[i] / m;
            if (piles[i] % m != 0)
                div++;
            sum += div;
        }

        return sum <= h;


    }
}
