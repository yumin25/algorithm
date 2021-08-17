import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static int count=0;
	public static int answer=0;
	public static int N,R,C, len;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
		N = Integer.parseInt(stringTokenizer.nextToken());
		R = Integer.parseInt(stringTokenizer.nextToken());
		C = Integer.parseInt(stringTokenizer.nextToken());
		len = (int)Math.pow(2, N);
		recur(len, 0, 0);
		System.out.println(answer-1);	//처음 0부터 세주기 때문에 1을 빼준다.
	}//main

	public static void recur(int len, int r, int c) {
		int []dx = {0,0,1,1};
		int []dy = {0,1,0,1};
		if(len==2) {
			for(int i=0;i<4;i++) {	//만약 크기가 2라면 z방향으로 검색
				count++;
				if(r+dx[i] == R && c+dy[i]==C) {
					answer=count;
					return;
				}
			}
			return;
		}
		len = len/2;
		if(r+len >R && c+len>C) recur(len,r,c);	//4개로 나눴을 때 왼쪽 위에 포함된다면
		else if(r+len >R && c+len+len>C) {	//4개로 나눴을 때 오른쪽 위에 포함된다면
			count += len*len;
			recur(len,r,c+len);
		}
		else if(r+len+len >R && c+len>C) {	//4개로 나눴을 때 왼쪽 아래에 포함된다면
			count += len*len*2;
			recur(len,r+len,c);
		}
		else if(r+len+len >R && c+len+len>C) {	//4개로 나눴을 때 오른쪽 아래에 포함된다면
			count += len*len*3;
			recur(len,r+len,c+len);
		}
	}
}