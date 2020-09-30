package bo.edu.ucb.sis.piratebay.controller;

import bo.edu.ucb.sis.piratebay.bl.RegisterClientBl;
import bo.edu.ucb.sis.piratebay.bl.UserBl;
import bo.edu.ucb.sis.piratebay.model.CredentialModel;
import bo.edu.ucb.sis.piratebay.model.RegisterClientModel;
import bo.edu.ucb.sis.piratebay.model.UserModel;
import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.auth0.jwt.interfaces.JWTVerifier;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/v1/register")
@CrossOrigin(origins = "*")
public class RegisterClientController {
    private RegisterClientBl registerClientBl;

    @Value("${piratebay.security.secretJwt}")
    private String secretJwt;

    @Autowired
    public RegisterClientController(RegisterClientBl registerClientBl) {
        this.registerClientBl = registerClientBl;
    }

    @RequestMapping(method = RequestMethod.POST,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Map<String, Object>> InsertClient(@RequestBody RegisterClientModel registerClientModel) {
        boolean vReturn = this.registerClientBl.InsertClient(registerClientModel);

        if(vReturn){
            Map <String, Object> response = new HashMap();
            response.put("message", "Register Ok");
            return new ResponseEntity<>(response, HttpStatus.OK);

        }else{
            Map <String, Object> response = new HashMap();
            response.put("message", "Error");
            return new ResponseEntity<>(response, HttpStatus.FORBIDDEN);
        }

    }

}

