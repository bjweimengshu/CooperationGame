package player;

import java.util.Random;

/**
 * Created by bjwei on 2020/4/25.
 */
public class OccasionallyBadPlayer extends Player {

    final static int BETRAY_RATE = 10;

    public OccasionallyBadPlayer(int id, String name) {
        super(id, name);
    }

    @Override
    public boolean play(int partnerId, int round, int totalRound) {
        Random random = new Random();
        if(random.nextInt(BETRAY_RATE) == 0){
            return false;
        }
        return true;
    }

    @Override
    public void feedback(int partnerId, boolean result) {

    }
}
