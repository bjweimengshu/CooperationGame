import player.*;
import java.util.*;

/**
 * Created by bjwei on 2020/4/25.
 */
public class Game {

    final static int COOPERATE_SCORE = 10;
    final static int BETRAY_WIN_SCORE = 15;
    final static int BETRAY_LOST_SCORE = -5;

    List<Player> playerList;
    List<Player> groupA;
    List<Player> groupB;

    //游戏主逻辑
    public void gameBegin(int playNum, int totalRound){
        if((playNum&1)==1 || playNum<=0 || totalRound<=0){
            System.out.println("参数非法！");
            return;
        }
        //初始化玩家
        initPlayers(playNum);
        for(int i=1; i<=totalRound; i++){
            //每回合重新分组
            reGroup();
            //回合内互动
            interact(i, totalRound);
        }
        output();
    }

    //初始化玩家
    private void initPlayers(int playNum){
        Random random = new Random();
        playerList = new ArrayList<>();
        for(int i=1; i<=playNum; i++){
            int type =  random.nextInt(PlayerType.values().length)+1;
            Player player = PlayerType.getTypeByCode(type).createPlayer(i);
            playerList.add(player);
        }
    }

    //重新分组
    private void reGroup() {
        Random random = new Random();
        groupA = new ArrayList<>();
        groupB = new ArrayList<>();

        for(Player player : playerList){
            groupA.add(player);
        }

        for(int i=0; i<playerList.size()/2; i++){
            Player player = groupA.remove(random.nextInt(groupA.size()));
            groupB.add(player);
        }
    }

    //回合内互动
    private void interact(int round, int totalRound){
        for(int j=0; j<playerList.size()/2; j++){
            Player playerA = groupA.get(j);
            Player playerB = groupB.get(j);
            boolean resultA = playerA.play(playerB.getId(), round, totalRound);
            boolean resultB = playerB.play(playerA.getId(), round, totalRound);
            calculate(playerA, resultA, playerB, resultB);
            playerA.feedback(playerB.getId(), resultB);
            playerB.feedback(playerA.getId(), resultA);
        }
    }

    //根据双方行为计算分值
    private void calculate(Player playerA, boolean resultA, Player playerB, boolean resultB){
        if(resultA){
            if(resultB){
                playerA.score += COOPERATE_SCORE;
                playerB.score += COOPERATE_SCORE;
            }else {
                playerA.score += BETRAY_LOST_SCORE;
                playerB.score += BETRAY_WIN_SCORE;
            }
        }else {
            if(resultB){
                playerA.score += BETRAY_WIN_SCORE;
                playerB.score -= BETRAY_LOST_SCORE;
            }
        }
    }

    //输出最终结果
    private void output(){
        playerList.sort((a, b) -> b.score - a.score);
        for(Player player : playerList){
            System.out.println("id:" + player.getId() + "  类型：" + player.getName() + "  得分：" + player.score);
        }
    }

    public static void main(String[] args) {
        Game game = new Game();
        game.gameBegin(20, 300);
    }

}
