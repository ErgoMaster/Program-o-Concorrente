package model;

public class Chair {
    private int id;
    private int state = 0;

    public Chair(int id) {
        this.id = id;
    }

    public void changeState() {
        this.state = 1;
    }

    public int getId() {
        return this.id;
    }

    public int getState() {
        return this.state;
    }
}
