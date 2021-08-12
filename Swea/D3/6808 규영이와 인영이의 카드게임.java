import java.io.BufferedReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {
	static int answerWin;
	static int answerLose;
	static int []a;
	static int []b;
	static int []number;
	static boolean []isSelected;
	
	public static void main(String[] args)  throws NumberFormatException, IOException  {
		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(bufferedReader.readLine());
		
		for(int tc =1; tc<T+1; tc++) {
			StringBuilder stringBuilder = new StringBuilder();
			StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
			answerWin = 0;
			answerLose = 0;
			a = new int[9];
			b = new int[9];
			number = new int[9];
			isSelected = new boolean[9];
			int []tmp = new int[19];

			for(int i=0;i<9;i++) {
				a[i] = Integer.parseInt(stringTokenizer.nextToken());
				tmp[a[i]] = 1;
			}	//a 입력
			
			int t = 0;
			for(int i=1;i<19;i++) {
				if(tmp[i] == 0) {
					b[t++]=i;
				}
			}	//b 입력
			permutation(0);
			stringBuilder.append("#").append(tc).append(" ").append(answerWin).append(" ").append(answerLose);
			System.out.println(stringBuilder);
		}//tc

	}//main

	public static void permutation(int cnt) {
		if(cnt == 9) {
			int countA = 0;
			int countB = 0;
			for(int i=0;i<9;i++) {
				if(number[i]>a[i]) countB += number[i]+a[i];
				else countA += number[i]+a[i];
			}
			if(countA > countB) answerWin++;
			else if(countA < countB) answerLose++;
			
			return;
		}
		for(int i=0;i<9;i++) {
			if(isSelected[i]) continue;
			number[cnt]= b[i];
			isSelected[i] = true;
			permutation(cnt+1);
			isSelected[i] = false;
		}
	}

}