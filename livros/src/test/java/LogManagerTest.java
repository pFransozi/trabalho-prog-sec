
import com.livros.common.LogManager;
import com.livros.common.StrongRandomNumberGenerator;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import uk.org.webcompere.systemstubs.environment.EnvironmentVariables;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.attribute.PosixFilePermission;
import java.nio.file.attribute.PosixFilePermissions;
import java.util.HashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

class LogManagerTest {
    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final PrintStream originalOut = System.out;
    private static final String TEST_LOG_FILE_NAME = "test_application.log";
    private static final String TEST_LOG_FILE_DIR = ".";

    private EnvironmentVariables environmentVariables;
    private StrongRandomNumberGenerator strongRandomNumberGenerator;

    @BeforeEach
    public void setUp() throws Exception {
        System.setOut(new PrintStream(outContent));

        // Configurar variáveis de ambiente para teste
        environmentVariables = new EnvironmentVariables(
                "LOG_FILE_NAME", TEST_LOG_FILE_NAME,
                "LOG_FILE_DIR", TEST_LOG_FILE_DIR
        );
        environmentVariables.setup();

        // Limpar o arquivo de log antes de cada teste
        Path logFilePath = Paths.get(TEST_LOG_FILE_DIR, TEST_LOG_FILE_NAME);
        Files.deleteIfExists(logFilePath);
        Files.createFile(logFilePath);
    }

    @AfterEach
    public void tearDown() throws Exception {
        System.setOut(originalOut);
        outContent.reset();
        // Remover o arquivo de log de teste
        Path logFilePath = Paths.get(TEST_LOG_FILE_DIR, TEST_LOG_FILE_NAME);
        Files.deleteIfExists(logFilePath);
        environmentVariables.teardown();
    }

    @Test
    public void testLogError() throws IOException {
        String friendlyMessage = "Ocorreu um erro na aplicação.";
        String detailedMessage = "Este é um exemplo de exceção detalhada.";

        LogManager.logError(friendlyMessage, detailedMessage);

        // Verificar saída no console
        String consoleOutput = outContent.toString();
        assertTrue(consoleOutput.contains(friendlyMessage));
        assertTrue(consoleOutput.contains("Error ID:"));

        // Verificar arquivo de log
        Path logFilePath = Paths.get(TEST_LOG_FILE_DIR, TEST_LOG_FILE_NAME);
        assertTrue(Files.exists(logFilePath));

        // Verificar conteúdo do arquivo de log
        String logFileContent = new String(Files.readAllBytes(logFilePath));
        assertTrue(logFileContent.contains(detailedMessage));
        assertTrue(logFileContent.contains("Error ID:"));
    }

    @Test
    public void testLogFilePermissions() throws IOException {
        // Configurar e limpar arquivo de log
        Path logFilePath = Paths.get(TEST_LOG_FILE_DIR, TEST_LOG_FILE_NAME);
        Files.deleteIfExists(logFilePath);

        String friendlyMessage = "Ocorreu um erro na aplicação.";
        String detailedMessage = "Este é um exemplo de exceção detalhada.";

        LogManager.logError(friendlyMessage, detailedMessage);

        // Verificar se o arquivo foi criado
        assertTrue(Files.exists(logFilePath));

        // Verificar permissões do arquivo (apenas em sistemas POSIX)
        Set<PosixFilePermission> expectedPermissions = PosixFilePermissions.fromString("rw-r-----");
        Set<PosixFilePermission> actualPermissions = Files.getPosixFilePermissions(logFilePath);
        assertEquals(expectedPermissions, actualPermissions);
    }

    @Test
    public void testStrongRandomIdGeneration() {
        Set<String> generatedIds = new HashSet<>();
        for (int i = 0; i < 1000; i++) {
            String id = StrongRandomNumberGenerator.generateStrongRandomId();
            assertFalse(generatedIds.contains(id), "ID duplicado encontrado: " + id);
            assertEquals(32, id.length(), "Comprimento do ID é inválido.");
            generatedIds.add(id);
        }
    }
}
