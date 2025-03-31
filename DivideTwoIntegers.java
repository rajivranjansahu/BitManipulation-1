// TC: O(log n)
// SC: O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

class Solution {
    // TC = O(log n), SC = O(1)
    public int divide(int dividend, int divisor) {
        if(dividend != 0 && divisor == 0) return Integer.MAX_VALUE;
        if(dividend == Integer.MIN_VALUE && divisor == -1) return Integer.MAX_VALUE; // causes overflow, -2³¹/-1 = 2³¹
        int result = 0;
        long ldividend = Math.abs((long)dividend); // long to prevent overflow
        long ldivisor = Math.abs((long)divisor);
        while(ldividend >= ldivisor) {
            int shifts = 0;
            while(ldividend >= (ldivisor << shifts)) {
                shifts++;
            }
            shifts--; // retracting shift back
            result += 1 << shifts;
            ldividend -= (ldivisor << shifts);
        }
        if((dividend < 0 && divisor > 0) || (dividend > 0 && divisor < 0)) return -result;
        return result;

        // dividend = 43, divisor = 5
        // Shifts:
        // 5 << 0 = 5
        // 5 << 1 = 10
        // 5 << 2 = 20
        // 5 << 3 = 40
        // 5 << 4 = 80 → too big

        // So, 5 << 3 = 40 is the largest valid subtractable value.
        // → result += 1 << 3 = 8
        // → ldividend -= 40 → now 3 left
    }
}