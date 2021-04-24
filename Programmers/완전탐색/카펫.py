def solution(brown, yellow):
    for i in range(1,yellow+1): #노란색의 가로, 세로 길이 구하기
        if yellow % i == 0:
            if (i*2 + yellow//i*2 + 4) == brown:
                answer = [i+2,yellow//i+2]
                
    print(answer)
    return answer
