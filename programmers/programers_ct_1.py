
def get_count_report(id, report):
    count = 0
    for rep in report:
        reporter, target = rep.split(" ")
        if target == id:
            count+=1
    return count

def remove_dup(report):
    return list(set(report))

def get_target_list(id, report):
    target_list = []
    for rep in report:
        reporter, target = rep.split(" ")
        if reporter == id:
            target_list.append(target)
    return target_list

def solution(id_list, report, k):
    answer = []

    report = remove_dup(report)
    
    report_counter = {id:0 for id in id_list}
    target_list = {id:[] for id in id_list}
    for rep in report:
        reporter, target = rep.split(" ")
        report_counter[target] += 1 
        target_list[reporter].append(target)           

    
    for id in id_list:
        result = 0
        for target in target_list[id]:
            if report_counter[target] >= k:
                result += 1
        answer.append(result)
    return answer



id_list = ["muzi", "frodo", "apeach", "neo"]
report = ["muzi frodo","apeach frodo","frodo neo","muzi neo","apeach muzi"]
answer = solution(id_list, report ,2)
print(answer)

id_list = ["con", "ryan"]
report = ["ryan con", "ryan con", "ryan con", "ryan con"]
answer = solution(id_list, report,3)
print(answer)
