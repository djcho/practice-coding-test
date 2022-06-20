N = int(input())

levels = []
count = 0

for i in range(N):
    levels.append(int(input()))

for i in reversed(range(1, N)):
    if levels[i-1] >= levels[i]:
        count += (levels[i-1] - levels[i]) + 1
        levels[i-1] = levels[i] - 1

print(count)
