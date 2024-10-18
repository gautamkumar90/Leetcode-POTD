//Appraoch 1 simple recursion (Scroll below for MORE insights)
// T.C. -> O(2 ^ n)
// S.C. -> O(n)
class Solution {
    public int countMaxOrSubsets(int[] nums) {
        int k = getMaxOr(nums, 0); //max Or value
        return countSubsets(nums, 0, 0, k);
    }

    public int countSubsets(int[] nums, int i, int currOR, int k) {
        if(i == nums.length) {
            if(currOR == k) {
                return 1;
            }
            return 0;
        } 

        int pick = countSubsets(nums, i+1, currOR | nums[i], k);
        int notPick = countSubsets(nums, i+1, currOR, k);
        int ans = pick + notPick;
        return ans;
    }

    public int getMaxOr(int[] nums, int i) {
        if(i == nums.length) {
            return 0;
        }
        int pick = nums[i] | getMaxOr(nums, i+1);
        int notPick = getMaxOr(nums, i+1);
        return Math.max(pick, notPick);
    }
}

//Appraoch 2
//memoization
// T.C. -> O (n * maxOR)
// S.C. -> O(n * maxOR)
class Solution {
    public int countMaxOrSubsets(int[] nums) {
        int[] dp1d = new int[nums.length];
        Arrays.fill(dp1d, -1);
        int k = getMaxOr(nums, 0, dp1d); //max Or value

        int[][] dp2d = new int[nums.length][k+1];
        
        for(int[] t : dp2d) {
            Arrays.fill(t, -1);
        }
        
        return countSubsets(nums, 0, 0, k, dp2d);
    }

    public int countSubsets(int[] nums, int i, int currOR, int k, int[][] dp) {
        if(i == nums.length) {
            if(currOR == k) {
                return 1;
            }
            return 0;
        } 

        if(dp[i][currOR] != -1) {
            return dp[i][currOR];
        }

        int pick = countSubsets(nums, i+1, currOR | nums[i], k, dp);
        int notPick = countSubsets(nums, i+1, currOR, k, dp);
        int ans = pick + notPick;

        dp[i][currOR] = ans;
        return ans;
    }

    public int getMaxOr(int[] nums, int i, int[] dp) {
        if(i == nums.length) {
            return 0;
        }
        if(dp[i] != -1) {
            return dp[i];
        }

        int pick = nums[i] | getMaxOr(nums, i+1, dp);
        int notPick = getMaxOr(nums, i+1, dp);

        dp[i] = Math.max(pick, notPick);
        return dp[i];
    }
}

//Appraoch 3 
// TIP OF THE DAY FOUND
// To calculate max OR value of an array we have to find the OR value of all the elements of the array
class Solution {
    public int countMaxOrSubsets(int[] nums) {

        int k = getMaxOr(nums); //max Or value
        int[][] dp2d = new int[nums.length][k+1];
        
        for(int[] t : dp2d) {
            Arrays.fill(t, -1);
        }
        
        return countSubsets(nums, 0, 0, k, dp2d);
    }

    public int countSubsets(int[] nums, int i, int currOR, int k, int[][] dp) {
        if(i == nums.length) {
            if(currOR == k) {
                return 1;
            }
            return 0;
        } 

        if(dp[i][currOR] != -1) {
            return dp[i][currOR];
        }

        int pick = countSubsets(nums, i+1, currOR | nums[i], k, dp);
        int notPick = countSubsets(nums, i+1, currOR, k, dp);
        int ans = pick + notPick;

        dp[i][currOR] = ans;
        return ans;
    }

    // !! TIP OF THE DAY !! 
    // Max OR value of the array is the OR of all elements

    public int getMaxOr(int[] nums) {
        int ans = 0;
        for(int n : nums) {
            ans = ans | n;
        }
        return ans;
    }
}
  
