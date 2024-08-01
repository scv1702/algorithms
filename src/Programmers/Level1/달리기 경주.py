def solution(players, callings):
    answer = [ player for player in players ]
    inv_players = dict(zip(players, [ i for i in range(len(players)) ]))
    for calling in callings:
        idx = inv_players[calling] # 추월하는 선수의 위치
        inv_players[calling] -= 1 # 추월하는 선수 위치 갱신
        inv_players[answer[idx-1]] += 1 # 추월 당하는 선수 위치 갱신
        answer[idx], answer[idx-1] = answer[idx-1], answer[idx] # 추월
    return answer
