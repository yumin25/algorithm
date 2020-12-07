a = list(input())
ans = 0
zero = 0
one = 0

for i in range(len(a)-2):   #숫자가 달라질 경우 
    if a[i] != a[i+1]:
        if a[i]=='0':
            zero +=1
        else:
            one +=1

if a[len(a)-2] == a[len(a)-1]: #맨 마지막 처리
    if a[len(a)-2]=='0':
        zero +=1
    else:
        one +=1
else:
    zero +=1
    one+=1

print(min(zero,one))
