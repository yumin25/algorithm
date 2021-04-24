import sys
sys.setrecursionlimit(50000)

def dfs(cabbage,x,y):
    dx = [-1,1,0,0]
    dy = [0,0,-1,1]
    cabbage[x][y]=0
    
    for i in range(4):
        nx = x+dx[i]
        ny = y+dy[i]
        if nx>=0 and nx<N and ny>=0 and ny<M:
            if cabbage[nx][ny] == 1:
                dfs(cabbage, nx, ny)
        
        
T = int(input())
for _ in range(T):
    M, N, K = map(int, input().split())
    cabbage = [[0]*M for _ in range(N)]
    visited = [[0]*M for _ in range(N)]
    count = 0
    
    for i in range(K):  #입력받기
        a, b= map(int, input().split())
        cabbage[b][a] = 1

    for i in range(N):
        for j in range(M):
            if cabbage[i][j] and not visited[i][j]:
                visited[i][j]=1
                count +=1
                dfs(cabbage,i,j)

    print(count)
