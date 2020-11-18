package utils;

public class StringUtils {
	
	private static String formataStringParaComparar(String stringRecebida) {
		return stringRecebida.trim().toLowerCase();
	}
	
	public static boolean comparaStrings(String string1, String string2) {
		if (formataStringParaComparar(string1).equals(formataStringParaComparar(string2))) {
			return true;
		} else {
			return false;
		}
	}
}
