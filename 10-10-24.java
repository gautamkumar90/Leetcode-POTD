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

//Appraoch 4
//Using sorting with the help of comparable Pair class
//T.C. -> O(n log n)
//S.C. -> O(n)

class Solution {

    class Pair implements Comparable<Pair> {
        int idx;
        int val;
        Pair(int idx, int val) {
            this.idx = idx;
            this.val = val;
        }

        public int compareTo(Pair o) {
            return this.val - o.val;
        }
    }

    public int maxWidthRamp(int[] nums) {
        int n = nums.length;
        Pair[] arr = new Pair[n];
        for(int i = 0; i < n; i++) {
            arr[i] = new Pair(i, nums[i]);
        }

        Arrays.sort(arr); // sort on the basis of values 

        //now values part is already checked so we have to only maximize the width
        int minIdxSeen = arr[0].idx;
        int maxWidth = 0;
        for(int i = 1; i < n; i++) {
            maxWidth = Math.max(maxWidth, arr[i].idx - minIdxSeen); //subtracting the current index with the min idx so far because greater than that index will not give any better ans
            minIdxSeen = Math.min(minIdxSeen, arr[i].idx); // If we see any index less than this minIdxSeen that we'll update that idx to minIdxSeen
        }
        return maxWidth;
    }
}

//Approach 5
// Using monotonic stack approach
// T.C. -> O(n)
// S.C. -> O(n)

class Solution {

    public int maxWidthRamp(int[] nums) {
        int n = nums.length;
        Stack<Integer> st = new Stack<>();

        // A strictly montonically decreasing stack is maintained and no popping is done because we wanted farthest element lesser or equal than the last index element. Why last element?
        // we took last element as ref because that will help us to find the max value of j-i
        for(int i = 0; i < n; i++) {
            if(st.size() == 0 || (nums[i] < nums[st.peek()])) {
                st.push(i);
            }
        }
        
        int maxWidth = 0;
        int j = n-1;
        while(j >= 0 && st.size() > 0) {
            if(nums[st.peek()] <= nums[j]) {
                maxWidth = Math.max(maxWidth, j-st.pop());
            }
            else {
                j--;
            }
        }
        return maxWidth;
    }
}
