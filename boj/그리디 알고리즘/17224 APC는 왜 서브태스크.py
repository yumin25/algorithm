n, l, k = map(int, input().split())
grade = [[0,0]]*n
sub1, sub2 = 100, 140
mygrade = 0
count = 0

for i in range(n):
    grade[i] = list(map(int, input().split()))

    if l>=grade[i][1]:
        if count >0 and k<=0:
            count -=1
            mygrade +=40
        elif k >0:
            k-=1
            mygrade += 140
    elif l>=grade[i][0]:
        if k>0:
            k-=1
            mygrade += 100
            count +=1

print(mygrade)
