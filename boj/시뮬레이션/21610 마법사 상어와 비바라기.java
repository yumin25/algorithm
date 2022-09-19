import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int [][]arr;
    static int N, M;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        arr = new int[N][N];
        int answer = 0, m=0, c=0;

        for(int i=0;i<N;i++) {  //격자 입력
            st = new StringTokenizer(br.readLine());
            for(int j=0;j<N;j++) arr[i][j]= Integer.parseInt(st.nextToken());
        }
        ArrayList<int[]> cloud = new ArrayList<>(); //초기 구름
        cloud.add(new int[]{N-1, 0}); cloud.add(new int[]{N-1, 1});
        cloud.add(new int[]{N-2, 0}); cloud.add(new int[]{N-2, 1});

        for(int i=0;i<M;i++) {
            st = new StringTokenizer(br.readLine());
            m = Integer.parseInt(st.nextToken());
            c = Integer.parseInt(st.nextToken());
            cloud = rain(cloud, m, c);
        }

        for(int i=0;i< N;i++){  //물의 양 합 구하기
            for(int j=0;j< N;j++) answer += arr[i][j];
        }
        System.out.println(answer);
    }

    public static ArrayList<int[]> rain(ArrayList<int[]> before, int m, int c){
        ArrayList<int[]> now = new ArrayList<>();   //현재 구름 위치
        boolean [][]nowC = new boolean[N][N];   //현재 구름 위치
        ArrayList<int[]> next = new ArrayList<>();  //다음 구름 위치
        int[] cloud = new int[2];
        int []dx = {0,-1,-1,-1,0,1,1,1};    //이동
        int []dy = {-1,-1,0,1,1,1,0,-1};
        int []nx = {-1,-1,1,1}; //대각선
        int []ny = {-1,1,1,-1};
        for(int i=0;i<before.size();i++){   //구름 이동
            cloud = before.get(i);
            cloud[0] = cloud[0] + (dx[m-1]*c)%N;
            cloud[1] = cloud[1] + (dy[m-1]*c)%N;

            if(cloud[0]<0) cloud[0]+=N;
            else if(cloud[0]>=N) cloud[0]-=N;
            if(cloud[1]<0) cloud[1]+=N;
            else if(cloud[1]>=N) cloud[1]-=N;

            now.add(new int[]{cloud[0], cloud[1]});
            nowC[cloud[0]][cloud[1]]=true;
        }

        for(int i=0;i<now.size();i++){
            cloud = now.get(i);
            arr[cloud[0]][cloud[1]] +=1;    //비 내림
            int nextX=0, nextY=0;
            for(int j=0;j<4;j++){   //대각선 물복사버그
                nextX = cloud[0] + nx[j];
                nextY = cloud[1] + ny[j];
                if(nextX<0 || nextX>=N) continue;
                if(nextY<0 || nextY>=N) continue;
                if(arr[nextX][nextY]==0){
                    for(int k=i;k<now.size();k++){  //아직 물복사버그 체크 안 해준 구름 중 원래 값이 0이었는데 1이 될 예정인 구름
                        if(nextX==now.get(k)[0]  && nextY==now.get(k)[1]) arr[cloud[0]][cloud[1]]++;
                    }
                }
                else arr[cloud[0]][cloud[1]]++;
            }
        }

        for(int i=0;i<N;i++){
            for(int j=0;j<N;j++){
                if(nowC[i][j]) continue;
                if(arr[i][j]>=2){
                    arr[i][j]-=2;
                    next.add(new int[]{i,j});
                }
            }
        }
        return next;
    }
}