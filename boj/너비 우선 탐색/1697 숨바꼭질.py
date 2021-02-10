from collections import deque

n, k = map(int, input().split())
queue = deque()
queue.append((n,0))
visited = [0]*100001

while queue:
    node, time = queue.popleft()
    if node == k:#동생과 수빈이의 위치가 같을 시 종료
        print(time)
        break
    for i in (node-1, node+1, node*2):
        if 0<=i<100001 and visited[i] == 0:
            queue.append((i,time+1))
            visited[i] = 1
