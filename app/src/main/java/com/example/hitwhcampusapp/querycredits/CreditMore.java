package com.example.hitwhcampusapp.querycredits;

public class CreditMore {
    private String source;
    private String time;
    private double credit;

    public CreditMore(String source, String time, double credit) {
        this.source = source;
        this.time = time;
        this.credit = credit;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public double getCredit() {
        return credit;
    }

    public void setCredit(double credit) {
        this.credit = credit;
    }
}
