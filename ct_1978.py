number = int(input())
number_arr = list(map(int, input().split()))

prime_number_arr = list(range(max(number_arr) + 2))
prime_number_arr[1] = 0

for i in range(2, len(prime_number_arr)):
    if prime_number_arr[i] == 0:
        continue
    for j in range(2, (max(number_arr)//i)+1): # i 의 배수들 제거
        if prime_number_arr[i*j] == 0:
            continue
        prime_number_arr[i*j] = 0
            
print(len(set(number_arr) & set(prime_number_arr)))

# [0, 0, 2, 3, 4, 5, 6, 7]
1
# 5*2
# 5*3
# 5*4
24/53
11
 