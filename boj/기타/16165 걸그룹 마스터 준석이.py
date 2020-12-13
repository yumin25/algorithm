n, m = map(int, (input().split()))
group = {}

for i in range(n):
    group_name = input()
    group_number = int(input())
    group[group_name] = []
    
    for j in range(group_number):
        group[group_name].append(input())

for i in range(m):
    name = input()
    num = int(input())
    if num == 1:    #멤버의 이름이 주어질 경우
        for k, v in group.items():
            for j in v:
                if j == name:
                    print(k)
    else:   #팀 이름 주어질 경우 
        group[name].sort()
        print("\n".join(group[name]))
