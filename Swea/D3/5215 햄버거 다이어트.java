import java.io.BufferedReader;
import java.util.StringTokenizer;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {
	static int N;
	static int L;
	static int [][] ingredient;
	static int answer;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
         
        for(int tc = 1;tc<t+1;tc++) {
        	answer=0;
        	StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        	N =  Integer.parseInt(st.nextToken());
        	L =  Integer.parseInt(st.nextToken());
        	StringBuilder stringBuilder = new StringBuilder();
        	stringBuilder.append("#").append(tc).append(" ");
        	ingredient = new int[N][N];
        	for(int i = 0;i<N;i++) {
        		st = new StringTokenizer(br.readLine(), " ");
        		ingredient[i][0] = Integer.parseInt(st.nextToken());	//score
        		ingredient[i][1] = Integer.parseInt(st.nextToken());	//cal
        	}
        	
        	check(0,0,0);
        	stringBuilder.append(answer);
        	System.out.println(stringBuilder);
        }   //tc
	}//main
	
	private static void check(int idx, int score, int cal) {
		if(cal>L) {
			return;
		}
		if(idx >= N) {
			answer = Math.max(answer, score);
			return;
		}
		check(idx+1, score+ingredient[idx][0] ,cal+ingredient[idx][1]);
		check(idx+1, score ,cal);
	}
}