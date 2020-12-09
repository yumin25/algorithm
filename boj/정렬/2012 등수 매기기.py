n = int(input())
b = []
ans = 0

for _ in range(n):
    b.append(int(input()))
             
b.sort()

for i in range(n):
    ans += abs(i+1-b[i])
        
print(ans)
