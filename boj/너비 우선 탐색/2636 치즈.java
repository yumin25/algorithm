import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	private static int N, M;
	private static int [][]arr;
	private static boolean [][]visited;
	private static int numCheese = 0;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		arr = new int[N][M];
		visited = new boolean[N][M];
		int count = 0;
		
		for(int i=0;i<N;i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0;j<M;j++) {
				arr[i][j]=Integer.parseInt(st.nextToken());
				if(arr[i][j]==1) numCheese++;
			}
		}

		int tmpCheese = numCheese;
		while (numCheese!=0) {
			bfs();
			visited = new boolean[N][M];
			count++;
			if(numCheese==0) break;
			tmpCheese = numCheese;
		}
		
		System.out.println(count);
		System.out.println(tmpCheese);
	}//main
	
	public static void bfs() {	//얼음을 bfs로 탐색한다. 위아래왼옆 중 치즈가 있을 경우 녹는다.
		int []dx = {-1,1,0,0};
		int []dy = {0,0,-1,1};
		int nx, ny;
		Queue<int[]> queue = new LinkedList<>();
		queue.add(new int[] {0,0});
		int[] destination;
		visited[0][0] = true;
		while (!queue.isEmpty()) {
			destination = queue.poll();
			for(int i=0;i<4;i++) {
				nx = destination[0] + dx[i];
				ny = destination[1] + dy[i];
				if(nx<0 || ny<0 || nx>=N || ny>=M || visited[nx][ny]==true) continue;
				if(visited[nx][ny]==false) {
					if(arr[nx][ny]==1) {
						arr[nx][ny]=0;
						numCheese--;
					}
					else {
						queue.add(new int[] {nx, ny});
					}
					visited[nx][ny] = true;
				}
			}
		}
	}
}