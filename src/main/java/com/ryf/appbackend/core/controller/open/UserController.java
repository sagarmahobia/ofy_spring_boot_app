package com.ryf.appbackend.core.controller.open;


import com.ryf.appbackend.InvalidInputException;
import com.ryf.appbackend.models.dto.OAuthBody;
import com.ryf.appbackend.models.dto.Token;
import com.ryf.appbackend.jpa.dao.UserDao;
import com.ryf.appbackend.jpa.entities.user.User;
import com.ryf.appbackend.jwtsecurity.model.JwtUser;
import com.ryf.appbackend.jwtsecurity.security.JwtUtil;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

@RestController
@CrossOrigin("*")
public class UserController {

    final RestTemplate restTemplate;

    final JwtUtil jwtUtil;

    final UserDao userDao;

    public UserController(RestTemplate restTemplate, JwtUtil jwtUtil, UserDao userDao) {
        this.restTemplate = restTemplate;
        this.jwtUtil = jwtUtil;
        this.userDao = userDao;
    }

    @PostMapping(path = "/v1/public/login")
    @ResponseBody
    public Token getUser(@RequestParam("username") String user, @RequestParam("password") String password) {


        if (user.equals("sagar@ofy.com") && password.equals("Password")) {
            String generate = jwtUtil.generate(new JwtUser(-1L, "ADMIN"));
            Token token = new Token();
            token.setToken(generate);

            return token;
        } else {
            throw new InvalidInputException();
        }
    }

    /*
     */
    @PostMapping(path = "/v1/public/accept_oauth_token")
    public Token acceptOAuthToken(@RequestParam("token") String token) {

        ResponseEntity<OAuthBody> forEntity = restTemplate.getForEntity(
                "https://oauth2.googleapis.com/tokeninfo?id_token=" + token,
                OAuthBody.class);

        if (forEntity.getStatusCode() == HttpStatus.OK) {


            OAuthBody body = forEntity.getBody();
            User user;

            boolean exists = userDao.existsByGoogleId(body.getSubject());

            if (!exists) {
                user = new User();
            } else {
                user = userDao.getFirstByGoogleId(body.getSubject());
            }

            OAuthBody.updateUser(user, body);
            user.setRole("USER");
            user = userDao.save(user);

            return Token
                    .builder()
                    .token(jwtUtil.generate(new JwtUser(user.getId(), user.getRole())))
                    .status(1)
                    .build();

        } else {
            throw new InvalidInputException();
        }
    }

}





