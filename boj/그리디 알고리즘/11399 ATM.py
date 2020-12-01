num = int(input())  #사람 수
p = list(map(int, input().split()))     #시간
ans = 0
time = 0

for k in range(num):
    i = 0
    
    while i <num-1:
        if p[i]>p[i+1]:     #버블 정렬
            tmp = p[i+1]
            p[i+1] = p[i]
            p[i]=tmp
        i = i+1
        
for i in range(num):        #합계
    time = time + p[i]
    ans = ans + time
print(ans)
