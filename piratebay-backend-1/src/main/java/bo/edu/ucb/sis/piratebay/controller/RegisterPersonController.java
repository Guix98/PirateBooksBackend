package bo.edu.ucb.sis.piratebay.controller;

import bo.edu.ucb.sis.piratebay.bl.RegisterPersonBl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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

}
