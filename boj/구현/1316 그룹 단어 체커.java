import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(bufferedReader.readLine());
		int count = 0;
		
		for(int i=0;i<N;i++) {
			String tmp = bufferedReader.readLine();
			ArrayList<Character> check = new ArrayList<>();
			char c = tmp.charAt(0);
			int length = tmp.length();
			if(length == 1) {
				count++;
			}
			for(int j=1;j<tmp.length();j++) {
				char t = tmp.charAt(j);
				if(c== t) {
					if(j == tmp.length()-1) count ++;
					continue;
				}
				if(check.contains(t)) break;
				check.add(c);
				c = t;
				if(j == tmp.length()-1) {
					count++;
				}
			}
			
		}
		System.out.println(count);
	}
}