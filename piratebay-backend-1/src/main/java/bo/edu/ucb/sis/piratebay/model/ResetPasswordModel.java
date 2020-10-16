package bo.edu.ucb.sis.piratebay.model;

public class ResetPasswordModel {
    private String email;
    private String password;

    public ResetPasswordModel() {

    }

    public ResetPasswordModel(String email, String password) {
        this.email = email;
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
