import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	static int visited[];
	static int N;
	static int number[];
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader bufferedReader= new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(bufferedReader.readLine());
		visited = new int[N+1];
		number = new int[N];
		Permutation(0);
	}
	
	private static void Permutation(int count) {
		if(count == N) {
			for(int i=0;i<N;i++) {
				System.out.print(number[i]+ " " );
			}
			System.out.println();
			return;
		}
		
		for(int i=1;i<=N;i++) {
			if(visited[i]==1) {
				continue;
			}
			
			number[count]=i;
			visited[i]=1;
			Permutation(count+1);
			visited[i]=0;
		}
	}
}