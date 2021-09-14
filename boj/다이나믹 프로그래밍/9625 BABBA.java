import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main{	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int K = Integer.parseInt(br.readLine());
		int [][]arr = new int[K+1][K+1];
		arr[0][0]=1;
		arr[0][1]=0;
		for(int i=1;i<=K;i++) {
			if(i%2==1) {
				arr[i][1] =arr[i-1][1] + arr[i-1][0];
				arr[i][0]=arr[i-1][1];
				continue;
			}
			arr[i][0]=arr[i-1][1];
			arr[i][1] =arr[i-1][0] + arr[i-1][1];
		}
		System.out.println(arr[K][0] + " " +arr[K][1]);
	}
}