package br.com.financas.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

public class DataUtils {

	public static final String DDMMYYYY = "DDMMYYYY";
	public static final String dd_MM_yyyy= "dd-MM-yyyy";
	public static final String dd_MM_yyyy_HH_mm_ss = "dd-MM-yyyy HH:mm:ss";
	public static final String MM_yyyy = "MM-yyyy";
	public static final String yyyy_MM_dd = "yyyy-MM-dd";
	
	private DataUtils() {}
	
	public static Date dataInicialDia(Date date) {
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		cal.set(Calendar.HOUR_OF_DAY, 0);
		cal.set(Calendar.MINUTE, 0);
		cal.set(Calendar.SECOND, 0);
		cal.set(Calendar.MILLISECOND, 0);
		return cal.getTime();
	}
	
	public static Date dataFinalDia(Date date) {
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		cal.set(Calendar.HOUR_OF_DAY, 23);
		cal.set(Calendar.MINUTE, 59);
		cal.set(Calendar.SECOND, 59);
		cal.set(Calendar.MILLISECOND, 999);
		return cal.getTime();
	}
	
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
	
	public static List<String> convertListDateToListString(List<Date> dates){
		return (dates != null && !dates.isEmpty()) ? dates.stream()
				.map(x -> new SimpleDateFormat("dd/MM/yyyy")
						.format(x)).collect(Collectors.toList()) : new ArrayList<>();
	}
	
	public static List<Date> dataVencimentoFatura(int xVezes, int diaFechamento, LocalDate data){
		Date dataLancamento = Date.from(data.withDayOfMonth(diaFechamento).atStartOfDay(ZoneId.systemDefault()).toInstant());
		List<Date> fatura = new ArrayList<>();
		for(int i = 0; i < xVezes; i++) {
			fatura.add(dataLancamento(dataLancamento, i, diaFechamento));
		}
		return fatura;
	}
	
	private static Date dataLancamento(Date data, int parcela, int diaVencimento) {
		Calendar cal = Calendar.getInstance();
		cal.setTime(data);
		cal.add(Calendar.MONTH, parcela);
		return cal.getTime();
	}
	
	public Date dataCartao(String data) throws ParseException {
		Calendar cal = Calendar.getInstance();
		cal.setTime(new Date());
		cal.add(Calendar.DAY_OF_MONTH, Integer.valueOf(data));
		String dataFatura = new SimpleDateFormat("dd-MM-yyyy").format(cal.getTime());
		return new SimpleDateFormat("dd-MM-yyyy").parse(dataFatura);
	}
}
