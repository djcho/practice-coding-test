import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        int[] answer = solution(1,2,3,4);

        answer = solution(9,2,1,3);

        int[] a = {0,999,0,2,2,1,};
        System.out.println(solution(a));

        List<Integer> a1 = new ArrayList<>();
        int[] aaa = a1.stream().mapToInt(i->i).toArray();
    }
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
}