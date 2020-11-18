package bo.edu.ucb.sis.piratebay.controller;

import bo.edu.ucb.sis.piratebay.bl.ProductsBl;
import bo.edu.ucb.sis.piratebay.bl.ProvedorBl;
import bo.edu.ucb.sis.piratebay.model.ProductsModel;
import bo.edu.ucb.sis.piratebay.model.ProvedorModel;
import bo.edu.ucb.sis.piratebay.model.ResetPasswordModel;
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

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/v1/provedor")
@CrossOrigin(origins = "*")
public class ProviderController {

    private ProvedorBl provedorBl;

    @Value("${piratebay.security.secretJwt}")
    private String secretJwt;

    @Autowired
    public ProviderController(ProvedorBl provedorBl) {
        this.provedorBl= provedorBl;
    }

    @RequestMapping(method = RequestMethod.POST,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<ProvedorModel>> findProvedor(@RequestHeader("Authorization") String authorization, @RequestBody String json) throws JSONException { // bearer asdasdasdasd

        // Lo unico que estamos haciendo es decodificar el token.
        String tokenJwT = authorization.substring(7);
        System.out.println("TOKEN JWT: " + tokenJwT);
        DecodedJWT decodedJWT = JWT.decode(tokenJwT);
        String idUsuario = decodedJWT.getSubject();
        System.out.println("USUARIO: " + idUsuario);
        JSONObject jsonObject = new JSONObject(json);
        int order = Integer.parseInt(jsonObject.getString("orderName"));
        System.out.println("ORDER_NAME: " + order);
        if(!"AUTHN".equals(decodedJWT.getClaim("type").asString()) ) {
            throw new RuntimeException("El token proporcionado no es un token de Autenthication");
        }
        // El siguiente código valida si el token es bueno y ademas es un token de authentication

        Algorithm algorithm = Algorithm.HMAC256(secretJwt);
        JWTVerifier verifier = JWT.require(algorithm)
                .withIssuer("PirateBay")
                .build();
        verifier.verify(tokenJwT);

        return new ResponseEntity<>( this.provedorBl.findProvedor(order), HttpStatus.OK);
    }
    @RequestMapping(value = "edit",method = RequestMethod.POST,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Map<String, Object>> changePassword(@RequestHeader("Authorization") String authorization, @RequestBody ProvedorModel provedorModel) {
        boolean vReturn = this.provedorBl.editProvider(provedorModel);
        String tokenJwT = authorization.substring(7);
        System.out.println("TOKEN JWT: " + tokenJwT);
        DecodedJWT decodedJWT = JWT.decode(tokenJwT);
        String idUsuario = decodedJWT.getSubject();
        System.out.println("USUARIO: " + idUsuario);
        if(!"AUTHN".equals(decodedJWT.getClaim("type").asString()) ) {
            throw new RuntimeException("El token proporcionado no es un token de Autenthication");
        }
        else{
            Map <String, Object> response = new HashMap();
            if(vReturn){
                response.put("email", provedorModel.getProvider_id());
                response.put("message", "Edit Provider Ok");
                return new ResponseEntity<>(response, HttpStatus.OK);

            }else{
                response.put("message", "Error");
                return new ResponseEntity<>(response, HttpStatus.FORBIDDEN);
            }

        }


    }
}
