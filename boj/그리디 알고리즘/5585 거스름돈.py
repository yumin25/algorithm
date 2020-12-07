a = int(input())
n = 1000-a
money = [500,100,50,10,5,1]
ans = 0

for i in money:
    ans += n // i
    n = n % i

print(ans)
