import java.io.BufferedReader;
import java.util.ArrayList;
import java.util.StringTokenizer;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {	
	public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
         
        for(int tc = 1;tc<11;tc++) {
        	int N = Integer.parseInt(br.readLine());
        	ArrayList<Integer> original = new ArrayList();
        	StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        	StringBuilder sb = new StringBuilder();
        	for(int i=0;i<N;i++) {
        		original.add(Integer.parseInt(st.nextToken()));
        	}//암호문 채우기
        	
        	int num = Integer.parseInt(br.readLine());
        	st = new StringTokenizer(br.readLine(), " ");
        	for(int i=0;i<num;i++) {
        		st.nextToken();	//I
        		int x = Integer.parseInt(st.nextToken());
        		int y = Integer.parseInt(st.nextToken());
        		for(int j=0;j<y;j++) {
        			original.add(x+j,Integer.parseInt(st.nextToken()));
        		}
        	}
        	sb.append("#").append(tc).append(" ");
        	
        	for(int i=0;i<10;i++) {
        		sb.append(original.get(i)).append(" "); 
        	}
        	
        	System.out.println(sb);
        }   //tc
	}//main
}