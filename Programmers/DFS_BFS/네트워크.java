import java.util.*;

class Solution {
    public boolean []visited;
    public int answer;
    
    public int solution(int n, int[][] computers) {
        visited = new boolean[n];
        answer = 0;
        for(int i=0;i<n;i++){
            if(!visited[i]) {
                answer++;
                bfs(n, computers, i);
            }
        }
        return answer;
    }
    
    public void bfs(int n, int[][] computers, int i){
        Queue<Integer> queue = new LinkedList<>();
        queue.add(i); visited[i]=true;
        int now = 0;
        
        while(!queue.isEmpty()){
            now = queue.poll();
            visited[now] = true;
            for(int j=0;j<n;j++){
                if(j==now) continue;
                if(computers[now][j] == 1 && !visited[j]) queue.add(j);
            }
        }
        return;
    }
}