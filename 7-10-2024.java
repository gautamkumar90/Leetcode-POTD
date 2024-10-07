public class MinStringLengthAfterRemovingSubstrings {
    public static void main(String[] args) {
        String s = "ABFCACDB";
        int ans = minLength(s);
        System.out.println(ans);
    }
    public static int minLength(String s) {
        StringBuilder sb = new StringBuilder(s);
        int i = 0;
        int n = sb.length();
        while(i < n-1) {
            char curr = sb.charAt(i);
            char next = sb.charAt(i+1);
            if((curr == 'A' && next == 'B') || (curr == 'C' && next == 'D')) {
                sb.delete(i,i+2);
                n = sb.length();
                i = 0;
            }
            else {
                i++;
            }
        }
        return sb.length();
    }
}
