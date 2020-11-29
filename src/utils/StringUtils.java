package utils;

/**
 * Metodos para manipulacao de string
 * @author Amanda Nobre
 * @version 1.0 (Nov 2020)
 */
public class StringUtils {
	
	/**
	 * Converte uma string para minusculo e da trim
	 * @param string
	 * @return string formatada
	 */
	private static String formataStringParaComparar(String stringRecebida) {
		return stringRecebida.trim().toLowerCase();
	}
	
	/**
	 * Compara duas strings formatadas
	 * @param string1
	 * @param string2
	 * @return verdadeiro se forem iguais ou falso se nao forem
	 */
	public static boolean comparaStrings(String string1, String string2) {
		if (formataStringParaComparar(string1).equals(formataStringParaComparar(string2))) {
			return true;
		} else {
			return false;
		}
	}
}
