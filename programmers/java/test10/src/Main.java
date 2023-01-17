import java.math.BigInteger;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {
    public static int[] solution(int denum1, int num1, int denum2, int num2) {
        int[] answer = {0, 0};

        int denum = denum1 * num2 + denum2 * num1;
        int num = num1 * num2;

        answer[0] = denum;
        answer[1] = num;

        int max =1;
        int min = Math.min(denum, num);
        for(int i = 2; i <= min; i++){
            if(denum%i == 0 && num%i == 0) {
                max = i;
            }
        }
        answer[0] /= max;
        answer[1] /= max;
        return answer;
    }
    public static int solution(int[] array) {
        int[] table = new int[1000];
        int max = 0;
        int answer = 0;
        for(int i = 0; i < array.length; i++){
            table[array[i]]++;
            if(table[array[i]] > max) {
                max = table[array[i]];
                answer = array[i];
            }
        }

        int count = 0;
        for(int i = 0; i < table.length; i++){
            if(table[i] == max)
                count++;
        }
        return count >= 2 ? -1 : answer;
    }

    public int solution(int n) {
        int answer = n/7;
        return n%7 == 0 ? answer : answer +1;
    }

    public int solution2(int n) {
        int p = 6;
        int answer = 1;
        while(p%n != 0){
            p+=6;
            answer++;
        }
        return answer;
    }

    public int solution3(int price) {
        if(price >= 500000)
            return (int)(price * 0.8);
        else if(price >= 300000){
            return (int)(price * 0.9);
        }
        else if(price >= 100000){
            return (int)(price * 0.95);
        }
        else{
            return price;
        }
    }

    public static double solution4(int n) {
        return Math.sqrt(n);
    }

    public int solution5(String[] s1, String[] s2) {
        int answer = 0;

        if(s1.length < s2.length){
            for(String s : s1){
                answer += Arrays.stream(s2).anyMatch(s::equals) ? 1 : 0;
            }
        }
        else {
            for(String s : s2){
                answer += Arrays.stream(s1).anyMatch(s::equals) ? 1 : 0;
            }
        }

        return answer;
    }

    public static int solution6(String my_string) {
        int answer = 0;
        for(int i = 0; i < my_string.length(); i++){
            if(Character.isDigit(my_string.charAt(i))) answer += my_string.charAt(i) - '0';
        }
        return answer;
    }

    public static int solution7(int n, int t) {
        if(t == 0)
            return n;
        return solution7(n*2, --t);
    }

    public static String solution8(String my_string) {
        String answer = "";

        for(int i = 0; i < my_string.length(); i++){
            if(Character.isLowerCase(my_string.charAt(i))){
                answer += String.valueOf(my_string.charAt(i)).toUpperCase();
            }
            else if(Character.isUpperCase(my_string.charAt(i))){
                answer += String.valueOf(my_string.charAt(i)).toLowerCase();
            }
            else{
                answer += my_string.charAt(i);
            }
        }
        return answer;
    }

    public static int solution9(int[] box, int n) {
        return box[0]/n * box[1]/n * box[2]/n;
    }

    public static String solution10(String cipher, int code) {
        String answer = "";
        for(int i = code; i < cipher.length(); i+=code)
            answer += cipher.charAt(i-1);
        return answer;
    }

    public static int[] solution11(int n) {
        Set<Integer> answer = new HashSet<>();
        for(int i = 1; i <= Math.sqrt(n); i++){
            if(n%i == 0){
                answer.add(i);
                answer.add(n/i);
            }
        }
        return answer.stream().sorted().mapToInt(i->i).toArray();
    }

    public static int[] solution12(int[] numbers, String direction) {
        int[] answer = new int[numbers.length];
        if(direction.equals("right")){
            System.arraycopy(numbers, 0, answer, 1, numbers.length-1);
            answer[0] = numbers[numbers.length-1];
        }else {
            System.arraycopy(numbers, 1, answer, 0, numbers.length-1);
            answer[numbers.length-1] = numbers[0];
        }
        return answer;
    }

    public static String solution13(int age) {
        String answer = "";
        for(char ch : String.valueOf(age).toCharArray()){
            answer += (char)(ch + '1');
        }
        return answer;
    }

    public static int[] solution14(int[] emergency) {
        int[] answer = new int[emergency.length];

        Map<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i < emergency.length; i++){
            map.put(emergency[i], i);
        }

        emergency = Arrays.stream(emergency).boxed().sorted(Collections.reverseOrder()).mapToInt(Integer::intValue).toArray();
        for(int i = 0; i < emergency.length; i++){
            answer[map.get(emergency[i])] = i + 1;
        }

        return answer;
    }
    public static String solution15(String letter) {
        String answer = "";
        String[] morse = {".-","-...","-.-.","-..",".",
                "..-.","--.","....","..",".---",
                "-.-",".-..","--","-.","---",
                ".--.","--.-",".-.","...","-",
                "..-","...-",".--","-..-","-.--","--.."};

        String[] ss = letter.split(" ");
        for(String s : ss){
            answer += (char)((int)'a' + Arrays.asList(morse).indexOf(s));
        }

        return answer;
    }

    public static int solution16(int balls, int share) {
        return (factorial(balls).divide(factorial(balls - share).multiply(factorial(share)))).intValue();
    }

    public static BigInteger factorial(int n){
        if(n <= 1)
            return new BigInteger(Integer.toString(n));

        BigInteger ret =  factorial(n-1).multiply(new BigInteger(Integer.toString(n)));
        return ret;
    }

    public static int[][] solution17(int[] num_list, int n) {
        int[][] answer = new int[num_list.length/n][n];
        int index = 0;
        for(int i = 0; i < num_list.length; i+=n){
            for(int j = 0; j < n; j++)
                answer[index][j] = num_list[i+j];
            index++;
        }
        return answer;
    }

    public static int solution18(int n) {
        int i = 1;
        while(true){
            if(n / i <= i)
                break;
            n/=i;
            i++;
        }
        return i;
    }

    public static int solution19(int[] citations) {
        int answer = 0;
        for(int i = 1; i <= citations.length; i++){
            int count = 0;
            for(int j = 0; j < citations.length; j++){
                if(citations[j] > j)
                    count ++;

                if(count > i){
                    answer = count;
                    break;
                }
            }
        }
        return answer;
    }

    public static String solution20(int n, int t, int m, int p) {
        StringBuilder answer = new StringBuilder();
        StringBuilder sb = new StringBuilder();

        for(int i = 0; i < 1000 ; i++){
            sb.append(Integer.toString(i, n));
        }

        int idx = p-1;
        for(int i = 0; i < t; i ++){
            if(idx > sb.length())
                break;
            answer.append(sb.charAt(idx));
            idx += m;
            //System.out.println(idx);
        }
        System.out.println(answer);
        return answer.toString().toUpperCase();
    }

    public static int solution21(int[] priorities, int location) {
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        queue.add(2);
        queue.add(1);
        queue.add(4);
        queue.add(0);
        int count = 0;
        for(int i = 0; i < priorities.length; i++){
            for(int j = i + 1; j < priorities.length - i; j++){
                if(priorities[i] < priorities[j]){
                    count++;
                    break;
                }
            }
        }

        int currentLocation = location - count;
        return currentLocation < 0 ? currentLocation + priorities.length + 1 : currentLocation + 1;
    }

    public static int solution22(int n) {
        int answer = 0;

        for(int i = 1; i <= n; i++){
            int sum = 0;
            for(int j = i; j <= n; j++){
                sum += j;
                if(sum > n)
                    break;
                else if(sum == n) {
                    answer++;
                    break;
                }
            }
        }
        return answer;
    }

    public static boolean isPrimeNumber(long number){
        for(int i = 2; i <= Math.sqrt(number); i+=2)
            if(number % i == 0)
                return false;
        return true;
    }


    public static int solution23(int n, int k) {
        int answer = 0;
        String strNumber = Integer.toString(n, k);
        String[] ss = strNumber.split("0");
        for (String s : ss) {
            if(s.isEmpty() || s.equals("1"))
                continue;

            if (isPrimeNumber(Long.parseLong(s)))
                answer++;
        }
        return answer;
    }

    public static void main(String[] args) {
        int[] test = {2,1,3,2};
        int[] test2 = {1,1,9,1,1,1,};
        //int[] test2 = {3,0,6,1,5, 10, 2, 7, 2};
        System.out.println(solution23(437674, 3));
        System.out.println(solution23(110011, 10));
        //int[] test = {1, 2, 3, 4, 5, 6, 7, 8};
////
////        solution18(5);
////        solution18(7);
////        solution18(2147483647);
//
//        //solution14(test);
//        //solution15(".... . .-.. .-.. ---");
//        //System.out.println(solution16(3,2));
//        solution17(test, 2);
//        System.out.println(solution16(2,2));
//        //System.out.println(solution16(5,3));
//        System.out.println(Arrays.toString(test));
    }
}