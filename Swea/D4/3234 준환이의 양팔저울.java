import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
	public static int count;
	
	//전역변수를 사용하게 되면 시간초과가 난다..
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(bufferedReader.readLine());
		
		for(int tc=0;tc<T;tc++) {
			int N = Integer.parseInt(bufferedReader.readLine());
			count = 0;
			int []weight = new int[N];
			boolean []isSelected = new boolean[N];
			StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());			
			for(int i=0;i<N;i++) weight[i]= Integer.parseInt(stringTokenizer.nextToken());
			
			StringBuilder stringBuilder = new StringBuilder();
			permutation(0, 0, 0 ,weight, isSelected);
			stringBuilder.append("#").append(tc+1).append(" ").append(count);
			System.out.println(stringBuilder);
		}//tc
	}//main
	
	public static void permutation(int cnt, int l, int r, int[] weight, boolean[] isSelected) {	//순열
		if(cnt==weight.length) {
			count++;
			return;
		}
		for(int i=0;i<weight.length;i++) {
			if(isSelected[i]==true) continue;
			isSelected[i]=true;
			permutation(cnt+1,l+weight[i],r, weight,isSelected);	//왼쪽부터 넣어주기
			if(r+weight[i]<=l) permutation(cnt+1,l,r+weight[i] , weight, isSelected);	//오른쪽 넣어주기
			isSelected[i]=false;
		}		
	}//permutation
}
