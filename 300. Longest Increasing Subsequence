class Solution {
    public int lengthOfLIS(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        int[] tail = new int[nums.length];
        int sz = 0;
        tail[sz++] = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (tail[0] > nums[i]) {
                // update the subsequence with size 1 to nums[i]
                tail[0] = nums[i];
            } else if (tail[sz - 1] < nums[i]) {
                // can add the current number to expand our subsequence
                tail[sz++] = nums[i];
            } else {
                // do binary search to find the first one that's larger than nums[i] and update it
                int l = 0, r = sz;
                while (l + 1 < r) {
                    int mid = l + (r - l) / 2;
                    if (tail[mid] <= nums[i]) {
                        l = mid;
                    } else {
                        r = mid;
                    }
                }
                if (tail[l] >= nums[i]) tail[l] = nums[i];
                else tail[r] = nums[i];
            }
        }
        return sz;
    }
}
