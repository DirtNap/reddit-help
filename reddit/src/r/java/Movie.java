package r.java;

public class Movie {
    private String name;
    private int runTime;

    public Movie(String n, int r) {
        this.name = n;
        this.runTime = r;
    }

    public String getName() {
        return this.name;
    }

    public void changeName(String n) {
        this.name = n;
    }

    public int getRunTimne() {
        return this.runTime;
    }

    public void extended(int extraTime) {
        this.runTime += extraTime;
    }
}