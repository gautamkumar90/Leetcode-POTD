class Solution {
    public int minAddToMakeValid(String s) {
        Stack<Character> st = new Stack<>();
        int i = 0;
        while(i < s.length()) {
            char ch = s.charAt(i);
            if(ch == '(') {
                st.push(ch);
            }
            else if(ch == ')' && st.size() > 0 && st.peek() == '(') {
                st.pop();
            }
            else {
                st.push(ch);
            }
            i++;
        }
        int len = st.size();
        return len;
    }
}
