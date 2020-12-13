n = int(input())
coor = []

for i in range(n):
    data = input().split(" ")
    coor.append((int(data[0]), int(data[1])))

coor.sort()

for i in range(n):
    print(coor[i][0], coor[i][1])
