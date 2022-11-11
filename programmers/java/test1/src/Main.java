public class Main {
    public static void main(String[] args) {
        solution(-1,-1);
        solution(110011,10);
    }

    public static int solution(int n, int k) {
        String strNumber = convertNotation(n,k);
        int answer = getPrimeNumberCount(strNumber);

        return answer;
    }

    private static String convertNotation(int n, int k){
        StringBuilder converted = new StringBuilder();
        while(n > 0){
            converted.append(n % k);
            n /= k;
        }
        return converted.reverse().toString();
    }

    private static boolean isPrimeNumber(long n){
        for(int i = 2; i <= Math.sqrt(n); i++)
            if(n % i == 0)
                return false;
        return true;
    }

    private static int getPrimeNumberCount(String strNumber){
        int count = 0;
        String[] split = strNumber.split("0");
        for (String str: split){
            if(str.equals("1") || str.isEmpty())
                continue;

            if(isPrimeNumber(Long.parseLong(str)))
                count++;
        }
        return count;
    }
}