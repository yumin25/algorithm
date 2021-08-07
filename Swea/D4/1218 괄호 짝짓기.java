import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Solution {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		 
        for(int tc=1;tc<11;tc++) {
            int n = Integer.parseInt(br.readLine());
            StringBuilder sb = new StringBuilder();
            sb.append("#").append(tc).append(" ");
            char [] bracket = new char[n];
            bracket = br.readLine().toCharArray();
            Stack<Character> stack = new Stack<>();
            int answer = -1;
             
            for(int i=0;i<n;i++) {
                if(bracket[i] == '(' || bracket[i] == '[' || bracket[i] == '{' || bracket[i] == '<') {
                    stack.push(bracket[i]);
                }
                else if (bracket[i] == ')'){
                    if(stack.peek() == '(') {
                        stack.pop();
                    }else {
                        answer = 0;
                    }
                }
                else if (bracket[i] == ']'){
                    if(stack.peek() == '[') {
                        stack.pop();
                    }else {
                        answer = 0;
                    }
                }
                else if (bracket[i] == '}'){
                    if(stack.peek() == '{') {
                        stack.pop();
                    }else {
                        answer = 0;
                    }
                }
                else if (bracket[i] == '>'){
                    if(stack.peek() == '<') {
                        stack.pop();
                    }else {
                        answer = 0;
                    }
                }
                if(answer == 0) {
                    break;
                }
            }   //for
             
            if(stack.isEmpty()) {
                answer=1;
            }
             
            sb.append(answer);          
            System.out.println(sb);
        }//tc
	}//main	
}