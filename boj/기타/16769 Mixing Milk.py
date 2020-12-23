def pour(a,b):
    if b[0]<a[1]+b[1]:
        a[1]=a[1]+b[1]-b[0]
        b[1]=b[0]
    else:
        b[1] = a[1]+b[1]
        a[1] = 0

a = [[0,0], [0,0], [0,0]]

for i in range(3):
    a[i][0] ,a[i][1] = map(int, (input()).split())

for i in range(100):
    tmp = i % 3
    pour(a[tmp], a[(tmp+1)%3])

for i in range(3):
    print(a[i][1])
