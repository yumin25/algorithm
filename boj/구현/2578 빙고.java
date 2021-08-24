import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int [][]arr= new int[5][5];
		int answer = 0;
		
		for(int i=0;i<5;i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int j=0;j<5;j++) arr[i][j]= Integer.parseInt(st.nextToken());
		}
		boolean check = false;
		
		for(int i=1;i<6;i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int j=1;j<6;j++) {
				answer++;
				int tmp = Integer.parseInt(st.nextToken());
				check(tmp, arr);
				if(bingo(arr)>=3) {
					check=true;
					System.out.println(answer);
					break;
				}
			}
			if(check==true)break;
		}
	}
	
	public static void check(int tmp, int [][]arr) {
		for(int i=0;i<5;i++) {
			for(int j=0;j<5;j++) {
				if(arr[i][j]==tmp) {
					arr[i][j]=0;
					return;
				}
			}
		}
	}
	
	public static int bingo(int [][]arr) {
		int count=0;
		int tmpcount=0;
		for(int i=0;i<5;i++) {	//가로
			tmpcount=0;
			for(int j=0;j<5;j++) {
				if(arr[i][j]==0) tmpcount++;
			}
			if(tmpcount==5) count++;
		}
		for(int j=0;j<5;j++) {	//세로
			tmpcount=0;
			for(int i=0;i<5;i++) {
				if(arr[i][j]==0) tmpcount++;
			}
			if(tmpcount==5) count++;
		}
		tmpcount=0;
		for(int i=0;i<5;i++) {	//대각선(왼-오)
			if(arr[i][i]==0) tmpcount++;
		}
		if(tmpcount==5) count++;
		tmpcount=0;
		for(int i=0;i<5;i++) {	//대각선(오-왼)
			if(arr[i][4-i]==0) tmpcount++;
		}
		if(tmpcount==5) count++;
		return count;
	}//bingo	
}
