import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int []stairs = new int[N+1];
		int [][]dp = new int[N+1][2];
		
		for(int i=1;i<N+1;i++) stairs[i]=Integer.parseInt(br.readLine());	// 입력받기
		for(int i=1;i<N+1;i++) {
			dp[i][0] = stairs[i];	dp[i][1] = stairs[i];	//dp[i][0] : 이전 계단 밟음, dp[i][1] : 이전 계단 안 밟음
			if(i==1) {
				dp[i][0]=0;
				continue;
			}
			dp[i][0] += dp[i-1][1];
			dp[i][1] += Math.max(dp[i-2][0], dp[i-2][1]);
		}
		System.out.println(Math.max(dp[N][0],dp[N][1]));
	}//main
}