import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main{
	public static char arr[][];
	public static int R, C;
	public static int count=0;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st= new StringTokenizer(bufferedReader.readLine());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		arr = new char[R][C];
		
		for(int i=0;i<R;i++) {
			String s = bufferedReader.readLine();
			for(int j=0;j<C;j++) {
				arr[i][j]= s.charAt(j);
			}
		}//입력받기
		
		for(int i=0;i<R;i++) {
			arr[i][0]='x';
			if(dfs(i,0)) count++;
		}
		
		System.out.println(count);		
	}
	
	public static boolean dfs(int x, int y) {
		if(y==C-1) return true;
		int dx[] = {-1,0,1};
		int dy = 1;
		int tx; int ty;
		for(int i=0;i<3;i++) {
			tx = x+dx[i];
			ty = y+dy;
			
			if(tx>=0 && tx<R && ty<C) {
				if(arr[tx][ty]=='.') {
					arr[tx][ty]='x';
					if(dfs(tx, ty)) return true;
				}
			}	
		}
		return false;
	}
}