package ohtu;

public class TennisGame {
    
    private int points1;
    private int points2;
    private String player1Name;
    private String player2Name;

    public TennisGame(String player1Name, String player2Name) {
        this.points2 = 0;
        this.points1 = 0;
        this.player1Name = player1Name;
        this.player2Name = player2Name;
    }

    public void wonPoint(String playerName) {
        if (playerName == "player1")
            points1 += 1;
        else
            points2 += 1;
    }

    public String getScore() {
        String score = "";
        int tempPoints=0;
        if (points1==points2) {
            return evenPointsToScores(points1);
        }
        
        if (points1>=4 || points2>=4)
        {
            int minusResult = points1-points2;
            if (minusResult==1) score ="Advantage player1";
            else if (minusResult ==-1) score ="Advantage player2";
            else if (minusResult>=2) score = "Win for player1";
            else score ="Win for player2";
        }
        else
        {
            for (int i=1; i<3; i++)
            {
                if (i==1) tempPoints = points1;
                else { score+="-"; tempPoints = points2;}
                score += pointsToScore(tempPoints);
            }
        }
        return score;
    }
    
    static String pointsToScore(int points) {
        String ret = "";
        switch (points) {
            case 0:
                ret = "Love";
                break;
            case 1:
                ret = "Fifteen";
                break;
            case 2:
                ret = "Thirty";
                break;
            case 3:
                ret = "Forty";
                break;
        }
        return ret;
    }

    private String evenPointsToScores(int points1) {
        String ret;
        if (points1 >= 0 && points1 <= 3) {
            ret = pointsToScore(points1) + "-All";
        } else {
            ret = "Deuce";
        }
        return ret;
    }
}