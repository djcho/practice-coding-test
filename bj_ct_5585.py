
PRICE = 1000
payment = int(input())

change_coin = [500, 100, 50, 10, 5, 1]
change = PRICE - payment
count = 0

for i in change_coin:
    count += change//i # 나눈 몫의 누적 : 동전 갯수
    change = change%i  # 나머지로 갱신

print(count)

# while(change > 0):
#     if change%500 == 0:
#         count += change//500
#         break
#     elif change%100 == 0:
#         change -= 100
#     elif change%50 == 0:
#         change -= 50
#     elif change%10 == 0:        
#         change -= 10
#     elif change%5 == 0:
#         change -= 5
#     else:
#         change -= 1
#     count += 1  
# print(count)
