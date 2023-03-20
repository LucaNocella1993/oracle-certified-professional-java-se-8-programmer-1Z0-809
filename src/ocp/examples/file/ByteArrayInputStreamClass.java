package ocp.examples.file;
import java.io.ByteArrayInputStream;
import java.io.InputStream;

public class ByteArrayInputStreamClass {
	public int getWidgetNumber(byte[] data) throws Exception {
		try (InputStream is = new ByteArrayInputStream(data)) {
			is.read(new byte[2]);
			if(!is.markSupported()) return -1;
			is.mark(5); //il parametro sta per il numero massimo di letture successive, altrimenti reset non funziona
			is.read();is.read();
			is.skip(3);
			is.reset();
			return is.read();
		}
	}
	public static void main(String... sprockets) throws Exception {
		final ByteArrayInputStreamClass p = new ByteArrayInputStreamClass();
		System.out.print(p.getWidgetNumber(new byte[] {1,2,3,4,5,6,7}));
	}
}