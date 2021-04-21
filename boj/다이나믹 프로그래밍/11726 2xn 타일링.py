n = int(input())

num = [0,1,2,3]

for i in range(len(num),n+1):
    num.append(num[i-1]+num[i-2])

print(num[n]%10007)
