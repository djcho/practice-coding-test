public class Main {
    public static void main(String[] args) {

//        int[][] board = {
//                {5,5,5,5,5},
//                {5,5,5,5,5},
//                {5,5,5,5,5},
//                {5,5,5,5,5}};
//
//        int[][] skill = {
//                {1,0,0,3,4,4},
//                {1,2,0,2,3,2},
//                {2,1,0,3,1,2},
//                {1,0,1,3,3,1}};


        int[][] board = {
                {1,2,3},
                {4,5,6},
                {7,8,9}};

        int[][] skill = {
                {1,1,1,2,2,4},
                {1,0,0,1,1,2},
                {2,2,0,2,0,100},
                {1,0,1,3,3,1}};

        solution(board, skill);
    }

    public static int solution(int[][] board, int[][] skill) {
        for(int i = 0; i < skill.length; i++){
            int damageOrHeal = skill[i][0] == 1 ? -1 : 1;
            applySkill(board, skill[i][1],skill[i][2], skill[i][3],skill[i][4], skill[i][5] * damageOrHeal);
        }
        int answer = 0;
        for(int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if (board[i][j] <= 0)
                    answer++;
            }
        }
        return answer;
    }

    public static void applySkill(int[][]board, int x1, int y1, int x2, int y2, int degree){
        for(int i = x1; i <= x2; i++){
            for(int j = y1; j <= y2; j++){
                board[i][j] += degree;
            }
        }
    }
}