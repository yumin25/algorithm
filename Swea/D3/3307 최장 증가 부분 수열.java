import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for(int tc=0;tc<T;tc++) {
			int N = Integer.parseInt(br.readLine());
			int []dp = new int[N];
			int []arr = new int[N];
			StringTokenizer st = new StringTokenizer(br.readLine());
			StringBuilder sb = new StringBuilder();
			for(int i=0;i<N;i++) arr[i]=Integer.parseInt(st.nextToken());
			int max = 1;
			
		    for(int i=0;i<N;i++){
		        dp[i] = 1;
		        for(int j=0;j<i;j++){
		            if(arr[j] < arr[i] && dp[j]+1 > dp[i]){
		                dp[i] = dp[j]+1;
		                if(max < dp[i]){
		                    max = dp[i];
		                }
		            }
		        }
		    }
		    sb.append("#").append(tc+1).append(" ").append(max);
		    System.out.println(sb);
		}//tc
	}
}
