import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
 
        for(int tc=1;tc<t+1;tc++) {
            int n = Integer.parseInt(br.readLine());
            StringBuilder sb = new StringBuilder();
            int [][]farm = new int[n][n];
            sb.append("#").append(tc).append(" ");
 
            for(int i=0;i<n;i++) {
                String tmp = br.readLine();
                for(int j=0;j<n;j++) {   
                    farm[i][j]=Character.getNumericValue(tmp.charAt(j));
                }
            } //배열 입력
 
            int half = n/2;
            int left=half;
            int right=half;
            int answer = 0;
            int tmp = 1;
            for(int i=0;i<=n;i++) {
                for(int j=left;j<=right;j++) {
                    answer +=farm[i][j];
                }
                if(left ==0) {
                    tmp*=-1;
                }
                left -=tmp;
                right +=tmp;
            }
            sb.append(answer);
            System.out.println(sb);         
        }//tc
    }//main	
}