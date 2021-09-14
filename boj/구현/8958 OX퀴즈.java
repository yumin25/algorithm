import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		for(int t=0;t<N;t++) {
			String S = br.readLine();
			
			int answer = 0, tmpAnswer = 0;
			for(int i=0;i<S.length();i++) {
				if(S.charAt(i)=='X') {
					tmpAnswer = 0;
					continue;
				}
				answer += ++tmpAnswer;
			}
			System.out.println(answer);
		}
	}//main
}