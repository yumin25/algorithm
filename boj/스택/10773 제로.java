import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
		int K = Integer.parseInt(bufferedReader.readLine());
		int answer = 0;
		
		Stack<Integer> stack = new Stack<>();
		for(int i=0;i<K;i++) {
			int tmp = Integer.parseInt(bufferedReader.readLine());
			if(tmp == 0) stack.pop();
			else stack.add(tmp);
		}
		
		while (!stack.isEmpty()) {
			answer += stack.pop();
		}
		System.out.println(answer);
	}
}