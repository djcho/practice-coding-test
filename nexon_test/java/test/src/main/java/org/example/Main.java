package org.example;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.PrintWriter;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {

    public static List<Integer> solution1(List<Integer> a, List<Integer> rotate) {
        List<Integer> answer = new ArrayList<>();

        final int maxIndex = getMaxIndex(a);

        for(Integer r : rotate){
            int index = maxIndex;
            List<Integer> temp = new ArrayList<>(a);
            r %= a.size();
            if(r != 0){
                List<Integer> subList = new ArrayList<>(temp.subList(0, r));
                temp.subList(0, r).clear();
                temp.addAll(subList);
                index = maxIndex - r;
                if(index < 0)
                    index = a.size() + index;
            }

            answer.add(index);
        }

        return answer;
    }

    private static Integer getMaxIndex(List<Integer> temp) {
        int max = 0;
        int maxIndex = 0;
        for(int i = 0; i < temp.size(); i++){
            if(temp.get(i) > max) {
                max = temp.get(i);
                maxIndex = i;
            }
        }
        return maxIndex;
    }


    private static final Scanner scan = new Scanner(System.in);

    public static void solution4() throws Exception {
        // read the string filename
        String filename;
        filename = scan.nextLine();

        Set<String> files = new LinkedHashSet<>();
        Pattern pattern = Pattern.compile("(?<=[/\\\\])[^/\\\\]+\\.(gif|GIF)");
        BufferedReader reader = new BufferedReader(new FileReader(filename));
        String line = null;
        while( (line = reader.readLine()) != null ){
            Matcher matcher = pattern.matcher(line);
            if (matcher.find())
            {
                files.add(matcher.group());
            }
        }

        List<String> sortedList = new ArrayList<String>(files);
        Collections.sort(sortedList);

        PrintWriter writer = new PrintWriter("gifs_" + filename);
        for(String file : sortedList){
            System.out.println(file);
            writer.println(file);
        }
        writer.close();
    }


    public static int solution3(int[][] office, int k){
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
    public static int largestSubgrid(List<List<Integer>> grid, int maxSum){

        int gridSize = grid.size();
        int testSubGridSize = gridSize;

        while(testSubGridSize > 0){
            int subGridMaxSum = 0;
            for(int i = 0; i <= gridSize - testSubGridSize; i++){
                for(int j = 0; j <= gridSize- testSubGridSize; j++){
                    int sum = 0;
                    for(int k = 0; k < testSubGridSize; k++){
                        for(int l = 0; l < testSubGridSize; l++){
                            sum += grid.get(i+k).get(j+l);
                        }
                    }
                    if(subGridMaxSum < sum){
                        subGridMaxSum = sum;
                    }
                }
            }
            if(maxSum >= subGridMaxSum)
                break;

            testSubGridSize--;
        }

        return testSubGridSize;
    }
    public static void main(String[] args) {
        List<List<Integer>> grid = new ArrayList<>();
        List<Integer> row1 = new ArrayList<>();
        row1.add(2);
        row1.add(2);
        row1.add(2);
        List<Integer> row2 = new ArrayList<>();
        row2.add(3);
        row2.add(3);
        row2.add(3);

        List<Integer> row3 = new ArrayList<>();
        row3.add(4);
        row3.add(4);
        row3.add(4);

        grid.add(row1);
        grid.add(row2);
        grid.add(row3);

        System.out.println(largestSubgrid(grid, 4));
    }
}