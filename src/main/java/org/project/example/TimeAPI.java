package org.project.example;

import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Month;
import java.time.Period;
import java.time.YearMonth;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;

public class TimeAPI {

	public static void main(String[] args) {
		
		//time api is similar to Joda. But now it is Java Native ;-)
		
		
		//Get system time
		LocalDate today = LocalDate.now();
		System.out.println(today);
		
		//Set a specific date
		LocalDate someDate = LocalDate.of(2016, Month.JUNE, 5);
		
		//Get the difference between dates
		int years = someDate.getYear() - today.getYear();
		System.out.println(years);
		
		//Getting a period object that represent the diference between 2 dates. It shows negative if someDate is after today
		Period periodo = Period.between(today, someDate);
		System.out.println(periodo.getYears());
		System.out.println(periodo.getMonths());
		System.out.println(periodo.getDays());
		
		//Applying operations on dates via method invocation
		System.out.println(today.minusYears(1));
		System.out.println(today.minusMonths(4));
		System.out.println(today.minusDays(2));
		System.out.println(today.plusYears(1));
		System.out.println(today.plusMonths(4));
		System.out.println(today.plusDays(2));
	
		
		//Objects are immutable. It doesn't change original object
		someDate.plusYears(4);
		System.out.println(someDate);
		System.out.println(someDate.plusYears(4));
		
		
		//Formatting dates using custom pattern
		LocalDateTime now = LocalDateTime.of(2018, Month.APRIL, 01, 10, 05,56,321);
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy hh:mm:ss nnn");
		System.out.println(now.format(formatter));
				
		//Formatting using Java bundle
		System.out.println(now.format(DateTimeFormatter.BASIC_ISO_DATE));
		System.out.println(now.format(DateTimeFormatter.ISO_DATE_TIME));

		
		//Dealing only partial parts of date
		YearMonth yearMonth = YearMonth.of(2015, Month.JANUARY);
		System.out.println(yearMonth);
		
		LocalTime interval = LocalTime.of(12, 30);
		System.out.println(interval);
		
		
		//With time zone
		System.out.println(ZonedDateTime.of(2018, 04, 01, 10, 5, 11, 212, ZoneId.of("Europe/Paris")));
		System.out.println(ZonedDateTime.now(ZoneId.of("America/Sao_Paulo")));
		
	}
	
	

}
