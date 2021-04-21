def solution(answers):
    answer = []
    count = [0,0,0]
    student = [[1,2,3,4,5],[2,1,2,3,2,4,2,5],[3,3,1,1,2,2,4,4,5,5]]
    
    for i in range(len(answers)):
        for j in range(3):
            if answers[i] == student[j][i%len(student[j])]:
                count[j] += 1
                
    for i in range(3):
        if max(count) == count[i]:
            answer.append(i+1)
        
    answer.sort()
    return answer
