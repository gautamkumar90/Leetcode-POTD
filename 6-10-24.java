import java.util.ArrayDeque;
import java.util.Deque;
import java.util.List;

public class SentenceSimilarityIII {
    public static void main(String[] args) {
        String s1 = "qbaVXO Msgr aEWD v ekcb";
        String s2 = "Msgr aEWD ekcb";
        boolean ans = areSentencesSimilar(s1, s2);
        System.out.println(ans);

    }
    //Approach1 using Two Pointers
    public static boolean areSentencesSimilar(String sentence1, String sentence2) {
        String[] arr1 = sentence1.split(" ");
        String[] arr2 = sentence2.split(" ");

        //sentence1 is always the shorter one
        if(arr1.length < arr2.length) {
            return areSentencesSimilar(sentence2, sentence1);
        }

        int i1 = 0, j1 = arr1.length-1, i2 = 0, j2 = arr2.length-1;
        while(i2 <= j2) {
            if(i1 >= arr1.length || j1 < 0) {
                return false;
            }

            if(arr1[i1].equals(arr2[i2])) {
                i1++;
                i2++;
            }
            //if from starting they are not matching then check from end
            else {
                if(arr1[j1].equals(arr2[j2])) {
                    j1--;
                    j2--;
                }
                //if from end too they are not matching, then return false
                else {
                    return false;
                }
            }
        }
        // if j2 crosses i2 means we found out the ans
        return true;
    }

    //Approach 2 using Deque
    public static boolean areSentencesSimilar(String sentence1, String sentence2) {
        //sentence1 is always the shorter one
        if(sentence1.length() < sentence2.length()) {
            return areSentencesSimilar(sentence2, sentence1);
        }
        //Deque because we have to check from first and last only here
        Deque<String> deq1 = new ArrayDeque<>(List.of(sentence1.split(" ")));
        Deque<String> deq2 = new ArrayDeque<>(List.of(sentence2.split(" ")));

        while(deq2.size() > 0) {
            if(deq1.getFirst().equals(deq2.getFirst())) {
                deq1.removeFirst();
                deq2.removeFirst();
            }
            else {
                if(deq1.getLast().equals(deq2.getLast())) {
                    deq1.removeLast();
                    deq2.removeLast();
                }
                else {
                    return false;
                }
            }
        }
        return true;
    }
}
