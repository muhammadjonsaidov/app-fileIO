package fileIOStream;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;


public class FileNIO {
    public static void main(String[] args) {


    }

    private static void filesReadAll() {
        Path path = Paths.get("./src/fileIOStream/example3.txt");
        try {
            byte[] bytes = Files.readAllBytes(path);
            String content = new String(bytes, StandardCharsets.UTF_8);
            System.out.println(content);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void filesWrite() {
        Path path = Paths.get("./src/fileIOStream/example3.txt");
        String data = "Hello, World!\nThis is another line.";

        try {
            Files.write(path, data.getBytes());
            System.out.println("File successfully wrote");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
