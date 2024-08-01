def solution(keymap, targets):
    MAX = 999
    answer = []
    for target in targets:
        target = list(target)
        ans = 0
        for c in target:
            cnt = MAX
            for key in keymap:
                i = key.find(c) + 1
                if i == 0: i = MAX
                if cnt > i: cnt = i
            if cnt == MAX:
                ans = -1
                break
            else:
                ans += cnt
        answer.append(ans)
    return answer
