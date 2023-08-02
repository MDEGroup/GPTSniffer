

public class Java8DateTimeExamples {

	
	
	

	private static void dateTimes() {
		

		
		LocalDate currentDate = LocalDate.now();

		
		LocalDate tenthFeb2014 = LocalDate.of(2014, Month.FEBRUARY, 10);

		
		LocalDate firstAug2014 = LocalDate.of(2014, 8, 1);

		
		LocalDate sixtyFifthDayOf2010 = LocalDate.ofYearDay(2010, 65);


		

		LocalTime currentTime = LocalTime.now(); 
		LocalTime midday = LocalTime.of(12, 0); 
		LocalTime afterMidday = LocalTime.of(13, 30, 15); 

		
		LocalTime fromSecondsOfDay = LocalTime.ofSecondOfDay(12345);

		
		LocalDateTime currentDateTime = LocalDateTime.now();

		
		LocalDateTime secondAug2014 = LocalDateTime.of(2014, 10, 2, 12, 30);

		
		LocalDateTime christmas2014 = LocalDateTime.of(2014, Month.DECEMBER, 24, 12, 0);


		
		

		
		LocalTime currentTimeInLosAngeles = LocalTime.now(ZoneId.of("America/Los_Angeles"));

		 in UTC time zone
		LocalTime nowInUtc = LocalTime.now(Clock.systemUTC());


		System.out.println("date/time creation: currentDate: " + currentDate);
		System.out.println("date/time creation: tenthFeb2014: " + tenthFeb2014);
		System.out.println("date/time creation: firstAug2014: " + firstAug2014);
		System.out.println("date/time creation: sixtyFifthDayOf2010: " + sixtyFifthDayOf2010);
		System.out.println("date/time creation: currentTime: " + currentTime);
		System.out.println("date/time creation: midday: " + midday);
		System.out.println("date/time creation: afterMidday: " + afterMidday);
		System.out.println("date/time creation: fromSecondsOfDay: " + fromSecondsOfDay);
		System.out.println("date/time creation: currentTimeInLosAngeles: " + currentTimeInLosAngeles);
		System.out.println("date/time creation: currentDateTime: " + currentDateTime);
		System.out.println("date/time creation: secondAug2014: " + secondAug2014);
		System.out.println("date/time creation: christmas2014: " + christmas2014);
	}



	private static void dateTimeInformation() {
		LocalDate date = LocalDate.of(2014, 2, 15); 

		boolean isBefore = LocalDate.now().isBefore(date); 

		
		Month february = date.getMonth(); 
		int februaryIntValue = february.getValue(); 
		int minLength = february.minLength(); 8
		int maxLength = february.maxLength(); 9
		Month firstMonthOfQuarter = february.firstMonthOfQuarter(); 

		
		int year = date.getYear(); 014
		int dayOfYear = date.getDayOfYear(); 
		int lengthOfYear = date.lengthOfYear(); 
		boolean isLeapYear = date.isLeapYear(); 

		DayOfWeek dayOfWeek = date.getDayOfWeek();
		int dayOfWeekIntValue = dayOfWeek.getValue(); 
		String dayOfWeekName = dayOfWeek.name(); 

		int dayOfMonth = date.getDayOfMonth(); 
		LocalDateTime startOfDay = date.atStartOfDay(); 014-02-15T00:00

		
		LocalTime time = LocalTime.of(15, 30); :30:00
		int hour = time.getHour(); 
		int second = time.getSecond(); 
		int minute = time.getMinute(); 
		int secondOfDay = time.toSecondOfDay(); 

		System.out.println("dateTimeInformation: february: " + february);
		System.out.println("dateTimeInformation: februaryIntValue: " + februaryIntValue);
		System.out.println("dateTimeInformation: firstMonthOfQuarter: " + firstMonthOfQuarter);
		System.out.println("dateTimeInformation: minLength: " + minLength);
		System.out.println("dateTimeInformation: maxLength: " + maxLength);
		System.out.println("dateTimeInformation: year: " + year);
		System.out.println("dateTimeInformation: dayOfYear: " + dayOfYear);
		System.out.println("dateTimeInformation: lengthOfYear: " + lengthOfYear);
		System.out.println("dateTimeInformation: isLeapYear: " + isLeapYear);
		System.out.println("dateTimeInformation: dayOfWeekName: " + dayOfWeekName);
		System.out.println("dateTimeInformation: dayOfWeekIntValue: " + dayOfWeekIntValue);
		System.out.println("dateTimeInformation: dayOfMonth: " + dayOfMonth);
		System.out.println("dateTimeInformation: startOfDay: " + startOfDay);
		System.out.println("dateTimeInformation: hour: " + hour);
		System.out.println("dateTimeInformation: second: " + second);
		System.out.println("dateTimeInformation: minute: " + minute);
		System.out.println("dateTimeInformation: secondOfDay: " + secondOfDay);
		System.out.println("dateTimeInformation: isBefore: " + isBefore);
	}


	private static void year() {
		Year currentYear = Year.now();
		Year twoThousand = Year.of(2000);
		boolean isLeap = currentYear.isLeap(); 
		int length = currentYear.length(); 

		
		LocalDate date = Year.of(2014).atDay(64);

		System.out.println("year: currentYear: " + currentYear);
		System.out.println("year: twoThousand: " + twoThousand);
		System.out.println("year: isLeap: " + isLeap);
		System.out.println("year: length: " + length);
		System.out.println("year: date: " + date);
	}


	private static void periodsAndDurations() {

		

		LocalDate firstDate = LocalDate.of(2010, 5, 17); 010-05-17
		LocalDate secondDate = LocalDate.of(2015, 3, 7); 015-03-07
		Period period = Period.between(firstDate, secondDate);

		int days = period.getDays(); 
		int months = period.getMonths(); 
		int years = period.getYears(); 
		boolean isNegative = period.isNegative(); 

		Period twoMonthsAndFiveDays = Period.ofMonths(2).plusDays(5);
		LocalDate sixthOfJanuary = LocalDate.of(2014, 1, 6);

		
		LocalDate eleventhOfMarch = sixthOfJanuary.plus(twoMonthsAndFiveDays);


		

		Instant firstInstant= Instant.ofEpochSecond( 1294881180 ); 011-01-13 01:13
		Instant secondInstant = Instant.ofEpochSecond(1294708260); 011-01-11 01:11

		Duration between = Duration.between(firstInstant, secondInstant);

		
		long seconds = between.getSeconds();

		
		long absoluteResult = between.abs().toMinutes();

		
		long twoHoursInSeconds = Duration.ofHours(2).getSeconds();

		System.out.println("periodsAndDurations: days: " + days);
		System.out.println("periodsAndDurations: months: " + months);
		System.out.println("periodsAndDurations: years: " + years);
		System.out.println("periodsAndDurations: isNegative: " + isNegative);
		System.out.println("periodsAndDurations: eleventhOfMarch: " + eleventhOfMarch);
		System.out.println("periodsAndDurations: seconds: " + seconds);
		System.out.println("periodsAndDurations: absoluteResult: " + absoluteResult);
		System.out.println("periodsAndDurations: twoHoursInSeconds: " + twoHoursInSeconds);
	}


	private static void additionSubtraction() {
		LocalDate tomorrow = LocalDate.now().plusDays(1);

		
		LocalDateTime dateTime = LocalDateTime.now().minusHours(5).minusMinutes(30);

		System.out.println("additionSubtraction: tomorrow: " + tomorrow);
		System.out.println("additionSubtraction: dateTime: " + dateTime);
	}


	private static void parsingFormatting() {
		014-04-01 10:45
		LocalDateTime dateTime = LocalDateTime.of(2014, Month.APRIL, 1, 10, 45);

		
		String asBasicIsoDate = dateTime.format(DateTimeFormatter.BASIC_ISO_DATE);

		
		String asIsoWeekDate = dateTime.format(DateTimeFormatter.ISO_WEEK_DATE);

		
		String asIsoDateTime = dateTime.format(DateTimeFormatter.ISO_DATE_TIME);

		
		String asCustomPattern = dateTime.format(DateTimeFormatter.ofPattern("dd/MM/yyyy"));

		
		String frenchDate = dateTime.format(DateTimeFormatter.ofPattern("d. MMMM yyyy", new Locale("fr")));

		
		DateTimeFormatter formatter = DateTimeFormatter.ofLocalizedDateTime(FormatStyle.SHORT).withLocale(new Locale("de"));
		String germanDateTime = dateTime.format(formatter);

		
		LocalDate fromIsoDate = LocalDate.parse("2014-01-20");
		LocalDate fromIsoWeekDate = LocalDate.parse("2014-W14-2", DateTimeFormatter.ISO_WEEK_DATE);
		LocalDate fromCustomPattern = LocalDate.parse("20.01.2014", DateTimeFormatter.ofPattern("dd.MM.yyyy"));

		System.out.println("parsingFormatting: asBasicIsoDate: " + asBasicIsoDate);
		System.out.println("parsingFormatting: asIsoWeekDate: " + asIsoWeekDate);
		System.out.println("parsingFormatting: asIsoDateTime: " + asIsoDateTime);
		System.out.println("parsingFormatting: asCustomPattern: " + asCustomPattern);
		System.out.println("parsingFormatting: fromIsoDate: " + fromIsoDate);
		System.out.println("parsingFormatting: fromIsoWeekDate: " + fromIsoWeekDate);
		System.out.println("parsingFormatting: fromCustomPattern: " + fromCustomPattern);
		System.out.println("parsingFormatting: frenchDate: " + frenchDate);
		System.out.println("parsingFormatting: germanDateTime: " + germanDateTime);
	}


	private static void temporalAdjuster() {
		LocalDate date = LocalDate.of(2014, Month.FEBRUARY, 25); 014-02-25

		
		LocalDate firstDayOfMonth = date.with(TemporalAdjusters.firstDayOfMonth());

		
		LocalDate lastDayOfMonth = date.with(TemporalAdjusters.lastDayOfMonth());

		

		
		LocalDate lastDayOfYear = date.with(lastDayOfYear());

		
		LocalDate firstDayOfNextMonth = date.with(firstDayOfNextMonth());

		
		LocalDate nextSunday = date.with(next(DayOfWeek.SUNDAY));

		System.out.println("temporalAdjuster: firstDayOfMonth: " + firstDayOfMonth);
		System.out.println("temporalAdjuster: lastDayOfMonth: " + lastDayOfMonth);
		System.out.println("temporalAdjuster: lastDayOfYear: " + lastDayOfYear);
		System.out.println("temporalAdjuster: firstDayOfNextMonth: " + firstDayOfNextMonth);
		System.out.println("temporalAdjuster: nextSunday: " + nextSunday);
	}


	private static void timezones() {
		ZoneId losAngeles = ZoneId.of("America/Los_Angeles");
		ZoneId berlin = ZoneId.of("Europe/Berlin");

		014-02-20 12:00
		LocalDateTime dateTime = LocalDateTime.of(2014, 02, 20, 12, 0);

		014-02-20 12:00, Europe/Berlin (+01:00)
		ZonedDateTime berlinDateTime = ZonedDateTime.of(dateTime, berlin);

		014-02-20 03:00, America/Los_Angeles (-08:00)
		ZonedDateTime losAngelesDateTime = berlinDateTime.withZoneSameInstant(losAngeles);

		int offsetInSeconds = losAngelesDateTime.getOffset().getTotalSeconds(); 

		
		Set<String> allZoneIds = ZoneId.getAvailableZoneIds();

		
		LocalDateTime date = LocalDateTime.of(2013, Month.JULY, 20, 3, 30);
		ZoneOffset offset = ZoneOffset.of("+05:00");

		013-07-20 22:30 +05:00
		OffsetDateTime plusFive = OffsetDateTime.of(date, offset);

		013-07-19 20:30 -02:00
		OffsetDateTime minusTwo = plusFive.withOffsetSameInstant(ZoneOffset.ofHours(-2));

		System.out.println("timezones: berlinDateTime: " + berlinDateTime);
		System.out.println("timezones: losAngelesDateTime: " + losAngelesDateTime);
		System.out.println("timezones: offsetInSeconds: " + offsetInSeconds);
		System.out.println("timezones: allZoneIds: " + allZoneIds);
		System.out.println("timezones: offset: " + offset);
		System.out.println("timezones: plusFive: " + plusFive);
		System.out.println("timezones: minusTwo: " + minusTwo);
	}


	private static void conversion() {

		
		LocalDate date = LocalDate.now();
		LocalTime time = LocalTime.now();
		LocalDateTime dateTimeFromDateAndTime = LocalDateTime.of(date, time);
		LocalDate dateFromDateTime = LocalDateTime.now().toLocalDate();
		LocalTime timeFromDateTime = LocalDateTime.now().toLocalTime();

		
		Instant instant = Instant.now();
		LocalDateTime dateTimeFromInstant = LocalDateTime.ofInstant(instant, ZoneId.of("America/Los_Angeles"));
		Instant instantFromDateTime = LocalDateTime.now().toInstant(ZoneOffset.ofHours(-2));

		
		Instant instantFromDate = new Date().toInstant();
		Instant instantFromCalendar = Calendar.getInstance().toInstant();
		ZoneId zoneId = TimeZone.getDefault().toZoneId();
		ZonedDateTime zonedDateTimeFromGregorianCalendar = new GregorianCalendar().toZonedDateTime();
		Date dateFromInstant = Date.from(Instant.now());
		TimeZone timeZone = TimeZone.getTimeZone(ZoneId.of("America/Los_Angeles"));
		GregorianCalendar gregorianCalendar = GregorianCalendar.from(ZonedDateTime.now());
	}


	private static void timestamps() {
		
		Instant now = Instant.now();

		
		Instant fromUnixTimestamp = Instant.ofEpochSecond(1262347200);

		
		Instant fromEpochMilli = Instant.ofEpochMilli(1262347200000l);

		
		Instant fromIso8601 = Instant.parse("2010-01-01T12:00:00Z");

		
		String toIso8601 = now.toString();

		
		long toUnixTimestamp = now.getEpochSecond();

		
		long toEpochMillis = now.toEpochMilli();

		
		Instant nowPlusTenSeconds = now.plusSeconds(10);

		
		Instant nowPlusTwoDays = now.plus(2, ChronoUnit.DAYS);
		Instant nowMinusTwoDays = now.minus(Duration.ofDays(2));

		System.out.println("timestamps now: " + now);
		System.out.println("timestamps fromUnixTimestamp: " + fromUnixTimestamp);
		System.out.println("timestamps fromEpochMilli: " + fromEpochMilli);
		System.out.println("timestamps fromIso8601: " + fromIso8601);
		System.out.println("timestamps toIso8601: " + toIso8601);
		System.out.println("timestamps toUnixTimestamp: " + toUnixTimestamp);
		System.out.println("timestamps toEpochMillis: " + toEpochMillis);
		System.out.println("timestamps nowPlusTenSeconds: " + nowPlusTenSeconds);
		System.out.println("timestamps nowPlusTwoDays: " + nowPlusTwoDays);
		System.out.println("timestamps nowMinusTwoDays: " + nowMinusTwoDays);
	}



	public static void main(String[] args) {
		dateTimes();
		dateTimeInformation();
		year();
		temporalAdjuster();
		additionSubtraction();
		timezones();
		timestamps();
		periodsAndDurations();
		parsingFormatting();
		conversion();
	}
}
