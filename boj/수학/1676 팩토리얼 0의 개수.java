import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(bufferedReader.readLine());
		int answer = 0;
		int count2 = 0;
		int count5 = 0;
		int tmp=0;
		for(int i=1;i<N+1;i++) {
			tmp=i;
			while(tmp%2==0) {
				count2++;
				tmp/=2;
			}
			while(tmp%5==0) {
				count5++;
				tmp/=5;
			}
			while(count5>0 && count2>0) {
				count2--;
				count5--;
				answer++;
				
			}
		}
		System.out.println(answer);
	}//main
}