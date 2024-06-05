package teste;

import common.StringSanitizer;
import org.junit.Test;
import static org.junit.Assert.*;

public class StringSanitizerTest {

    @Test
    public void testSanitizeText_NullInput() {
        assertNull(StringSanitizer.sanitizeText(null));
    }

    @Test
    public void testSanitizeText_EmptyString() {
        assertEquals("", StringSanitizer.sanitizeText(""));
    }

    @Test
    public void testSanitizeText_NormalString() {
        String input = "normal string";
        String expected = "normal string";
        assertEquals(expected, StringSanitizer.sanitizeText(input));
    }

    @Test
    public void testSanitizeText_StringWithHTMLTags() {
        String input = "<div>content</div>";
        String expected = "content";
        assertEquals(expected, StringSanitizer.sanitizeText(input));
    }

    @Test
    public void testSanitizeText_StringWithSpecialCharacters() {
        String input = "test&string\"with'special%characters<>";
        String expected = "teststringwithspecialcharacters";
        assertEquals(expected, StringSanitizer.sanitizeText(input));
    }

    @Test
    public void testSanitizeText_StringWithXSS() {
        String input = "<script>alert('xss')</script>";
        String expected = "alert(xss)";
        assertEquals(expected, StringSanitizer.sanitizeText(input));
    }
}
