// TC: O(n)
// SC: O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

class Solution {
    // TC = O(n), SC = O(1)
    public int singleNumber(int[] nums) {
        if(nums == null || nums.length == 0) return -1;
        int xor = 0;
        // xoring the number with itself gives 0, so at the end, the number with a single occurence is left
        for(int num : nums) {
            xor ^= num;
        }
        return xor;
    }
}