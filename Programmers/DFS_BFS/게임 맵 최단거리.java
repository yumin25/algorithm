import java.util.*;

class Solution {
    public static int answer;
    public int solution(int[][] maps) {
        answer = 0;
        bfs(maps);
        return answer;
    }
    
    public void bfs(int[][] maps){
        int n = maps.length;
        int m = maps[0].length;
        int [][]visited = new int[n][m];
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{0,0});
        int []now; int nx, ny;
        int []dx = {0,0,1,-1};
        int []dy = {1,-1,0,0};
        
        while(!queue.isEmpty()){
            now = queue.poll();
            for(int i=0;i<4;i++){
                nx = dx[i] + now[0];
                ny = dy[i] + now[1];
                if(nx<0 || ny<0 || nx>=n || ny>=m || visited[nx][ny]!=0 || maps[nx][ny]==0) continue;
                visited[nx][ny]=visited[now[0]][now[1]]+1;
                queue.add(new int[]{nx, ny});
            }
        }
        if(visited[n-1][m-1] !=0) answer = visited[n-1][m-1]+1;
        else answer = -1;
        return;
    }
}