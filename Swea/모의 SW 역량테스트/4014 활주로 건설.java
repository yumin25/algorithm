import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
	public static int N, X;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		
		for(int tc=1;tc<=T;tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			X = Integer.parseInt(st.nextToken());
			int [][]arr = new int[N][N];
			int []tmpArr = new int[N];
			int answer = 0;
			
			for(int i=0;i<N;i++) {
				st = new StringTokenizer(br.readLine());
				for(int j=0;j<N;j++) arr[i][j] = Integer.parseInt(st.nextToken());
			}
			
			for(int i=0;i<N;i++) if(flight(arr[i])) answer++;
			for(int i=0;i<N;i++) {
				for(int j=0;j<N;j++) tmpArr[j] = arr[j][i]; 
				if(flight(tmpArr)) answer++;
			}
			sb.append("#").append(tc).append(" ").append(answer).append("\n");
		}
		System.out.println(sb);
	}
	
	public static boolean flight(int []list) {
		boolean check = true;
		int prev = list[0];
		int prevSame = 1;
		
		for(int i=1;i<N;i++) {
			int tmp = -1;
			if(list[i]==prev) prevSame++;
			else if(Math.abs(prev-list[i])>1) return false;
			else {
				if(prev-list[i] > 0) {	//내리막
					int count = 1;
					for(int j=i+1;j<i+X;j++) {
						if(j>=N) break;
						if(list[j]!=list[i]) break;
						count++;
						tmp = j;
					}
					if(count<X) check = false;
				}
				else if(prevSame<X) check=false;	//오르막
					
				prev = list[i];
				prevSame = 1;
				if(tmp!=-1) {
					i=tmp;
					prevSame = 0;
				}
			}
		}
		return check;
	}
}