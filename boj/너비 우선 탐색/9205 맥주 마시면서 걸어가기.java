import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	public static int[] home;
	public static int[] destination;
	public static int[][] convienent_store;
	public static boolean[] visited;
	public static int N;
	public static boolean check;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		StringTokenizer st;
		for(int tc=0;tc<T;tc++) {
			N = Integer.parseInt(br.readLine());
			home = new int[2];
			destination = new int[2];
			convienent_store = new int[N][2];
			visited = new boolean[N];
			check = false;
			st = new StringTokenizer(br.readLine());
			home[0]=Integer.parseInt(st.nextToken());
			home[1]=Integer.parseInt(st.nextToken());
			for(int i=0;i<N;i++) {
				st = new StringTokenizer(br.readLine());
				convienent_store[i][0]=Integer.parseInt(st.nextToken());
				convienent_store[i][1]=Integer.parseInt(st.nextToken());
			}
			st = new StringTokenizer(br.readLine());
			destination[0]=Integer.parseInt(st.nextToken());
			destination[1]=Integer.parseInt(st.nextToken());
			bfs();
			if(check==false) System.out.println("sad");
			else System.out.println("happy");
		}
	}//main
	
	public static void bfs() {
		Queue<int[]> queue = new LinkedList<>();
		queue.add(home);
		int [] tmp = new int[2];
		while(!queue.isEmpty()) {
			tmp = queue.poll();
			int distance = Math.abs(tmp[0]-destination[0]) + Math.abs(tmp[1]-destination[1]);
			if(distance>1000) {
				for(int i=0;i<N;i++) {
					if(visited[i]==false && (Math.abs(convienent_store[i][0]-tmp[0]) + Math.abs(convienent_store[i][1]-tmp[1]))<=1000) {
						queue.offer(convienent_store[i]);
						visited[i]=true;
					}
				}
			}else {
				check=true;
			}
		}
	}
}