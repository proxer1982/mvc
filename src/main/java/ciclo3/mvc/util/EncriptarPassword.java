package ciclo3.mvc.util;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class EncriptarPassword {
    public static void main(String[] args){
        var password = "123";
        System.out.println("Clave " + password);
        System.out.println("Clave encriptada " + encriptarPassword(password) );
    }

    private static String encriptarPassword(String password) {
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        return encoder.encode(password);
    }
}
