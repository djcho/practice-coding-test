package org.example;

import org.w3c.dom.Node;

import java.util.*;

public class Main {

    public static int solution(int[] numbers) {
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < numbers.length; i++){
            String bin = Integer.toBinaryString(numbers[i]);
            if(bin.length()-1 < i){
                sb.append("0");
            }
            else {
                sb.append(bin.charAt(bin.length()-1 - i));
            }
        }
        return Integer.parseInt(sb.reverse().toString(), 2);
    }

    public static int[][] makeMap(int mapSize, int[][] bus_stop){
        int [][]map = new int[mapSize][mapSize];
        for (int[] row : map)
            Arrays.fill(row, 1);

        for (int[] row : bus_stop)
            map[row[0]-1][row[1]-1] = 0;

        return map;
    }
    public static int bfs(int startX, int startY, int [][]map){
        if(map[startX][startY] == 0)
            return 0;

        Queue<Integer[]> queue = new LinkedList<>();
        int [][]visited = new int[map.length][map.length];
        int[] dx = {0, 0, 1, -1};
        int[] dy = {1, -1, 0, 0};

        queue.add(new Integer[]{startX, startY});
        visited[startX][startY] = 1;

        while(!queue.isEmpty()){
            Integer[] current = queue.poll();
            int x = current[0];
            int y = current[1];

            if(map[x][y] == 0)
                return visited[x][y];

            for(int i = 0; i < 4; i++) {
                int nextX = x + dx[i];
                int nextY = y + dy[i];

                if(0 <= nextX && nextX < map.length && 0 <= nextY && nextY < map.length) {
                    if(visited[nextX][nextY] == 0 || visited[nextX][nextY] == visited[x][y] + 1){
                        queue.add(new Integer[]{nextX, nextY});
                        if(map[nextX][nextY] == 0)
                            return visited[x][y];
                        visited[nextX][nextY] += visited[x][y] + 1;


                    }
                }
            }
        }

        return 0;
    }

    public static int[][] solution(int N, int[][] bus_stop) {
        int[][] answer = new int[N][N];
        int [][] map = makeMap(N, bus_stop);

        for(int i = 0; i < map.length; i++){
            for(int j = 0; j < map[i].length; j++){
                if(i == 2 && j == 0){
                    int a= 1;
                }
                int distance = bfs(i, j, map);
                answer[i][j] = distance;
            }
        }
        return answer;
    }

    public static String solution120863(String polynomial) {
        StringBuilder sb = new StringBuilder();
        boolean numberFlag = false;
        int xCount = 0;
        String[] ss = polynomial.replace(" ", "").split("[+]");
        for(String s : ss){
            if(s.contains("x")){
                if(s.length() == 1){
                    xCount++;
                }else{
                    xCount += Integer.parseInt(s.replace("x", ""));
                }
            }else{
                if(numberFlag){
                    sb.append(" + ");
                }
                sb.append(s);
                numberFlag = true;
            }
        }

        String answer;
        if(xCount == 0){
            answer = sb.toString();
        }else {
            if(xCount == 1){
                answer = "x";
            }else{
                answer = xCount + "x";
            }
            if(sb.length() != 0){
                answer += " + " + sb;
            }
        }

        return answer;
    }

    public static int solution100(int[][] office, int k){
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

    public static int solution101(int n){
        List<Double> sumList = new ArrayList<>();
        double sum = 1;
        sumList.add(sum);

        for(int i = 1; i < n; i++){
            double pow = Math.pow(3, i);
            sumList.add(pow);
            sum += pow;
            sumList.add(sum);
        }


        return 0;
    }

    public static void main(String[] args) {

        System.out.println(solution101(4));
        /*
        System.out.println(solution100(new int[][]{{1,0,0,0}, {0,0,0,1}, {0,0,1,0},{0,1,1,0}}, 1));
        System.out.println(solution100(new int[][]{{1,0,0,0}, {0,0,0,1}, {0,0,1,0},{0,1,1,0}}, 2));
        System.out.println(solution100(new int[][]{{1,0,0,0}, {0,0,0,1}, {0,0,1,0},{0,1,1,0}}, 3));
        System.out.println(solution100(new int[][]{{1,0,0,0}, {0,0,0,1}, {0,0,1,0},{0,1,1,0}}, 4));
        System.out.println(solution100(new int[][]{{1,0,0,0}, {0,0,0,1}, {0,0,1,0},{0,1,1,0}}, 5));
        System.out.println(solution100(new int[][]{{1,0,0,0}, {0,0,0,1}, {0,0,1,0},{0,1,1,0}}, 20));
        System.out.println(solution100(new int[][]{{1,0,0}, {0,0,1}, {1,0,0}}, 2));
        */



//        System.out.println(solution120863("3x + 7 + x"));
        //System.out.println(solution120863("21 + 2x + 7 + x + 100 + 223x"));

        //System.out.println(Arrays.deepToString(solution(3, new int[][]{{1, 2}})));
        //System.out.println(Arrays.deepToString(solution(3, new int[][]{{1, 2}, {3, 3}})));
        //System.out.println(solution(new int[]{5,27,9,0,31,123,435,34,123,5555,6210101,33,1}));
        //System.out.println(solution(new int[]{1,1,4,1231,2131,0, 1,1145435234}));
        //System.out.println(solution(new int[]{1,2,4,8}));
        //System.out.println(solution(new int[]{1,2,4,8}));
    }
}