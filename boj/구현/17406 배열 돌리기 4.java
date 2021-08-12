import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static int N, M, K, answer=Integer.MAX_VALUE;
	public static int [][]arr;
	public static int [][]arrOrigin;//원래 배열
	public static int [][]rot;	//r,c, s 입력값

	public static int [][]choice;
	static boolean []isSelected;	

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());

		N = Integer.parseInt(stringTokenizer.nextToken());
		M = Integer.parseInt(stringTokenizer.nextToken());
		K = Integer.parseInt(stringTokenizer.nextToken());
		arr = new int[N][M];
		arrOrigin = new int[N][M];
		rot = new int[K][3];
		choice = new int[K][3];
		isSelected = new boolean[K];

		for(int i=0;i<N;i++) {
			stringTokenizer = new StringTokenizer(bufferedReader.readLine());
			for(int j=0;j<M;j++) {
				arrOrigin[i][j] = Integer.parseInt(stringTokenizer.nextToken());;
			}
		}

		for(int i=0;i<K;i++) {
			stringTokenizer = new StringTokenizer(bufferedReader.readLine());
			rot[i][0] = Integer.parseInt(stringTokenizer.nextToken());
			rot[i][1] = Integer.parseInt(stringTokenizer.nextToken());
			rot[i][2] = Integer.parseInt(stringTokenizer.nextToken());
			rotate(rot[i][0],rot[i][1],rot[i][2]);
		}

		permutation(0);
		System.out.println(answer);
	}//main

	public static void permutation(int cnt) {
		if(cnt == K) {
			for(int i=0;i<N;i++) {
				for(int j=0;j<M;j++) {
					arr[i][j] = arrOrigin[i][j];
				}
			}
			for(int i=0;i<K;i++) {
				rotate(choice[i][0], choice[i][1], choice[i][2]);
			}
			int tmpAnswer = Integer.MAX_VALUE;
			
			for(int i=0;i<N;i++) {
				int sum = 0;
				for(int j=0;j<M;j++) {
					sum += arr[i][j];
				}
				tmpAnswer = Math.min(tmpAnswer, sum);
			}
			answer = Math.min(tmpAnswer, answer);
			return;
		}
		for(int i=0;i<K;i++) {
			if (isSelected[i]) continue;
			isSelected[i]= true;
			choice[cnt]= rot[i];  
			permutation(cnt+1);
			isSelected[i]= false;			
		}

	}

	public static void rotate(int r, int c, int s) {
		int x1 = r-s-1;
		int x2 = r+s-1;
		int y1 = c-s-1;
		int y2 = c+s-1;
		int[] dx = {0, 1, 0, -1};
		int[] dy = {1, 0, -1, 0};

		for(int i = 0; i <s; i++) {
			int x = x1+i;
			int y = y1+i;
			int count = 0;
			int tmp = arr[x][y];
			int t = 0;

			while(count < 4) {
				int nx = x + dx[count];
				int ny = y + dy[count];
				if(nx > x2-i || ny > y2-i || nx < x1+i || ny < y1+i) {
					count++;
				}
				else{
					t = arr[nx][ny];
					arr[nx][ny] = tmp;	
					tmp = t;
					x = nx;
					y = ny;
				}
			}
		}
	}//rotate
}