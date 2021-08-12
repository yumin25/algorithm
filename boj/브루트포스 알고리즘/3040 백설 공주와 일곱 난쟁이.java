import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	static int []dwarf = new int [9];
	static boolean []n = new boolean [9];
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
		int sum = 0;
		for(int i=0;i<9;i++) {
			dwarf[i] = Integer.parseInt(bufferedReader.readLine());
			sum += dwarf[i];
		}
		sum -= 100;
		int tmp;
		boolean c = false;
		
		for(int i=0;i<9;i++) {
			for(int j=i+1;j<9;j++) {
				tmp = dwarf[i] + dwarf[j];
				if(tmp == sum) {
					n[i] = true;
					n[j] = true;
					c = true;
					break;
				}
			}
			if(c == true) break;
		}
		StringBuilder stringBuilder = new StringBuilder();
		for(int i=0;i<9;i++) {
			if(n[i]== false) {
				stringBuilder.append(dwarf[i]).append("\n");
			}
		}
		
		System.out.println(stringBuilder);
	}
	
	
}