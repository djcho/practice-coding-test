N, K= map(int, input().split())
TABLE = list(input())

count = 0
for i in range(N):
    if TABLE[i] != "P":
        continue

    for j in range(i-K, i+K+1):
        if (0 <= j < len(TABLE)) and TABLE[j] == "H":
            TABLE[j] = "X"
            count += 1
            break

print(count)