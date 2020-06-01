package player;

/**
 * Created by bjwei on 2020/4/25.
 */
public class GoodPlayer extends Player {

    public GoodPlayer(int id, String name) {
        super(id, name);
    }

    @Override
    public boolean play(int partnerId, int round, int totalRound) {
        return true;
    }

    @Override
    public void feedback(int partnerId, boolean result) {

    }
}
