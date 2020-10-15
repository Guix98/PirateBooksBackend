package bo.edu.ucb.sis.piratebay.controller;

import bo.edu.ucb.sis.piratebay.model.ProductsModel;
import bo.edu.ucb.sis.piratebay.model.ResetPasswordRequestModel;
import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.auth0.jwt.interfaces.JWTVerifier;
import org.json.JSONException;
import org.json.JSONObject;
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
    @Value("${spring.mail.username}")
    private String username;
    @Value("${spring.mail.password}")
    private String password;

    @RequestMapping(method = RequestMethod.POST,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public String sendEmail(@RequestBody ResetPasswordRequestModel resetPasswordRequestModel) throws IOException, MessagingException {

        sendmail(resetPasswordRequestModel);
        return "Email sent successfully";
    }

    private void sendmail(ResetPasswordRequestModel resetPasswordRequestModel) throws MessagingException, IOException {

        Properties props= new Properties();
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.host", "smtp.gmail.com");
        props.put("mail.smtp.port", "587");

        Session session= Session.getInstance(props, new javax.mail.Authenticator(){
           protected PasswordAuthentication getPasswordAuthentication(){
               return new PasswordAuthentication(username,password);
           }
        });

        Message msg = new MimeMessage(session);
        msg.setFrom(new InternetAddress(username, false));

        msg.setRecipients(Message.RecipientType.TO, InternetAddress.parse(resetPasswordRequestModel.getEmail()));
        msg.setSubject(resetPasswordRequestModel.getSubject());
        msg.setContent(resetPasswordRequestModel.getBody(), "text/html");
        msg.setSentDate(new Date());

        MimeBodyPart messageBodyPart = new MimeBodyPart();
        messageBodyPart.setContent(resetPasswordRequestModel.getBody(), "text/html");

        Multipart multipart = new MimeMultipart();
        multipart.addBodyPart(messageBodyPart);
        MimeBodyPart attachPart = new MimeBodyPart();

        attachPart.attachFile("C:\\Users\\Luchin111\\Desktop\\perfil.jpeg");

        multipart.addBodyPart(attachPart);
        msg.setContent(multipart);
        // sends the e-mail
        Transport.send(msg);

    }
}
