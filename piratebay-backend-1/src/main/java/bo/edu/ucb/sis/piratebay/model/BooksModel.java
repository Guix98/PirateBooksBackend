package bo.edu.ucb.sis.piratebay.model;

public class BooksModel {
    private String category_name;
    private String product_code;
    private String author;
    private String product_name;
    private String product_description;
    private String image;
    private Double unit_price;

    public BooksModel(String category_name, String product_code, String author, String product_name, String product_description, String image, Double unit_price) {
        this.category_name = category_name;
        this.product_code = product_code;
        this.author = author;
        this.product_name = product_name;
        this.product_description = product_description;
        this.image = image;
        this.unit_price = unit_price;
    }



    public String getCategory_name() {
        return category_name;
    }

    public void setCategory_name(String category_name) {
        this.category_name = category_name;
    }

    public String getProduct_code() {
        return product_code;
    }

    public void setProduct_code(String product_code) {
        this.product_code = product_code;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getProduct_name() {
        return product_name;
    }

    public void setProduct_name(String product_name) {
        this.product_name = product_name;
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

    public Double getUnit_price() {
        return unit_price;
    }

    public void setUnit_price(Double unit_price) {
        this.unit_price = unit_price;
    }

    @Override
    public String toString() {
        return "Books{" +
                "category_name='" + category_name + '\'' +
                ", product_code='" + product_code + '\'' +
                ", author='" + author + '\'' +
                ", product_name='" + product_name + '\'' +
                ", product_description='" + product_description + '\'' +
                ", image='" + image + '\'' +
                ", unit_price='" + unit_price + '\'' +
                '}';
    }
}
