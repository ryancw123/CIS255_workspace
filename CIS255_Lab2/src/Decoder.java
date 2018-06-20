import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;

public class Decoder {

	public static void main(String[] args) throws IOException {
		String content = new String(Files.readAllBytes(Paths.get("secret.txt")));//reads the text file
		String[] splitArray = content.split(" ");//holds every word of the text file.
		StringBuilder sBuilder = new StringBuilder();
		for(int i=0;i<splitArray.length;i+=5) {
			sBuilder.append(splitArray[i].substring(0, 1).toUpperCase());//adds the specified letters to sBuilder
		}
		System.out.print(sBuilder.toString());
	}
}
