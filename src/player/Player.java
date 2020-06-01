package player;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by bjwei on 2020/4/25.
 */
public abstract class Player {

    private int id;
    private String name;
    public int score;
    //黑名单，记录欺骗过自己的id
    Set<Integer> blackSet;

    public Player(int id, String name){
        this.setId(id);
        this.name = name;
        this.blackSet = new HashSet<>();
    }

    public abstract boolean play(int partnerId, int round, int totalRound);

    public abstract void feedback(int partnerId, boolean result);

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
