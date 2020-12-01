n,m = map(int, input().split())
a = list(map(int, input().split()))
ans = 0

for i in range(n):
    for k in range(i+1,n):        
        for j in range(k+1,n):
            tmp = a[i]+a[k]+a[j]
            if tmp<=m and tmp>ans:
                ans = tmp

print(ans)
