/*This was a problem based on binary search on answer because of the words written in the problem statement like minimizing the maximum number of balls in the bag*/

class Solution {
    public int minimumSize(int[] nums, int maxOperations) {
        
        int lo = 1;
        int hi = maxim(nums);
        int ans = -1;

        while(lo <= hi) {
            int m = lo+(hi-lo)/2;

            if(isPossible(nums, m, maxOperations)) {
                ans = m;
                hi = m-1;
            }
            else {
                lo = m+1;
            }
        }
        return ans;
    }

    public boolean isPossible(int[] nums, int m, int maxOperations) {
        
        int myOperations = 0;
        for(int num : nums) {
            if(num % m == 0) {
                //if num is fully divisible by m then it is counting one extra operation so we have to reduce by 1 in this case
                myOperations += (num/m)-1;
            }
            else {
                myOperations += (num/m);
            }
        }

        return myOperations <= maxOperations;
        //go to left only when myOperations are less or equal to maxOp
        //we have achieved the mid ans in equal or less operations so we can minimize it further
        //That's why we have to go to left in this case and right otherwise
    }

    public int maxim(int[] nums) {
        int max = 0;
        for(int num : nums) {
            if(num > max) {
                max = num;
            }
        }
        return max;
    }
}
