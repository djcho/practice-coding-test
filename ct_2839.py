n = int(input())

count_of_bag = 0
while(n >= 0):
    if n%5 == 0:
        count_of_bag += (n//5)
        print(count_of_bag)
        break
    n -= 3
    count_of_bag += 1
else:
    print(-1)