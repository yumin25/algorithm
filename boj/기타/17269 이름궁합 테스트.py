n ,m = map(int, input().split())
a, b = map(str, input().split())

word = [3,2,1,2,4,3,1,3,1,1,3,1,3,2,1,2,2,2,1,2,1,1,1,2,2,1]
ans = []
tmp = []

for i in range(len(a)+len(b)):
    if i > len(a)-1:
        ans.extend(b[i:])
        break
    if i > len(b)-1:
        ans.extend(a[i:])
        break
    else:
        ans.append(a[i])
        ans.append(b[i])
        
for i in range(len(ans)):
    k = ord(ans[i])-65    
    tmp.append(word[k])

while len(ans) !=2:
    ans = []
    for i in range(len(tmp)-1):
        k = int(tmp[i])+int(tmp[i+1])
        if k // 10 == 1:
            ans.append(k%10)
        else:
            ans.append(k)
    tmp = ans

if ans[0]==0:
    pass
else:
    print(ans[0], end='')
print(ans[1], end='')
print("%")
