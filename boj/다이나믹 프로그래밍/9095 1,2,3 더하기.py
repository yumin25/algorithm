t = int(input())
dp = [0,1,2,4]  #dp[i] == i를 만들 수 있는 방법의 수

for i in range(4,11):
    dp.append(dp[i-1]+dp[i-2]+dp[i-3])  #n은 11보다 작으니 미리 계산
    
for _ in range(t):
    n = int(input())
    print(dp[n])
    
