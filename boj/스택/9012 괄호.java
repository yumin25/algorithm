import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;
import java.util.stream.IntStream;

public class Main{
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		
		for(int tc=0;tc<t;tc++) {
			Stack<Character> stack = new Stack<>();
			String s = br.readLine();
			boolean check = true;
			
			for(int i=0;i<s.length();i++) {
				if(s.charAt(i)=='(') stack.add(s.charAt(i));
				else {
					if(!stack.isEmpty()) stack.pop();
					else {
						check = false;
						break;
					}
				}
			}			
			if (!stack.isEmpty()) check = false;
			if(check==false) System.out.println("NO");
			else System.out.println("YES");
		}		
	}//main	
}