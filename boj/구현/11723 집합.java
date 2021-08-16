import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
		ArrayList<Integer> list = new ArrayList<>();
		int M = Integer.parseInt(bufferedReader.readLine());
		StringBuilder stringBuilder = new StringBuilder();
		int x=0;
		String calc;
		for(int i=0;i<M;i++) {
			StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
			calc = stringTokenizer.nextToken();
			if(stringTokenizer.hasMoreTokens()) x = Integer.parseInt(stringTokenizer.nextToken());
			
			if(calc.equals("add")) {
				if(!list.contains(x)) list.add(x);
			}else if(calc.equals("remove")) {
				if(list.contains(x)) list.remove(Integer.valueOf(x));
			}else if(calc.equals("check")) {
				if(list.contains(x)) stringBuilder.append(1).append("\n");
				else stringBuilder.append(0).append("\n");
			}else if(calc.equals("toggle")) {
				if(list.contains(x)) list.remove(Integer.valueOf(x));
				else list.add(x);
			}else if(calc.equals("all")) {
				list.clear();
				for(int j=1;j<21;j++) list.add(j);
			}else if(calc.equals("empty")) {
				list.clear();
			}
		}
		System.out.println(stringBuilder);
	}
}