package bo.edu.ucb.sis.piratebay.bl;

import bo.edu.ucb.sis.piratebay.dao.UserDao;
import bo.edu.ucb.sis.piratebay.model.UserModel;
import com.google.common.hash.Hashing;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.nio.charset.StandardCharsets;
import java.util.List;

@Service
public class UserBl {

    private UserDao userDao;

    @Value("${piratebay.security.salt}")
    private String salt;
    @Autowired
    public UserBl(UserDao userDao) {
        this.userDao = userDao;
    }

    public List<UserModel> findAllActives() {
        return this.userDao.findAllActives();
    }

    public List<UserModel> findid(String username, String password) {
        String sha256hex = Hashing.sha256()
                .hashString(password+salt, StandardCharsets.UTF_8)
                .toString();
        return this.userDao.findid(username, sha256hex);
    }
}
