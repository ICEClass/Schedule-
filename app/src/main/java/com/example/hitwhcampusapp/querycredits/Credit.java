package com.example.hitwhcampusapp.querycredits;

public class Credit {
    private String name;

    /* termCredits的下标用于控制是哪个学期，
        1为大一上学期，2为大一下学期，3为大一夏季学期，
        4为大二上学期，5为大二下学期，6为大二夏季学期，
        7为大三上学期，8为大三下学期，9为大三夏季学期，
        10为大四上学期，11为大四下学期
     */
    private double[] termCredits = new double[15];
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
        double sum = 0.0;
        for (int i = 1; i <= 11; ++i) sum += termCredits[i];
        return sum;
    }

    public void setTermCredit(int term, double credit) {
        termCredits[term] = credit;
    }

    public double getTermCredit(int term) {
        return termCredits[term];
    }
}
