package player;

/**
 * Created by bjwei on 2020/4/25.
 */
public class LateBadPlayer extends Player {

    final static float BETRAY_ROUND_RATE = 0.8f;

    public LateBadPlayer(int id, String name) {
        super(id, name);
    }

    @Override
    public boolean play(int partnerId, int round, int totalRound) {
        if(round>= totalRound*BETRAY_ROUND_RATE){
            return false;
        }
        if(blackSet.contains(partnerId)){
            return false;
        }
        return true;
    }

    @Override
    public void feedback(int partnerId, boolean result) {
        if(!result){
            blackSet.add(partnerId);
        }else {
            blackSet.remove(partnerId);
        }
    }
}
