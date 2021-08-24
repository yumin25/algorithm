import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		ArrayList<Integer> list = new ArrayList<>();
		
		int N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		for(int i=1;i<N+1;i++) {
			int t = Integer.parseInt(st.nextToken());
			if(t==0) list.add(i);
			else {
				list.add(i-t-1, i);
			}
		}
		StringBuilder sb = new StringBuilder();
		for(int i=0;i<N;i++) sb.append(list.get(i)).append(" ");
		System.out.println(sb);
	}
}
