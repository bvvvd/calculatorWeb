package ru.spbu.models;

import java.util.Date;

public class Calculation {
    private int id;
    private String expression;
    private double result;
    private int userId;
    private Date date;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getExpression() {
        return expression;
    }

    public void setExpression(String expression) {
        this.expression = expression;
    }

    public double getResult() {
        return result;
    }

    public void setResult(double result) {
        this.result = result;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Calculation(int id, String expression, double result, int userId, Date date) {

        this.id = id;
        this.expression = expression;
        this.result = result;
        this.userId = userId;
        this.date = date;
    }

    public Calculation() {

    }
}
