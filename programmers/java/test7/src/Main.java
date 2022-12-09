import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        System.out.println(solution(78));
        System.out.println(solution(15));

        int[] cards = {8,6,3,7,2,5,1,4};
        System.out.println(solution(cards));
    }
    public static int solution(int[] cards) {
        List<Integer> groups = new ArrayList<>();
        boolean[] opened = new boolean[cards.length];

        for(int i = 0; i < cards.length; i++){
            int cardNumber = cards[i];
            int count = 0;
            while(!opened[cardNumber-1]){
                opened[cardNumber-1] = true;
                cardNumber = cards[cardNumber-1];
                count++;
            }
            if(count != 0)
                groups.add(count);
        }

        Collections.sort(groups, Collections.reverseOrder());

        return groups.size() == 1 ? 0 : groups.get(0) * groups.get(1);
    }

    public static int getOneCount(int n){
        int count = 0;
        while(n != 0){
            if(n%2 == 1)
                count++;
            n/=2;
        }
        return count;
    }

    public static int solution(int n) {
        int answer = 0;
        int count = getOneCount(n);
        while(true){
            if(getOneCount(++n) == count){
                answer = n;
                break;
            }
        }
        return answer;
    }
}