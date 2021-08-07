import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(bufferedReader.readLine());
		
		for(int tc=1;tc<T+1;tc++) {
			int N = Integer.parseInt(bufferedReader.readLine());
			int [] arr = new int[N];
			long tmpMoney = 0;
			int count = 0;
			long money = 0;
			StringBuilder stringBuilder = new StringBuilder();
			stringBuilder.append("#").append(tc).append(" ");
			StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine(), " ");
			for(int i=0;i<N;i++) {	// ют╥б
				arr[i]= Integer.parseInt(stringTokenizer.nextToken()); 
			}
			
			for(int i=0;i<N;i++) {
				for(int j=i;j<N;j++) {
					if(arr[i]<arr[j]) {
						tmpMoney += arr[i];
						count ++;
						break;
					}
					else if(arr[i]>= arr[j]) {
						if(j == N-1) {
							money += arr[i]*count - tmpMoney;
							tmpMoney = 0;
							count = 0;
						}
					}
				}
			}
			stringBuilder.append(money);
			System.out.println(stringBuilder);
		}
	}//main
}