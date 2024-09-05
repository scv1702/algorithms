def is_pronounceable(s, p):
    if s == '': 
        return True
    if (s[0:3] == 'aya' or s[0:3] == 'woo') and s[0:3] != p:
        return is_pronounceable(s[3:], s[0:3])
    if (s[0:2] == 'ye' or s[0:2] == 'ma') and s[0:2] != p:
        return is_pronounceable(s[2:], s[0:2])
    return False
        
def solution(babbling):
    answer = 0
    for word in babbling:
        if is_pronounceable(word, ''):
            print(word)
            answer += 1
    return answer
