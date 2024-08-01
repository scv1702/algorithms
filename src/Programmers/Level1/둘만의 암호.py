def solution(s, skip, index):
    bias = ord('a') # 97
    answer = ''
    for i in s: # i: 암호화 대상
        j = (ord(i) - bias) 
        k = 0
        while k < index:
            j = (j + 1) % 26 # 0 ~ 25로 제한
            if chr(j + bias) not in skip:
                k += 1
        answer += chr(j + bias)
    return answer
