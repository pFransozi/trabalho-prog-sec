package teste;

import model.LivroGenero;

import org.junit.Test;
import static org.junit.Assert.*;

public class LivroGeneroTest {

    @Test
    public void testLivroGeneroConstructor() {
        LivroGenero livroGenero = new LivroGenero(1, "Ficção");
        assertEquals(1, livroGenero.getId());
        assertEquals("Ficção", livroGenero.getDescricao());
    }

    @Test
    public void testEmptyConstructor() {
        LivroGenero livroGenero = new LivroGenero();
        assertEquals(0, livroGenero.getId());
        assertNull(livroGenero.getDescricao());
    }

    @Test
    public void testGettersAndSetters() {
        LivroGenero livroGenero = new LivroGenero();

        livroGenero.setId(2);
        assertEquals(2, livroGenero.getId());

        livroGenero.setDescricao("Não-Ficção");
        assertEquals("Não-Ficção", livroGenero.getDescricao());
    }

    @Test
    public void testSetAndGetId() {
        LivroGenero livroGenero = new LivroGenero();
        livroGenero.setId(10);
        assertEquals(10, livroGenero.getId());
    }

    @Test
    public void testSetAndGetDescricao() {
        LivroGenero livroGenero = new LivroGenero();
        livroGenero.setDescricao("Romance");
        assertEquals("Romance", livroGenero.getDescricao());
    }
}
