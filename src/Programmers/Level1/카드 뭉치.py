def solution(cards1, cards2, goal):
    i = 0 # cards1
    j = 0 # cards2
    k = 0
    
    cards1_len = len(cards1)
    cards2_len = len(cards2)
    goal_len = len(goal)

    while k < goal_len and i < cards1_len and j < cards2_len:
        if goal[k] == cards1[i]:
            i += 1
        elif goal[k] == cards2[j]:
            j += 1
        else:
            return 'No'
        k += 1
    
    if i == cards1_len: # cards1 다 사용한 경우
        while k < goal_len and j < cards2_len:
            if goal[k] == cards2[j]:
                j += 1
            else:
                return 'No'
            k += 1
    elif j == cards2_len: # cards2 다 사용한 경우
        while k < goal_len and i < cards1_len:
            if goal[k] == cards1[i]:
                i += 1
            else:
                return 'No'
            k += 1
                
    return 'Yes'
