package org.example;

import java.util.*;

public class Main {

    public static boolean containsWrongWord(String babble){
        final String [] wrongTable = {"ayaaya", "yeye", "woowoo", "mama"};
        for (int i = 0; i < wrongTable.length; i++) {
            if (babble.contains(wrongTable[i]))
                return true;
        }
        return false;
    }

    public static boolean checkResult(String babble){
        for (int i = 0; i < babble.length(); i++) {
            if(babble.charAt(i) != 'X')
                return false;
        }
        return true;
    }

    public static int solution(String[] babbling) {
        final String [] table = {"aya", "ye", "woo", "ma" };
        int answer = 0;
        for(String babble : babbling){
            if(containsWrongWord(babble))
                continue;

            for (int i = 0; i < table.length; i++) {
                babble = babble.replace(table[i], "X");
            }
            if(checkResult(babble)){
                answer++;
            }
        }
        return answer;
    }

    public static String solution1(String s) {
        StringBuilder answer = new StringBuilder();
        String[] numbers = s.split(" ");

        int max = Integer.parseInt(numbers[0]);
        int min = max;
        for(String strNumber : numbers){
            int number = Integer.parseInt(strNumber);
            if(number > max){
                max = number;
            }
            if(number < min){
                min = number;
            }
        }

        answer.append(min);
        answer.append(" ");
        answer.append(max);
        return answer.toString();
    }

    public static int solution2(int bridge_length, int weight, int[] truck_weights) {
        int sec = 0;

        Queue<Integer> trucks = new LinkedList<>();
        Queue<Integer> bridge = new LinkedList<>();

        for(int truckWeights : truck_weights){
            trucks.add(truckWeights);
        }

        int currentBridgeWeight = 0;
        while(!trucks.isEmpty()) {
            //대기 트럭 존재
            if (currentBridgeWeight + trucks.peek() <= weight) {
                //다리에 오를 수 있는 경우
                int truck = trucks.poll();
                bridge.add(truck);
                currentBridgeWeight += truck;
                sec++;
            }else{
                sec += bridge_length;
                bridge.clear();
                currentBridgeWeight = 0;
            }

        }
        sec += bridge_length;
        return sec;
    }

    public static void Foo() {
        try {
            throw new Exception();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public static int[] solution3(int n) {
        Set<Integer> answer = new HashSet<>();

        int i = 2;
        while(n > 1){
            if(n%i == 0){
                answer.add(i);
                n/=i;
            }else{
                i++;
            }
        }

        return answer.stream().mapToInt(num->num).toArray();
    }

    public static int solution4(String s) {
        int answer = 0;

        String[] ss = s.split(" ");
        int cached = 0;
        for(String n : ss){
            if(n.equals("Z")){
                answer -= cached;
            }else{
                answer += Integer.parseInt(n);
                cached = Integer.parseInt(n);
            }
        }

        return answer;
    }

    public static String solution(String my_string) {
        LinkedHashSet<String> lhs = new LinkedHashSet<>();

        String[] ss = my_string.split("");
        for(String s : ss){
            lhs.add(s);
        }

        StringBuilder sb = new StringBuilder();
        for(String s : lhs){
            sb.append(s);
        }

        return sb.toString();
    }

    public static void main(String[] args) {

        System.out.println(solution4("1 2 Z 3"));
        System.out.println(solution4("10 20 30 40"));

        System.out.println(Arrays.toString(solution3(4123)));
    }
}