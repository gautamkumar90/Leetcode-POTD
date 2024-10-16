// T.C. -> O(n)
// S.C. -> O(1)

class Solution {
    public long minimumSteps(String s) {
        long swaps = 0;
        int count1 = 0;
        for(int i = 0; i < s.length(); i++) {
            if(s.charAt(i) == '1') {
                count1++;
            }  
            else {
                //no of 1s before 0 is the no of swaps required to shift that 0 to the left side
                swaps += count1;
            }
        }
        return swaps;
    }
}
