/**
 * ValidarDNI.java
 * 21 nov 2023 13:48:46
 * @author Marta Fernández Carrión
 */
package swing_c_p02_FernandezCarrionMarta;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author Marta
 *
 */
public class ValidarDNI {
	
	public static boolean validar(String dni) {
        Pattern patron = Pattern.compile("[0-9]{8}[A-Z]");
        Matcher matcher = patron.matcher(dni);
        if (matcher.matches()) {
            String letra = dni.substring(8);
            String digitos = dni.substring(0, 8);
            int numero = Integer.parseInt(digitos);
            numero = numero % 23;
            String letras = "TRWAGMYFPDXBNJZSQVHLCKE";
            String letraCorrecta = letras.substring(numero, numero + 1);
            return letraCorrecta.equals(letra);
        } else {
            return false;
        }
    }

}
