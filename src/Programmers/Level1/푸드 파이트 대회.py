def solution(food):
    prefix = ''
    for i, f in enumerate(food[1:]):
        prefix += str(i + 1) * int(f // 2)
    answer = prefix + str(0) + prefix[::-1]
    return answer
