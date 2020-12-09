a = int(input())

for _ in range(a):
    f = int(input())
    check = {}
    b = [[] for i in range(f)]
    
    for i in range(f):
        f1, f2 = input().split(" ")
        if f1 not in check and f2 not in check: #둘 다 관계 x
            check[f1] = i
            check[f2] = i
            b[i].extend([f1, f2])
            print("2")

        else:
            if f1 in check and f2 in check: #둘 다 관계가 있을 경우
                k = check[f1]
                j = check[f2]
                if k != j:                    
                    tmp_min = min(k,j)
                    tmp_max = max(k,j)
                    k = tmp_min
                    j = tmp_max
                    b[k].extend(b[j])
                    check[f1] = k
                    check[f2] = k
                    for o in b[j]:
                        check[o] = k
                
            elif f1 in check:   #한 명만 관계가 있을 경우 
                k = check[f1]
                check[f2] = k
                b[k].append(f2)
                
            elif f2 in check:
                k = check[f2]
                check[f1] = k
                b[k].append(f1)
            print(len(b[k]))


