def solution(s):
    answer = 0
    n = len(s)
    i = 0
    while i < n:
        j = i + 1
        same = 1
        not_same = 1 if j < n and s[i] != s[j] else 0
        while j < n and same != not_same:
            if s[i] == s[j]:
                same += 1
            else:
                not_same += 1
            j += 1
        if same == not_same: j -= 1
        answer += 1
        i = j + 1
    return answer
