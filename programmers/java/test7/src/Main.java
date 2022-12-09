import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
//        System.out.println(solution(78));
//        System.out.println(solution(15));

        int[] cards = {8,6,3,7,2,5,1,4};
        System.out.println(solution(cards));
    }
    public static int solution(int[] cards) {
        int answer = 0;

        List<Integer> boxes = Arrays.stream(cards).boxed().collect(Collectors.toList());
        List<Integer> groups = new ArrayList<>();
        boolean[] opened = new boolean[cards.length];

        opened[0] = true;
        while(!boxes.isEmpty()){
            int cardNumber = boxes.get(0);
            boxes.remove(0);

            int count = 0;
            while(!opened[cardNumber-1]){
                opened[cardNumber-1] = true;

                cardNumber = boxes.get(cardNumber-1);

                count++;
            }
            groups.add(count);
        }


        return answer;
    }

//    public static int getOneCount(int n){
//        int count = 0;
//        while(n != 0){
//            if(n%2 == 1)
//                count++;
//            n/=2;
//        }
//        return count;
//    }
//
//    public static int solution(int n) {
//        int answer = 0;
//        int count = getOneCount(n);
//        while(true){
//            if(getOneCount(++n) == count){
//                answer = n;
//                break;
//            }
//        }
//        return answer;
//    }
}