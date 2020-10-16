package bo.edu.ucb.sis.piratebay.model;

public class DetailOrderModel {
    private int provider_product_id;
    private String product_name;
    private double unit_price;

    public DetailOrderModel(int provider_product_id, String product_name, double unit_price) {
        this.provider_product_id = provider_product_id;
        this.product_name = product_name;
        this.unit_price = unit_price;
    }

    public int getProvider_product_id() {
        return provider_product_id;
    }

    public void setProvider_product_id(int provider_product_id) {
        this.provider_product_id = provider_product_id;
    }

    public String getProduct_name() {
        return product_name;
    }

    public void setProduct_name(String product_name) {
        this.product_name = product_name;
    }

    public double getUnit_price() {
        return unit_price;
    }

    public void setUnit_price(double unit_price) {
        this.unit_price = unit_price;
    }
}
