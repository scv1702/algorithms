def solution(k, m, score):
    # 사과 상자 속 최저 사과 점수에 의해 한 상자의 가격이 결정된다.
    # 그러므로 최저 사과 점수를 최대한 높게 포장해야지 최대 이익을 얻을 수 있다.
    score = sorted(score)
    answer = 0
    n = len(score)
    for i in range(n % m, n, m):
        answer += score[i] * m
    return answer
