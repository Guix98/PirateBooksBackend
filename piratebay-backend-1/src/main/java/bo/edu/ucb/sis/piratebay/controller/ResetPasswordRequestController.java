package bo.edu.ucb.sis.piratebay.controller;

import bo.edu.ucb.sis.piratebay.bl.RegisterProviderBl;
import bo.edu.ucb.sis.piratebay.bl.ResetPasswordRequestBl;
import bo.edu.ucb.sis.piratebay.model.ProductsModel;
import bo.edu.ucb.sis.piratebay.model.ResetPasswordRequestModel;
import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.auth0.jwt.interfaces.JWTVerifier;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import java.io.IOException;
import java.util.Date;
import java.util.List;
import java.util.Properties;

@RestController
@RequestMapping("/api/v1/resetpassword")
@CrossOrigin(origins = "*")
public class ResetPasswordRequestController {

    private ResetPasswordRequestBl resetPasswordRequestBl;
    @Autowired
    public ResetPasswordRequestController(ResetPasswordRequestBl resetPasswordRequestBl) {
        this.resetPasswordRequestBl = resetPasswordRequestBl;


    }

    @RequestMapping(method = RequestMethod.POST,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public String sendEmail(@RequestBody ResetPasswordRequestModel resetPasswordRequestModel) throws IOException, MessagingException {

        resetPasswordRequestBl.sendmail(resetPasswordRequestModel);
        return "Email sent successfully";
    }


}
