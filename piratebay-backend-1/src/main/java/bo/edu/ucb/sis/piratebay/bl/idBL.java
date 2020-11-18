package bo.edu.ucb.sis.piratebay.bl;

import bo.edu.ucb.sis.piratebay.dao.UserDao;
import com.google.common.hash.Hashing;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.Map;
import com.auth0.jwt.JWT;
import com.auth0.jwt.exceptions.JWTCreationException;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.auth0.jwt.interfaces.JWTVerifier;
@Service
public class idBL {
    private UserDao userDao;

    @Value("${piratebay.security.salt}")
    private String salt;

    @Value("${piratebay.security.secretJwt}")
    private String secretJwt;

    @Autowired
    public idBL(UserDao userDao) {
        this.userDao = userDao;
    }


}
