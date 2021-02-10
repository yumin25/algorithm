n = int(input())
apt = [list(map(int, list(input()))) for _ in range(n)]

def dfs(apt,x,y):
    dx = [-1,1,0,0]
    dy = [0,0,1,-1]
    global count
    apt[x][y] = 0 # 다시 방문하지 않도록 0으로 바꿔준다
    
    for i in range(4):  #상하좌우 탐색
        nx = x + dx[i]
        ny = y + dy[i]

        if nx>=0 and nx<n and ny>=0 and ny<n:
            if apt[nx][ny] == 1:
                count +=1
                dfs(apt, nx, ny)

ans = []
count = 0
for i in range(n):
    for j in range(n):
        if apt[i][j] == 1: #집이 있을 경우
            count += 1
            dfs(apt,i,j)
            ans.append(count)
            count = 0
            
ans.sort()
print(len(ans))
print(*ans, sep='\n')
