import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static int N, M, tmpN, D, tmpD;
	public static int answer= 0;
	public static int [][]enemy;
	public static int [][]tmpEnemy;
	public static int [][]tmpKill;	//임시로 죽일 적들 저장 
	public static int []number = new int[3];


	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
		N = Integer.parseInt(stringTokenizer.nextToken());
		M = Integer.parseInt(stringTokenizer.nextToken());
		D = Integer.parseInt(stringTokenizer.nextToken());
		enemy = new int[N][M];
		tmpEnemy = new int[N][M];
		tmpKill = new int[3][2];

		for(int i=0;i<N;i++) {
			stringTokenizer = new StringTokenizer(bufferedReader.readLine());
			for(int j=0;j<M;j++) {
				enemy[i][j]= Integer.parseInt(stringTokenizer.nextToken());
			}
		}

		Combination(0, 0);
		System.out.println(answer);
	}//main

	public static void Combination(int cnt, int start) {
		if(cnt == 3) {
			for(int i=0;i<N;i++) {
				for(int j=0;j<M;j++) {
					tmpEnemy[i][j]= enemy[i][j];
				}
			}
			fight();
			return;
		}
		for(int i=start;i<M;i++) {
			number[cnt] = i;
			Combination(cnt+1, i+1);
		}
	}

	public static void fight() {
		tmpN = N;
		tmpD = D;	//적 한 칸 아래로 이동할 때 tmpD++ 해준다.
		int tmpAnswer = 0;
		while (true) {
			if(tmpN<0) break;
			for(int i=0;i<3;i++) {	//-1로 초기화
				tmpKill[i][0] = -1;
				tmpKill[i][1] = -1;
			}

			for(int a=0;a<3;a++) {
				int tmpD1 = Integer.MAX_VALUE;	//가장 작은 거리값
				int tmpD2 = 0;	//해당 배열의 거리값 계산
				int ii = tmpN-1-D;
				if(ii <0) ii=0;

				for(int i=tmpN-1;i>=ii; i--) {	//ii를 그냥 0으로 해줘도 메모리, 시간 비슷
					for(int j=0;j<M;j++) {
						if(tmpEnemy[i][j]==1) {
							tmpD2 = Math.abs(N-i) + Math.abs(number[a]-j);					
							if(tmpD2 == tmpD1 && tmpD2 <=tmpD) {
								if(tmpKill[a][0]==-1 || (tmpKill[a][0]!= -1 && tmpKill[a][1]>j)) {
									tmpD1 = tmpD2;
									tmpKill[a][0] = i;
									tmpKill[a][1] = j;
								}
							}
							if(tmpD2 < tmpD1 && tmpD2 <=tmpD) {
								tmpD1 = tmpD2;
								tmpKill[a][0] = i;
								tmpKill[a][1] = j;
							}
						}
					}
				}//i
			}//a

			//적 배열 바꾸기
			for(int i=0;i<3;i++) {
				if(tmpKill[i][0]!=-1 && tmpKill[i][1]!=-1) {
					tmpEnemy[tmpKill[i][0]][tmpKill[i][1]] = 0;
				}
			}

			//중복 검사
			boolean same = false;
			for(int i=0;i<3;i++) {
				for(int j=i+1;j<3;j++) {
					if(tmpKill[i][0] == tmpKill[j][0] && tmpKill[i][1] == tmpKill[j][1]) same=true;
				}
				if(same == false && tmpKill[i][0]!=-1) {
					tmpAnswer++;
				}
				else
					same = false;
			}
			
			tmpN--;
			tmpD++;
		}//while
		
		answer = Math.max(answer, tmpAnswer);
	}

}