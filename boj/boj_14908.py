# 3 4
# 1 1000
# 2 2
# 5 5

N = int(input())
weightList = []

totalTime = 0
for i in range(N):
    t, s = map(int, input().split())
    weightList.append([t/s,i+1])

weightList.sort()

for w in weightList:
    print(w[1], end=" ")


