import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        int[] A = {1, 4, 2};
        int[] B = {5, 4, 4};

        System.out.println(solution(A, B));
    }

    public static int solution(int []A, int []B)
    {
        Arrays.sort(A);
        Arrays.sort(B);

        int answer = 0;
        for(int i = 0; i < A.length; i++){
            answer += A[i] * B[A.length - 1 - i];
        }

        return answer;
    }
}