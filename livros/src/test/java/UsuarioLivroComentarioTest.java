import com.livros.model.UsuarioLivroComentario;

import org.junit.Test;
import static org.junit.Assert.*;

public class UsuarioLivroComentarioTest {

    @Test
    public void testUsuarioLivroComentarioConstructor() {
        UsuarioLivroComentario comentario = new UsuarioLivroComentario(1, 1, 1, "Muito bom!");
        assertEquals(1, comentario.getId());
        assertEquals(1, comentario.getIdUsuarioLivroAvaliacao());
        assertEquals(1, comentario.getUsuario());
        assertEquals("Muito bom!", comentario.getComentario());
    }

    @Test
    public void testEmptyConstructor() {
        UsuarioLivroComentario comentario = new UsuarioLivroComentario();
        assertEquals(0, comentario.getId());
        assertEquals(0, comentario.getIdUsuarioLivroAvaliacao());
        assertEquals(0, comentario.getUsuario());
        assertNull(comentario.getComentario());
    }

    @Test
    public void testGettersAndSetters() {
        UsuarioLivroComentario comentario = new UsuarioLivroComentario();

        comentario.setId(2);
        assertEquals(2, comentario.getId());

        comentario.setIdUsuarioLivroAvaliacao(3);
        assertEquals(3, comentario.getIdUsuarioLivroAvaliacao());

        comentario.setUsuario(4);
        assertEquals(4, comentario.getUsuario());

        comentario.setComentario("Interessante.");
        assertEquals("Interessante.", comentario.getComentario());
    }

    @Test
    public void testSetAndGetId() {
        UsuarioLivroComentario comentario = new UsuarioLivroComentario();
        comentario.setId(10);
        assertEquals(10, comentario.getId());
    }

    @Test
    public void testSetAndGetIdUsuarioLivroAvaliacao() {
        UsuarioLivroComentario comentario = new UsuarioLivroComentario();
        comentario.setIdUsuarioLivroAvaliacao(20);
        assertEquals(20, comentario.getIdUsuarioLivroAvaliacao());
    }

    @Test
    public void testSetAndGetUsuario() {
        UsuarioLivroComentario comentario = new UsuarioLivroComentario();
        comentario.setUsuario(30);
        assertEquals(30, comentario.getUsuario());
    }

    @Test
    public void testSetAndGetComentario() {
        UsuarioLivroComentario comentario = new UsuarioLivroComentario();
        comentario.setComentario("Excelente comentário.");
        assertEquals("Excelente comentário.", comentario.getComentario());
    }
}
