from collections import deque

N = int(input())
MAP = [list(map(int, input().split())) for _ in range(N)]
visited = [([False] * N) for _ in range(N)]

def bfs():
    queue = deque()
    queue.append([0,0])

    while(queue):
        current = queue.popleft()
        x = current[0]
        y = current[1]

        distance = MAP[x][y]
        if distance == -1:
            print("HaruHaru")
            return
        
        # 인접한 다음 좌표들 구함
        nextX = x + distance
        nextY = y + distance
        if (0 <= nextX < N) and visited[nextX][y] == False:
            queue.append([nextX, y])
            visited[nextX][y] = True           
        if (0 <=  nextY < N) and visited[x][nextY] == False:
            queue.append([x, nextY])
            visited[x][nextY] = True
    else:
        print("Hing")

bfs()
