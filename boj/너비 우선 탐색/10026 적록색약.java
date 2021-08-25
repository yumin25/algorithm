import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main {

	private static int N;

	private static class Destination{	//위치 담는 클래스
		private int x;
		private int y;
		public Destination(int x, int y) {
			super();
			this.x = x;
			this.y = y;
		}
	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		char [][]arr = new char[N][N];
		boolean [][]visited = new boolean[N][N];
		String s;

		for(int i=0;i<N;i++) {
			s = br.readLine();
			for(int j=0;j<N;j++) arr[i][j]=  s.charAt(j);	//배열 입력받기
		}

		int answer1 = 0;
		int answer2 = 0;
		for(int i=0;i<N;i++) {
			for(int j=0;j<N;j++) {
				if(visited[i][j]==false) {
					answer1++;
					bfs(1, arr, visited, new Destination(i,j));	//비 적록색약
				}
			}
		}
		
		visited = new boolean[N][N];
		for(int i=0;i<N;i++) {
			for(int j=0;j<N;j++) {
				if(visited[i][j]==false) {
					answer2++;
					bfs(2,arr, visited, new Destination(i,j));	//적록색약
				}
			}
		}		

		System.out.println(answer1 + " " +answer2);
	}//main

	public static void bfs(int type, char [][]arr, boolean [][]visited, Destination des) {	//비 적록색약
		int []dx = {-1,1,0,0};
		int []dy = {0,0,-1,1};
		Queue<Destination> queue = new LinkedList<Destination>();
		queue.add(des);
		visited[des.x][des.y]=true;

		while(!queue.isEmpty()) {
			Destination tmp = queue.poll();
			int x = tmp.x;
			int y = tmp.y;
			for(int i=0;i<4;i++) {
				int nx = x + dx[i];
				int ny = y + dy[i];
				if(nx<0 || ny<0 || nx>=N || ny>=N) continue;
				if(type==1 && visited[nx][ny]==false && arr[nx][ny]==arr[des.x][des.y]) {	//비 적록색약
					queue.add(new Destination(nx, ny));
					visited[nx][ny]=true;
				}
				else if(type==2 && visited[nx][ny]==false) {	//적록색약
					if((arr[des.x][des.y] == 'B' && arr[nx][ny]=='B') || (arr[nx][ny]!='B' && arr[des.x][des.y]!='B')) { //B일 경우, B가 아닐 경우로 나눔
						queue.add(new Destination(nx, ny));
						visited[nx][ny]=true;
					}
				}
			}
		}
	}
}