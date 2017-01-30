package ru.academits.gusev.range;

public class Range {
    private double from;
    private double to;

    public Range(double from1, double to1) {
        this.from = from1;
        this.to = to1;
    }

    public double getFrom() {
        return from;
    }

    public double getTo() {
        return to;
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
        if (to < variant.getFrom() || from > variant.getTo()) {
            return null;
        }
        return new Range(from < variant.getFrom() ? variant.getFrom() : from, to < variant.getTo() ? to : variant.getTo());
    }

    public Range[] doUnion(Range variant) {

        if (to < variant.getFrom()) {
            return new Range[]{new Range(from, to), new Range(variant.getFrom(), variant.getTo())};
        }
        if (from > variant.getTo()) {
            return new Range[]{new Range(variant.getFrom(), variant.getTo()), new Range(from, to)};
        }
        return new Range[]{new Range(from < variant.getFrom() ? from : variant.getFrom(), to < variant.getTo() ? variant.getTo() : to)};
    }

    public Range[] doDifference(Range variant) {
        if (to < variant.getFrom() || from > variant.getTo()) {
            return new Range[]{new Range(from, to)};
        }
        if (from < variant.getFrom() && to > variant.getTo()) {
            return new Range[]{new Range(from, variant.getFrom()), new Range(variant.getTo(), to)};
        }
        return new Range[]{new Range(from < variant.getFrom() ? from : variant.getTo(), to < variant.getTo() ? variant.getFrom() : to)};
    }
}
