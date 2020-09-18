n = int(input())
a = []

for i in range(0,n):
    a.append(int(input()))

a.sort()
ans = a[n-1]

for i in range(0,n):
    b = a[i]*(n-i)
    
    if b > ans:
        ans = b

print(ans)
