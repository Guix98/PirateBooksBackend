package bo.edu.ucb.sis.piratebay.controller;

import bo.edu.ucb.sis.piratebay.bl.RegisterPersonBl;
import bo.edu.ucb.sis.piratebay.bl.RegisterProviderBl;
import bo.edu.ucb.sis.piratebay.model.RegisterPersonModel;
import bo.edu.ucb.sis.piratebay.model.RegisterProviderModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api/v1/registerprovider")
@CrossOrigin(origins = "*")
public class RegisterProviderController {

    private RegisterProviderBl registerProviderBl;

    @Value("${piratebay.security.secretJwt}")
    private String secretJwt;

    @Autowired
    public RegisterProviderController(RegisterProviderBl registerProviderBl) {
        this.registerProviderBl = registerProviderBl;


    }

    @RequestMapping(method = RequestMethod.POST,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Map<String, Object>> InsertProvider(@RequestBody RegisterProviderModel registerProviderModel) {
        boolean vReturn = this.registerProviderBl.InsertProvider(registerProviderModel);


        if(vReturn){
            Map <String, Object> response = new HashMap();
            response.put("message", "Register Ok");
            return new ResponseEntity<>(response, HttpStatus.OK);

        }else{
            Map <String, Object> response = new HashMap();
            response.put("message", "ErrorProvider");
            return new ResponseEntity<>(response, HttpStatus.FORBIDDEN);
        }

    }
}
