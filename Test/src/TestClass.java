import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;

public class TestClass {

	public static void main(String[] args) throws IOException {
		String content = new String(Files.readAllBytes(Paths.get("secret.txt")));
		//String path = "./secret.txt";
		//String[] splitArray =
		System.out.println(content);
	}
}
