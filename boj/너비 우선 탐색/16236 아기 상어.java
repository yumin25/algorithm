import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	private static class Destination{	//위치 담는 클래스
		private int x;
		private int y;
		
		public Destination(int x, int y) {
			super();
			this.x = x;
			this.y = y;
		}
	}
	private static int N, tmpX, tmpY;
	private static int sharkSize=2;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		int [][]arr = new int[N][N];
		int [][]visited = new int[N][N];
		Destination shark = new Destination(0,0);	//상어 위치 임시 초기화
		
		for(int i=0;i<N;i++) {	//입력받기
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int j=0;j<N;j++) {
				int tmp = Integer.parseInt(st.nextToken());
				if(tmp==9) {	//상어 위치 입력받기
					shark = new Destination(i, j);
					arr[i][j]=0;
				}
				else arr[i][j]= tmp;	//물고기 위치 입력받기
			}
		}

		int count = 0;	//상어가 먹은 물고기수 계산
		int answer = 0;	//답
		while (true) {
			for(int i=0;i<N;i++) Arrays.fill(visited[i], -1);	//방문한 배열 초기화
			bfs(shark, arr, visited);
			if(tmpX==Integer.MAX_VALUE && tmpY==Integer.MAX_VALUE) break;	//물고기가 더 이상 없음
			answer += visited[tmpX][tmpY];
			count++;
			if(count==sharkSize) {			
				sharkSize++;
				count=0;
			}
			arr[tmpX][tmpY]=0;	//먹었으므로 비어있다고 설정해줌.
			shark = new Destination(tmpX, tmpY);	//상어의 위치 업데이트
		}
		System.out.println(answer);
	}
	
	public static void bfs(Destination shark, int[][]arr, int [][]visited) {
		int []dx = {-1,1,0,0};
		int []dy = {0,0,-1,1};
		tmpX = Integer.MAX_VALUE;
		tmpY = Integer.MAX_VALUE;
		int min_dis = Integer.MAX_VALUE;	//가장 가까운 곳에 있는 물고기 찾기 위해
		Queue<Destination> queue = new LinkedList<>();
		queue.add(shark);
		visited[shark.x][shark.y]=0;
		
		while (!queue.isEmpty()) {
			Destination d1 = queue.poll();
			int x = d1.x;
			int y = d1.y;
			for(int i=0;i<4;i++) {	
				int nx = x + dx[i];
				int ny = y + dy[i];
				if(nx<0 || ny <0 || nx>=N || ny>=N || arr[nx][ny]>sharkSize || visited[nx][ny]!=-1) continue;
				queue.add(new Destination(nx,ny));	//상하좌우 계속 큐에 추가해주면서 bfs 계산을 해준다.
				visited[nx][ny]=visited[x][y]+1;
				if(arr[nx][ny]>0 && arr[nx][ny]<sharkSize) {	//물고기가 있으며 상어의 크기보다 작은 경우
					if(min_dis>visited[nx][ny]) {	//방문 최소값보다 거리가 더 짧다면  이 물고기를 먹을 물고기로 결정
						tmpX = nx;
						tmpY = ny;
						min_dis=visited[nx][ny];
					}if(min_dis==visited[nx][ny]) {	//방문 최소값과 거리가 같다면
						if(tmpX> nx) {	//가장 위에 있는 물고기 먹기
							tmpX = nx;
							tmpY = ny;
						}else if(tmpX== nx) {	//가장 위에 있는 물고기가 여러 마리일 경우 가장 왼쪽에 있는 물고기 먹기
							if(tmpY> ny) tmpY = ny;
						}
					}
				}
			}
		}
	}
}