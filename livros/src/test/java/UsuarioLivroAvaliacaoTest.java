package teste;

import model.UsuarioLivroAvaliacao;

import org.junit.Test;
import static org.junit.Assert.*;

public class UsuarioLivroAvaliacaoTest {

    @Test
    public void testUsuarioLivroAvaliacaoConstructor() {
        UsuarioLivroAvaliacao avaliacao = new UsuarioLivroAvaliacao(1, 1, 1, "Ótimo livro!", 4.5);
        assertEquals(1, avaliacao.getId());
        assertEquals(1, avaliacao.getUsuario());
        assertEquals(1, avaliacao.getLivro());
        assertEquals("Ótimo livro!", avaliacao.getComentario());
        assertEquals(4.5, avaliacao.getNota(), 0.0);
    }

    @Test
    public void testEmptyConstructor() {
        UsuarioLivroAvaliacao avaliacao = new UsuarioLivroAvaliacao();
        assertEquals(0, avaliacao.getId());
        assertEquals(0, avaliacao.getUsuario());
        assertEquals(0, avaliacao.getLivro());
        assertNull(avaliacao.getComentario());
        assertEquals(0.0, avaliacao.getNota(), 0.0);
    }

    @Test
    public void testGettersAndSetters() {
        UsuarioLivroAvaliacao avaliacao = new UsuarioLivroAvaliacao();

        avaliacao.setId(2);
        assertEquals(2, avaliacao.getId());

        avaliacao.setUsuario(3);
        assertEquals(3, avaliacao.getUsuario());

        avaliacao.setLivro(4);
        assertEquals(4, avaliacao.getLivro());

        avaliacao.setComentario("Bom livro.");
        assertEquals("Bom livro.", avaliacao.getComentario());

        avaliacao.setNota(4.0);
        assertEquals(4.0, avaliacao.getNota(), 0.0);
    }

    @Test
    public void testSetAndGetId() {
        UsuarioLivroAvaliacao avaliacao = new UsuarioLivroAvaliacao();
        avaliacao.setId(10);
        assertEquals(10, avaliacao.getId());
    }

    @Test
    public void testSetAndGetUsuario() {
        UsuarioLivroAvaliacao avaliacao = new UsuarioLivroAvaliacao();
        avaliacao.setUsuario(20);
        assertEquals(20, avaliacao.getUsuario());
    }

    @Test
    public void testSetAndGetLivro() {
        UsuarioLivroAvaliacao avaliacao = new UsuarioLivroAvaliacao();
        avaliacao.setLivro(30);
        assertEquals(30, avaliacao.getLivro());
    }

    @Test
    public void testSetAndGetComentario() {
        UsuarioLivroAvaliacao avaliacao = new UsuarioLivroAvaliacao();
        avaliacao.setComentario("Excelente leitura.");
        assertEquals("Excelente leitura.", avaliacao.getComentario());
    }

    @Test
    public void testSetAndGetNota() {
        UsuarioLivroAvaliacao avaliacao = new UsuarioLivroAvaliacao();
        avaliacao.setNota(5.0);
        assertEquals(5.0, avaliacao.getNota(), 0.0);
    }
}
