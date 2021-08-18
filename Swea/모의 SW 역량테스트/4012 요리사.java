import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
	public static int [][]S;
	public static int []select;
	public static int N;
	public static int R;
	public static int answer=Integer.MAX_VALUE;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(bufferedReader.readLine());
		StringBuilder stringBuilder = new StringBuilder();

		for(int tc=0;tc<T;tc++) {
			stringBuilder.append("#").append(tc+1).append(" ");
			N = Integer.parseInt(bufferedReader.readLine());
			R=N/2;
			S= new int[N][N];
			select = new int[N/2];
			answer=Integer.MAX_VALUE;
			for(int i=0;i<N;i++) {
				StringTokenizer stringTokenizer=new StringTokenizer(bufferedReader.readLine());
				for(int j=0;j<N;j++) {
					S[i][j]=  Integer.parseInt(stringTokenizer.nextToken());
				}
				
			}//입력받기
			Combination(0,0);
			stringBuilder.append(answer).append("\n");
			
		}
		System.out.println(stringBuilder);
	}//main
	public static void Combination(int cnt, int start) {
		if(cnt==R) {
			int tmpAnswer1 = 0;
			int tmpAnswer2 = 0;
			int tmpAnswer=0;
			int []select2 = new int[R];
			int tmp=0; int tmp1=0;
			for(int i=0;i<N;i++) {	//식재료2 배열
				if(tmp<R && select[tmp]==i) tmp++;
				else select2[tmp1++]=i;
			}
			
			for(int i : select) {
				for(int j : select) {
					tmpAnswer1 += S[i][j];
				}
			}
			
			for(int i : select2) {
				for(int j : select2) {
					tmpAnswer2 += S[i][j];
				}
			}
			tmpAnswer = Math.abs(tmpAnswer1-tmpAnswer2);
			answer = Math.min(answer, tmpAnswer);
			return;
		}
		else{
			for(int i=start;i<N;i++) {

				select[cnt]=i;
				Combination(cnt+1, i+1);
			}
		}
	}

}
