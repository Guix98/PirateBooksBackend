package bo.edu.ucb.sis.piratebay.model;

public class ProductProviderModel {

    private String product_code;
    private String product_name;
    private String author;
    private double unit_price;
    private String category_name;

    public ProductProviderModel(String product_code, String product_name, String author, double unit_price, String category_name) {
        this.product_code = product_code;
        this.product_name = product_name;
        this.author = author;
        this.unit_price = unit_price;
        this.category_name = category_name;
    }

    public String getProduct_code() {
        return product_code;
    }

    public void setProduct_code(String product_code) {
        this.product_code = product_code;
    }

    public String getProduct_name() {
        return product_name;
    }

    public void setProduct_name(String product_name) {
        this.product_name = product_name;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public double getUnit_price() {
        return unit_price;
    }

    public void setUnit_price(double unit_price) {
        this.unit_price = unit_price;
    }

    public String getCategory_name() {
        return category_name;
    }

    public void setCategory_name(String category_name) {
        this.category_name = category_name;
    }
}
