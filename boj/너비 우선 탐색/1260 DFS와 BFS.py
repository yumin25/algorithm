n, m, v = map(int, input().split())
graph = {i:[] for i in range(1,n+1)}

for _ in range(m):
    i,j = map(int, input().split())
    graph[i].append(j)
    graph[j].append(i)


def bfs():
    visited, queue = [], []
    queue.append(v)
    while queue:
        node = queue.pop(0)
        if node not in visited:
            visited.append(node)
            queue.extend(sorted(graph[node]))
    print(*visited, sep=' ')            

def dfs():
    visited, stack = [], []
    stack.append(v)
    
    while stack:
        node = stack.pop()
        if node not in visited:
            visited.append(node)
            stack.extend(sorted(graph[node], reverse=True))
    print(*visited, sep=' ')            

dfs()
bfs()
