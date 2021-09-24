import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static int N;
	public static int answer;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine().trim());
		answer = Integer.MAX_VALUE;
		int [][]arr = new int[N][N];
		boolean []visited = new boolean[N];
		StringTokenizer st;
		for(int i=0;i<N;i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0;j<N;j++) arr[i][j]=Integer.parseInt(st.nextToken());
		}
		dfs(arr, visited, 0, 0, 0);
		System.out.println(answer);
	}
	
	public static void dfs(int [][]arr, boolean []visited, int now, int tmpAnswer, int cnt) {
		if(answer<=tmpAnswer) return;
		if(cnt == N-1) {
			if(arr[now][0]!=0) answer = Math.min(tmpAnswer+arr[now][0], answer);
			return;
		}
		
		for(int i=1;i<N;i++) {
			if(arr[now][i]==0 || visited[i]) continue;
			visited[i]=true;
			dfs(arr, visited, i, tmpAnswer+arr[now][i], cnt+1);
			visited[i]=false;
		}
	}
}
