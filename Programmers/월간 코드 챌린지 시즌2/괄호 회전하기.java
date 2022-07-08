import java.util.*;

class Solution {
    public int solution(String s) {
        int answer = 0;        
        for(int i=0;i<s.length();i++){
            StringBuilder sb = new StringBuilder(s);
            sb.append(sb.substring(0,i));
            sb.replace(0,i,"");
            if(isString(sb)) answer++;
        }
        return answer;
    }
    
    public boolean isString(StringBuilder sb){
        Stack<Character> stack = new Stack<>();
        for(int i=0;i<sb.length();i++){
            if(sb.charAt(i)==']' || sb.charAt(i)==')' || sb.charAt(i)=='}'){
                if(stack.size()<=0) return false;
                if(sb.charAt(i)==']') if(stack.peek()!='[') return false;
                else if(sb.charAt(i)==')') if(stack.peek()!='(') return false;
                else if(sb.charAt(i)=='}') if(stack.peek()!='{') return false;
                stack.pop();
            }
            
            else stack.push(sb.charAt(i));
        }
        if(stack.size()!=0) return false;
        return true;
    }
}