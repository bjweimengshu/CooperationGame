import player.*;

/**
 * Created by bjwei on 2020/4/25.
 */
public enum PlayerType {

    GOOD_PLAYER(1, "老实型") {
        @Override
        public Player createPlayer(int id) {
            return new GoodPlayer(id, this.getName());
        }
    },
    BAD_PLAYER(2, "骗子型") {
        @Override
        public Player createPlayer(int id) {
            return new BadPlayer(id, this.getName());
        }
    },
    OCCASIONALLY_BAD_PLAYER(3, "偶尔欺骗型") {
        @Override
        public Player createPlayer(int id) {
            return new OccasionallyBadPlayer(id, this.getName());
        }
    },
    MIRROR_PLAYER(4, "一报还一报型") {
        @Override
        public Player createPlayer(int id) {
            return new MirrorPlayer(id, this.getName());
        }
    },
    REVENGE_PLAYER(5, "记仇到底型") {
        @Override
        public Player createPlayer(int id) {
            return new RevengePlayer(id, this.getName());
        }
    },
    LATE_BAD_PLAYER(6, "晚节不保型") {
        @Override
        public Player createPlayer(int id) {
            return new LateBadPlayer(id, this.getName());
        }
    },
    ;

    PlayerType(int code, String name){
        this.code = code;
        this.name = name;
    }

    private int code;
    private String name;

    public int getCode() {
        return code;
    }

    public String getName() {
        return name;
    }

    public abstract Player createPlayer(int id);

    public static PlayerType getTypeByCode(int code){

        for (PlayerType type: PlayerType.values()) {
            if (type.getCode() == code) {
                return type;
            }
        }
        return null;
    }
}
