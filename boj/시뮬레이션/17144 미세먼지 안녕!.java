import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static int R, C, T, cleanerX, cleanerY=0;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		T = Integer.parseInt(st.nextToken());
		int [][]arr = new int[R][C];

		for(int i=0;i<R;i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0;j<C;j++) {
				arr[i][j]= Integer.parseInt(st.nextToken());
				if(arr[i][j]==-1) cleanerX=i;
			}
		}
		for(int i=0;i<T;i++) {
			arr = spread(arr);
			arr = cleaner(arr);
		}
		
		System.out.println(count(arr));
	}
	
	public static int[][] spread(int [][]arr) {		// 미세먼지 확산
		int []dx= {0,1,0,-1};
		int []dy= {1,0,-1,0};
		int [][]tmp = new int[R][C];
		int count=0;
		int nx=0, ny=0;
		for(int i=0;i<R;i++) {
			for(int j=0;j<C;j++) {
				count=0;
				 if(arr[i][j]==0 || arr[i][j]==-1) continue;
				 for(int k=0;k<4;k++) {
					 nx = i+dx[k];
					 ny = j+dy[k];
					 if(nx<0 || ny<0 || nx>=R || ny>=C || arr[nx][ny]==-1) continue;
					 tmp[nx][ny] += arr[i][j]/5;
					 count++;
				 }
				 tmp[i][j] += arr[i][j]-(arr[i][j]/5)*count;
			}
		}
		return tmp;
	}
	
	public static int[][] cleaner(int [][]arr) {
		int [][]tmp = new int[R][C];
		// 윗 부분
		for(int i=1;i<=cleanerX-2;i++) for(int j=1;j<C-1;j++) tmp[i][j]=arr[i][j];	//원 안
		for(int i=C-1;i>0;i--) tmp[0][i-1] = arr[0][i];
		for(int i=0;i<cleanerX-1;i++) tmp[i+1][0] = arr[i][0];	
		for(int i=1;i<C-1;i++) tmp[cleanerX-1][i+1] = arr[cleanerX-1][i];
		for(int i=cleanerX-1;i>=1;i--) tmp[i-1][C-1] = arr[i][C-1];
		
		// 아래 부분
		for(int i=cleanerX+1;i<R-1;i++) for(int j=1;j<C-1;j++) tmp[i][j]=arr[i][j];	//원 안
		for(int i=1;i<C-1;i++) tmp[cleanerX][i+1] = arr[cleanerX][i];
		for(int i=cleanerX;i<R-1;i++) tmp[i+1][C-1] = arr[i][C-1];
		for(int i=C-1;i>0;i--) tmp[R-1][i-1] = arr[R-1][i];
		for(int i=R-1;i>cleanerX;i--) tmp[i-1][0] = arr[i][0];
		
		tmp[cleanerX-1][0]=-1; tmp[cleanerX][0]=-1;
		return tmp;
	}
	
	public static int count(int [][]arr) {
		int answer=0;
		for(int i=0;i<R;i++) {
			for(int j=0;j<C;j++) {
				if(arr[i][j]==-1) continue;
				answer += arr[i][j];
			}
		}
		return answer;
	}
}
