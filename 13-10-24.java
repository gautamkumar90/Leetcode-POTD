// using k sized array which stores k pointers and min Priority Queue
// T.C.-> O(n log k)
// S.C. -> O(k)
  

class Solution {
    class Pair implements Comparable<Pair> {
        int val;
        int listIdx;
        int ptrIdx;
        
        Pair(int v, int li, int pi) {
            val = v;
            listIdx = li;
            ptrIdx = pi;
        }

        public int compareTo(Pair o) {
            return this.val - o.val;
        }
    }

    public int[] smallestRange(List<List<Integer>> nums) {
        int k = nums.size();
        int[] ptrs = new int[k];
        PriorityQueue<Pair> minpq = new PriorityQueue<>();
        int maxele = Integer.MIN_VALUE;

        int[] ans = {-100000, 100000};
        
        //insert the 0 elements of all the lists
        for(int i = 0; i < k; i++) {
            int ele = nums.get(i).get(0);
            minpq.add(new Pair(ele, i, 0));
            maxele = Math.max(maxele, ele);
        }

        //decrease the range by shifting the pointer of min element by 1
        //break when any one of the list is out of bound
        while(minpq.size() != 0) {
            Pair rem = minpq.poll();
            int minele = rem.val;
            int listIdx = rem.listIdx;
            int idx = rem.ptrIdx;

            if(maxele - minele < ans[1]-ans[0]) {
                ans[1] = maxele;
                ans[0] = minele;
            }

            if(idx+1 < nums.get(listIdx).size()) {
                int nextEle = nums.get(listIdx).get(idx+1);
                minpq.add(new Pair(nextEle, listIdx, idx+1));
                maxele = Math.max(maxele, nextEle);
            }
            else {
                break;
            }           
        }
        return ans; 
    }
}
