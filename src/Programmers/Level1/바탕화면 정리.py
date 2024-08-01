def solution(wallpaper):
    matrix = [ list(w) for w in wallpaper ]
    
    N = len(matrix)
    M = len(matrix[0])
    
    min_j = min_i = float("inf")
    max_j = max_i = -1
    
    # matrix에서 가장 왼쪽 상하단 파일과 가장 오른쪽 상하단 파일 위치 탐색
    for i in range(N):
        for j in range(M):
            if matrix[i][j] == '#':
                if j < min_j:
                    min_j = j
                if j > max_j:
                    max_j = j
                if i > max_i:
                    max_i = i
                if i < min_i:
                    min_i = i
                    
    # matrix의 좌표계를 wallpaper의 좌표계로 변환
    lux = min_i
    luy = min_j
    rdx = max_i + 1
    rdy = max_j + 1

    return [lux, luy, rdx, rdy]
