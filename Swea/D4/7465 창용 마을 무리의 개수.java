import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Solution {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for(int tc=1;tc<T+1;tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());
			int []arr = new int[N+1];
			ArrayList<Integer> list = new ArrayList<>();
			for(int i=1;i<N+1;i++) arr[i] =i;
			StringBuilder sb = new StringBuilder();
			sb.append("#").append(tc).append(" ");
			for(int i=0;i<M;i++) {
				st = new StringTokenizer(br.readLine());
				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());		
				
				union(a, b, N, arr);
				}
			for(int i=1;i<N+1;i++) {
				if(!list.contains(arr[i])) list.add(arr[i]);
			}
			
			sb.append(list.size());
			System.out.println(sb);
		}
	}
	
	public static void union(int x, int y, int n, int[] arr) {
		int x1 = findSet(x,arr);
		int y1 = findSet(y,arr);
		if(x1!= y1) arr[y1]=x1;
		for(int i=1;i<n+1;i++) {
			if(arr[i]==y1) arr[i]=x1;
		}
	}
	
	public static int findSet(int x, int[] arr) {
		if(x == arr[x]) return x;
		else {
			arr[x]= findSet(arr[x],arr);
			return arr[x];
		}
	}
}
