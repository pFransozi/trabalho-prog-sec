package teste;

import model.Usuario;

import org.junit.Test;
import static org.junit.Assert.*;

public class UsuarioTest {

    @Test
    public void testUsuarioConstructor() {
        Usuario usuario = new Usuario(1, "123.456.789-00", "email@example.com", 2);
        assertEquals(1, usuario.getId());
        assertEquals("123.456.789-00", usuario.getCpf());
        assertEquals("email@example.com", usuario.getEmail());
        assertEquals(2, usuario.getGrupo());
    }

    @Test
    public void testEmptyConstructor() {
        Usuario usuario = new Usuario();
        assertEquals(0, usuario.getId());
        assertNull(usuario.getCpf());
        assertNull(usuario.getEmail());
        assertEquals(0, usuario.getGrupo());
    }

    @Test
    public void testGettersAndSetters() {
        Usuario usuario = new Usuario();

        usuario.setId(2);
        assertEquals(2, usuario.getId());

        usuario.setCpf("987.654.321-00");
        assertEquals("987.654.321-00", usuario.getCpf());

        usuario.setEmail("newemail@example.com");
        assertEquals("newemail@example.com", usuario.getEmail());

        usuario.setGrupo(3);
        assertEquals(3, usuario.getGrupo());
    }

    @Test
    public void testSetAndGetId() {
        Usuario usuario = new Usuario();
        usuario.setId(10);
        assertEquals(10, usuario.getId());
    }

    @Test
    public void testSetAndGetCpf() {
        Usuario usuario = new Usuario();
        usuario.setCpf("111.222.333-44");
        assertEquals("111.222.333-44", usuario.getCpf());
    }

    @Test
    public void testSetAndGetEmail() {
        Usuario usuario = new Usuario();
        usuario.setEmail("user@example.com");
        assertEquals("user@example.com", usuario.getEmail());
    }

    @Test
    public void testSetAndGetGrupo() {
        Usuario usuario = new Usuario();
        usuario.setGrupo(4);
        assertEquals(4, usuario.getGrupo());
    }
}
