import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;
 
public class Main {
	private static ArrayList<Node>[] list;
	private static int []distance;
	private static boolean []check;
    public static void main(String[] args) throws IOException {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	StringTokenizer st = new StringTokenizer(br.readLine());
    	int V = Integer.parseInt(st.nextToken());
    	int E = Integer.parseInt(st.nextToken());
    	int K = Integer.parseInt(br.readLine());
    	int start, end, weight;
    	list = new ArrayList[V+1];
    	distance = new int[V+1];
    	check = new boolean[V+1];
    	Arrays.fill(distance, Integer.MAX_VALUE);
    	
    	for(int i=1;i<=V;i++) list[i] = new ArrayList<>();

    	for(int i=1;i<=E;i++) {
    		st = new StringTokenizer(br.readLine());
    		start = Integer.parseInt(st.nextToken());
    		end = Integer.parseInt(st.nextToken());
    		weight = Integer.parseInt(st.nextToken());
    		list[start].add(new Node(end, weight));
    	}
    	
    	dijkstra(K);
    	StringBuilder sb = new StringBuilder();
    	for(int i=1;i<=V;i++) {
    		if(distance[i]==Integer.MAX_VALUE) sb.append("INF\n");
    		else sb.append(distance[i]+"\n");
    	}
    	
    	System.out.println(sb.toString());
    }	//main
    
    public static void dijkstra(int start) {
    	PriorityQueue<Node> pq = new PriorityQueue<>();
    	pq.add(new Node(start,0));
    	distance[start] = 0;
    	Node node;
    	
    	while(!pq.isEmpty()) {
    		node = pq.poll();
    		if(check[node.vertex]) continue;
    		check[node.vertex]=true;
    		for(Node n:list[node.vertex]) {
    			if(distance[n.vertex]>distance[node.vertex]+n.weight) {
    				distance[n.vertex] = distance[node.vertex] + n.weight;
    				pq.add(new Node(n.vertex, distance[n.vertex]));
    			}
    		}
    	}
    }
    
    static class Node implements Comparable<Node>{
    	int vertex, weight;
    	public Node(int vertex, int weight) {
    		this.vertex = vertex;
    		this.weight = weight;
    	}
    	
    	@Override
    	public int compareTo(Node n) {
    		return weight-n.weight;
    	}
    }
}
