'''
소수 찾기

문제
주어진 수 N개 중에서 소수가 몇 개인지 찾아서 출력하는 프로그램을 작성하시오.

입력
첫 줄에 수의 개수 N이 주어진다. N은 100이하이다. 다음으로 N개의 수가 주어지는데 수는 1,000 이하의 자연수이다.

출력
주어진 수들 중 소수의 개수를 출력한다.

예제 입력 1 
4
1 3 5 7

예제 출력 1 
3
'''

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
 