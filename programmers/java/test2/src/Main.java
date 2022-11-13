import java.util.*;

public class Main {
    public static void main(String[] args) {
        /*
        int[] fees = {180, 5000, 10, 600};
        String[] records = {
                "05:34 5961 IN", //334
                "06:00 0000 IN", // 1439 + 300 = 1739
                "06:34 0000 OUT", // 1439 + 300 - 334 = 1434
                "07:59 5961 OUT", //479 - 334 = 145
                "07:59 0148 IN",
                "18:59 0000 IN",  // 34 + 1139 = 1173
                "19:09 0148 OUT",
                "22:59 5961 IN", // 145 + 1379 = 1524
                "23:00 5961 OUT"}; // 1524 - 1380 = 144

        solution(fees,records);
         */

        int[] fees = {1, 461, 1, 10};
        String[] records = {
                "00:00 1234 IN"}; // 1524 - 1380 = 144

        solution(fees,records);
    }

    static class Record {
        public String carNumber;
        public Integer usageTime;

        public Record(String carNumber, Integer usageTime){
            this.carNumber = carNumber;
            this.usageTime = -usageTime;
        }
    }

    public static int[] solution(int[] fees, String[] records) {
        List<Record> list = getUsageByCar(records);
        return getPayment(fees, list);
    }

    private static int[] getPayment(int[] fees, List<Record> list) {
        Collections.sort(list, Comparator.comparing(obj -> obj.carNumber));
        int[] payment = new int[list.size()];

        int defaultMin = fees[0];
        int defaultPrice = fees[1];
        int timeUnit = fees[2];
        int overCharge = fees[3];

        for (int i = 0; i < list.size(); i++) {
            int pay = defaultPrice;

            Record record = list.get(i);
            if(record.usageTime <= 0)
                record.usageTime += getMinute("23:59");
            if(record.usageTime > defaultMin)
                pay += Math.ceil((double) (record.usageTime - defaultMin) / timeUnit) * overCharge;
            payment[i] = pay;
        }

        return payment;
    }

    private static List<Record> getUsageByCar(String[] records) {
        List<Record> list = new ArrayList<>();

        for(String recordStr : records){
            String [] splitStr = recordStr.split(" ");
            int minute = getMinute(splitStr[0]);

            Record record = list.stream().filter(obj -> obj.carNumber.equals(splitStr[1]))
                    .findAny().orElse(null);

            if(record != null) {
                if (splitStr[2].equals("IN")) {
                    record.usageTime -= minute;
                } else {
                    record.usageTime += minute;
                }
            }
            else{
                list.add(new Record(splitStr[1], minute));
            }
        }
        return list;
    }

    private static int getMinute(String strMin){
        String[] splits = strMin.split(":");
        return (Integer.parseInt(splits[0]) * 60) + Integer.parseInt(splits[1]);
    }
}