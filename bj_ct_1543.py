document = input()
word = input()

count = 0
i = 0
while True:
    if i >= len(document):
        break
    if document[i:(len(word) + i)] == word:
        count += 1
        i += len(word)
        continue
    i += 1

print(count)