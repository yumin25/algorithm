import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String S = br.readLine();
		StringBuilder sb = new StringBuilder();
		int N = S.length();
		int R=0, C=0; char [][]arr;
		for(int i=1;i<=(int)Math.sqrt(N);i++) {
			if(N%i==0) {
				R = i;
				C = N/i;
			}
		}
		
		arr = new char[R][C];
		int tmp = 0;
		for(int i=0;i<C;i++) {
			for(int j=0;j<R;j++) arr[j][i]=S.charAt(tmp++);
		}
		
		for(int i=0;i<R;i++) {
			for(int j=0;j<C;j++) sb.append(arr[i][j]);
		}
		System.out.println(sb);
	}//main
}