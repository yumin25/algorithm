t = int(input())

for _ in range(t):
    n = int(input())
    count = 0
    candy =  list(map(int, input().split()))

    while True: #순환
        tmp, tmpcount =0, 0

        for i in range(n): #보충
            if candy[i]% 2 == 1:
                candy[i]+=1

            if candy[0] == candy[i]:
                tmpcount+=1
        
        if tmpcount == n:
            break
        
        for i in range(n):  #절반 나눠 주기
            tmp, candy[i] = candy[i]//2, candy[i]//2+tmp
        candy[0] += tmp
        
        count +=1        
        
    print(count)
