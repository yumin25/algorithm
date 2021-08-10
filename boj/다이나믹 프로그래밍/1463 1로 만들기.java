import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(bufferedReader.readLine());
		int []count = new int [N+1];
		
		for(int i=2;i<N+1;i++) {
			int tmp0 = Integer.MAX_VALUE;
			if(i % 3 == 0) {
				tmp0 = Math.min(tmp0, count[i/3]);
			}
			if(i %2 ==0) {
				tmp0 = Math.min(tmp0, count[i/2]);
			}
			tmp0 = Math.min(tmp0, count[i-1]);
			count[i]=tmp0+1;
		}
		System.out.println(count[N]);
	}//main
}