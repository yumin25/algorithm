import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution {
	public static int answer, N, M, L;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;

		for(int tc=1;tc<=T;tc++) {
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			int R = Integer.parseInt(st.nextToken());
			int C = Integer.parseInt(st.nextToken());
			L = Integer.parseInt(st.nextToken());
			answer = 0;
			int [][]arr = new int[N][M];
			boolean [][]visited = new boolean[N][M];
			for(int i=0;i<N;i++) {
				st = new StringTokenizer(br.readLine());
				for(int j=0;j<M;j++) arr[i][j]=Integer.parseInt(st.nextToken());
			}
			visited[R][C]=true;
			bfs(arr, visited, new int[] {R,C,1});
			sb.append("#").append(tc).append(" ").append(answer).append("\n");
		}
		System.out.println(sb.toString());
	}//main

	public static void bfs(int [][]arr, boolean [][]visited, int []now) {
		int []dx = {-1,1,0,0};
		int []dy = {0,0,-1,1};
		Queue<int[]> queue = new LinkedList<int[]>();
		queue.add(now);
		int nx, ny;
		
		while(!queue.isEmpty()) {
			now = queue.poll();
			answer++;
			if(now[2]>=L) continue;
	
			for(int i=0;i<4;i++) {
				nx = dx[i]+now[0];
				ny = dy[i]+now[1];

				if(nx<0 || ny <0 || nx>=N || ny>=M || arr[nx][ny]==0 || visited[nx][ny]) continue;
				
				if(i==0) {
					if(arr[now[0]][now[1]]==1 || arr[now[0]][now[1]]==2 || arr[now[0]][now[1]]==4 || arr[now[0]][now[1]]==7) {
						if(arr[nx][ny]==1 || arr[nx][ny] ==2 || arr[nx][ny]==5 || arr[nx][ny]==6) {
							queue.add(new int[] {nx, ny, now[2]+1});
							visited[nx][ny]=true;
						}
					}
				}
				else if(i==1) {
					if(arr[now[0]][now[1]]==1 || arr[now[0]][now[1]]==2 || arr[now[0]][now[1]]==5 || arr[now[0]][now[1]]==6) {
						if(arr[nx][ny]==1 || arr[nx][ny] ==2 || arr[nx][ny]==4 || arr[nx][ny]==7) {
							queue.add(new int[] {nx, ny, now[2]+1});
							visited[nx][ny]=true;
						}

					}
				}
				else if(i==2) {
					if(arr[now[0]][now[1]]==1 || arr[now[0]][now[1]]==3 || arr[now[0]][now[1]]==6 || arr[now[0]][now[1]]==7) {
						if(arr[nx][ny]==1 || arr[nx][ny] ==3 || arr[nx][ny]==4 || arr[nx][ny]==5) {
							queue.add(new int[] {nx, ny, now[2]+1});
							visited[nx][ny]=true;
						}
					}

				}else if(i==3) {
					if(arr[now[0]][now[1]]==1 || arr[now[0]][now[1]]==3 || arr[now[0]][now[1]]==4 || arr[now[0]][now[1]]==5) {
						if(arr[nx][ny]==1 || arr[nx][ny] ==3 || arr[nx][ny]==6 || arr[nx][ny]==7) {
							queue.add(new int[] {nx, ny, now[2]+1});
							visited[nx][ny]=true;
						}
					}
				}
			}
		}
	}
}
