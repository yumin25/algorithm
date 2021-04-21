t = int(input())

fibo = [[1,0], [0,1]]

for i in range(t):
    n = int(input())
    for j in range(len(fibo), n+1):
        fibo.append([fibo[j-1][0]+fibo[j-2][0], fibo[j-1][1]+fibo[j-2][1]])
    print(*fibo[n])

