package teste;

import model.UsuarioGrupo;

import org.junit.Test;
import static org.junit.Assert.*;

public class UsuarioGrupoTest {

    @Test
    public void testUsuarioGrupoConstructor() {
        UsuarioGrupo usuarioGrupo = new UsuarioGrupo(1, "Admin");
        assertEquals(1, usuarioGrupo.getId());
        assertEquals("Admin", usuarioGrupo.getDescricao());
    }

    @Test
    public void testEmptyConstructor() {
        UsuarioGrupo usuarioGrupo = new UsuarioGrupo();
        assertEquals(0, usuarioGrupo.getId());
        assertNull(usuarioGrupo.getDescricao());
    }

    @Test
    public void testGettersAndSetters() {
        UsuarioGrupo usuarioGrupo = new UsuarioGrupo();

        usuarioGrupo.setId(2);
        assertEquals(2, usuarioGrupo.getId());

        usuarioGrupo.setDescricao("User");
        assertEquals("User", usuarioGrupo.getDescricao());
    }

    @Test
    public void testSetAndGetId() {
        UsuarioGrupo usuarioGrupo = new UsuarioGrupo();
        usuarioGrupo.setId(10);
        assertEquals(10, usuarioGrupo.getId());
    }

    @Test
    public void testSetAndGetDescricao() {
        UsuarioGrupo usuarioGrupo = new UsuarioGrupo();
        usuarioGrupo.setDescricao("Guest");
        assertEquals("Guest", usuarioGrupo.getDescricao());
    }
}
