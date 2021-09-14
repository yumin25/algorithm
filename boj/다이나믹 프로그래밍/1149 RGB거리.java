import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main{	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int N = Integer.parseInt(br.readLine());
		int [][]arr = new int[N][3];
		int [][]dp = new int[N][3];
		for(int t=0;t<N;t++) {
			st = new StringTokenizer(br.readLine());
			for(int i=0;i<3;i++) {
				arr[t][i] = Integer.parseInt(st.nextToken());
			}
		}	//입력받기
		
		dp[0][0]=arr[0][0];	dp[0][1]=arr[0][1];	dp[0][2]=arr[0][2];
		
		for(int t=1;t<N;t++) {
			dp[t][0]= arr[t][0] + Math.min(dp[t-1][1], dp[t-1][2]);
			dp[t][1]= arr[t][1] + Math.min(dp[t-1][0], dp[t-1][2]);
			dp[t][2]= arr[t][2] + Math.min(dp[t-1][0], dp[t-1][1]);
		}
		
		int answer = Math.min(dp[N-1][0], dp[N-1][1]);
		answer = Math.min(answer, dp[N-1][2]);
		System.out.println(answer);
	}
}