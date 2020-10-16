package bo.edu.ucb.sis.piratebay.model;

import javax.validation.constraints.NotNull;

public class ResetPasswordRequestModel {
    private String email;

    private String username;


    public ResetPasswordRequestModel() {
    }

    public ResetPasswordRequestModel(String email, String subject) {
        this.email = email;
        this.username = subject;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}
