MAX_NUMBER = 10000
self_number_list = [True] * MAX_NUMBER

for i in range(1, MAX_NUMBER + 1):
    sum = i
    result = i
    while(result != 0):
        sum += result % 10
        result = result//10    
    
    if sum < MAX_NUMBER:
        self_number_list[sum] = False
    sum = 0

for i in range(1, MAX_NUMBER):
    if self_number_list[i] == False:
        continue
    print(i)
