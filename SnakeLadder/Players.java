package lld.snakeladder;

import java.util.UUID;

public class Players {

    private String name;
    private String uid;

    public Players(String name) {
        this.name = name;
        this.uid = UUID.randomUUID().toString();
    }

    public Players(String name, String uid) {
        this.name = name;
        this.uid = uid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }
}
