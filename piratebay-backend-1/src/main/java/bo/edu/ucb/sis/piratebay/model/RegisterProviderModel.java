package bo.edu.ucb.sis.piratebay.model;

public class RegisterProviderModel {

    private String provider_name;
    private String provider_zone;
    private String provider_street;
    private String email;
    private String phone;
    private String phone2;

    public RegisterProviderModel(String provider_name, String provider_zone, String provider_street, String email, String phone, String phone2) {
        this.provider_name = provider_name;
        this.provider_zone = provider_zone;
        this.provider_street = provider_street;
        this.email = email;
        this.phone = phone;
        this.phone2 = phone2;


    }

    public String getProvider_name() {
        return provider_name;
    }

    public void setProvider_name(String provider_name) {
        this.provider_name = provider_name;
    }

    public String getProvider_zone() {
        return provider_zone;
    }

    public void setProvider_zone(String provider_zone) {
        this.provider_zone = provider_zone;
    }

    public String getProvider_street() {
        return provider_street;
    }

    public void setProvider_street(String provider_street) {
        this.provider_street = provider_street;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getPhone2() {
        return phone2;
    }

    public void setPhone2(String phone2) {
        this.phone2 = phone2;
    }


}
