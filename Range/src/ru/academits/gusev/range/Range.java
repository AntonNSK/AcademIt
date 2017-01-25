package ru.academits.gusev.range;

public class Range {
    private int from;
    private int to;

    public Range(int from, int to) {
        this.from = from;
        this.to = to;
    }

    public int getFrom() {
        return from;
    }

    public int getTo() {
        return to;
    }

    public void setFrom(int from) {
        this.from = from;
    }

    public void setTo(int to) {
        this.to = to;
    }

    public boolean isInside(int number) {
        for (int i = from; i <= to; i++) {
            if (i == number) {
                return true;
            }
        }
        return false;
    }

}
