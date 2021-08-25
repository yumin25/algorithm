import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution {
	private static class Edge implements Comparable<Edge>{	//위치 담는 클래스
		private int x;
		private int y;
		private double weight;
		public Edge(int x, int y, double weight) {
			super();
			this.x = x;
			this.y = y;
			this.weight=weight;
		}
		@Override
		public int compareTo(Edge o) {
			if((this.weight-o.weight)>0) return 1;
			else if((this.weight-o.weight)<0) return -1;
			else return 0;
		}		
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for(int tc=1;tc<T+1;tc++) {
			int N = Integer.parseInt(br.readLine());
			StringTokenizer st = new StringTokenizer(br.readLine());
			int []x = new int[N];
			int []y = new int[N];
			int []parent = new int[N];	//부모 배열
			for(int i=0;i<N;i++) parent[i]=i;
			for(int i=0;i<N;i++) x[i] = Integer.parseInt(st.nextToken());
			st = new StringTokenizer(br.readLine());
			for(int i=0;i<N;i++) y[i] = Integer.parseInt(st.nextToken());
			double E = Double.parseDouble(br.readLine());
			Edge[] edges = new Edge[N*(N-1)/2];
			int cnt = 0;
			for(int i=0;i<N-1;i++) {
				for(int j=i+1;j<N;j++) {
					edges[cnt++] = new Edge(i, j, calculate(E, i,j,x, y));
				}
			}
			Arrays.sort(edges);

			double answer = 0;
			cnt = 0;
			for(int i=0;i<N*(N-1)/2;i++) {
				int tmp_x = find(edges[i].x, parent);
				int tmp_y = find(edges[i].y, parent);
				if(tmp_x==tmp_y) continue;
				answer += edges[i].weight;
				union(tmp_x, tmp_y, parent);
			}
			StringBuilder sb = new StringBuilder();
			sb.append("#").append(tc).append(" ").append(Math.round(answer));
			System.out.println(sb);
		}//tc
	}//main
	
	public static double calculate(double E, int i, int j, int[]x, int[] y) {
		return E*(Math.pow(x[i]-x[j], 2) + Math.pow(y[i]-y[j],2));
	}
	
	public static int find(int x, int[] parent) {
		if(x == parent[x]) return x;
		return parent[x] = find(parent[x],parent);
	}
	
	public static void union(int x, int y, int[] parent) {
		int x1 = find(x,parent);
		int y1 = find(y,parent);
		if(x1!= y1) parent[y1]=x1;
	}
}
