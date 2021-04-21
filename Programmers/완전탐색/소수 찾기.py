import itertools
import math

def isPrime(number):    #소수 판별
    a = int(math.sqrt(number))
    if number < 2:
        return False
    if number != 2 and number % 2 == 0: #2 제외 짝수는 소수가 아니다
        return False
    for i in range(3,a+1,2):
        if number % i == 0:
            return False
    return True

def solution(numbers):
    answer = 0
    make = []
    for i in range(1,len(numbers)+1):
        p = list(map(int, map("".join, itertools.permutations(list(numbers), i))))
        make.extend(p)
    make = list(set(make))
    for i in make:
        if isPrime(i):
                answer += 1
    return answer
