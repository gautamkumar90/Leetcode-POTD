// T.C. -> O(n log 3)
// S.C. -> O(log 3) => O(1)

class Solution {

    class Pair implements Comparable<Pair>{
        char ch;
        int count;
        Pair(char ch, int count) {
            this.ch = ch;
            this.count = count;
        }

        public int compareTo(Pair o) {
            return this.count - o.count;
        }
    }


    public String longestDiverseString(int a, int b, int c) {
        StringBuilder sb = new StringBuilder();
        PriorityQueue<Pair> pq = new PriorityQueue<>(Collections.reverseOrder());
        if(a > 0) {
            pq.add(new Pair('a', a));
        }
        if(b > 0) {
            pq.add(new Pair('b', b));
        }
        if(c > 0) {
            pq.add(new Pair('c', c));
        }

        while(pq.size() > 0) {
            Pair top = pq.peek();
            char currChar = top.ch;
            int currCount = top.count;
            pq.poll();

            if(sb.length() >= 2 && sb.charAt(sb.length()-1) == currChar && sb.charAt(sb.length()-2) == currChar) {
                //we can't use this current character
                if(pq.size() == 0) {
                    break;
                }

                Pair secondTop = pq.peek();
                char nextChar = secondTop.ch;
                int nextCount = secondTop.count;
                pq.poll();

                sb.append(nextChar);
                nextCount--;

                if(nextCount > 0) {
                    pq.add(new Pair(nextChar, nextCount));
                }
            }
            else {
                currCount--;
                sb.append(currChar);
            }
            
            if(currCount > 0) {
                pq.add(new Pair(currChar, currCount));
            }
        }
        return sb.toString();
    }
}
