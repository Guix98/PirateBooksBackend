package bo.edu.ucb.sis.piratebay.model;

public class ProductsModel {
    private String product_name;
    private String product_code;
    private String product_description;
    private String image;
    private String author;
    private Double unit_price;

    public ProductsModel(int anInt, String string, String resultSetString, String setString, String s, String string1, double aDouble){

    }
    public ProductsModel(String product_name, String product_code, String product_description, String image, String author, Double unit_price) {
        this.product_name = product_name;
        this.product_code = product_code;
        this.product_description = product_description;
        this.image = image;
        this.author = author;
        this.unit_price = unit_price;
    }

    public String getProduct_name() {
        return product_name;
    }

    public void setProduct_name(String product_name) {
        this.product_name = product_name;
    }

    public String getProduct_code() {
        return product_code;
    }

    public void setProduct_code(String product_code) {
        this.product_code = product_code;
    }

    public String getProduct_description() {
        return product_description;
    }

    public void setProduct_description(String product_description) {
        this.product_description = product_description;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public Double getUnit_price() {
        return unit_price;
    }

    public void setUnit_price(Double unit_price) {
        this.unit_price = unit_price;
    }

    @Override
    public String toString() {
        return "ProductsModel{" +
                "product_name='" + product_name + '\'' +
                ", product_code='" + product_code + '\'' +
                ", product_description='" + product_description + '\'' +
                ", image='" + image + '\'' +
                ", author='" + author + '\'' +
                ", unit_price=" + unit_price +
                '}';
    }
}
