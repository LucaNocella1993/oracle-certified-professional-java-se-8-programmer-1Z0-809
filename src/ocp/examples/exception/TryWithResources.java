package ocp.examples.exception;

import java.io.Closeable;
import java.io.IOException;
import java.sql.SQLException;

class AutoCloseableClass implements AutoCloseable {
	@Override
	public void close() throws Exception {}
}

class CloseableClass implements Closeable {
	@Override
	public void close() throws IOException {}
}

class Database implements AutoCloseable {
	@Override
	public void close() throws SQLException {}
}

public class TryWithResources {
	public static void main(String... keys)  {
		try(AutoCloseableClass aC = new AutoCloseableClass();
				CloseableClass c = new CloseableClass();
				Database db = new Database();) 
		{

		} catch (IOException | RuntimeException e) {
			System.out.println("IOException or RuntimeException!");
		} catch (Exception e) {
			System.out.println("Exception!");
		} finally {
			System.out.println("Finally!");
		}
	}
}