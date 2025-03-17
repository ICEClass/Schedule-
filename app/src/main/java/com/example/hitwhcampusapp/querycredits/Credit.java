package com.example.hitwhcampusapp.querycredits;

public class Credit {
    private String name;
    private double firstTermFirst;
    private double firstTermSecond;
    private double secondTermFirst;
    private double secondTermSecond;
    private double thirdTermFirst;
    private double thirdTermSecond;
    private double forthTermFirst;
    private double forthTermSecond;
    private double need;

    public Credit(String name, double need) {
        this.name = name;
        this.need = need;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getNeed() {
        return need;
    }

    public void setNeed(double need) {
        this.need = need;
    }

    public double getProgress() {
        return getSum() * 100 / need;
    }

    public double getSum() {
        return firstTermFirst + firstTermSecond + secondTermFirst + secondTermSecond + thirdTermFirst + thirdTermSecond + forthTermFirst + forthTermFirst;
    }

    public double getFirstTermFirst() {
        return firstTermFirst;
    }

    public void setFirstTermFirst(double firstTermFirst) {
        this.firstTermFirst = firstTermFirst;
    }

    public double getFirstTermSecond() {
        return firstTermSecond;
    }

    public void setFirstTermSecond(double firstTermSecond) {
        this.firstTermSecond = firstTermSecond;
    }

    public double getSecondTermFirst() {
        return secondTermFirst;
    }

    public void setSecondTermFirst(double secondTermFirst) {
        this.secondTermFirst = secondTermFirst;
    }

    public double getSecondTermSecond() {
        return secondTermSecond;
    }

    public void setSecondTermSecond(double secondTermSecond) {
        this.secondTermSecond = secondTermSecond;
    }

    public double getThirdTermFirst() {
        return thirdTermFirst;
    }

    public void setThirdTermFirst(double thirdTermFirst) {
        this.thirdTermFirst = thirdTermFirst;
    }

    public double getThirdTermSecond() {
        return thirdTermSecond;
    }

    public void setThirdTermSecond(double thirdTermSecond) {
        this.thirdTermSecond = thirdTermSecond;
    }

    public double getForthTermFirst() {
        return forthTermFirst;
    }

    public void setForthTermFirst(double forthTermFirst) {
        this.forthTermFirst = forthTermFirst;
    }

    public double getForthTermSecond() {
        return forthTermSecond;
    }

    public void setForthTermSecond(double forthTermSecond) {
        this.forthTermSecond = forthTermSecond;
    }
}
