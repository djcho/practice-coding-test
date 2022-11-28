import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Main {
    public static void main(String[] args) {
//        System.out.println(solution(1,2,6));
//        System.out.println(solution(4,4,6));
//        System.out.println(solution(8,5,3));
//        System.out.println(solution(1,1,2));
//        System.out.println(solution(1,1,3));
//        System.out.println(solution(1,1,4));
//        System.out.println(solution(1,2,2));

        List<Integer> cost = new ArrayList<>();
        for(int i = 0 ; i< (int)Math.pow(10,5); i++){
            cost.add((int)Math.pow(10,5));
        }
//
//        cost.add((int)Math.pow(10,5));
//        cost.add((int)Math.pow(10,5));
//        cost.add((int)Math.pow(10,5));
//        cost.add((int)Math.pow(10,5));
//        cost.add((int)Math.pow(10,5));
//        cost.add((int)Math.pow(10,5));
//        cost.add((int)Math.pow(10,5));
//        cost.add((int)Math.pow(10,5));
        System.out.println(solution(cost,(int)Math.pow(10,9)));

    }
    public static int solution(List<Integer> cost, int x) {
        // Write your code here
        long count = 0;
        for(int i = cost.size()-1; i >= 0; i--){
            if(cost.get(i) <= x) {
                count += (int) Math.pow(2, i);
                x -= cost.get(i);
            }
        }

        if(count > (int)(Math.pow(10,9) + 7))
            count = count % (int)(Math.pow(10,9) + 7);

        return (int)count;
    }


    public static int solution1(int x, int y, int z) {
        //distance
        int distance = Math.abs(x-y);
        if(distance > z)
            return -1;
        int freeDistance = (distance + z)/2;
        return x < y ? x + freeDistance : y + freeDistance;
    }
}