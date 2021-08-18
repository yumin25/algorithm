import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
	private static int answer;
	private static int userX1 = 1;
	private static int userY1 = 1;
	private static int userX2 = 10;
	private static int userY2 = 10;
	private static int []userA;
	private static int []userB;
	private static int [][]ap;
	private static int A;
	private static boolean []checkA;
	private static boolean []checkB;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(bufferedReader.readLine());
		StringBuilder stringBuilder = new StringBuilder();
		for(int tc=0;tc<T;tc++) {
			StringTokenizer stringTokenizer= new StringTokenizer(bufferedReader.readLine());
			int M = Integer.parseInt(stringTokenizer.nextToken());
			A = Integer.parseInt(stringTokenizer.nextToken());
			userA = new int[M]; 
			userB = new int[M];
			ap = new int[A][4];
			answer = 0;
			userX1 = 1; userY1 = 1; userX2 = 10; userY2 = 10;
			stringBuilder.append("#").append(tc+1).append(" ");

			stringTokenizer= new StringTokenizer(bufferedReader.readLine());
			for(int i=0;i<M;i++) {	
				userA[i] = Integer.parseInt(stringTokenizer.nextToken());
			}
			stringTokenizer= new StringTokenizer(bufferedReader.readLine());
			for(int i=0;i<M;i++) {
				userB[i] = Integer.parseInt(stringTokenizer.nextToken());
			}
			for(int i=0;i<A;i++) {
				stringTokenizer= new StringTokenizer(bufferedReader.readLine());
				for(int j=0;j<4;j++) {
					ap[i][j] = Integer.parseInt(stringTokenizer.nextToken());
				}
			}//ap 입력받기
			for(int i=0;i<M+1;i++) {//움직일 때마다
				checkA = new boolean[A];
				checkB = new boolean[A];
				int tmpanswer = 0;
				int tmpuser1 = 0;
				int tmpuser2 = 0;
				boolean c = false;

				check();
				for(int j=0;j<A;j++) {
					if(checkA[j]==true) tmpuser1 = Math.max(tmpuser1, ap[j][3]);
					if(checkB[j]==true) tmpuser2 = Math.max(tmpuser2, ap[j][3]);
					if(checkA[j] == true && checkB[j]==true) c=true;
				}				
				
				if(c==false) {
					 answer += tmpuser1+tmpuser2;
				}
				if(c==true) {
					for(int j=0;j<A;j++) {
						if(checkA[j]==false) continue;
						for(int k=0;k<A;k++) {
							if(checkB[k]==false) continue;
							if(j==k) {
								tmpanswer = Math.max(tmpanswer, ap[k][3]);
							}
							else{
								tmpanswer = Math.max(tmpanswer, ap[j][3]+ap[k][3]);
							}
						}
					}
					answer += tmpanswer;
				}
				if(i!=M)move(i);
			}
			stringBuilder.append(answer).append("\n");
		}
		System.out.println(stringBuilder);
	}

	public static void move(int i) {
		if(userA[i]==1) userY1--;
		else if(userA[i]==2) userX1++;
		else if(userA[i]==3) userY1++;
		else if(userA[i]==4) userX1--;
		if(userB[i]==1) userY2--;
		else if(userB[i]==2) userX2++;
		else if(userB[i]==3) userY2++;
		else if(userB[i]==4) userX2--;
	}
	
	public static void check() {
		for(int i=0;i<A;i++) {
			if(Math.abs(ap[i][0]-userX1)+Math.abs(ap[i][1]-userY1)<=ap[i][2]) checkA[i]=true;
			if(Math.abs(ap[i][0]-userX2)+Math.abs(ap[i][1]-userY2)<=ap[i][2]) checkB[i]=true;
		}
	}

}
