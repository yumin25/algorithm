n = int(input())
b = list(map(int, input().split()))
a = []
sum = 0

for i in range(n):
    k = (i+1)*b[i] - sum
    a.append(str(k))
    sum += k

print(" ".join(a))

