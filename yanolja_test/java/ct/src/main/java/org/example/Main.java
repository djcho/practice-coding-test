package org.example;

import java.math.BigInteger;
import java.util.*;

public class Main {
    public static int solution(int[] bombs) {
        int answer = 0;
        Arrays.sort(bombs);

        for(int i = 0; i < bombs.length; i++){
            if(bombs[i] >= i+1){
                answer++;
            } else if(bombs[i] < i+1){
                break;
            }
        }
        return answer;
    }

    public static int solution(String p) {
        int answer = 0;
        for(int i = 0; i < p.length(); i++){
            int location = i;

            char current =  p.charAt(i);
            while(current == p.charAt(location)){
                if(current == '>'){
                    location++;
                }else
                    location--;

                if(location < 0 || location >= p.length()){
                    answer++;
                    break;
                }

            }

        }
        return answer;
    }

    public static long solution(int n) {
        Queue<String> queue = new LinkedList<>();
        List<String> table = new ArrayList<>();

        queue.add("4");
        queue.add("13");

        while(table.size() <= n){
            String current = queue.poll();
            queue.add("4" + current);
            queue.add("13" + current);
            table.add(current);
        }

        System.out.println(Arrays.toString(table.toArray()));
        Collections.sort(table);
        return Long.parseLong(table.get(n-1));
    }

    public static String solution2(String s) {

        String answer = "";
        int[] table = new int[25];
        for(char ch : s.toCharArray()){
            table[ch - 'a'] ++;
        }

        for(int i = 0; i < table.length; i++){
            if(table[i] == 1){
                answer += (char)(i + 'a');
            }
        }

        char [] temp = answer.toCharArray();
        Arrays.sort(temp);
        return new String(temp);
    }

    public static int solution3(String my_string) {
        int answer = 0;
        my_string = my_string.replace(" + ", "@");
        my_string = my_string.replace(" - ", "~");
        String [] plusString = my_string.split("@");
        for(String ps : plusString) {
            if (ps.isEmpty())
                continue;

            if (ps.contains("~")) {
                String[] minusString = ps.split("~");
                for (String ms : minusString) {
                    if (ms.isEmpty())
                        continue;
                    answer -= Integer.parseInt(ms);
                }
            }
            else
                answer += Integer.parseInt(ps);
        }

        return answer;
    }

    public static void main(String[] args) {
        System.out.println(solution3("-3 + 4 - 10 + 20 - -12"));
        //System.out.println(solution(new int[]{3,1,2,4}));
        //System.out.println(solution(new int[]{2,2,2,2}));
        //System.out.println(solution("<<<><"));

        System.out.println(solution(5000));
        //for(int i = 1; i <= 5000; i++){
           // System.out.println(i + " : " +  solution(i));
        //}

        //System.out.println(solution("<><><>"));
        //System.out.println(solution("<<<<><><>"));
        //System.out.println(solution("<<<<><><<><><<>>>><"));//<<<<<<>>>
        //System.out.println(solution(">><<>"));//<<<<<<>>>
        //System.out.println(solution(""));
    }
}