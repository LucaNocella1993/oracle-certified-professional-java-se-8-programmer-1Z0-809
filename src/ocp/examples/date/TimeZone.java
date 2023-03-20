package ocp.examples.date;

import java.time.Duration;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;

public class TimeZone {  

	public static void main(String[] args) {
		LocalDateTime ldt = LocalDateTime.of(2017, 12, 02, 6, 0, 0);    
		ZonedDateTime nyZdt = ldt.atZone(ZoneId.of("America/New_York"));
		ZonedDateTime laZdt = ldt.atZone(ZoneId.of("America/Los_Angeles")); 
		Duration d = Duration.between(nyZdt, laZdt);
		System.out.println(d);
	} 
}

