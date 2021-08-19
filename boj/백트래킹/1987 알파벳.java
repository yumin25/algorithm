import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
	
	public static int R,C;
	public static int tmpAnswer=0;
	public static int answer=0;
	public static char [][]arr;
	public static boolean []visited;
	public static int []dx = {-1,1,0,0};
	public static int []dy = {0,0,-1,1};

	public static void main(String[] args) throws IOException {	//1987
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		arr = new char[R][C];
		visited = new boolean[26];
		
		for(int i=0;i<R;i++) {
			arr[i]= br.readLine().toCharArray(); 
		}
		dfs(0,0);
		System.out.println(answer);
	}//main
	
	public static void dfs(int x, int y) {
		int tmp = arr[x][y]-'A';
		if(visited[tmp]) return;
		visited[tmp] = true;
		tmpAnswer++;
		int nx, ny;	
		
		for(int i=0;i<4;i++) {
			nx = x+dx[i];
			ny = y+dy[i];
			if(nx<0 || ny<0 || nx>=R || ny>=C) continue;
			dfs(nx, ny);
		}//for
		
		answer = Math.max(answer, tmpAnswer);
		tmpAnswer--;
		visited[tmp] = false;		
	}//dfs
}
