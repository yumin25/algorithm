a = int(input())
for i in range(4,-1,-1):
    b = (a//(10**i))*(10**i)
    print("["+str(b)+"]")
    a = a-b
