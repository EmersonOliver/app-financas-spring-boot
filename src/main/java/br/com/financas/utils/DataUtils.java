package br.com.financas.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DataUtils {

	public static final String DDMMYYYY = "DDMMYYYY";
	public static final String dd_MM_yyyy= "dd-MM-yyyy";
	public static final String dd_MM_yyyy_HH_mm_ss = "dd-MM-yyyy HH:mm:ss";
	public static final String MM_yyyy = "MM-yyyy";
	public static final String yyyy_MM_dd = "yyyy-MM-dd";
	
	
	public static String converterDataToString(Date date, String pattern) {
		return new SimpleDateFormat(pattern).format(date);
	}
	
	public static Date converterStringToDate(String data, String pattern) throws RuntimeException {
		try {
			return new SimpleDateFormat(pattern).parse(data);
		} catch (ParseException e) {
			throw new RuntimeException("Falha ao converter data");
		}
	}
	
}
