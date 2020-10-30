package bo.edu.ucb.sis.piratebay.controller;

import bo.edu.ucb.sis.piratebay.bl.ProvedorBl;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api/v1/deleteprovider")
@CrossOrigin(origins = "*")
public class DeleteProviderController {

    private ProvedorBl provedorBl;

    @Value("${piratebay.security.secretJwt}")
    private String secretJwt;

    @Autowired
    public DeleteProviderController(ProvedorBl provedorBl) {
        this.provedorBl = provedorBl;


    }

    @RequestMapping(method = RequestMethod.POST,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Map<String, Object>> InsertProvider(@RequestBody String json) throws JSONException {
        JSONObject jsonObject = new JSONObject(json);
        String order = jsonObject.getString("orderName");
        int aux = Integer.parseInt(order);
        System.out.println("ORDER_NAME: " + order);
        boolean vReturn = this.provedorBl.DeleteProvider(aux);


        if(vReturn){
            Map <String, Object> response = new HashMap();
            response.put("message", "Delete Ok");
            return new ResponseEntity<>(response, HttpStatus.OK);

        }else{
            Map <String, Object> response = new HashMap();
            response.put("message", "ErrorProvider");
            return new ResponseEntity<>(response, HttpStatus.FORBIDDEN);
        }

    }

}
