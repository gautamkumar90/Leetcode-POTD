//Approach 1  is to use a suffix max array which will store the indices on the right of each no
//T.C. -> O(n)
//S.C. => O(n)

//Approach 2 is to make a 10 sized array and iterate on it. Store the indices of every digit
//Now iterate from the right and check if the no is greater than any no present on right. if yes then swap
//as it is fixed the space will be O(1)

//Approach 1 code
class Solution {
    public int maximumSwap(int num) {
        StringBuilder sb = new StringBuilder(Integer.toString(num));
        int n = sb.length();
        int[] arr = new int[n]; //stores the indices of max in right
        int maxRightIdx = n-1;
        arr[n-1] = maxRightIdx;

        for(int i = n-2; i >= 0; i--) {
            if(sb.charAt(i) > sb.charAt(arr[i+1])) {
                maxRightIdx = i;
            }
            arr[i] = maxRightIdx;
        }
        
        for(int i = 0; i < n; i++) {
            if(sb.charAt(i) < sb.charAt(arr[i])) {
                //swapping the characters
                char temp = sb.charAt(i);
                sb.setCharAt(i, sb.charAt(arr[i]));
                sb.setCharAt(arr[i], temp);

                return Integer.parseInt(sb.toString());
            }
        }
        return num;
    }
}
