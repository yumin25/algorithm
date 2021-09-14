import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int L = Integer.parseInt(br.readLine());
		int N = Integer.parseInt(br.readLine());
		int P=0,K=0, check=0, answer=0, tmpCount, count=0, answer1=0;
		int []arr = new int[L+1];
		for(int t=1;t<N+1;t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			P = Integer.parseInt(st.nextToken());
			K = Integer.parseInt(st.nextToken());
			tmpCount = 0;
			for(int i= P;i<=K;i++) {
				if(arr[i]==0) {
					arr[i] = t;
					tmpCount++;
				}
			}
			if(tmpCount>count) {
				count = tmpCount;
				answer1 = t;
			}
			if(K-P+1>check) {
				check = K-P+1;
				answer = t;
			}
		}
		System.out.println(answer);
		System.out.println(answer1);
	}//main
}