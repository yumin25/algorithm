import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(bufferedReader.readLine());
		int M = Integer.parseInt(bufferedReader.readLine());
		int count = 0;
		char [] S = bufferedReader.readLine().toCharArray();

		for(int i=0;i<M-2;i++) {
			int tmp = 0;
			if(S[i]=='I') {
				while(S[i+1]=='O' && S[i+2]=='I') {
					i=i+2;
					tmp++;
					if(tmp==N) {
						tmp--;
						count++;
					}
					if(i>=M-2) break;
				}
			}
		}

		System.out.println(count);		
	}//main
}