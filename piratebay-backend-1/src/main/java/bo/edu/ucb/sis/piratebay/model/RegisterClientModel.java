package bo.edu.ucb.sis.piratebay.model;

public class RegisterClientModel {

    private String username;
    private String password;
    private String email;
    private String phoneNumber;
    private String catUserStatus;
    private String latitude;
    private String longitude;
    private String direction;

    public RegisterClientModel() {
    }

    public RegisterClientModel(String username, String password, String email, String phoneNumber, String catUserStatus, String latitude, String longitude, String direction) {
        this.username = username;
        this.password = password;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.catUserStatus = catUserStatus;
        this.latitude = latitude;
        this.longitude = longitude;
        this.direction = direction;
    }


    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getCatUserStatus() {
        return catUserStatus;
    }

    public void setCatUserStatus(String catUserStatus) {
        this.catUserStatus = catUserStatus;
    }

    public String getLatitude() {
        return latitude;
    }

    public void setLatitude(String latitude) {
        this.latitude = latitude;
    }

    public String getLongitude() {
        return longitude;
    }

    public void setLongitude(String longitude) {
        this.longitude = longitude;
    }

    public String getDirection() {
        return direction;
    }

    public void setDirection(String direction) {
        this.direction = direction;
    }
}
