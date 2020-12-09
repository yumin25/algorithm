n = int(input())
crane = list(map(int, input().split(" ")))
crane.sort(reverse=True)

m = int(input())   #박스 수
box = list(map(int, input().split(" ")))
box.sort(reverse=True)

ans = 0

while box and ans != -1:
    ans += 1
    b = 0

    if crane[0] < box[0]:   #옮길 수 없음 
        ans = -1
        break
    
    for c in range(n):
        if b>= len(box):
            break
        while b <len(box)-1 and crane[c] < box[b]:
            b +=1
            
        if crane[c] >= box[b]:           
            del box[b]          

        if not box:
            break

print(ans)
