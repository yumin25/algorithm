n,k = map(int, input().split(" "))
a = []
coin = 0 //동전 개수

for i in range(0,n):
    b = int(input())
    a.append(b)

a.reverse() //내림차순으로 바꾸기
for i in range(0,n):
    c = k//a[i]
    
    if c >= 1:
        coin += c
        k = k%a[i]

print(coin)
