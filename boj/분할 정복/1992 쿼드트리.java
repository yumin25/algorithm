import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main{

	public static char [][]arr;
	public static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader bufferedReader= new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(bufferedReader.readLine());
		arr = new char[N][N];
		String tmp;

		for(int i=0;i<N;i++) {
			tmp = bufferedReader.readLine();
			for(int j=0;j<N;j++) arr[i][j]= tmp.charAt(j);	//입력받기 
		}

		if(N==1) sb.append(arr[0][0]);	//1일 경우 쿼드 트리 연산할 필요 x
		else tree(N,0,0);	//1이 아니면 쿼드 트리 연산 수행
		
		System.out.println(sb);	
	}
	
	public static void tree(int len, int x, int y) {
		if(len==1) return;	//1일 경우 쿼드 트리 연산할 필요 x

		boolean check = false;
		char tmpCheck = arr[x][y];
		
		for(int i=x; i<x+len;i++) {	// 전부 하나의 숫자로 이루어져 있는지 확인
			for(int j=y; j<y+len;j++) {
				if(arr[i][j]!=tmpCheck) check=true;
			}
			if(check==true) break;
		}
		if(check==false) sb.append(tmpCheck);
		
		else {	//전부 같지 않다면 4개로 쪼개기
			sb.append('(');
			int length = len/2;
			int []startX = {x, x, x+length, x+length};
			int []startY = {y, y+length, y, y+length};
			int []endX = {x+length,x+length, x+length*2, x+length*2};
			int []endY = {y+length, y+length*2, y+length, y+length*2};

			for(int t=0;t<4;t++) {	//4개로 나눈 뒤 그 안에서 전부 같은지 확인
				tmpCheck = arr[startX[t]][startY[t]];
				check = false;

				for(int i=startX[t]; i<endX[t];i++) {
					for(int j=startY[t]; j<endY[t];j++) {
						if(arr[i][j]!=tmpCheck) check=true;
					}
					if(check==true) break;
				}

				if(check==false) sb.append(tmpCheck);
				else tree(length, startX[t], startY[t]);	//전부 같지 않다면 쿼드 트리 연산 수행
			}	
			sb.append(')');
		}
	}	//tree 함수 끝
}