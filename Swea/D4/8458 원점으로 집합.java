import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
	public static void main(String[] args) throws NumberFormatException, IOException {	//8458
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;

		for(int tc=1;tc<=T;tc++) {
			int N = Integer.parseInt(br.readLine());
			long []len = new long[N];
			long max = Long.MIN_VALUE;
			long answer = 0;
			long sum=0;
			int count = 0;
			sb.append("#").append(tc).append(" ");
			
			for(int i=0;i<N;i++) {
				st = new StringTokenizer(br.readLine());
				len[i] = Math.abs(Integer.parseInt(st.nextToken())) + Math.abs(Integer.parseInt(st.nextToken()));
				max = Math.max(max, len[i]);
				if(len[i]%2==1) count++;
			}
			if(count==0 || count==N) {
				while(sum<max || (max-sum)%2!=0) sum += ++answer;
			}
			else answer=-1;

			sb.append(answer).append("\n");
		}//tc
		System.out.println(sb);
	}//main
}
