//Approach 1 (using stack)
/*
Used stack to remove the balanced Strings and then count the number of closing brackets left in the stack. 
There is a fixed pattern (n+1)/2 is the min swaps.
for ex. ] ] ] [ [ [ 
this kind of pattern is always left in the stack when we remove the balanced string 
so we divide it by 2, and +1 to handle odd number cases.
*/ 
class Solution {
    public int minSwaps(String s) {
        Stack<Character> st = new Stack<>();
        int i = 0;
        while(i < s.length()) {
            char ch = s.charAt(i);
            if(ch == '[') {
                st.push(ch);
                // i++;
            }

            else if(ch == ']' && st.size() > 0 && st.peek() == '[') {
                st.pop();
                // i++;
            }

            else if(ch == ']' && st.size() > 0 && st.peek() == ']') {
                st.push(ch);
                // i++;
            }
            i++;
        }
        int len = st.size();
        return (len+1)/2;
    }
}

//Approach 2 (Space Optimized)
/*
Used just 2 variables - size and top to remove the balanced Strings and then count the number of closing brackets in the unbalanced String
There is a fixed pattern (n+1)/2 is the min swaps.
for ex. ] ] ] [ [ [ 
this kind of pattern is always left in the stack when we remove the balanced string 
so we divide it by 2, and +1 to handle odd number cases.
*/

class Solution {
    public int minSwaps(String s) {
        int size = 0;
        int i = 0;
        char top = 'x';
        while(i < s.length()) {
            char ch = s.charAt(i);
            if(ch == '[') {
                top = '[';
                size++;
            }

            else if(ch == ']' && size > 0 && top == '[') {
                size--;
            }

            else if(ch == ']' && size > 0 && top == ']') {
                top = ']';
                size++;
            }
            i++;
        }
        return (size+1)/2;
    }
}
