def solution(s):
    answer = []
    n = len(s)
    for i in range(n):
        j = i-1
        while j >= 0:
            if s[i] == s[j]:
                answer.append(i-j)
                break
            j -= 1
        if j < 0:
            answer.append(-1)
    return answer
