package bo.edu.ucb.sis.piratebay.model;

public class RegisterPersonModel {
    private String first_name;
    private String second_name;
    private String third_name;
    private String first_surname;
    private String second_surname;
    private String third_surname;
    private String birthdate;
    private String zone_direction;
    private String street_direction;
    private String document_id;
    private String document_expedition;
    private String cat_document_type;
    private String cat_genre;
    private String marital_status;

    public RegisterPersonModel(String first_name, String second_name, String thrid_name, String first_surname, String second_surname, String thrid_surname, String birthdate, String zone_direction, String street_direction, String document_id, String document_expedition, String cat_document_type, String cat_genre, String marital_status) {
        this.first_name = first_name;
        this.second_name = second_name;
        this.third_name = thrid_name;
        this.first_surname = first_surname;
        this.second_surname = second_surname;
        this.third_surname = thrid_surname;
        this.birthdate = birthdate;
        this.zone_direction = zone_direction;
        this.street_direction = street_direction;
        this.document_id = document_id;
        this.document_expedition = document_expedition;
        this.cat_document_type = cat_document_type;
        this.cat_genre = cat_genre;
        this.marital_status = marital_status;
    }

    public String getFirst_name() {
        return first_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public String getSecond_name() {
        return second_name;
    }

    public void setSecond_name(String second_name) {
        this.second_name = second_name;
    }

    public String getThird_name() {
        return third_name;
    }

    public void setThird_name(String third_name) {
        this.third_name = third_name;
    }

    public String getFirst_surname() {
        return first_surname;
    }

    public void setFirst_surname(String first_surname) {
        this.first_surname = first_surname;
    }

    public String getSecond_surname() {
        return second_surname;
    }

    public void setSecond_surname(String second_surname) {
        this.second_surname = second_surname;
    }

    public String getThird_surname() {
        return third_surname;
    }

    public void setThird_surname(String third_surname) {
        this.third_surname = third_surname;
    }

    public String getBirthdate() {
        return birthdate;
    }

    public void setBirthdate(String birthdate) {
        this.birthdate = birthdate;
    }

    public String getZone_direction() {
        return zone_direction;
    }

    public void setZone_direction(String zone_direction) {
        this.zone_direction = zone_direction;
    }

    public String getStreet_direction() {
        return street_direction;
    }

    public void setStreet_direction(String street_direction) {
        this.street_direction = street_direction;
    }

    public String getDocument_id() {
        return document_id;
    }

    public void setDocument_id(String document_id) {
        this.document_id = document_id;
    }

    public String getDocument_expedition() {
        return document_expedition;
    }

    public void setDocument_expedition(String document_expedition) {
        this.document_expedition = document_expedition;
    }

    public String getCat_document_type() {
        return cat_document_type;
    }

    public void setCat_document_type(String cat_document_type) {
        this.cat_document_type = cat_document_type;
    }

    public String getCat_genre() {
        return cat_genre;
    }

    public void setCat_genre(String cat_genre) {
        this.cat_genre = cat_genre;
    }

    public String getMarital_status() {
        return marital_status;
    }

    public void setMarital_status(String marital_status) {
        this.marital_status = marital_status;
    }
}
