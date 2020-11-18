package bo.edu.ucb.sis.piratebay.controller;

import bo.edu.ucb.sis.piratebay.bl.BooksBl;
import bo.edu.ucb.sis.piratebay.bl.OrderBl;
import bo.edu.ucb.sis.piratebay.model.BooksModel;
import bo.edu.ucb.sis.piratebay.model.CartModel;
import bo.edu.ucb.sis.piratebay.model.OrderModel;
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
@RequestMapping("/api/v1/order")
@CrossOrigin(origins = "*")
public class OrderController {

    private OrderBl orderBl;

    @Value("${piratebay.security.secretJwt}")
    private String secretJwt;

    @Autowired
    public OrderController(OrderBl orderBl) {
        this.orderBl= orderBl;
    }

    @RequestMapping(method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<OrderModel>> findAllOrders(@RequestHeader("Authorization") String authorization) throws JSONException { // bearer asdasdasdasd

        // Lo unico que estamos haciendo es decodificar el token.
        String tokenJwT = authorization.substring(7);
        System.out.println("TOKEN JWT: " + tokenJwT);
        DecodedJWT decodedJWT = JWT.decode(tokenJwT);
        String idUsuario = decodedJWT.getSubject();
        System.out.println("USUARIO: " + idUsuario);
        if(!"AUTHN".equals(decodedJWT.getClaim("type").asString()) ) {
            throw new RuntimeException("El token proporcionado no es un token de Autenthication");
        }
        // El siguiente código valida si el token es bueno y ademas es un token de authentication

        Algorithm algorithm = Algorithm.HMAC256(secretJwt);
        JWTVerifier verifier = JWT.require(algorithm)
                .withIssuer("PirateBay")
                .build();
        verifier.verify(tokenJwT);

        return new ResponseEntity<>( this.orderBl.findAllOrders(), HttpStatus.OK);
    }
    @RequestMapping(
            value = "carrito",
            method = RequestMethod.POST,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<CartModel>> findCarrito(@RequestHeader("Authorization") String authorization, @RequestBody String json) throws JSONException { // bearer asdasdasdasd

        // Lo unico que estamos haciendo es decodificar el token.
        String tokenJwT = authorization.substring(7);
        System.out.println("TOKEN JWT: " + tokenJwT);
        DecodedJWT decodedJWT = JWT.decode(tokenJwT);
        String idUsuario = decodedJWT.getSubject();
        System.out.println("USUARIO: " + idUsuario);
        if(!"AUTHN".equals(decodedJWT.getClaim("type").asString()) ) {
            throw new RuntimeException("El token proporcionado no es un token de Autenthication");
        }
        // El siguiente código valida si el token es bueno y ademas es un token de authentication

        Algorithm algorithm = Algorithm.HMAC256(secretJwt);
        JWTVerifier verifier = JWT.require(algorithm)
                .withIssuer("PirateBay")
                .build();
        verifier.verify(tokenJwT);
        JSONObject jsonObject = new JSONObject(json);
        int order = Integer.parseInt(jsonObject.getString("order"));

        return new ResponseEntity<>( this.orderBl.findCarrito(order), HttpStatus.OK);
    }
    @RequestMapping(
            value = "add",
            method = RequestMethod.POST,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Map<String, Object>> insertOrder(@RequestHeader("Authorization") String authorization, @RequestBody OrderModel orderModel) throws JSONException { // bearer asdasdasdasd

        // Lo unico que estamos haciendo es decodificar el token.
        String tokenJwT = authorization.substring(7);
        System.out.println("TOKEN JWT: " + tokenJwT);
        DecodedJWT decodedJWT = JWT.decode(tokenJwT);
        String idUsuario = decodedJWT.getSubject();
        System.out.println("USUARIO: " + idUsuario);
        if(!"AUTHN".equals(decodedJWT.getClaim("type").asString()) ) {
            throw new RuntimeException("El token proporcionado no es un token de Autenthication");
        }
        // El siguiente código valida si el token es bueno y ademas es un token de authentication

        Algorithm algorithm = Algorithm.HMAC256(secretJwt);
        JWTVerifier verifier = JWT.require(algorithm)
                .withIssuer("PirateBay")
                .build();
        verifier.verify(tokenJwT);
        boolean vReturn = this.orderBl.InsertOrder(orderModel);
        if(vReturn){
            Map<String, Object> response = new HashMap();
            response.put("id", orderModel.getOrder_id());
            response.put("message", "Register Ok");
            return new ResponseEntity<>(response, HttpStatus.OK);

        }else{
            Map <String, Object> response = new HashMap();
            response.put("message", "ErrorPerson");
            return new ResponseEntity<>(response, HttpStatus.FORBIDDEN);
        }
    }


}
