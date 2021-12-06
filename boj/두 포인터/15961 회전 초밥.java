import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int d = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		int c = Integer.parseInt(st.nextToken());
		int []bab = new int[N];
		int []visited = new int[d+1];
		for(int i=0;i<N;i++) bab[i] = Integer.parseInt(br.readLine());
		int answer = 0;
		int tmpAnswer=0; int tmpIndex = 0;
		
		for(int j=0;j<k;j++) {
			tmpIndex = j%N;
			if(visited[bab[tmpIndex]]==0) tmpAnswer++;
			visited[bab[tmpIndex]]++;
		}
		
		for(int i=1;i<N;i++) {
			if(visited[c]==0) answer = Math.max(answer, tmpAnswer+1);
			else answer = Math.max(answer, tmpAnswer);
			visited[bab[i-1]]--;
			if(visited[bab[i-1]]==0) tmpAnswer--;
			
			if(visited[bab[(i+k-1)%N]]==0) tmpAnswer++;
			visited[bab[(i+k-1)%N]]++;
		}
		System.out.println(answer);
	}
}
