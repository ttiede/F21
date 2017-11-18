package br.com.caelum.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class DateUtil {
	public static String dateFormatDayMonthYear(final String date){
		 return new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").format(date);
	}

	public static Date dateParseDayMonthYear(final String date){
		 try {
			return new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").parse(date);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return null;
	}

	public static Calendar stringToDate(final String dateString){
		final Calendar dataNascimento = Calendar.getInstance();
		Date date = dateParseDayMonthYear(dateString);
		dataNascimento.setTime(date);
		return dataNascimento;
	}
}
