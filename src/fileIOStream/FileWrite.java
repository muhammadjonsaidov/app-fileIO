package fileIOStream;

import java.io.*;

public class FileWrite {
    public static void main(String[] args) {

    }

    private static void bufferedReader() {
        try {
            BufferedReader br = new BufferedReader(new FileReader("./src/fileIOStream/example2.txt"));
            String line;
            while ((line = br.readLine()) != null) {
                System.out.println(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void bufferedWriter() {
        try {
            BufferedWriter bw = new BufferedWriter(new FileWriter("./src/fileIOStream/example2.txt"));
            bw.write("Hello World!");
            bw.newLine();
            bw.write("Writing with BufferedWriter...");
            bw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void fileInputStream() {
        try {
            FileInputStream fis = new FileInputStream("./src/fileIOStream/example.txt");
            int content;
            StringBuilder sb = new StringBuilder();
            while((content = fis.read()) != -1) {
                sb.append((char) content);
            }
            System.out.println(sb);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void fileOutputStream() {
        String data = "Hello World!";
        try {
            FileOutputStream fos = new FileOutputStream("./src/fileIOStream/example.txt");
            fos.write(data.getBytes());
            System.out.println("Data written to " + fos);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
