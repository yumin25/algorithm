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
            int[][] num = new int[100][100];
            int t = Integer.parseInt(br.readLine());
             
            for(int i=0;i<100;i++) {
                StringTokenizer st = new StringTokenizer(br.readLine(), " ");
                for(int j=0;j<100;j++) {
                num[i][j]= Integer.parseInt(st.nextToken());
                }
            }   // ÀÔÃâ·Â
            
            for(int i=0;i<100;i++) {
                boolean tmp = false;
                if(num[0][i] == 1) {
                    tmp = ladder(i, num);
                }
                if(tmp == true) {
                    result = i;
                    sb.append(result).append("\n");
                    break;
                }
            }           
        }
		System.out.println(sb);
    }//main
	
	private static boolean ladder(Integer n, int[][] num) {
        int x=0;
        int y=n;
        boolean [][]visited = new boolean[100][100];
 
        while(x<100) {
            visited[x][y]=true;
            if(num[x][y] == 2) {
                return true;
            }
            if((y+1)<100 && num[x][y+1] ==1 && visited[x][y+1]==false) {
                y++;
            }else if((y-1)>=0 && num[x][y-1] ==1 && visited[x][y-1]==false) {
                y--;
            }else {
                x++;
            }   
        }
        return false;
    }
	
}