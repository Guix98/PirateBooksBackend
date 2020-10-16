package bo.edu.ucb.sis.piratebay.controller;

import bo.edu.ucb.sis.piratebay.bl.ResetPasswordRequestBl;
import bo.edu.ucb.sis.piratebay.model.ResetPasswordRequestModel;
import org.json.JSONException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.mail.*;
import java.io.IOException;

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
    public ResponseEntity findUserByEmail(@RequestBody ResetPasswordRequestModel resetPasswordRequestModel) throws JSONException, IOException, MessagingException {

        resetPasswordRequestBl.sendmail(resetPasswordRequestModel);
        return new ResponseEntity<>( this.resetPasswordRequestBl.finUserByEmail(resetPasswordRequestModel.getEmail()), HttpStatus.OK);
    }


}
