import java.util.Stack;

public class Main {
    public static void main(String[] args) {
        System.out.println(solution("()()"));
        System.out.println(solution("(())()"));
        System.out.println(solution(")()("));
        System.out.println(solution("(()("));
        System.out.println(solution("()))))"));
    }
    public static boolean solution(String s) {
        if(s.charAt(0) == ')' || s.charAt(s.length()-1) == '(')
            return false;

        Stack<Character> stack = new Stack<>();
        for(int i = 0; i < s.length(); i++){
            char ch = s.charAt(i);
            if(ch == '('){
                stack.push(ch);
            }
            else{
                if(stack.isEmpty())
                    return false;
                stack.pop();
            }
        }
        return stack.isEmpty();
    }
}