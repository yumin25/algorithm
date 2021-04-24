import sys
sys.setrecursionlimit(10000)

def dfs(v):
    visited[v]=True
    for i in graph[v]:
        if not visited[i]:
            dfs(i)

N, M = map(int, input().split())
graph = [[] for i in range(N+1)]
visited = [False]*(N+1)
count = 0
for _ in range(M):
    i,j = map(int, input().split())
    graph[i].append(j)
    graph[j].append(i)

for i in range(1,N+1):
    if visited[i] == False:
        count += 1
        dfs(i)

print(count)
