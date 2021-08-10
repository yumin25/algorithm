import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(bufferedReader.readLine());
 
        for(int tc=1; tc<=t;tc++) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("#").append(tc).append(" ");
            StringTokenizer stringTokenizer=new StringTokenizer(bufferedReader.readLine());
            int n = Integer.parseInt(stringTokenizer.nextToken());
            int m =  Integer.parseInt(stringTokenizer.nextToken());
            int [][]fly = new int[n][n];
            int answer = 0;
            int answerx = 0;
            int answery = 0;
 
            for(int i=0;i<n;i++) {
                stringTokenizer = new StringTokenizer(bufferedReader.readLine());
                for(int j=0;j<n;j++) {
                    fly[i][j]=Integer.parseInt(stringTokenizer.nextToken());
                }
            } //입력
             
            for(int i=0;i<n;i++) {
                if((i+m)<=n) {
                    for(int j=0;j<n;j++) {
                        if((j+m)<=n) {
                            int tmpAnswer = 0;
                            for(int k=i;k<(i+m);k++) {
                                for(int u=j;u<(j+m);u++) {
                                    tmpAnswer += fly[k][u];
                                }
                            }//더하기
                            if(answer<tmpAnswer) {
                                answer = tmpAnswer;
                                answerx = i;
                                answery = j;
                            }
                        }
                    }
                }
            }
            stringBuilder.append(answer);
            System.out.println(stringBuilder);             
        }//tc
	}//main
}