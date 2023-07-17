package sin12743.securityexample1.Services;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class TestEncryption {
    //Encrypt Password with BCryptPasswordEncoder public
    static String encryptPassword(String password) {
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        return encoder.encode(password);
    }
/*
    public static void main(String[] args) {
        String pass= "Simranbenipal09@";
        String encodedPass = encryptPassword(pass);
        System.out.println(encodedPass);
    }*/
}