#include <iostream>
#include <cmath>
#include <vector>
#include <algorithm>

using namespace std;

//Lv.1 짝수와 홀수
string solution1(int num) {
    return  num % 2 == 0 ? "Even" : "Odd";
}

//Lv.1 자릿수 더하기
int solution2(int n)
{
    int answer = 0;

     do{
        answer += (n % 10);
     } while (n /= 10);
    

    return answer;
}

//Lv.1 약수의 합
int solution3(int n) {
    int answer = 0;

    if (n == 0) return 0;

    int i = 1;
    while (1) {
        if (n % i == 0) {
            answer += n / i;
        }
        if (n == i)
            break;
        i++;
    }
    return answer;
}

//Lv.1 평균 구하기
double solution4(vector<int> arr) {
    double answer = 0;
    for (auto& n : arr)
        answer += n;
    return answer / arr.size();
}

//Lv.1 정수 제곱근 판별
long long solution(long long n) {
    double answer = std::sqrt(n);

    return std::floor(answer) == answer ? std::pow(answer + 1, 2) : -1;
}