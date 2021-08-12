import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {	
	public static boolean[] visited;
	public static int[][] ingredient;
	public static int N;
	public static boolean checkVisited=false;
	public static int answer=Integer.MAX_VALUE;
	

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(bufferedReader.readLine());
		ingredient = new int[N][2];
		visited = new boolean[N];
		
		for(int i=0;i<N;i++) {
			StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
			ingredient[i][0] = Integer.parseInt(stringTokenizer.nextToken());
			ingredient[i][1] = Integer.parseInt(stringTokenizer.nextToken());
		}
		cook(0,1,0);
		System.out.println(answer);
	}
	
	public static void cook(int idx, int s, int b) {
		if(idx==N) {
			if(checkVisited) {
				answer = Math.min(answer, Math.abs(s-b));
			}
			return;
		}
		visited[idx] = false;
		cook(idx+1, s, b);
		
		visited[idx] = true;
		checkVisited = true;
		cook(idx+1, s*ingredient[idx][0], b+ingredient[idx][1]);
	}
}