// Approach 1 
// use sorting and then iterate again and again to check if start > end
// T.C. -> O(n^2)
// S.C. -> O(1)

// Approach 2
/*
Use priorityQueue to store end Points and now you need to check the start only with the smallest end point
if(currentStart > smallestEndPoint) => then we can include that interval also in that group
so the answer will be the size of pq
T.C. -> O(n log n)
S.C. -> O(n)
*/

class Solution {
    public int minGroups(int[][] intervals) {
        Arrays.sort(intervals, new Comparator<int[]>() {
            @Override
            public int compare(int[] a, int[] b) {
                return Integer.compare(a[0], b[0]); // Sort based on starting point
            }
        });

        PriorityQueue<Integer> endPoints = new PriorityQueue<>();
        int n = intervals.length;
        for(int i = 0; i < n; i++) {
            if((endPoints.size() > 0) && (intervals[i][0] > endPoints.peek())) { //if start > smallest end point then we can add that interval in the current group and store the new ending point
                endPoints.poll();
            }
            endPoints.add(intervals[i][1]);
        }
        return endPoints.size();
    }
}
