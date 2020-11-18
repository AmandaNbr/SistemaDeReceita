package utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DataUtils {
	
	DataUtils(){}
	
	public static Date converteData(String dataRecebida) {
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy");
		simpleDateFormat.setLenient(false);
		Date dataFormatada = new Date();
		try {
			dataFormatada = simpleDateFormat.parse(dataRecebida);
		} catch (ParseException e) {
			// Nada a fazer
		}
		
		return dataFormatada;
	}
	
	public static boolean validarData(String data) {
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy");
		simpleDateFormat.setLenient(false);
		Date dataFormatada;
		try {
			dataFormatada = simpleDateFormat.parse(data);
		} catch (ParseException e) {
			return false;
		}
		return true;
	}
	
	public static Date dataAtual() {
		return new Date(System.currentTimeMillis());
	}
}
