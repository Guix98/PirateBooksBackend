package bo.edu.ucb.sis.piratebay.model;

import java.util.Date;

public class OrderModel {
    private int order_id;
    private String userid;
    private Date date;
    private double amount;

    public OrderModel(int order_id, String userid, Date date, double amount) {
        this.order_id = order_id;
        this.userid = userid;
        this.date = date;
        this.amount = amount;
    }

    public int getOrder_id() {
        return order_id;
    }

    public void setOrder_id(int order_id) {
        this.order_id = order_id;
    }

    public String getUserid() {
        return userid;
    }

    public void setUserid(String userid) {
        this.userid = userid;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }
}
