from collections import deque

n, m = map(int, input().split())
maze = [list(map(int, list(input()))) for _ in range(n)]
visited = [[0]*m for _ in range(n)]
dx = [-1,1,0,0]
dy = [0,0,1,-1]
queue = deque()
queue.append((0,0))
visited[0][0] = 1

while queue:
    x, y = queue.popleft()
    for i in range(4):  #상하좌우 탐색
        nx = x + dx[i]
        ny = y + dy[i]
        if nx>=0 and nx<n and ny>=0 and ny<m and maze[nx][ny] == 1 and visited[nx][ny] == 0:
            queue.append((nx, ny))
            visited[nx][ny] = visited[x][y] +1 #방문횟수 적기

print(visited[n-1][m-1])
