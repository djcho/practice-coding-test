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

#include <cmath>

//Lv.1 두 정수 사이의 합
long long solution13(int a, int b) {
    long long sum = 0;
    for(int i = std::min(a, b); i <= std::max(a, b); i++)
        sum += i;
    return sum;
}

//Lv.1 서울에서 김서방 찾기
string solution14(vector<string> seoul) {
    string answer = "김서방은 ";
    vector<string>::iterator iter = std::find_if(seoul.begin(), seoul.end(), [](std::string str){return str == "Kim";});
    size_t index = std::distance(seoul.begin(), iter);

    answer.append(std::to_string(index));
    answer.append("에 있다.");

    return answer;
}

//Lv.1 핸드폰 번호 가리기
string solution15(string phone_number) {
    for(string::iterator iter = phone_number.begin(); iter < phone_number.end() - 4; iter++){
        phone_number.replace(iter, iter+1, "*");
    }
    
    return phone_number;
}

//Lv.1 제일 작은 수 구하기
vector<int> solution16(vector<int> arr) {
    if(arr.size() <= 1)
        return {-1};
        
    arr.erase(std::min_element(arr.begin(), arr.end()));
    return arr;
}

//Lv.1 나누어 떨어지는 숫자 배열
vector<int> solution17(vector<int> arr, int divisor) {
    vector<int> answer;
    for(auto& i : arr){
        if(i%divisor == 0){
            answer.push_back(i);
        }        
    }
    if(answer.empty())
        return {-1};

    std::sort(answer.begin(), answer.end());
    return answer;
}

//Lv.1 음양 더하기
int solution18(vector<int> absolutes, vector<bool> signs) {
    int answer = 0;

    for(int i = 0; i < absolutes.size(); i++){
        signs[i] ? answer += absolutes[i] : answer -= absolutes[i];
    }

    return answer;
}

//Lv.1 수박수박수박수박수박수?
string solution19(int n) {
    string answer = "";
    string str;
    for(int i = 1; i <= n; i++){
        str = i%2 ? "수" : "박";
        answer.append(str);
    }
    return answer;
}

#include <numeric>
//Lv.1 없는 숫자 더하기
int solution20(vector<int> numbers) {
    vector<int> table = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9};
    vector<int> diff;

    sort(numbers.begin(), numbers.end());
    set_difference(table.begin(), table.end(), numbers.begin(), numbers.end(), inserter(diff, diff.begin()));
    return accumulate(diff.begin(), diff.end(), 0);
}

//Lv.1 가운데 글자 가져오기
string solution21(string s) {
    return s.size()%2 ? s.substr(s.length()/2, 1) : s.substr(s.length()/2-1, 2) ;
}

//Lv.1 내적
int solution22(vector<int> a, vector<int> b) {
    int answer = 0;

    for(int i = 0; i < a.size(); i++){
        answer += a[i]*b[i];
    }

    return answer;
}

//Lv.1 문자열 내림차순으로 배치하기
string solution23(string s) {
    sort(s.begin(), s.end(), std::greater<int>());
    return s;
}

//Lv.1 문자열 다루기 기본
bool solution24(string s) {
    if(s.length() != 4 && s.length() != 6)
        return false;
    return (find_if(s.begin(), s.end(), [](const char& c){return (c < '0' || c > '9');}) == s.end());
}


//Lv.1 약수의 개수와 덧셈
int solution25(int left, int right) {
    int answer = 0;
    int mcount = 0;
    for(int i = left; i <= right; i++){
        mcount = 0;
        for(int j = 1; j <= i; j++){
            if(i%j == 0) mcount++;            
        }
        answer = mcount%2 ? answer - i : answer + i;
    }

    return answer;
}

//Lv.1 행렬의 덧셈
vector<vector<int>> solution26(vector<vector<int>> arr1, vector<vector<int>> arr2) {
    vector<vector<int>> answer;
    for(int i = 0; i < arr1.size(); i++){
        vector<int> temp;
        for(int j = 0; j < arr1[i].size(); j++){
            temp.push_back(arr1[i][j] + arr2[i][j]);
        }
        answer.push_back(temp);
    }
    return answer;
}

//Lv1 부족한 금액 계산하기
long long solution27(int price, int money, int count)
{
    long long total = 0;
    for(int i =1; i <= count; i++){
        total += (price * i);
    }

    return total < money ? 0: total - money;
}

//Lv1 직사각형 별찍기
int solution28(void) {
    int a;
    int b;
    cin >> a >> b;
    
    for(int i = 0; i < b; i++){
        for(int j = 0; j < a; j++)
            cout<< "*";
        cout << endl;
    }
    return 0;
}

//Lv.1 최대공약수와 최소공배수
vector<int> solution29(int n, int m){
    vector<int> cf;
    for(int i = 1; i <= n && i <=m; i++){
        if(n%i == 0 && m%i == 0){
            cf.push_back(i);
        }
    }

    int g = *(cf.end() -1);
    int l = g * n/g * m/g;


    return {g,l};
}

//Lv.1 같은 숫자는 싫어
vector<int> solution30(vector<int> arr) 
{
    vector<int> answer = {arr[0]};
    for(auto& i : arr){
        if(*(answer.end() - 1) != i){
            answer.push_back(i);
        }
    }
    return answer;
}

//Lv.1 이상한 문자 만들기
string solution31(string s) {
    int internal_index = 1;
    for(int i = 0; i < s.length(); i++){
        if(s[i] == ' '){
            internal_index = 1;
            continue;
        }
        s[i] = internal_index%2 ? toupper(s[i]) : tolower(s[i]);
        internal_index++;
    }
    return s;
}

//Lv.1 3진법 뒤집기
int solution32(int n) {
    vector<int> vec;
    while(n > 2){
        vec.push_back(n%3);
        n /= 3;
    }
    vec.push_back(n);

    int sum = 0;
    int vec_size = vec.size() - 1;
    for(int i = 0; i < vec.size(); i++){
        sum += vec[i] * pow(3, vec_size);
        vec_size--;
    }
    
    return sum;
}

//Lv.1 예산
int solution33(vector<int> d, int budget) {
    int sum = 0;
    sort(d.begin(), d.end());

    int cnt = 0;
    for(int i = 0; i < d.size(); i++){
        sum += d[i];
        if(sum <= budget)
            cnt++;
    }

    return cnt;
}

int main(){
    return 0;
}