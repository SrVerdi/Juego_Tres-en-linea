package Juego;

	import java.util.regex.Matcher;
	import java.util.regex.Pattern;

	public class ValidacionesG {
		public static boolean jugadorUno (String letra) {
			Pattern patronAbc = Pattern.compile("^[xX]{1}$");
			Matcher matcher = patronAbc.matcher(letra);
			return matcher.matches();
			}
		public static boolean jugadorDos (String letra) {
			Pattern patronAbc = Pattern.compile("^[oO]{1}$");
			Matcher matcher = patronAbc.matcher(letra);
			return matcher.matches();
			}
		public static boolean esPalabra(String letra) {
			Pattern patronAbc = Pattern.compile("^[a-zA-ZÒ—0-9]{3,23}$");
			Matcher matcher = patronAbc.matcher(letra);
			return matcher.matches();
			}
		public boolean esPosicion (String letra) {
			Pattern patronAbc = Pattern.compile("^[1-9]{1}$");
			Matcher matcher = patronAbc.matcher(letra);
			return matcher.matches();
			}
	}
	
