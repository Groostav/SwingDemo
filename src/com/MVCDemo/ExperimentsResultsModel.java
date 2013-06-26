package com.MVCDemo;

/**
 * @author Geoff on 24/06/13
 */
public class ExperimentsResultsModel {
    private String name;
    private String title;
    private int n0;
    private double s0;

    public ExperimentsResultsModel(String name, String title, int n0, double s0) {
        this.name = name;
        this.title = title;
        this.n0 = n0;
        this.s0 = s0;
    }

    public String getName() {
        return name;
    }

    public String getTitle() {
        return title;
    }

    public int getN0() {
        return n0;
    }

    public double getS0() {
        return s0;
    }

    public void setN0(int n0) {
        this.n0 = n0;
    }
}
