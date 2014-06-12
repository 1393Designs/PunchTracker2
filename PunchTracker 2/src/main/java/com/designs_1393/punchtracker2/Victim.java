package com.designs_1393.punchtracker2;

public class Victim {
    private long id;
    private String victimName;
    private int trackedNumber;

    public Victim() {}

    public Victim(String victimName, int trackedNumber) {
        this.victimName = victimName;
        this.trackedNumber = trackedNumber;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getVictimName() {
        return victimName;
    }

    public int getTrackedNumber() {
        return trackedNumber;
    }

    public void setVictimName (String victimName) {
        this.victimName = victimName;
    }

    public void setTrackedNumber(int trackedNumber) {
        this.trackedNumber = trackedNumber;
    }

    public void incrementTrackedNumber() {
        this.trackedNumber++;
    }

    public void decrementTrackedNumber() {
        this.trackedNumber--;
    }

}
