import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Solution {

	private static class Node implements Comparable<Node>{
		private int a;
		private int b;
		private int v;
		public Node(int a, int b, int v) {
			this.a = a;
			this.b = b;
			this.v = v;
		}

		@Override
		public int compareTo(Node node) {
			return this.v - node.v;
		}
	}
	private static int[] parent;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		StringTokenizer st;
		for(int tc=1;tc<=T;tc++) {
			st = new StringTokenizer(br.readLine());
			int V = Integer.parseInt(st.nextToken());
			int E = Integer.parseInt(st.nextToken());
			ArrayList<Node> list = new ArrayList<>();
			parent = new int[V+1];
			for(int i=0;i<V+1;i++) parent[i]=i;
			long answer = 0;
			StringBuilder sb = new StringBuilder();
			sb.append("#").append(tc);

			for(int i=0;i<E;i++) {
				st = new StringTokenizer(br.readLine());
				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());
				int c = Integer.parseInt(st.nextToken());
				list.add(new Node(a,b,c));
			}
			Collections.sort(list);
			
			for(Node n:list) {
				if(union(n.a, n.b)) answer += n.v;
			}

			sb.append(" ").append(answer);
			System.out.println(sb);
		}
	}//main

	public static boolean union(int x, int y) {
		int x1 = findSet(x);
		int y1 = findSet(y);
		if(x1!= y1) {
			parent[y1]=x1;
			return true;
		}
		return false;
	}

	public static int findSet(int x) {
		if(x==parent[x]) return x;
		return parent[x]=findSet(parent[x]);
	}
}