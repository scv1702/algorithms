def solution(n, m, section):
    answer = 0
    i = 0
    while i < len(section):
        answer += 1
        if section[i] + m >= section[i+1]: # 다음 벽도 덧칠할 수 있는 경우
            i += m
        else:
            i += 1
    return answer

def solution(n, m, section):
    answer = 0
    painted = 0
    for idx, wall in enumerate(section):
        if wall > painted:
            answer += 1
            painted += m - 1
    return answer
