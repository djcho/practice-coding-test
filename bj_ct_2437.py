N = int(input())
weights = list(map(int, input().split()))
weights.sort()
i = 0

min_val = 1

for i in weights:
    if min_val < i:
        break
    min_val += i

print(min_val)

