import model.Livro;
import org.junit.Test;
import static org.junit.Assert.*;

public class LivroTest {

    @Test
    public void testLivroConstructor() {
        Livro livro = new Livro(1, "O Alquimista", "Paulo Coelho", "978-0061122415", 2);
        assertEquals(1, livro.getId());
        assertEquals("O Alquimista", livro.getTitulo());
        assertEquals("Paulo Coelho", livro.getAutor());
        assertEquals("978-0061122415", livro.getIsbn());
        assertEquals(2, livro.getGenero());
    }

    @Test
    public void testGettersAndSetters() {
        Livro livro = new Livro(1, "O Alquimista", "Paulo Coelho", "978-0061122415", 2);

        livro.setId(2);
        assertEquals(2, livro.getId());

        livro.setTitulo("Brida");
        assertEquals("Brida", livro.getTitulo());

        livro.setAutor("Gabriel Garcia Marquez");
        assertEquals("Gabriel Garcia Marquez", livro.getAutor());

        livro.setIsbn("978-0307389732");
        assertEquals("978-0307389732", livro.getIsbn());

        livro.setGenero(3);
        assertEquals(3, livro.getGenero());
    }

    @Test
    public void testEmptyConstructor() {
        Livro livro = new Livro(0, "", "", "", 0);
        assertEquals(0, livro.getId());
        assertEquals("", livro.getTitulo());
        assertEquals("", livro.getAutor());
        assertEquals("", livro.getIsbn());
        assertEquals(0, livro.getGenero());
    }

    @Test
    public void testPartialConstructor() {
        Livro livro = new Livro(1, "Cem Anos de Solidão", "Gabriel Garcia Marquez", "", 4);
        assertEquals(1, livro.getId());
        assertEquals("Cem Anos de Solidão", livro.getTitulo());
        assertEquals("Gabriel Garcia Marquez", livro.getAutor());
        assertEquals("", livro.getIsbn());
        assertEquals(4, livro.getGenero());
    }

    @Test
    public void testSetAndGetId() {
        Livro livro = new Livro(0, "", "", "", 0);
        livro.setId(10);
        assertEquals(10, livro.getId());
    }

    @Test
    public void testSetAndGetTitulo() {
        Livro livro = new Livro(0, "", "", "", 0);
        livro.setTitulo("Novo Titulo");
        assertEquals("Novo Titulo", livro.getTitulo());
    }

    @Test
    public void testSetAndGetAutor() {
        Livro livro = new Livro(0, "", "", "", 0);
        livro.setAutor("Novo Autor");
        assertEquals("Novo Autor", livro.getAutor());
    }

    @Test
    public void testSetAndGetIsbn() {
        Livro livro = new Livro(0, "", "", "", 0);
        livro.setIsbn("123-4567890123");
        assertEquals("123-4567890123", livro.getIsbn());
    }

    @Test
    public void testSetAndGetGenero() {
        Livro livro = new Livro(0, "", "", "", 0);
        livro.setGenero(5);
        assertEquals(5, livro.getGenero());
    }
}
