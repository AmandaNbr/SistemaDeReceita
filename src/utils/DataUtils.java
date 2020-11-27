package utils;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;


public class DataUtils {
	
	DataUtils(){}
	
	public static boolean validarData(String data) {
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");

		try {
			LocalDate.parse(data, formatter);
		} catch (DateTimeParseException e) {
			return false;
		}
		return true;
	}
	
	public static LocalDate converteData(String dataRecebida) {
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		LocalDate dataFormatada = LocalDate.parse(dataRecebida, formatter);
		
		return dataFormatada;
	}
	
	public static LocalDate dataAtual() {
		return LocalDate.now();
	}
	
	public static String formataData(LocalDate dataRecebida) {
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		return dataRecebida.format(formatter);
	}
}
