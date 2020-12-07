package utils;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

/**
 * Metodos para manipulacao da data
 * @author Amanda Nobre
 * @version 1.0 (Nov 2020)
 */
public class DataUtils {
	
	DataUtils(){}
	
	/**
	 * Verifica se a data informada existe
	 * @param string data
	 * @return verdadeiro se for valida ou falso se nao for
	 */
	public static boolean validarData(String data) {
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");

		try {
			LocalDate.parse(data, formatter);
		} catch (DateTimeParseException e) {
			return false;
		}
		return true;
	}
	
	/**
	 * Converte uma string para um localdate no formato certo
	 * @param string data
	 * @return localdate data
	 */
	public static LocalDate converteData(String dataRecebida) {
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		LocalDate dataFormatada = LocalDate.parse(dataRecebida, formatter);
		
		return dataFormatada;
	}
	
	/**
	 * Pega a data atual
	 * @return local date data atual
	 */
	public static LocalDate dataAtual() {
		return LocalDate.now();
	}
	
	/**
	 * Formata um localdate
	 * @param localdate data
	 * @return string data 
	 */
	public static String formataData(LocalDate dataRecebida) {
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		return dataRecebida.format(formatter);
	}
}
