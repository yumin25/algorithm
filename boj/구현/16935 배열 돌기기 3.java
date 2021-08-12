import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static int N;
	public static int M;
	public static int R;
	public static int C;
	public static int [][]arr;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());

		N = Integer.parseInt(stringTokenizer.nextToken());
		M = Integer.parseInt(stringTokenizer.nextToken());
		R = Integer.parseInt(stringTokenizer.nextToken());
		arr = new int[N][M];

		for(int i=0;i<N;i++) {
			stringTokenizer = new StringTokenizer(bufferedReader.readLine());
			for(int j=0;j<M;j++) {
				arr[i][j] = Integer.parseInt(stringTokenizer.nextToken());
			}
		}

		stringTokenizer = new StringTokenizer(bufferedReader.readLine());
		while(stringTokenizer.hasMoreTokens()) {
			C = Integer.parseInt(stringTokenizer.nextToken());
			if(C==1) function1();
			else if(C==2) function2();
			else if(C==3) function3();
			else if(C==4) function4();
			else if(C==5) function5();
			else if(C==6) function6();
		}

		StringBuilder stringBuilder = new StringBuilder();
		for(int i=0;i<N;i++) {
			for(int j=0;j<M;j++) {
				stringBuilder.append(arr[i][j]).append(" ");
			}
			stringBuilder.append("\n");
		}
		System.out.println(stringBuilder);
	}//main

	private static void function1() {
		int [][]tmp = new int[N][M];
		for(int i=0;i<N;i++) {
			for(int j=0;j<M;j++) {
				tmp[N-1-i][j]=arr[i][j];
			}
		}
		arr = tmp;
	}

	private static void function2() {
		int [][]tmp = new int[N][M];
		for(int i=0;i<N;i++) {
			for(int j=0;j<M;j++) {
				tmp[i][M-j-1] = arr[i][j];
			}
		}
		arr = tmp;
	}

	private static void function3() {
		int [][]tmp = new int[M][N];
		for(int j=0;j<M;j++) {
			for(int i=0;i<N;i++) {
				tmp[j][i] = arr[N-1-i][j];
			}
		}
		arr = tmp;
		int t = N;
		N= M;
		M=t;
	}

	private static void function4() {
		int [][]tmp = new int[M][N];
		for(int j=0;j<M;j++) {
			for(int i=0;i<N;i++) {
				tmp[M-1-j][i] = arr[i][j];
			}
		}
		arr = tmp;
		int t = N;
		N= M;
		M=t;
	}

	private static void function5() {
		int [][]tmp = new int[N][M];
		int s = 1;
		for(int i=0;i<N;i++) {
			for(int j=0;j<M;j++) {
				if(i==N/2 && j==0) {
					s*=-1;
				}
				if((s==1 &&j<M/2) || (s==-1 && j>=M/2)) {
					tmp[i][j+M/2*s] = arr[i][j];
				}
				else {
					tmp[i+N/2*s][j] = arr[i][j];
				}
			}
		}
		arr = tmp;
	}

	private static void function6() {
		int [][]tmp = new int[N][M];
		int s = 1;
		for(int j=0;j<M;j++) {
			for(int i=0;i<N;i++) {
				if(j==M/2 && i==0) {
					s*=-1;
				}
				if((s==1 &&i<N/2) || (s==-1 && i>=N/2)) {
					tmp[i+N/2*s][j] = arr[i][j];
				}
				else {
					tmp[i][j+M/2*s] = arr[i][j];
				}
			}
		}
		arr = tmp;
	}
}