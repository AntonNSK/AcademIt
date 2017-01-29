package ru.academits.gusev.range;

public class Range {
    private double from;
    private double to;
    private double from1;
    private double to1;

    public Range(double from1, double to1) {
        this.from = from1;
        this.to = to1;
    }

    public Range(double from, double to, double from1, double to1) {
        this.from = from;
        this.to = to;
        this.from1 = from1;
        this.to1 = to1;
    }

    public double getFrom() {
        return from;
    }

    public double getTo() {
        return to;
    }

    public double getFrom1() {
        return from1;
    }

    public double getTo1() {
        return to1;
    }

    public void setFrom(double from) {
        this.from = from;
    }

    public void setTo(double to) {
        this.to = to;
    }

    public boolean isInside(double number) {
        return (number >= from && number <= to);
    }

    public double calculateLength() {
        return (to - from);
    }

    public Range doIntersection(Range variant) {
        double from = this.from;
        double to = this.to;
        double from1 = variant.getFrom();
        double to1 = variant.getTo();

        if (to < from1 || from > to1) {
            return null;
        }
        return new Range(from < from1 ? from1 : from, to < to1 ? to : to1);
    }

    public Range doUnion(Range variant) {
        double from = this.from;
        double to = this.to;
        double from1 = variant.getFrom();
        double to1 = variant.getTo();

        if (to < from1 || from > to1) {
            return new Range(from, to, from1, to1);
        }
        return new Range(from < from1 ? from : from1, to < to1 ? to1 : to);
    }

    public Range doDifference(Range variant) {
        double from = this.from;
        double to = this.to;
        double from1 = variant.getFrom();
        double to1 = variant.getTo();

        if (to < from1 || from > to1) {
            return new Range(from, to);
        }
        if (from < from1 && to > to1) {
            return new Range(from, from1, to1, to);
        }
        return new Range(from < from1 ? from : to1, to < to1 ? from1 : to);
    }
}
