import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(bufferedReader.readLine());
		System.out.println(factorial(N));
		
	}//main
	
	private static int factorial(int n) {
		if(n<=1) return 1;
		return n*factorial(n-1);
	}
}