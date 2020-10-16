package bo.edu.ucb.sis.piratebay.bl;

import bo.edu.ucb.sis.piratebay.dao.ProvedorDao;
import bo.edu.ucb.sis.piratebay.dao.ResetPasswordRequestDao;
import bo.edu.ucb.sis.piratebay.model.ProductsModel;
import bo.edu.ucb.sis.piratebay.model.ResetPasswordRequestModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import java.io.IOException;
import java.util.Date;
import java.util.List;
import java.util.Properties;

@Service
public class ResetPasswordRequestBl {
    private ResetPasswordRequestDao resetPasswordRequestDao;

    @Value("${spring.mail.username}")
    private String username;
    @Value("${spring.mail.password}")
    private String password;

    @Autowired
    public ResetPasswordRequestBl(ResetPasswordRequestDao resetPasswordRequestDao) {
        this.resetPasswordRequestDao = resetPasswordRequestDao;
    }
    public List<ResetPasswordRequestModel> finUserByEmail(String email) {
        return this.resetPasswordRequestDao.findUserByEmail(email);
    }
    public void sendmail(ResetPasswordRequestModel resetPasswordRequestModel) throws MessagingException, IOException {
        //this.resetPasswordRequestDao.findUserByEmail(resetPasswordRequestModel.getEmail());
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

        // Concadenamos la url con el usuario
        String a="http://localhost:4200/#/resetpassword/"+resetPasswordRequestModel.getEmail();
        System.out.println(a);
        System.out.println(resetPasswordRequestModel.getEmail());
        Message msg = new MimeMessage(session);
        msg.setFrom(new InternetAddress(username, false));

        msg.setRecipients(Message.RecipientType.TO, InternetAddress.parse(resetPasswordRequestModel.getEmail()));
        msg.setSubject("Piratebay Cambio de Contraseña");
        msg.setContent("Piratebay Cambio de Contraseña", "text/html");
        msg.setSentDate(new Date());

        MimeBodyPart messageBodyPart = new MimeBodyPart();

        //Ponemos el link y el usuario que cambiara su contraseña en el correo
        messageBodyPart.setContent("<html><center><b>Para cambiar su contraseña ingrese al siguiente link :</b><br> <font color=#00000>"+a+"</font>", "text/html");
        Multipart multipart = new MimeMultipart();
        multipart.addBodyPart(messageBodyPart);
        //MimeBodyPart attachPart = new MimeBodyPart();

        //attachPart.attachFile("C:\\Users\\Luchin111\\Desktop\\perfil.jpeg");

        //multipart.addBodyPart(attachPart);
        msg.setContent(multipart);
        // sends the e-mail
        Transport.send(msg);

    }
}
