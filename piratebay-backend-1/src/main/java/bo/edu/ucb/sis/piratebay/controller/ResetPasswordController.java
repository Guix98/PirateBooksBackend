package bo.edu.ucb.sis.piratebay.controller;

import bo.edu.ucb.sis.piratebay.bl.RegisterClientBl;
import bo.edu.ucb.sis.piratebay.bl.ResetPasswordBl;
import bo.edu.ucb.sis.piratebay.model.RegisterClientModel;
import bo.edu.ucb.sis.piratebay.model.ResetPasswordModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api/v1/resetpassword")
@CrossOrigin(origins = "*")
public class ResetPasswordController {
    private ResetPasswordBl resetPasswordBl;
    @Autowired
    public ResetPasswordController(ResetPasswordBl resetPasswordBl) {
        this.resetPasswordBl = resetPasswordBl;
    }

    @RequestMapping(method = RequestMethod.POST,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Map<String, Object>> changePassword(@RequestBody ResetPasswordModel resetPasswordModel) {
        boolean vReturn = this.resetPasswordBl.changePassword(resetPasswordModel);


        if(vReturn){
            Map <String, Object> response = new HashMap();
            response.put("email", resetPasswordModel.getEmail());
            response.put("message", "Change Password Ok");
            return new ResponseEntity<>(response, HttpStatus.OK);

        }else{
            Map <String, Object> response = new HashMap();
            response.put("message", "Error");
            return new ResponseEntity<>(response, HttpStatus.FORBIDDEN);
        }

    }
}
