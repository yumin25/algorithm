import math

m = int(input())
n = int(input())
ans = []
sum = 0

for i in range(m,n+1):
    div = int(math.sqrt(i))
    prime = True
    if i == 1:
        prime = False
    for j in range(2,div+1):    #소수라면 2~i의 제곱근까지 수 중 나누어 떨어지는 수 존재 X
        if i % j == 0:
            prime = False
            break
    if prime == True:
        ans.append(i)
        sum += i

if not ans:
    print("-1")
else:
    print(sum)
    print(ans[0])

