//Approach1
// using heaps
// T.C. -> O(n log n)
// S.C. -> O(N)

class Solution {
    public long maxKelements(int[] nums, int k) {
        long ans = 0;
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        int n = nums.length;
        
        for(int num : nums) {
            pq.add(num);
        }

        for(int i = 0; i < k; i++) {
            int rem = pq.poll();
            ans += rem;
            pq.add((int)Math.ceil(rem/3.0));
        }
        return ans;
    }
}
