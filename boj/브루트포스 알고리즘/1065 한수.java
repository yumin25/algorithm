import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int answer = 99;
		int hun, ten, one;
		
		if(N<100) answer=N;
		else {
			if(N==1000) N=999;
			for(int i=100;i<=N;i++) {
				hun = i/100;
				ten = (i%100)/10;
				one = (i%100)%10;
				if((hun-ten)==(ten-one)) answer++;
			}
		}
		
		System.out.println(answer);
	}//main
}