import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());

		int N = Integer.parseInt(stringTokenizer.nextToken());
		int M = Integer.parseInt(stringTokenizer.nextToken());
		int R = Integer.parseInt(stringTokenizer.nextToken());
		int [][]arr = new int[N][M];
		int dx[] = {1,0,-1,0};
		int dy[] = {0,1,0,-1};

		for(int i=0;i<N;i++) {
			stringTokenizer = new StringTokenizer(bufferedReader.readLine());
			for(int j=0;j<M;j++) {
				arr[i][j] = Integer.parseInt(stringTokenizer.nextToken());
			}
		}

		for(int r=0;r<R;r++) {			// 돌리는 횟수
			for(int rr=0;rr<Math.min(N, M)/2;rr++) {	// 한 바퀴
				int i=rr; int j=rr;	//현재 위치
				int x1 = 0; int y1 = 0;	//다음 위치
				int c = 0;
				int t = arr[i][j];	// 현재값 저장
				int tt = 0;
				
				while (c <4) {
					x1 = i+dx[c]; y1= j+dy[c];
					
					if(x1<N-rr && y1<M-rr && x1 >=rr && y1 >=rr) {
						tt = arr[x1][y1];
						arr[x1][y1]=t;
						t = tt;
						i=x1; j=y1;
					}else {
						c++;
					}
				}
			}
		}//R번
		
		StringBuilder stringBuilder = new StringBuilder();
		for(int i=0;i<N;i++) {
			for(int j=0;j<M;j++) {
				stringBuilder.append(arr[i][j]).append(" ");
			}
			stringBuilder.append("\n");
		}	
		System.out.println(stringBuilder);
	}
}