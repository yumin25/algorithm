import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int N,K;
	static int answer = 0;
	
	public static void main(String[] args) throws IOException {
		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
		N = Integer.parseInt(stringTokenizer.nextToken());
		K = Integer.parseInt(stringTokenizer.nextToken());
		Combination(0,0);
		System.out.println(answer);
	}
	
	public static void Combination(int count, int start) {
		if(count == K) {
			answer++;
			return;
		}
		for(int i=start; i<N;i++) {
			Combination(count+1, i+1);
		}
	}
	
}