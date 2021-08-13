import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.StringTokenizer;

//BigInteger라는 자료형을 써야 함.
public class Main {
	static BigInteger [][] visited;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
		int N = Integer.parseInt(stringTokenizer.nextToken());
		int M = Integer.parseInt(stringTokenizer.nextToken());
		visited = new BigInteger[N+1][M+1];
		Combination(N, M);
		System.out.println(visited[N][M]);
	}//main

	public static void Combination(int n, int m) {
		if(m==0 || m==n) {
			visited[n][m] = new BigInteger("1");
		}
		else if(visited[n][m]!=null) return;
		else {
			Combination(n-1, m-1);
			Combination(n-1, m); 
			visited[n][m]= visited[n-1][m-1].add(visited[n-1][m]);
		}
	}
}