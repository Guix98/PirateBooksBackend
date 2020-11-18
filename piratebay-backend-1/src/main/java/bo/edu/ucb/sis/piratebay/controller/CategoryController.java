package bo.edu.ucb.sis.piratebay.controller;

import bo.edu.ucb.sis.piratebay.bl.CategoryBl;
import bo.edu.ucb.sis.piratebay.dao.CategoryDao;
import bo.edu.ucb.sis.piratebay.model.CategoryModel;
import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.auth0.jwt.interfaces.JWTVerifier;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/api/v1/category")
@CrossOrigin(origins = "*")
public class CategoryController {
    private CategoryBl categoryBl;
    @Value("${piratebay.security.secretJwt}")
    private String secretJwt;

    @Autowired
    public CategoryController(CategoryBl categoryBl) {
        this.categoryBl= categoryBl;
    }

    @RequestMapping(method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<CategoryModel>> findAllCategory() { // bearer asdasdasdasd


        return new ResponseEntity<>( this.categoryBl.findAllCategory(), HttpStatus.OK);
    }
}
