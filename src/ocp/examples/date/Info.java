package ocp.examples.date;

import java.time.Duration;
import java.time.Period;

public class Info {
	
public static void main(String... strings) {
	Duration d = Duration.ofHours(25);
	System.out.println(d);
	Period p = Period.ofDays(1);
	System.out.println(p);
}
}

/* Duration.toString:  (take of days, hours, minutes, seconds, millis, nanos)
 * It generates a string representation of the duration object using ISO-8601 seconds based representation, such as PT8H6M12.345S.
 * The format of the returned string will be PTnHnMnS, where n is the relevant hours, minutes or seconds part of the duration.
 * Any fractional seconds are placed after a decimal point i the seconds section. If a section has a zero value, it is omitted. 
 * The hours, minutes and seconds will all have the same sign. 
 * Examples:     "20.345 seconds"                 
 * -- "PT20.345S     "15 minutes" (15 * 60 seconds)   
 * -- "PT15M"     "10 hours" (10 * 3600 seconds)   
 * -- "PT10H"     "2 days" (2 * 86400 seconds)     
 * -- "PT48H"  Note that multiples of 24 hours are not output as days to avoid confusion with Period.  
 * 
 * Period.toString: (take of days, months, years and weeks)
 * Outputs this period as a String, such as P6Y3M1D. 
 * The output will be in the ISO-8601 period format. 
 * A zero period will be represented as zero days, 'P0D'.
 */