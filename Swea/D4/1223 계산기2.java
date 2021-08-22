import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Solution {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		for(int tc=1;tc<11;tc++) {
			int N = Integer.parseInt(br.readLine());
			String s = br.readLine();
			StringBuilder sb = new StringBuilder();
			StringBuilder answer = new StringBuilder();
			Stack<Character> stack = new Stack<>();
			for(int i=0;i<N;i++) {//후위로 바꾸기
				if(s.charAt(i)=='*' || s.charAt(i)=='+') {
					if(stack.isEmpty()) {//스택이 비어있으면 push
						stack.add(s.charAt(i));
					}else {
						while(!stack.isEmpty()) {
							if(stack.peek()=='*') {
								sb.append(stack.pop());
							}
							else if(stack.peek()=='+' && s.charAt(i)=='*') {
								break;
							}
							else if(stack.peek()=='+' && s.charAt(i)=='+') {
								sb.append(stack.pop());
							}
						}
						stack.add(s.charAt(i));
					}
				}
				else sb.append(s.charAt(i));
			}
			while(!stack.isEmpty()) sb.append(stack.pop());
			s = sb.toString();
			
			//후위계산 시작			
			Stack<Integer> stack2 = new Stack<>();
			int a=0; int b=0; int tmp=0;
			for(int i=0;i<N;i++) {
				if(s.charAt(i)!='*' && s.charAt(i)!='+') {
					stack2.add(s.charAt(i)-'0');
				}
				if(s.charAt(i)=='*') {
					a = stack2.pop();
					b = stack2.pop();
					tmp = a*b;
					stack2.add(tmp);
				}
				if(s.charAt(i)=='+') {
					a = stack2.pop();
					b = stack2.pop();
					tmp = a+b;
					stack2.add(tmp);
				}
			}
			answer.append("#").append(tc).append(" ").append(stack2.pop());
			System.out.println(answer);
		}
	}
}
