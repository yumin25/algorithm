import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int visited[][]=new int[1002][1002];
		int []answer = new int[N+1];
		StringTokenizer st;
		int i1, i2, i3, i4;
		for(int t=1;t<N+1;t++) {
			st = new StringTokenizer(br.readLine());
			i1 = Integer.parseInt(st.nextToken());
			i2 = Integer.parseInt(st.nextToken());
			i3 = Integer.parseInt(st.nextToken());
			i4 = Integer.parseInt(st.nextToken());
			for(int i=i1;i<i1+i3;i++) {
				for(int j=i2;j<i2+i4;j++) visited[i][j] = t;
			}
		}
		
		for(int i=0;i<1002;i++) {
			for(int j=0;j<1002;j++) {
				if(visited[i][j]!=0) answer[visited[i][j]]++;
			}
		}
		StringBuilder sb = new StringBuilder();
		for(int i=1;i<N+1;i++) sb.append(answer[i]).append("\n");
		System.out.println(sb);
	}//main
}