//Approach 1 -> O(n^2) Time Complexity which will Exceed the Time Limit


//Approach 2 -> Two pointers 
/*
start i from 0 and j from last index.
  if(nums[i] <= nums[j]) {
    update the ans
    Now we can't get any better answer by reducing the j further
    j = n-1
    i++;
  }
  else {
    j--
  }
*/
//But the worst case here also is O(n^2)


//Approach 3
// Using two Pointers and suffixMax array;
//This will give you the max element from ith index to n-1 in nums array
class Solution {
    public int maxWidthRamp(int[] nums) {
        int n = nums.length;
        int[] suffmax = new int[n];
        suffmax[n-1] = nums[n-1];
        for(int i = n-2; i >= 0; i--) {
            suffmax[i] = Math.max(nums[i], suffmax[i+1]);
        }
        int ans = 0;
        int i = 0, j = 0;
        while(j < n) { //runs till j < n
            if(nums[i] <= suffmax[j]) { // checking the given condition of the ques i.e. nums[i] <= nums[j] and corresponding to that updating the ramp width
                ans = Math.max(ans, j-i);
                j++;
            }
            else { //if condition is false then go for the next element in the nums array
                i++;
            }
        }
        return ans;
    }
}
