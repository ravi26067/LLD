package models;

public class Ticket {
    private int id;
    private int entryTime;
    private String carNumer;

    public Ticket(int id, int entryTime, String carNumer) {
        this.id = id;
        this.entryTime = entryTime;
        this.carNumer = carNumer;
    }

    public int getId() {
        return id;
    }

    public int getEntryTime() {
        return entryTime;
    }

    public String getCarNumer() {
        return carNumer;
    }

}
