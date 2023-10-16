package cgi.curl_authenticate.domain;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Description:
 * Author: Petya Katsarova
 * Email: pskpetya@gmail.com
 * Created on: 16/10/2023 13:35
 */
public class User {
    private final Logger    logger = LoggerFactory.getLogger(User.class);
    private String          password;
    private String          username;
    private String          salt;
    private String          jwtToken;

    public User(String password, String username, String salt, String jwtToken) {
        this.password = password;
        this.username = username;
        this.salt = salt;
        this.jwtToken = jwtToken;
        logger.info("New User created");
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getSalt() {
        return salt;
    }

    public void setSalt(String salt) {
        this.salt = salt;
    }

    public String getJwtToken() {
        return jwtToken;
    }

    public void setJwtToken(String jwtToken) {
        this.jwtToken = jwtToken;
    }
}
