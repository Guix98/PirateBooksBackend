package bo.edu.ucb.sis.piratebay.controller;

import bo.edu.ucb.sis.piratebay.bl.OrderBl;
import bo.edu.ucb.sis.piratebay.bl.ProductProviderBl;
import bo.edu.ucb.sis.piratebay.model.OrderModel;
import bo.edu.ucb.sis.piratebay.model.ProductProviderModel;
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
@RequestMapping("/api/v1/product/provider")
@CrossOrigin(origins = "*")
public class ProductProviderController {

    private ProductProviderBl productProviderBl;

    @Autowired
    public ProductProviderController(ProductProviderBl productProviderBl) {
        this.productProviderBl= productProviderBl;
    }

    @RequestMapping(method = RequestMethod.POST,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<ProductProviderModel>> findAllProduct(@RequestBody String json) throws JSONException {
        JSONObject jsonObject = new JSONObject(json);
        int order = Integer.parseInt(jsonObject.getString("orderName"));


        return new ResponseEntity<>( this.productProviderBl.findAllProduct(order), HttpStatus.OK);
    }
}
