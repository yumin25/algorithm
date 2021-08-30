import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String S = br.readLine();
		
		StringBuilder sb = new StringBuilder();
		boolean check = false;
		int tmp=-1;
		
		for(int i=0;i<S.length();i++) {
			if(S.charAt(i)=='<') {
				tmp=-1;
				check = true;
			}
			
			if(check==true) sb.append(S.charAt(i));
			else {
				if(S.charAt(i)==' ') {
					sb.append(' ');
					tmp=-1;
					continue;
				}
				if(tmp==-1) tmp=i;
				sb.insert(tmp,S.charAt(i));				
			}
			
			if(S.charAt(i)=='>') check = false;
		}
		System.out.println(sb);
	}//main
}