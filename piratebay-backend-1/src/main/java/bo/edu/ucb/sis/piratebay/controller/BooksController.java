package bo.edu.ucb.sis.piratebay.controller;

import bo.edu.ucb.sis.piratebay.bl.BooksBl;
import bo.edu.ucb.sis.piratebay.bl.ProductsBl;
import bo.edu.ucb.sis.piratebay.model.BooksModel;
import bo.edu.ucb.sis.piratebay.model.ProductsModel;
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

import java.util.List;

@RestController
@RequestMapping("/api/v1/book")
@CrossOrigin(origins = "*")
public class BooksController {

    private BooksBl booksBl;

    @Value("${piratebay.security.secretJwt}")
    private String secretJwt;

    @Autowired
    public BooksController(BooksBl booksBl) {
        this.booksBl= booksBl;
    }

    @RequestMapping(method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<BooksModel>> findBook(@RequestHeader("Authorization") String authorization, @RequestBody String json) throws JSONException { // bearer asdasdasdasd

        // Lo unico que estamos haciendo es decodificar el token.
        String tokenJwT = authorization.substring(7);
        System.out.println("TOKEN JWT: " + tokenJwT);
        DecodedJWT decodedJWT = JWT.decode(tokenJwT);
        String idUsuario = decodedJWT.getSubject();
        System.out.println("USUARIO: " + idUsuario);
        JSONObject jsonObject = new JSONObject(json);
        String order = jsonObject.getString("orderName");
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

        return new ResponseEntity<>( this.booksBl.findBook(order), HttpStatus.OK);
    }
}
