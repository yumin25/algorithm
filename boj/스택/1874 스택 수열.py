a = int(input())
sequence = []
tmp = []
tmp_num = 1
ans = []

for i in range(a):
    sequence.append(int(input()))

for i in range(a):
    while tmp_num <= sequence[i]:
        tmp.append(tmp_num)
        tmp_num += 1
        ans.append("+")
        
    if tmp[-1] == sequence[i]:
        del tmp[-1]
        ans.append("-")

if tmp:
    print("NO")
else:
    print(*ans, sep='\n')
    
