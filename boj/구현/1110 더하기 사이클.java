import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String input = br.readLine();
		String tmpString = "";
		String answer = input;
		int tmpAnswer = 0;
		int count = 0;
		int tmp=0;
		while (true) {
			if(Integer.parseInt(answer)<10) {
				answer = '0'+answer;
			}
			tmp = answer.charAt(0)-'0' + answer.charAt(1)-'0';
			tmpString = Integer.toString(tmp);
			answer = Character.toString(answer.charAt(1)) + Character.toString(tmpString.charAt(tmpString.length()-1));
			tmpAnswer = Integer.parseInt(answer);
			answer =  Integer.toString(tmpAnswer);
			count++;
			if(input.equals(answer)) break;			
		}
		System.out.println(count);
	}//main
}