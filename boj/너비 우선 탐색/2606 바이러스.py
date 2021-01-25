def bfs():
    visited, queue = [], []
    queue.append(1)
    while queue:
        node = queue.pop(0)
        if node not in visited:
            visited.append(node)
            queue.extend(sorted(computer[node]))
    print(len(visited)-1)


n = int(input())
m = int(input())
computer = a = {i:[] for i in range(1,n+1)}
count = 0

for _ in range(m):
    i,j = map(int, input().split())
    computer[i].append(j)
    computer[j].append(i)

bfs()

