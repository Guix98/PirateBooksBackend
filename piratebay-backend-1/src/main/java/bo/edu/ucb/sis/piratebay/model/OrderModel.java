package bo.edu.ucb.sis.piratebay.model;

import java.util.Date;

public class OrderModel {
    private int order_id;
    private String username;
    private Date date;
    private String email;
    private String phone_number;

    public OrderModel(int order_id, String username, Date date, String email, String phone_number) {
        this.order_id = order_id;
        this.username = username;
        this.date = date;
        this.email = email;
        this.phone_number = phone_number;
    }

    public int getOrder_id() {
        return order_id;
    }

    public void setOrder_id(int order_id) {
        this.order_id = order_id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone_number() {
        return phone_number;
    }

    public void setPhone_number(String phone_number) {
        this.phone_number = phone_number;
    }
}
