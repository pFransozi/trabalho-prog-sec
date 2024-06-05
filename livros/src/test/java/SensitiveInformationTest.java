
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.fail;

class SensitiveInformationTest {

    // Padrão para detectar strings de conexão MySQL hardcoded com usuário e senha
    private static final Pattern CONNECTION_STRING_PATTERN = Pattern.compile(
            "jdbc:mysql://.*\\?user=.*&password=.*", Pattern.CASE_INSENSITIVE);

    @Test
    void testNoHardcodedConnectionString() throws IOException {
        List<Path> javaFiles = findJavaFiles(Paths.get("src"));

        for (Path file : javaFiles) {
            // Ignorar arquivos de teste
            if (file.toString().contains("/test/") || file.toString().endsWith("SensitiveInformationTest.java")) {
                continue;
            }

            List<String> lines = Files.readAllLines(file);
            for (String line : lines) {
                if (CONNECTION_STRING_PATTERN.matcher(line).find() && !isSafeUsage(line)) {
                    fail("Hardcoded connection string found in file " + file + ": " + line);
                }
            }
        }
    }

    private List<Path> findJavaFiles(Path rootDir) throws IOException {
        try (Stream<Path> paths = Files.walk(rootDir)) {
            return paths
                    .filter(path -> path.toString().endsWith(".java"))
                    .collect(Collectors.toList());
        }
    }

    private boolean isSafeUsage(String line) {
        // Verifica se a linha contém a construção segura da string de conexão
        return line.contains("System.getenv");
    }
}
