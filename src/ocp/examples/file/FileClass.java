package ocp.examples.file;
import java.io.File;


public class FileClass {
	public void resetWorkingDirectory() throws Exception {
		File f1 = new File("src/ocp/examples/file/templates/proofs");
		f1.mkdirs();
		File f2 = new File("src/ocp/examples/file/templates");
		f2.mkdir(); // k1
		new File(f2,"draft.txt").createNewFile();
		f1.delete();
		f2.delete(); // k2
	}
	public static void main(String... leads) {
		try {
			new FileClass().resetWorkingDirectory();
		} catch (Exception e) {
			new RuntimeException(e);
		}
	}
}