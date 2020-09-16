n = int(input())
count = -1
quotient5 = n//5
remainder5 = n % 5

if remainder5 == 0:
        count = quotient5

else:
    for i in range(quotient5,-1, -1):
        remainder3 = remainder5 % 3
        
        if remainder3 == 0:
            quotient3 = remainder5//3
            count = quotient5 + quotient3
            
        else:
            quotient5-=1
            remainder5 = remainder5 +5
        
print(count)
