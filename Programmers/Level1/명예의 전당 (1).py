import bisect

def solution(k, score):
    answer = []
    lo = 0
    hof = []
    for i, s in enumerate(score):
        if i < k:
            bisect.insort(hof, s)
        elif s > hof[lo]:
            bisect.insort(hof, s)
            lo += 1
        answer.append(hof[lo])
    return answer
