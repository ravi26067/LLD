package models;

public class ParkingLot {
    int suvSpaceCount;
    int hatckbackSpaceCount;
    int suvCount;
    int hatchbackCount;

    public ParkingLot(int suvSpaceCount, int hatckbackSpaceCount) {
        this.suvSpaceCount = suvSpaceCount;
        this.hatckbackSpaceCount = hatckbackSpaceCount;
    }

    public int getSuvSpaceCount() {
        return suvSpaceCount;
    }

    public void setSuvSpaceCount(int suvSpaceCount) {
        this.suvSpaceCount = suvSpaceCount;
    }

    public int getHatckbackSpaceCount() {
        return hatckbackSpaceCount;
    }

    public void setHatckbackSpaceCount(int hatckbackSpaceCount) {
        this.hatckbackSpaceCount = hatckbackSpaceCount;
    }

    public int getSuvCount() {
        return suvCount;
    }

    public void increaseSuvCount() {
        this.suvCount++;
    }

    public void deccreaseSuvCount() {
        this.suvCount++;
    }

    public int getHatchbackCount() {
        return hatchbackCount;
    }

    public void increaseHatchbackCount() {
        this.hatchbackCount++;
    }

    public void deccreaseHatchbackCount() {
        this.hatchbackCount--;
    }

}
