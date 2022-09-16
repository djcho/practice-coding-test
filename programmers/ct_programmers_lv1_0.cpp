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

    do {
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
long long solution5(long long n) {
    double answer = std::sqrt(n);

    return std::floor(answer) == answer ? std::pow(answer + 1, 2) : -1;
}

#include <string>
//Lv.1 자연수 뒤집어 배열로 만들기
vector<int> solution6(long long n) {
    vector<int> answer;
    string num_str = to_string(n);
    for (int i = num_str.size() - 1; i >= 0; i--) {
        answer.push_back(num_str[i] - '0');
    }
    return answer;
}

//Lv. 문자열 내 p와 y의 개수
bool solution7(string s)
{
    int y_count = 0;
    int p_count = 0;

    for (int i = 0; i < s.size(); i++)
    {
        if (std::tolower(s[i]) == 'y')
            y_count++;
        else if (std::tolower(s[i]) == 'p')
            p_count++;
    }

    return y_count == p_count;
}

#include <algorithm>

//Lv.1 정수 내림차순으로 배치하기
long long solution8(long long n) {
    string s = to_string(n);
    std::sort(s.begin(), s.end(), std::greater<int>());
    return std::stoll(s);
}

//Lv.1 하샤드 수
bool solution9(int x) {
    string s = to_string(x);
    int sum = 0;
    for (int i = 0; i < s.size(); i++)
        sum += (s[i] - '0');

    return x % sum == 0;
}

//Lv.1 나머지가 1이 되는 수 찾기
int solution10(int n) {
    for (int i = 1; i < n; i++) {
        if (n % i == 1)
            return i;
    }
    return 0;
}

//Lv.1 x만큼 간격이 있는 n개의 숫자
vector<long long> solution11(int x, int n) {
    vector<long long> answer;
    int sum = x;
    for (int i = 0; i < n; i++) {
        answer.push_back(sum);
        sum += x;
    }
    return answer;
}


//Lv.1 콜라츠 추측
int solution12(int num) {
    int roop_count = 0;
    long long temp = num;
    while (temp != 1) {
        if (roop_count == 500)
            return -1;

        if (temp % 2 == 0) {
            temp /= 2;
        }
        else {
            temp *= 3;
            temp++;
        }

        roop_count++;
    }

    return roop_count;
}