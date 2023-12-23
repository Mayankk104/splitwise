package scaler.splitwise.services;

public interface PasswordEncoder {
    public String encode(String password);
    public boolean matches(String password, String hashedPassword);
}
