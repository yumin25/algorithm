import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
	private static class rupee implements Comparable<rupee>{
		private int x;
		private int y;
		private int cost;
		public rupee(int x, int y, int cost) {
			this.x = x;
			this.y = y;
			this.cost = cost;
		}
		@Override
		public int compareTo(rupee o) {
			return this.cost-o.cost;
		}
	}
	
	public static int N;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		int count = 1;
		
		while(true) {
			N = Integer.parseInt(br.readLine());
			if(N==0) break;
			int [][]arr = new int[N][N];
			int [][]answer = new int[N][N];
			
			for(int i=0;i<N;i++) {
				st = new StringTokenizer(br.readLine());
				Arrays.fill(answer[i], Integer.MAX_VALUE);
				for(int j=0;j<N;j++) arr[i][j]= Integer.parseInt(st.nextToken());
			}
			
			bfs(arr, answer);
			sb.append("Problem ").append(count++).append(": ").append(answer[N-1][N-1]).append("\n");
		} //while
		System.out.println(sb.toString());
	}//main
	
	public static void bfs(int [][]arr, int [][]answer) {
		int []dx = {-1,1,0,0};
		int []dy = {0,0,-1,1};
		PriorityQueue<rupee> priorityQueue = new PriorityQueue<>();
		priorityQueue.add(new rupee(0, 0, arr[0][0]));
		answer[0][0]=arr[0][0];
		
		while(!priorityQueue.isEmpty()) {
			rupee r = priorityQueue.poll();
			for(int i=0;i<4;i++) {
				int nx = r.x + dx[i];
				int ny = r.y + dy[i];
				if(nx<0 || ny <0 || nx >=N || ny>=N) continue;
				if(answer[nx][ny]>answer[r.x][r.y]+arr[nx][ny]) {
					answer[nx][ny]=answer[r.x][r.y]+arr[nx][ny];
					priorityQueue.add(new rupee(nx, ny, answer[nx][ny]));
				}	
			}
		}
	}
}