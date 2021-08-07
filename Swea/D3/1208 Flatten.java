import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		for(int tc=1;tc<=10;tc++) {
            int result = 0;
            sb.append("#").append(tc).append(" ");
            int maxDumpCnt = Integer.parseInt(br.readLine());
            int[] num = new int[100];
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            for(int i=0;i<100;i++) {
                num[i]= Integer.parseInt(st.nextToken()); 
            }
            for(int i=1;i<100;i++) { //버블 정렬
                for(int j=0;j<100-i;j++) {
                    if(num[j]>num[j+1]) {
                        int tmp = num[j];
                        num[j]= num[j+1];
                        num[j+1]=tmp;
                    }
                }
            }
            
            for(int i=0;i<maxDumpCnt;i++) {
                if((num[99]- num[0]) <= 1 ) {
                    break;
                }
                num[0] +=1;
                num[99]-=1;
                for(int j=1;j<100;j++) {
                    for(int k=0;k<100-j;k++) {
                        if(num[k]>num[k+1]) {
                            int tmp = num[k];
                            num[k]= num[k+1];
                            num[k+1]=tmp;
                        }
                    }
                }
            }
            result = num[99]-num[0];
            sb.append(result);
            sb.append("\n");
		}
		System.out.println(sb);
	}
}