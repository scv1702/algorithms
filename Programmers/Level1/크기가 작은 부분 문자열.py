def solution(t, p):
    answer = 0
    n = len(p)
    end = n
    for start in range(len(t)-n+1):
        if int(t[start:end]) <= int(p):
            answer += 1
        end += 1
    return answer
