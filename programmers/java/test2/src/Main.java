import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        int[] fees = {180, 5000, 10, 600};
        String[] records = {
                "05:34 5961 IN", //334
                "06:00 0000 IN", // 300
                "06:34 0000 OUT", // 334 - 300 = 34
                "07:59 5961 OUT", //479 - 334 = 145
                "07:59 0148 IN",
                "18:59 0000 IN",  // 34 + 1139 = 1173
                "19:09 0148 OUT",
                "22:59 5961 IN", // 145 + 1379 = 1524
                "23:00 5961 OUT"}; // 1524 - 1380 = 144

        solution(fees,records);
    }

    public static int[] solution(int[] fees, String[] records) {
        int[] answer = {};

        int defaultMin = fees[0];
        int defaultPrice = fees[1];
        int timeUnit = fees[2];
        int overCharge = fees[3];

        Map<String, Integer> map = new HashMap<>();

        for(String record : records){
            String [] splitStr = record.split(" ");
            map.put(splitStr[1], getMinute(splitStr[0]));


            int
        }



        return answer;
    }
}