package bo.edu.ucb.sis.piratebay.controller;

import bo.edu.ucb.sis.piratebay.bl.RegisterPersonBl;
import bo.edu.ucb.sis.piratebay.model.RegisterClientModel;
import bo.edu.ucb.sis.piratebay.model.RegisterPersonModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api/v1/registerperson")
@CrossOrigin(origins = "*")
public class RegisterPersonController {
    private RegisterPersonBl registerPersonBl;

    @Value("${piratebay.security.secretJwt}")
    private String secretJwt;

    @Autowired
    public RegisterPersonController(RegisterPersonBl registerPersonBl) {
        this.registerPersonBl = registerPersonBl;


    }

    @RequestMapping(method = RequestMethod.POST,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Map<String, Object>> InsertPerson(@RequestBody RegisterPersonModel registerPersonModel) {
        boolean vReturn = this.registerPersonBl.InsertPerson(registerPersonModel);


        if(vReturn){
            Map <String, Object> response = new HashMap();
            response.put("name", registerPersonModel.getUsername());
            response.put("message", "Register Ok");
            return new ResponseEntity<>(response, HttpStatus.OK);

        }else{
            Map <String, Object> response = new HashMap();
            response.put("message", "ErrorPerson");
            return new ResponseEntity<>(response, HttpStatus.FORBIDDEN);
        }

    }

}
