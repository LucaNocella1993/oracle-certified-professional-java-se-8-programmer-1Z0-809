package ocp.examples.lambda;
import java.time.LocalDate;
import java.time.chrono.IsoChronology;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;

public class Person {
	public enum Sex {
		MALE, FEMALE
	}

	String name; 
	LocalDate birthday;
	Sex gender;
	String emailAddress;

	Person(String nameArg, LocalDate birthdayArg,
			Sex genderArg, String emailArg) {
		name = nameArg;
		birthday = birthdayArg;
		gender = genderArg;
		emailAddress = emailArg;
	}  

	public int getAge() {
		return birthday
				.until(IsoChronology.INSTANCE.dateNow())
				.getYears();
	}

	public void printPerson() {
		System.out.println(name + ", " + this.getAge());
	}

	public Sex getGender() {
		return gender;
	}

	public String getName() {
		return name;
	}

	public String getEmailAddress() {
		return emailAddress;
	}

	public LocalDate getBirthday() {
		return birthday;
	}

	public static int compareByAge(Person a, Person b) {
		return a.birthday.compareTo(b.birthday);
	}

	public static List<Person> createRoster() {

		List<Person> roster = new ArrayList<>();
		roster.add(
				new Person(
						"Fred",
						IsoChronology.INSTANCE.date(1980, 6, 20),
						Person.Sex.MALE,
						"fred@example.com"));
		roster.add(
				new Person(
						"Jane",
						IsoChronology.INSTANCE.date(1990, 7, 15),
						Person.Sex.FEMALE, "jane@example.com"));
		roster.add(
				new Person(
						"George",
						IsoChronology.INSTANCE.date(1991, 8, 13),
						Person.Sex.MALE, "george@example.com"));
		roster.add(
				new Person(
						"Bob",
						IsoChronology.INSTANCE.date(2000, 9, 12),
						Person.Sex.MALE, "bob@example.com"));

		return roster;
	} 

	public static void printPersonsWithPredicate(
			List<Person> roster, Predicate<Person> tester) {
		for (Person p : roster) {
			if (tester.test(p)) {
				p.printPerson();
			}
		}
	}

	public static void processPersons( List<Person> roster, Predicate<Person> tester, Consumer<Person> block) {
		for (Person p : roster) {
			if (tester.test(p)) {
				block.accept(p);
			}
		}
	}

	public static void processPersonsWithFunction(List<Person> roster, Predicate<Person> tester,
			Function<Person, String> mapper, Consumer<String> block) {
		for (Person p : roster) {
			if (tester.test(p)) {
				String data = mapper.apply(p);
				block.accept(data);
			}
		}
	}

	interface Predicate<Person> {
		boolean test(Person t);
	}

	public static void main(String... args) {
		List<Person> roster = new ArrayList<>();

		printPersonsWithPredicate(roster, p -> p.getGender() == Person.Sex.MALE && p.getAge() >= 18
				&& p.getAge() <= 25);

		processPersons(roster,
				p -> p.getGender() == Person.Sex.MALE && p.getAge() >= 18 && p.getAge() <= 25,
				p -> p.printPerson());

		processPersonsWithFunction(
				roster,
				p -> p.getGender() == Person.Sex.MALE && p.getAge() >= 18 && p.getAge() <= 25,
				p -> p.getEmailAddress(),
				email -> System.out.println(email)
				);

		roster.stream().filter( p -> p.getGender() == Person.Sex.MALE && p.getAge() >= 18 && p.getAge() <= 25)
		.map(p -> p.getEmailAddress()).forEach(email -> System.out.println(email));
	}

}