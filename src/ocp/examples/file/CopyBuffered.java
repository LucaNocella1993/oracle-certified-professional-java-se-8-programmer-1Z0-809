package ocp.examples.file;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class CopyBuffered {
	public static void main(String[] args) throws IOException {


		try (   BufferedReader BufferedReader = new BufferedReader(new FileReader("src/ocp/examples/file/xanadu.txt"));
				BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("src/ocp/examples/file/characteroutput.txt"));) {


			String s;
			while ((s = BufferedReader.readLine()) != null) {
				bufferedWriter.write(s);
			}
		}
	}
}