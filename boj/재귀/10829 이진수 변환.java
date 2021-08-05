import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		long n = Long.parseLong(br.readLine());
		binary(n);
		
	}
	public static void binary(long n) {
		if(n<2) {
			System.out.print(n);
			return;
		}
		binary(n/2);
		System.out.print(n%2);
	}
}
