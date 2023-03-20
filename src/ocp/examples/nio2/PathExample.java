package ocp.examples.nio2;
import java.nio.file.Path;
import java.nio.file.Paths;

public class PathExample {
	public String doTrick(Path path) {
		return path.subpath(2,3)
				.toAbsolutePath()
				.toString();
	}
	public static void main(String... cards) {
		final PathExample m = new PathExample();
		System.out.print(m.doTrick(
				Paths.get("/bag/of/tricks/.././disappear.txt")));
	} }