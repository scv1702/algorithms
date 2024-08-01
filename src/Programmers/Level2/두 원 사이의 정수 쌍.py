from math import floor, ceil, sqrt
    
def solution(r1, r2):
    answer = 0
    for x in range(1, r2):    
        if x < r1:
            answer += floor(sqrt(r2 ** 2 - x ** 2)) - ceil(sqrt(r1 ** 2 - x ** 2)) + 1
        else:
            answer += floor(sqrt(r2 ** 2 - x ** 2)) + 1
    answer += 1
    answer *= 4
    return answer
