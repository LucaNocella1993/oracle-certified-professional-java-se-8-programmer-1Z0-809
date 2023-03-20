package ocp.examples.file;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class CopyBytes {
	public static void main(String[] args) throws IOException {


		try (	FileInputStream in = new FileInputStream("src/ocp/examples/file/xanadu.txt");
				FileOutputStream out = new FileOutputStream("src/ocp/examples/file/outagain.txt");) {

			int c;

			while ((c = in.read()) != -1) {
				out.write(c);
			}
		}
	}
}