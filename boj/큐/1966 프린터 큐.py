a = int(input())

for i in range(0,a):
    n, m= map(int, input().split())
    im = list(map(int, input().split()))
    num = 0
    count = 1

    while im:
        while count < len(im):
            if im[0]<im[count]:
                if m==0:
                    m=len(im)-1
                else:
                    m -=1
                    
                im.append(im.pop(0))
                count = 1
                
            else:
                count += 1

        num +=1
        count = 1
        if m==0:
            break
        else:
            m-=1
        im.pop(0)

        
    print(num)
            
