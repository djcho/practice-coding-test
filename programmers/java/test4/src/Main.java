public class Main {
    public static void main(String[] args) {
        System.out.println(solution("3people unFollowed me"));
        System.out.println(solution("for the last week"));
        System.out.println(solution("my   test   1da  "));
    }

    public static String solution(String s) {
        String answer = "";
        boolean blank = true;

        String[] split = s.toLowerCase().split("");
        for (String str : split){
            answer += blank ? str.toUpperCase() : str;
            blank = str.equals(" ") ? true : false;
        }
        return answer;
    }
}