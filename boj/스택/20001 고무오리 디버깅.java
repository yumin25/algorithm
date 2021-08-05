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
			if(duck.equals("����")) {
				stack.push(true);
			}else if(duck.equals("������")) {
				if(stack.isEmpty()) {
					stack.push(true);
					stack.push(true);
				}
				else {
					stack.pop();
				}
			}
			else if(duck.equals("������ ����� ��")) {
				break;
			}
		}
		
		if(stack.isEmpty()) {
			System.out.println("�������� �����");
		}else {
			System.out.println("����");
		}
		
	}
}
