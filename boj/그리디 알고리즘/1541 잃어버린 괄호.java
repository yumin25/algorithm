import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int answer = 0;
		String[] arr = br.readLine().split("-");
		for(int i=0;i<arr.length;i++) {
			String[] arr2 = arr[i].split("\\+");
			for(int j=0;j<arr2.length;j++) {
				if(i==0) answer += Integer.parseInt(arr2[j]);
				else answer -= Integer.parseInt(arr2[j]);
			}
		}
		System.out.println(answer);
	}
}