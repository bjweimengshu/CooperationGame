package player;

/**
 * Created by bjwei on 2020/4/25.
 */
public class RevengePlayer extends Player {

    public RevengePlayer(int id, String name) {
        super(id, name);
    }

    @Override
    public boolean play(int partnerId, int round, int totalRound) {
        if(blackSet.contains(partnerId)){
            return false;
        }
        return true;
    }

    @Override
    public void feedback(int partnerId, boolean result) {
        if(!result){
            blackSet.add(partnerId);
        }
    }
}
