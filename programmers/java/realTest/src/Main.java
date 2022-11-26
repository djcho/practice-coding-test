import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Main {

    static class Player{
        public String name;
        public List<Integer> scores;

        public Player(String name, List<Integer> scores){
            this.name = name;
            this.scores = scores;
        }
    }

    public static void main(String[] args) {
        System.out.println("Hello world!");
        String[] testCase = {"jack:9,10,13,9,15",
                "jerry:7,7,14,10,17",
                "jean:0,0,11,20,0",
                "alex:21,2,7,11,4",
                "kevin:8,4,5,0,0",
                "brown:3,5,16,3,8",
                "ted:0,8,0,0,8",
                "lala:0,12,0,7,9",
                "hue:17,16,8,6,10",
                "else:11,13,10,4,13"
        };
        String[] answer = solution(testCase);
    }

    public static String[] solution(String[] record){
        List<Player> players  = parsePlayer(record);

        removePlayerByCourseCount(players);
        removePlayerByCourseScore(players);
        removePlayerByMedalScore(players);

        List<String> playerList = new ArrayList<>();

        for(Player player : players){
            playerList.add(player.name);
        }
        return playerList.toArray(new String[0]);
    }

    static class ScoreComparator implements Comparator<Player> {
        private int trackIndex;
        public ScoreComparator(int trackIndex){
            this.trackIndex = trackIndex;
        }
        @Override
        public int compare(Player p1, Player p2) {
            if(p1.scores.get(trackIndex) < p2.scores.get(trackIndex))
                return 1;
            else if(p1.scores.get(trackIndex) > p2.scores.get(trackIndex))
                return -1;
            return 0;
        }
    }


    private static void removePlayerByMedalScore(List<Player> players) {
        players.sort(new ScoreComparator(0));

    }

    private static void removePlayerByCourseScore(List<Player> players) {
        List<Player> temp = new ArrayList<>(players);

        int max = 0;
        for(Player player : temp) {

            int playerScore = 0;
            for(int i = 0; i < player.scores.size(); i++){
                if(player.scores.get(i) == 0)
                    continue;
                playerScore += i+1;
            }
            if(max <= playerScore)
                max = playerScore;
            else
                players.remove(player);
        }
    }

    public static void removePlayerByCourseCount(List<Player> players){
        int max = 0;
        List<Player> temp = new ArrayList<>(players);
        for(Player player : temp){
            int finishCount = player.scores.size() - Collections.frequency(player.scores, 0);
            if(max <= finishCount)
                max = finishCount;
            else
                players.remove(player);
        }
    }

    public static List<Player> parsePlayer(String[] records){
        List<Player> playerList = new ArrayList<>();

        for(String record : records){
            String[] ss = record.split(":");

            String[] scoreArray = ss[1].split(",");
            List<Integer> scores = new ArrayList<>();
            for(String s : scoreArray){
                scores.add(Integer.parseInt(s));
            }
            playerList.add(new Player(ss[0], scores));
        }
        return playerList;
    }
}