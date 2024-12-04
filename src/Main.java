import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Month;
import java.time.format.TextStyle;
import java.util.Locale;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        try {
            System.out.println("Enter the year:");
            int year = scanner.nextInt();

            String folderName;
            String fileName;

            for (int month = 1; month <= 12; month++) {
                Month currentMonth = Month.of(month);

                folderName = currentMonth.getDisplayName(TextStyle.FULL, new Locale("uz"));
                Path path1 = Paths.get("./src/" + folderName);
                Files.createDirectories(path1);

                LocalDate currentDate = LocalDate.of(year, month, 1);
                int daysInMonth = currentDate.lengthOfMonth();

                for (int day = 1; day <= daysInMonth; day++) {
                    LocalDate date = LocalDate.of(year, month, day);

                    folderName = day + "-" + currentMonth.getDisplayName(TextStyle.FULL, new Locale("uz"));
                    Path path2 = Paths.get(path1 + "/" + folderName);
                    Files.createDirectories(path2);

                    LocalDateTime dateTime = LocalDateTime.of(date, LocalTime.now());
                    fileName = date + ".txt";
                    Path path3 = Paths.get(path2 + "/" + fileName);

                    String data = dateTime.toString();
                    Files.write(path3, data.getBytes());
                }
            }
            System.out.println("All files has been successfully created");
        } catch (Exception e) {
            System.err.println("Failed: " + e.getMessage());
        }
    }
}
