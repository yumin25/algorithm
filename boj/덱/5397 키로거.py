n = int(input())

for _ in range(n):
    word = list(input())
    
    ans1 = []
    ans2 = []
    
    for i in range(0,len(word)):        
        if word[i] == "<":
            if ans1:
                ans2.append(ans1.pop())
                
        elif word[i] == ">":
            if ans2:
                ans1.append(ans2.pop())

        elif word[i] == "-":
            if ans1:
                ans1.pop()

        else:
            ans1.append(word[i])

    ans2.reverse()
    print("".join(ans1)+"".join(ans2))
            
            
                
