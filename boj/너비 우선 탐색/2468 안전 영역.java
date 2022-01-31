import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    public static int n, answer;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        int[][] arr = new int[n][n];
        StringTokenizer st; answer = 0;
        ArrayList<Integer> heightList = new ArrayList<>();
        heightList.add(0);
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
                if(!heightList.contains(arr[i][j])) heightList.add(arr[i][j]);
            }
        }
        for(int i:heightList) bfs(arr, i);
        System.out.println(answer);

    }//main
    
    public static void bfs(int[][] arr, int top){
        boolean [][]visited = new boolean[n][n];
        Queue<int[]> queue = new LinkedList<>();
        int []now;  int nx, ny, count = 0;
        int []dx = {0,0,1,-1};
        int []dy = {1,-1,0,0};

        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                if(visited[i][j] || arr[i][j]<=top) continue;
                queue.add(new int []{i,j});
                count++;
                while(!queue.isEmpty()){
                    now = queue.poll();
                    for(int z=0;z<4;z++){
                        nx = now[0] + dx[z];
                        ny = now[1] + dy[z];
                        if(nx<0 || ny<0 || nx>=n || ny>=n || visited[nx][ny]) continue;
                        visited[nx][ny]=true;
                        if(arr[nx][ny]>top) queue.add(new int[]{nx, ny});
                    }
                }
            }
        }
        answer = Math.max(answer, count);
    }//bfs
}