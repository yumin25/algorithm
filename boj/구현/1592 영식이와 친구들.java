import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int L = Integer.parseInt(st.nextToken());
		int []arr = new int[N];
		arr[0]=1;
		int have = 0, count = 0;
		while (true) {
			if(arr[have] % 2 == 1) {
				have += L;
				have = have%N;
			}
			else {
				have -= L;
				if(have <0) have+=N;
			}
			arr[have] +=1;
			count++;
			if(arr[have]==M) break;
		}
		System.out.println(count);
	}//main
}