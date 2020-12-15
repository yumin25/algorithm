n = int(input())
count = [0]*(n+1)
count[0] = 0
count[1] = 1

for i in range(n+1):
    if i>1:
        count[i] = count[i-1] + count[i-2]
        
print(count[n])
