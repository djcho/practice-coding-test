S = int(input())
sum = 0
i = 1

while True:
    sum += i
    if sum > S:
        print(i-1)
        break
    elif sum == S:
        print(i)
        break    
    i += 1