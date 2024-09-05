def solution(targets):
    answer = 0
    targets = sorted(targets)
    overlap = [0, 0]
    for interval in targets:
        if overlap[0] < interval[1] and overlap[1] > interval[0]: # 겹치는지 판단
            overlap = [interval[0], min(overlap[1], interval[1])] # 겹치는 구간 계산
        else:
            overlap = interval
            answer += 1
    return answer
