def solution(name, yearning, photo):
    answer = []
    point = { n: y for n, y in zip(name, yearning)}
    # O(사진 개수 * 사진 속 인물 수 * 전체 인물 수)
    for i in photo: # i: 사진 1장
        k = 0
        for j in i: # j: 사진 속 인물
            if j in name:
                k += point[j]
        answer.append(k)
    return answer
