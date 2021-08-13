import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static int [][]dp;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(bufferedReader.readLine());

		for(int i=0;i<T;i++) {
			StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
			int N = Integer.parseInt(stringTokenizer.nextToken());
			int M = Integer.parseInt(stringTokenizer.nextToken());
			dp = new int[M+1][N+1];
			System.out.println(Combination(M,N));
		}
	}//main

	private static int Combination(int n, int r) {
		if(r==n || r==0) return 1;
		if(dp[n][r]!=0) return dp[n][r];
		dp[n][r] = Combination(n-1,r-1) + Combination(n-1, r);
		return dp[n][r];		
	}
}