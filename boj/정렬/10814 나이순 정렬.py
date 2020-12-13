n = int(input())
member = {}

for i in range(n):
    age, name = map(str, input().split())
    age = int(age)
    if age in member:
        member[age].append(name)
    else:
        member[age] = [name]

key = list(member.keys())
key.sort()

for i in key:
    for j in member[i]:
        print(i,j)
