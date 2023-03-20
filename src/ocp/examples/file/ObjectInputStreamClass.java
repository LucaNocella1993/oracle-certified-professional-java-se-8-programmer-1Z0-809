package ocp.examples.file;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class ObjectInputStreamClass implements Serializable {
	private static final long serialVersionUID = 1L;
	private int numPassengers = 1;
	private transient String schedule = "NONE";
	{numPassengers = 2;}
	public ObjectInputStreamClass() {
		this.numPassengers = 3;
		this.schedule = "Tropical Island";
	}
	public static void main(String... passengers) throws Exception {
		try (ObjectOutputStream o = new ObjectOutputStream(
				new FileOutputStream("ship.txt"))) {
			ObjectInputStreamClass c = new ObjectInputStreamClass();
			c.numPassengers = 4;
			c.schedule = "Casino";
			o.writeObject(c);
		}
		try (ObjectInputStream i = new ObjectInputStream(
				new FileInputStream("ship.txt"))) {
			ObjectInputStreamClass c = (ObjectInputStreamClass)i.readObject();
			System.out.print(c.numPassengers+","+c.schedule);
		}
	}
}