package ocp.examples.enumeration;

interface Interface{	}

enum EnumExample implements Interface {
	LUNEDI(8,24),
	MARTEDI(8,24),
	MERCOLEDI(8,24),
	GIOVEDI(8,24),
	VENERDI(8,24),
	SABATO(4,24),
	DOMENICA(0,24);
	
    public int workedHours;   
    public int totalHoursPerDay;
	private EnumExample(int workedHours, int totalHoursPerDay) {
		this.workedHours = workedHours;
		this.totalHoursPerDay = totalHoursPerDay;
	}
}

public class EnumExampleClass {
	public static void main (String...strings) {
		for (EnumExample enumExample : EnumExample.values()) {
			System.out.println(enumExample.ordinal() + " " + enumExample.workedHours + "/" + enumExample.totalHoursPerDay);
		}
		
		System.out.println(EnumExample.valueOf("LUNEDI"));
	}
}