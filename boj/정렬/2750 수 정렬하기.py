n = int(input())
data = []

for i in range(n):  #데이터 넣어주면서 동시에 정렬
    data.append(int(input()))

    k=i
    while k > 0:
        if data[k] < data[k-1]:
            data[k], data[k-1] = data[k-1], data[k]
        else:
            break
        k -=1

for i in range(n):
    print(data[i])


    
