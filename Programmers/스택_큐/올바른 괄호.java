import java.util.*;

class Solution {
    boolean solution(String s) {
        boolean answer = true;
        Stack<Character> stack = new Stack<>();
        for(int i=0;i<s.length();i++){
            if(s.charAt(i)==')') {
                if(stack.size()>0) stack.pop();
                else return false;
            }
            else stack.push(s.charAt(i));
        }
        if(stack.size()!=0) answer=false;
        return answer;
    }
}