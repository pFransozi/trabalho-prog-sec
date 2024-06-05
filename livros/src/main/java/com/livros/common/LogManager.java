package common;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.attribute.PosixFilePermission;
import java.nio.file.attribute.PosixFilePermissions;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Set;

public class LogManager {
    public static void logError(String friendlyMessage, String detailedMessage) {
        String logFileName = System.getenv().getOrDefault("LOG_FILE_NAME", "application.log");
        String logFileDir = System.getenv().getOrDefault("LOG_FILE_DIR", ".");
        String errorId = StrongRandomNumberGenerator.generateStrongRandomId();
        String timestamp = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.getDefault()).format(new Date());

        // Print friendly message with error ID
        System.out.println(friendlyMessage + " [Error ID: " + errorId + "]");

        // Create the log entry
        String logEntry = String.format("[%s] [Error ID: %s] %s%n", timestamp, errorId, detailedMessage);

        // Append log entry to the log file
        appendLogEntry(logFileDir, logFileName, logEntry);
    }

    /*
    private static void appendLogEntry(String logFileDir, String logFileName, String logEntry) {
        File logFile = new File(logFileDir, logFileName);
        try (FileWriter writer = new FileWriter(logFile, true)) {
            writer.write(logEntry);
        } catch (IOException e) {
            System.err.println("Erro ao escrever no arquivo de log: " + e.getMessage());
        }
    }*/

    private static void appendLogEntry(String logFileDir, String logFileName, String logEntry) {
        Path logFilePath = new File(logFileDir, logFileName).toPath();
        try {
            if (!Files.exists(logFilePath)) {
                // Define permissões apropriadas para o arquivo de log
                Set<PosixFilePermission> permissions = PosixFilePermissions.fromString("rw-r-----");
                Files.createFile(logFilePath, PosixFilePermissions.asFileAttribute(permissions));
            }
            try (FileWriter writer = new FileWriter(logFilePath.toFile(), true)) {
                writer.write(logEntry);
            }
        } catch (IOException e) {
            System.err.println("Erro ao escrever no arquivo de log: " + e.getMessage());
        }
    }
}
