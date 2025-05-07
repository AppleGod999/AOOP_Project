import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;


import java.io.*;
import java.nio.file.*;
import java.util.Map;

/**
 * Unit tests for system functionality related to user role access,
 * exception handling, header parsing, and logger behavior.
 *
 * @author Miguel
 * @author Diego
 * @version 1.0
 */
public class SysFuncTest {

    private Filereader filereader;
    private Path tempLogDir;

    @BeforeEach
    void setUp() throws IOException {
        filereader = new Filereader();
        // create a temporary directory for logger tests
        tempLogDir = Files.createTempDirectory("testlogs");
    }

    @AfterEach
    void tearDown() throws IOException {
        // clean up temp log directory
        if (Files.exists(tempLogDir)) {
            try (DirectoryStream<Path> ds = Files.newDirectoryStream(tempLogDir)) {
                for (Path p : ds) Files.deleteIfExists(p);
            }
            Files.deleteIfExists(tempLogDir);
        }
    }

    @Test
    public void testUnauthorizedAccessExceptionThrown() {
        Exception exception = assertThrows(UnauthorizedAccessException.class, () -> {
            throw new UnauthorizedAccessException("Scientist not allowed.");
        });
        assertEquals("Scientist not allowed.", exception.getMessage());
    }

    @Test
    public void testGetHeaderSimple() {
        String[] headers = {"id", "name", "value"};
        Map<String, Integer> map = filereader.getHeader(headers);
        assertEquals(0, map.get("id"));
        assertEquals(1, map.get("name"));
        assertEquals(2, map.get("value"));
    }



    @Test
    public void testLoggerWritesToFile() throws IOException {
        Logger logger = new Logger(tempLogDir.toString());
        String message = "Test log entry";

        logger.log(message);

        // Expect at least one file in the temp dir
        try (DirectoryStream<Path> ds = Files.newDirectoryStream(tempLogDir, "*.log")) {
            Path logFile = ds.iterator().next();
            String content = Files.readString(logFile);
            assertTrue(content.contains(message), "Log file should contain the message");
        }
    }
}
