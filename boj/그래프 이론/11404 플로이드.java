import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int INF = 10000000;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());
        int [][]arr = new int[N][N];
        StringTokenizer st; int start, end;

        for(int i=0;i<N;i++){
            for(int j=0;j<N;j++) if(i!=j) arr[i][j]=INF;
        }

        for(int i=0;i<M;i++){
            st = new StringTokenizer(br.readLine());
            start = Integer.parseInt(st.nextToken())-1;
            end = Integer.parseInt(st.nextToken())-1;
            arr[start][end] = Integer.min(Integer.parseInt(st.nextToken()), arr[start][end]);
        }

        for(int k=0;k<N;k++){
            for(int i=0;i<N;i++){
                for(int j=0;j<N;j++) if(arr[i][j]>arr[i][k]+arr[k][j]) arr[i][j] = arr[i][k]+arr[k][j];
            }
        }

        StringBuilder sb = new StringBuilder();
        for(int i=0;i<N;i++) {
            for (int j = 0; j < N; j++) {
                if(arr[i][j]==INF) sb.append(0).append(" ");
                else sb.append(arr[i][j]).append(" ");
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }
}
