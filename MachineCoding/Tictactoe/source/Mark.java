package lld.tictac;

public class Mark {
    private String id;
    private MarkType type;
    private Player player;

    public Mark( MarkType type, Player player) {
        this.type = type;
        this.player = player;
    }

    public Mark(String id, MarkType type, Player player) {
        this.id = id;
        this.type = type;
        this.player = player;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public MarkType getType() {
        return type;
    }

    public void setType(MarkType type) {
        this.type = type;
    }

    public Player getPlayer() {
        return player;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }
}
