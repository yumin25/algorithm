a,b,c = map(int, input().split())

if c <= b:
    print(-1)
else:
    ans = int(a / (c-b) +1)
    print(ans)
