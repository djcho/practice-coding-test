package org.example;

public class Main {

    public static int solution2(int[][] office, int k){
        if(office.length < k)
            k = office.length;

        int maxCount = 0;
        for(int i = 0; i <= office.length-k; i++){
            for(int j = 0; j <= office[i].length-k; j++){
                int count = 0;
                for(int w = 0; w < k; w++){
                    for(int h = 0; h < k; h++){
                        if(office[i+w][j+h] == 1){
                            count++;
                        }
                    }
                }

                if(maxCount < count)
                    maxCount = count;
            }
        }
        return maxCount;
    }

    public static int solution3(int[][] office, int k){
        int maxCount = 0;
        for(int i = 0; i <= office.length-k; i++){
            for(int j = 0; j <= office[i].length-k; j++){
                int count = 0;
                for(int w = 0; w < k; w++){
                    for(int h = 0; h < k; h++){
                        if(office[i+w][j+h] == 1){
                            count++;
                        }
                    }
                }

                if(maxCount < count)
                    maxCount = count;
            }
        }
        return maxCount;
    }

    public static int solution4(int N) {
        final int MAX_PERSON_COUNT = 45;
        int[] arr = new int[MAX_PERSON_COUNT + 1];

        arr[0] = 1;
        arr[1] = 1;

        for (int i = 2; i <= MAX_PERSON_COUNT; i++) {
            arr[i] = arr[i - 1] + arr[i - 2];
        }

        return arr[N];
    }

    public static long solution(long n){
        long temp_n = n;
        int count = 0;
        while(temp_n > 1){
            temp_n /= 2;
            count++;
        }

        n -= (long) Math.pow(2, count);
        if(n != 0){
            return (long) Math.pow(3, count) + solution(n);
        }
        return (long) Math.pow(3, count);
    }

    public static int solution(String t, String p) {
        int answer = 0;

        for(int i = 0; i <= t.length() - p.length(); i++){
            if(Integer.parseInt(p) >= Integer.parseInt(t.substring(i, p.length() + i))){
                answer++;
            }
        }

        return answer;
    }

    public static int solution(String[] babbling) {
        int answer = 0;
        final String[] wordTable = {"aya", "ye", "woo", "ma"};

        for(String babb : babbling){
            for(String word : wordTable){
                babb = babb.replace(word, " ");
            }
            babb = babb.trim();
            if(babb.length() == 0)
                answer++;
        }

        return answer;
    }

    public static void main(String[] args) {

        System.out.println(solution(new String[]{"aya", "yee", "u", "maa", "wyeoo"}));

        //System.out.println(solution(5));
        //for(long i = 1; i < 1000000000; i++) {
        //    System.out.println(solution(i));
        //}

        //System.out.println(solution3(new int[][]{{1,0,0,0}, {0,0,0,1}, {0,0,1,0}, {0,1,1,0}}, 2));
        //System.out.println(solution3(new int[][]{{1,0,0}, {0,0,1}, {1,0,0}}, 2));
    }
}