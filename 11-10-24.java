//Approach 1
/*
Sort the times array based on the arrival time 
Create an array chairs
Iterate in the times array and store the departure time in the chairs array, and for every element in times array iterate in chairs array

T.C. -> O(n^2), S.C. -> O(n)
*/

//Appraoch 2
// using two minHeaps 
// T.C. -> O(n log n)
// S.C. -> O(n)

class Solution {
    class Pair implements Comparable<Pair> {
        int depart;
        int chair;
        
        Pair(int d, int c) {
            depart = d;
            chair = c;
        }

        public int compareTo(Pair o) {
            return this.depart - o.depart;
        }
    }

    public int smallestChair(int[][] times, int targetFriend) {
        int n = times.length;
        int targetArrivalTime = times[targetFriend][0];
        int highestChair = 0;
        PriorityQueue<Pair> occupiedChair = new PriorityQueue<>();
        PriorityQueue<Integer> freeChair = new PriorityQueue<>();

        // Sort by the first index (column 0) i.e. by arrival time
        Arrays.sort(times, new Comparator<int[]>() {
            @Override
            public int compare(int[] a, int[] b) {
                return Integer.compare(a[0], b[0]); // Sort based on column 0
            }
        });

        int currChair = 0;
        int i = 0;
        while(i < n) {

            // if the departure time is pq is less than the current arrival time then pop and add it in the freeChair pq to get the lowest unoccupied chairNo
            while((occupiedChair.size() > 0) && (occupiedChair.peek().depart <= times[i][0])) {
                Pair rem = occupiedChair.poll();
                freeChair.add(rem.chair);
            }

            // if freeChair contains any element then its top is the lowest chair that can be occupied
            if(freeChair.size() > 0) {
                currChair = freeChair.poll();
            }

            //if we can't get a chair from both the heaps then assign a new chair
            else {
                currChair = highestChair;
                highestChair++;
            }
            //add the chair in pq with the departure time
            occupiedChair.add(new Pair(times[i][1], currChair));
            
            //if we get the target arrival time then return
            if(times[i][0] == targetArrivalTime) {
                return currChair;
            }
            i++;
        }
        return currChair;
    }
}
