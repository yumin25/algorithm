import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.Arrays;
import java.util.StringTokenizer;

import sun.net.www.content.text.plain;

public class Main {
	public static int [][]city;
	public static int [][]chicken;
	public static int C = 0;	//치킨집 개수
	public static int []number;	//조합 저장
	public static int answer=Integer.MAX_VALUE;	//치킨거리 답 저장
	public static int M;
	public static int N;
	

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
		N = Integer.parseInt(stringTokenizer.nextToken());
		M = Integer.parseInt(stringTokenizer.nextToken());
		int tmp = 0;
		city = new int[N][N];
		chicken = new int[13][2];
		number = new int[M];
		
		for(int i=0;i<N;i++) {	//배열 입력받기
			stringTokenizer = new StringTokenizer(bufferedReader.readLine());
			for(int j=0;j<N;j++) {
				tmp = Integer.parseInt(stringTokenizer.nextToken());
				if(tmp == 2) {
					chicken[C][0] = i;
					chicken[C][1] = j;
					C++;
				}
				city[i][j] = tmp;
			}
		}
		Combination(0, 0);
		System.out.println(answer);
	}//main
	
	public static void Combination(int cnt, int start) {
		if(cnt == M) {
			//치킨거리 구하기, 작으면 답
			int tmpAnswer = 0;

			for(int i=0;i<N;i++) {
				for(int j=0;j<N;j++) {
					if(city[i][j] == 1) {
						int tmpSum = Integer.MAX_VALUE;
						for(int k=0;k<M;k++) {
							tmpSum = Math.min(tmpSum, Math.abs(chicken[number[k]][0]-i) + Math.abs(chicken[number[k]][1]-j));
						}
						tmpAnswer += tmpSum;
					}
				}
			}
			answer = Math.min(answer, tmpAnswer);
			
			return;
		}
		for (int i=start; i<C; i++) {
			number[cnt] = i;
			Combination(cnt+1, i+1);
		}		
	}
}