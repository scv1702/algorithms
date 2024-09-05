from math import sqrt

def divisor(n):
    cnt = 0
    for i in range(1, int(sqrt(n)) + 1):
        if n % i == 0:
            cnt += 1
            if (i != n // i): cnt += 1
    return cnt

def solution(number, limit, power):
    answer = 0
    for n in range(1, number + 1):
        m = divisor(n)
        if m > limit:
            answer += power
        else:
            answer += m
    return answer
