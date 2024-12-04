import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.time.LocalTime;
//import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println("Give me year: ");
//        Scanner sc = new Scanner(System.in);


        try {
            int takeYear = 2024;
            int month = 12;
            String folderName;
            String fileName;
            for (int i = 1; i <= month; i++) {
                LocalDate date = LocalDate.of(takeYear, i, 1);
                folderName = date.getMonth().toString();
                Path path1 = Paths.get("./src/" + folderName);
                Files.createDirectories(path1);
                for (int j = 1; j <= date.lengthOfMonth(); j++) {
                    folderName = (j + " - " + date.getMonth());
                    Path path12 = Paths.get(path1 + folderName);
                    Files.createDirectories(path12);
                    for (int k = 0; k < date.getDayOfMonth(); k++) {
                        LocalDate curr = LocalDate.of(takeYear, i, j);
                        LocalTime time = LocalTime.now();
                        fileName = (curr + ".txt");
                        Path path123 = Paths.get(path12 + fileName);
                        String content = curr + " " + time;
                        Files.writeString(path123, content);
                    }
                }

            }
        } catch (IOException e) {
            System.err.println("Failed: " + e.getMessage());
        }
    }
}