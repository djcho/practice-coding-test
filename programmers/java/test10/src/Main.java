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

    public static void main(String[] args) {
        int[] test = {3, 76, 24};

        //solution14(test);
        //solution15(".... . .-.. .-.. ---");
        //System.out.println(solution16(3,2));
        System.out.println(solution16(2,2));
        //System.out.println(solution16(5,3));
        System.out.println(Arrays.toString(test));
    }
}