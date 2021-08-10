import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.StringTokenizer;

//BigInteger ��� �ڷ����� ��� ��.
public class Main {
	static BigInteger [][] visited;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
		int N = Integer.parseInt(stringTokenizer.nextToken());
		int M = Integer.parseInt(stringTokenizer.nextToken());
		visited = new BigInteger[N+1][M+1];
		System.out.println(Combination(N,M));
	}//main

	public static BigInteger Combination(int n, int m) {
		if(m==0 || m==n) {
			visited[n][m] = new BigInteger("1");
			return BigInteger.ONE;
		}
		else if(visited[n][m]!=null) return visited[n][m];
		else {
			Combination(n-1, m-1);
			Combination(n-1, m); 
			visited[n][m]= visited[n-1][m-1].add(visited[n-1][m]);
			return visited[n][m];
		}
	}
}