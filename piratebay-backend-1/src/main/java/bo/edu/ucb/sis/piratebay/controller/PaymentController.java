package bo.edu.ucb.sis.piratebay.controller;

import bo.edu.ucb.sis.piratebay.bl.ProductsBl;
import bo.edu.ucb.sis.piratebay.model.PaymentIntentModel;

import bo.edu.ucb.sis.piratebay.service.PaymentService;
import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.auth0.jwt.interfaces.JWTVerifier;
import com.stripe.exception.StripeException;
import com.stripe.model.PaymentIntent;
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
@RequestMapping("/api/v1/payment")
@CrossOrigin(origins = "*")
public class PaymentController {

    @Value("${piratebay.security.secretJwt}")
    private String secretJwt;

    @Autowired
    PaymentService paymentService;
    @PostMapping("/paymentIntent")
    public ResponseEntity<String> payment(@RequestBody PaymentIntentModel paymentIntentModel) throws StripeException {
        PaymentIntent paymentIntent = paymentService.paymentIntent(paymentIntentModel);
        String paymentStr = paymentIntent.toJson();
        return new ResponseEntity<String>(paymentStr,HttpStatus.OK);
    }
    @PostMapping("/confirm/{id}")
    public ResponseEntity<String> confirm(@PathVariable("id") String id) throws StripeException {
        PaymentIntent paymentIntent = paymentService.confirm(id);
        String paymentStr = paymentIntent.toJson();
        return new ResponseEntity<String>(paymentStr,HttpStatus.OK);
    }
    @PostMapping("/cancel/{id}")
    public ResponseEntity<String> cancel(@PathVariable("id") String id) throws StripeException {
        PaymentIntent paymentIntent = paymentService.cancel(id);
        String paymentStr = paymentIntent.toJson();
        return new ResponseEntity<String>(paymentStr,HttpStatus.OK);
    }

}
