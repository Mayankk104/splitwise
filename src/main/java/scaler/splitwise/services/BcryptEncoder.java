package scaler.splitwise.services;
 
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
class BcryptEncoder implements PasswordEncoder {

    private BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();

    @Override
    public String encode(String password) {
        return bCryptPasswordEncoder.encode(password);
    }

    @Override
    public boolean matches(String password, String hashedString) {
        return bCryptPasswordEncoder.matches(password, hashedString);
    }
    
}