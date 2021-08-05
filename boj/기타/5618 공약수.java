import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(bufferedReader.readLine());
		StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
		int []num = new int[N];
		int g = 0;
		StringBuilder stringBuilder = new StringBuilder();
		ArrayList<Integer> answer = new ArrayList<>();
		
		for(int i=0;i<N;i++) {
			num[i] = Integer.parseInt(stringTokenizer.nextToken());
		}
		
		if(N==2) {
			g = gcd(num[0],num[1]);
		}
		else if(N==3) {
			g = gcd(gcd(num[0],num[1]),num[2]);
		}
		
		for(int i=1;i<=Math.sqrt(g);i++) {
			if(g%i == 0) {
				stringBuilder.append(i).append("\n");
				if(i!=Math.sqrt(g)) {
					answer.add(i);
				}
			}
		}
		for(int i=answer.size()-1;i>=0;i--) {
			stringBuilder.append(g/answer.get(i)).append("\n");
		}
		System.out.println(stringBuilder);
		
	} // main
	
	//유클리드 호제법
	private static int gcd(int a, int b) {
		if(b == 0) return a;
		return gcd(b, a%b);
	}
}