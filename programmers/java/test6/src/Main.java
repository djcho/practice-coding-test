public class Main {
    public static void main(String[] args) {

        System.out.println(solution("1924", 2));
    }

    public static String solution(String number, int k) {
        String answer = "";

        for(int i = 0; i < number.length(); i++){
            for(int j = i + 1; j < number.length(); j++){
                Character.getNumericValue(number.charAt(i));
            }

        }

        return answer;
    }

}