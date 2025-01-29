package com.in28minutes.microservices.limitsservice.bean;

public class Limits {
    private int min;
    private int max;

    public Limits() {}

    public Limits(int min, int max) {
        this.min = min;
        this.max = max;
    }

    public int getMin() {
        return min;
    }

    public Limits setMin(int min) {
        this.min = min;
        return this;
    }

    public int getMax() {
        return max;
    }

    public Limits setMax(int max) {
        this.max = max;
        return this;
    }
}
