import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N=0, M=0, K=0;
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		int [][]arr =new int[N][M];
		for(int i=0;i<N;i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0;j<M;j++) arr[i][j] = Integer.parseInt(st.nextToken());
		}
		int []dice = new int[] {2,4,1,3,5,6};
		int []now = new int[] {0,0,0};
		int answer = 0;
		for(int i=0;i<K;i++) answer += move(dice, arr, N, M, now);
		System.out.println(answer);
	}
	
	
	public static int move(int[] dice, int[][] arr, int N, int M, int []now) {
		int []dx = new int[]{0,1,0,-1};
		int []dy = new int[]{1,0,-1,0};
		boolean [][]visited = new boolean[N][M];
		int nx = now[0]+dx[now[2]], ny = now[1]+dy[now[2]];
		int move = now[2];
		if(nx<0 || ny<0 || nx>=N || ny>=M) {
			move = (now[2]+2)%4;
			nx = now[0]+dx[move]; ny = now[1]+dy[move];
		}
		now[0] = nx; now[1]=ny;
		Queue<int[]> queue = new LinkedList<>();
		queue.add(new int[] {nx, ny});
		visited[nx][ny]=true;
		int sum = 1;
		while(!queue.isEmpty()) {	//이동 가능
			int []tmp = queue.poll();
			int nnx=0, nny=0;
			for(int i=0;i<4;i++) {
				nnx = tmp[0]+dx[i];
				nny = tmp[1]+dy[i];
				if(nnx<0 || nny<0 || nnx>=N || nny>=M || visited[nnx][nny]) continue;
				visited[nnx][nny]=true;
				if(arr[nnx][nny]==arr[nx][ny]) {
					queue.add(new int[] {nnx, nny});
					sum++;
				}
			}
		}
		sum = sum * arr[nx][ny];
		int []tmp = new int[4];
		
		if(move==0) {
			tmp[0] = dice[1]; tmp[1] = dice[2]; tmp[2]=dice[3]; tmp[3]=dice[5];
			dice[1]=tmp[3]; dice[2]=tmp[0]; dice[3] =tmp[1]; dice[5]=tmp[2];
		}
		else if(move==1) {
			tmp[0]=dice[0]; tmp[1]=dice[2]; tmp[2]=dice[4]; tmp[3]=dice[5];
			dice[2]=tmp[0]; dice[4]=tmp[1]; dice[5]=tmp[2]; dice[0]=tmp[3];
		}
		else if(move==2) {
			tmp[0]=dice[1]; tmp[1]=dice[2]; tmp[2]=dice[3]; tmp[3]=dice[5];
			dice[5]=tmp[0]; dice[1]=tmp[1]; dice[2]=tmp[2]; dice[3]=tmp[3];
		}
		else if(move==3) {
			tmp[0]=dice[0]; tmp[1]=dice[2]; tmp[2]=dice[4]; tmp[3]=dice[5];
			dice[5]=tmp[0]; dice[0]=tmp[1]; dice[2]=tmp[2]; dice[4]=tmp[3];
		}
		now[2] = move;
		if(dice[5] > arr[nx][ny]) now[2]=(now[2]+1)%4;
		else if(dice[5] < arr[nx][ny]) {
			if(now[2]==0) now[2]=3;
			else now[2] = (now[2]-1)%4;
		}
		return sum;
	}
}
