import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    public static int n, m, army, enemy;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        m = Integer.parseInt(st.nextToken());
        n = Integer.parseInt(st.nextToken());
        army = 0; enemy = 0;
        char[][] arr = new char[n][m];
        for(int i=0;i<n;i++) arr[i] = br.readLine().toCharArray();
        bfs(arr);
        System.out.println(army + " " + enemy);
    }

    public static void bfs(char[][] arr){
        Queue<int[]> queue = new LinkedList<>();
        boolean [][]visited = new boolean[n][m];
        int []dx = {0,0,1,-1};
        int []dy = {1,-1,0,0};
        int nx, ny, tmp = 0 ; int []now;

        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(visited[i][j]) continue;
                visited[i][j] = true;
                tmp = 1;
                queue.add(new int[]{i,j});
                while (!queue.isEmpty()) {
                    now = queue.poll();
                    for(int z=0;z<4;z++){
                        nx = now[0] + dx[z];
                        ny = now[1] + dy[z];
                        if(nx<0 || nx>=n ||  ny<0 || ny>=m || visited[nx][ny]) continue;
                        if(arr[i][j] != arr[nx][ny]) continue;
                        queue.add(new int[]{nx, ny});
                        visited[nx][ny] = true;
                        tmp++;
                    }
                }
                if(arr[i][j]=='W') army += tmp * tmp;
                else if(arr[i][j]=='B') enemy += tmp * tmp;
            }
        }
    }
}
