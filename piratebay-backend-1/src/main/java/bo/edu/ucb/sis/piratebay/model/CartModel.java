package bo.edu.ucb.sis.piratebay.model;

import java.util.Date;

public class CartModel {
    private int order_id;
    private String username;
    private String product;
    private double unit_price;
    private int quantity;
    private double total;

    public CartModel(int order_id, String username, String product, double unit_price, int quantity, double total) {
        this.order_id = order_id;
        this.username = username;
        this.product = product;
        this.unit_price = unit_price;
        this.quantity = quantity;
        this.total = total;
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

    public String getProduct() {
        return product;
    }

    public void setProduct(String product) {
        this.product = product;
    }

    public double getUnit_price() {
        return unit_price;
    }

    public void setUnit_price(double unit_price) {
        this.unit_price = unit_price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }
}
