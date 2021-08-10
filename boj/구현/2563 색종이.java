import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(bufferedReader.readLine());
		int [][]paper = new int[101][101];
		int count = 0;

		for(int t=0;t<N;t++) {
			StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
			int left = Integer.parseInt(stringTokenizer.nextToken());// y. 그대로. 색종이 맨 왼쪽
			int top = Integer.parseInt(stringTokenizer.nextToken());//x. 100-right-10. 색종이 맨 위.
			top = 100-top-10;
			
			
			for(int i=top;i<top+10;i++) {
				for(int j=left;j<left+10;j++) {
					if(paper[i][j]==0) {
						paper[i][j]=1;
						count++;
					}
				}
			}			
		}
		System.out.println(count);
	}
}