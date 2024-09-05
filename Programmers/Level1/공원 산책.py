def solution(park, routes):
    x = 0
    y = 0
    
    N = len(park)
    M = len(park[0])
    
    matrix = [ [ True for i in range(M) ] for j in range(N) ]
    
    # matrix 구성
    for i in range(N):
        k = park[i]
        for j in range(M):
            if k[j] == 'X':
                matrix[i][j] = False
            elif k[j] == 'S':
                y, x = i, j

    for route in routes:
        direction, distance = route.split()
        distance = int(distance)
        new_y = y
        new_x = x
        if direction == 'N':
            while new_y != y - distance:
                new_y -= 1
                if new_y < 0 or not matrix[new_y][x]:
                    new_y = y
                    break
        elif direction == 'W':
            while new_x != x - distance:
                new_x -= 1
                if new_x < 0 or not matrix[y][new_x]:
                    new_x = x
                    break
        elif direction == 'E':
            while new_x != x + distance:
                new_x += 1
                if new_x >= M or not matrix[y][new_x]:
                    new_x = x
                    break
        elif direction == 'S':
            while new_y != y + distance:
                new_y += 1
                if new_y >= N or not matrix[new_y][x]:
                    new_y = y
                    break
        y = new_y
        x = new_x
    return [y, x]
