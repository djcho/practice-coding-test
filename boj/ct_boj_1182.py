
def check_queen(x, y):
    board[x][y] # 1,2

    
    for i in range(N):
        if board[i][y] or board[x][i]:
            return False
        if x-i

N = int(input())
print(N)

board = [([False] * N) for _ in range(N)]

board[3][0]= True

print(check_queen(1,2))

for i in board:
    print(i)

