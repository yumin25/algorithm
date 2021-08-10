import java.io.BufferedReader;
import java.util.ArrayList;
import java.util.StringTokenizer;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {	
	public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
         
        for(int tc = 1;tc<T+1;tc++) {
        	StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        	int N = Integer.parseInt(st.nextToken());
        	int M = Integer.parseInt(st.nextToken());
        	int answer = 0;
        	StringBuilder stringBuilder = new StringBuilder();
        	stringBuilder.append("#").append(tc).append(" ");
        	int []snack = new int[N];
        	st = new StringTokenizer(br.readLine(), " ");
        	for(int i=0;i<N;i++) {
        		snack[i] = Integer.parseInt(st.nextToken());
        	}
        	
        	boolean check = false;
        	for(int i=0;i<N;i++) {
        		if(snack[i]>= M) {
        			continue;
        		}
        		for(int j=i+1;j<N;j++) {
        			if(snack[i] + snack[j]> M) {
        				continue;
        			}
        			answer = Math.max(answer, snack[i] + snack[j]);
        			if(snack[i] + snack[j] == M) {	//만약 최대 무게와 같으면 더 찾을 필요 X
        				check = true;
        				break;
        			}
        		}
        		if(check == true) {
        			break;
        		}
        	}
        	if(answer == 0) {
        		answer = -1;
        	}
        	stringBuilder.append(answer);
        	System.out.println(stringBuilder);
        }   //tc
	}//main
}