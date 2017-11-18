package br.com.caelum.util;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class DateUtil {
	public static String dateFormatDayMonthYear(final Calendar dateCalendar) {
		final DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
		return dateFormat.format(dateCalendar.getInstance().getTime());
	}

	public static Date dateParseDayMonthYear(final String dateString) {
		try {
			final Date date = new SimpleDateFormat("dd/MM/yyyy").parse(dateString);
			return date;
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return null;
	}

	public static Calendar stringToDate(final String dateString) {
		Calendar dataNascimento = Calendar.getInstance();
		Date date = dateParseDayMonthYear(dateString);
		dataNascimento.setTime(date);
		return dataNascimento;
	}
	
}
