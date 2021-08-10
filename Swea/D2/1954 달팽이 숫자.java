import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {
	public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
         
        for(int tc = 1;tc<11;tc++) {
            StringBuilder sb = new StringBuilder();
            int n = Integer.parseInt(br.readLine());
            int resultn = n;
            int [][]snail = new int[n][n];
            int num=1;
            int x=0;
            int y=0;
            int tmp=1;
             
            while(true) {
                for(int i=0;i<n;i++) {
                    snail[x][y]=num;
                    num += 1;
                    y +=tmp;
                }
                n--;
                x +=tmp;
                y -=tmp;
                 
                if(resultn*resultn<num) {
                    break;
                }
                 
                for(int i=0;i<n;i++) {
                    snail[x][y]=num;
                    num += 1;
                    x +=tmp;
                }
                x -=tmp;
                y-=tmp;
                tmp = tmp*-1;
            }
             
            sb.append("#").append(resultn).append("\n");
            for(int i=0;i<resultn;i++) { //print
                for(int j=0;j<resultn;j++) {
                    sb.append(snail[i][j]).append(" ");
                }
                if(i != resultn-1) {
                    sb.append("\n");
                }
            }
            System.out.println(sb);
        }   //tc
	}//main
}