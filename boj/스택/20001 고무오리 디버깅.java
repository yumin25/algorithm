import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
		bufferedReader.readLine();
		Stack<Boolean> stack = new Stack<>();
		
		while(true){
			String duck = bufferedReader.readLine();
			if(duck.equals("문제")) {
				stack.push(true);
			}else if(duck.equals("고무오리")) {
				if(stack.isEmpty()) {
					stack.push(true);
					stack.push(true);
				}
				else {
					stack.pop();
				}
			}
			else if(duck.equals("고무오리 디버깅 끝")) {
				break;
			}
		}
		
		if(stack.isEmpty()) {
			System.out.println("고무오리야 사랑해");
		}else {
			System.out.println("힝구");
		}
		
	}
}
