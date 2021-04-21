def solution(n, lost, reserve):
    answer = n-len(lost)
    delete = []
    
    for i in lost:
        for j in reserve:
            if i == j:
                delete.append(i)
                answer +=1
                print(answer)
                break
                
    for i in delete:
        lost.remove(i)
        reserve.remove(i)
    
    for i in lost:
        for j in range(0,len(reserve)):
            if i ==reserve[j]-1 or i ==reserve[j]+1:
                del reserve[j]
                answer +=1
                break
    return answer
