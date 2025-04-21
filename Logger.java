import java.io.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * Logger class responsible for logging all system-level interactions.
 * Each log entry is timestamped and appended to a persistent log file.
 * Example:
 * [2024-10-10 12:35:10] Debris-123 is still in orbit at an altitude of 400 km.
 * [2024-10-10 12:40:25] Scientist filtered by LEO orbit.
 * 
 * @author Miguel
 * @version 1.0
 */
public class Logger {

    private final String logFilePath;
    private final DateTimeFormatter tsFormatter;
    private final DateTimeFormatter dateFormatter;

    public Logger(String logFilePath) {
        this.logFilePath = logFilePath;
        this.dateFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        this.tsFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
    }

    /**
     * Appends a message to the log file with a timestamp.
     * @param message the message to log
     */

    public void log(String message) {
        String timestamp = LocalDateTime.now().format(tsFormatter);
        String logEntry  = "[" + timestamp + "] " + message;

        String dateSuffix = LocalDate.now().format(dateFormatter);

        String base = logFilePath;
        int dot = base.lastIndexOf('.');
        if (dot > 0) {
            base = base.substring(0, dot);
        }
        String datedPath = base + "-" + dateSuffix + ".txt";

        try (BufferedWriter writer =
                     new BufferedWriter(new FileWriter(datedPath, true))) {
            writer.write(logEntry);
            writer.newLine();
        } catch (IOException e) {
            System.err.println("Logging failed: " + e.getMessage());
        }
    }
}