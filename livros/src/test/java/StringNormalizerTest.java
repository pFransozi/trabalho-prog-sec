import static org.junit.Assert.*;

import com.livros.common.StringNormalizer;
import org.junit.Test;

public class StringNormalizerTest {

    @Test
    public void testNormalizeString_NullInput() {
        assertNull(StringNormalizer.normalizeString(null));
    }

    @Test
    public void testNormalizeString_EmptyString() {
        assertEquals("", StringNormalizer.normalizeString(""));
    }

    @Test
    public void testNormalizeString_NormalString() {
        String input = "normal string";
        assertEquals(input, StringNormalizer.normalizeString(input));
    }

    @Test
    public void testNormalizeString_WithAccents() {
        String input = "é";
        String expected = "é";
        assertEquals(expected, StringNormalizer.normalizeString(input));
    }

    @Test
    public void testNormalizeString_CombiningCharacters() {
        String input = "e\u0301";  // 'e' followed by a combining accent
        String expected = "é";     // single 'é' character
        assertEquals(expected, StringNormalizer.normalizeString(input));
    }

    @Test
    public void testNormalizeString_AlreadyNormalized() {
        String input = "é";
        String expected = "é";
        assertEquals(expected, StringNormalizer.normalizeString(input));
    }

    @Test
    public void testNormalizeString_DifferentForms() {
        String inputNFD = "e\u0301"; // 'e' followed by a combining accent (NFD)
        String inputNFC = "é";      // single 'é' character (NFC)
        assertEquals(inputNFC, StringNormalizer.normalizeString(inputNFD));
    }

    @Test
    public void testNormalizeString_MultipleCombiningCharacters() {
        String input = "A\u030A"; // 'A' followed by ring above
        String expected = "Å";   // single 'Å' character
        assertEquals(expected, StringNormalizer.normalizeString(input));
    }
}
