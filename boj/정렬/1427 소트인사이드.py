a = list(input())

for i in range(len(a)-1):   #선택 정렬
    data = i

    for k in range(i+1, len(a)):
        if int(a[data]) < int(a[k]):
            data = k

    a[i], a[data] = a[data], a[i]

print("".join(a))
