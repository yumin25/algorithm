import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashSet;

public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		HashSet<String> set = new HashSet<>();
		
		for(int i=0;i<N;i++) set.add(br.readLine());
		int length = set.size();
		String []arr = new String[set.size()];
		arr = set.toArray(new String[0]);
		
		Arrays.sort(arr, new Comparator<String>() {
			@Override
			public int compare(String o1, String o2) {
				if(o1.length()!=o2.length())return o1.length()-o2.length();	//길이 짧은 것부터
				return o1.compareTo(o2);	//길이 같으면 사전 순으로
			}
		});
		
		StringBuilder sb = new StringBuilder();
		for(int i=0;i<length;i++) sb.append(arr[i]).append("\n");
		System.out.println(sb);
	}//main
}