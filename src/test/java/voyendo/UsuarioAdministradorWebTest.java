package voyendo;

import voyendo.authentication.ManagerUserSession;
import voyendo.authentication.UsuarioNoAdministradorException;
import voyendo.service.CompanyService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.mock.web.MockHttpSession;
import org.springframework.test.web.servlet.MockMvc;

import java.util.ArrayList;
import java.util.Arrays;

import static org.hamcrest.Matchers.containsString;
import static org.hamcrest.Matchers.not;
import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
public class UsuarioAdministradorWebTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private CompanyService usuarioService;

    @MockBean
    ManagerUserSession managerUserSession;

    @MockBean
    MockHttpSession session;

    /*
    @Test
    public void formularioRegistroDetectaAdministrador() throws Exception {
        when(usuarioService.hayAdministrador()).thenReturn(true);
        this.mockMvc.perform(get("/registro")).andExpect(content().string(not(containsString("Administrador"))));
    }

    @Test
    public void formularioRegistroDetectaAdministrador2() throws Exception {
        when(usuarioService.hayAdministrador()).thenReturn(false);
        this.mockMvc.perform(get("/registro")).andExpect(content().string(containsString("Administrador")));
    }

    @Test
    public void servicioLoginUsuarioAdministradorOK() throws Exception {

        Usuario anaGarcia = new Usuario("ana.garcia@gmail.com");
        anaGarcia.setId(1L);
        anaGarcia.setAdministrador(true);

        when(usuarioService.login("ana.garcia@gmail.com", "12345678"))
                .thenReturn(CompanyService.LoginStatus.LOGIN_OK);
        when(usuarioService.findByEmail("ana.garcia@gmail.com"))
                .thenReturn(anaGarcia);

        this.mockMvc.perform(post("/login")
                        .param("eMail", "ana.garcia@gmail.com")
                        .param("password", "12345678"))
                .andExpect(status().is3xxRedirection())
                .andExpect(redirectedUrl("/usuarios"));
    }

    @Test
    public void paginaListadoUsuariosSinSerAdministrador() throws Exception {
        when(managerUserSession.comprobarUsuarioAdministradorLogeado(any())).thenThrow(UsuarioNoAdministradorException.class);
        this.mockMvc.perform(get("/usuarios")).andExpect(status().isUnauthorized());
    }

    @Test
    public void paginaListadoUsuariosSiendoAdministrador() throws Exception {
        Usuario user1 = new Usuario("usuario1@ua.com");
        user1.setId(1L);
        user1.setNombre("Jose");
        user1.setAdministrador(true);
        Usuario user2 = new Usuario("usuario2@ua.com");
        user2.setId(2L);
        Usuario user3 = new Usuario("usuario3@ua.com");
        user3.setId(3L);

        ArrayList<Usuario> arrayListUsuarios = new ArrayList<Usuario>(Arrays.asList(user1, user2, user3));
        Iterable<Usuario> usuarios = arrayListUsuarios;

        when(usuarioService.findAll()).thenReturn(usuarios);
        when(managerUserSession.usuarioLogeado(session)).thenReturn(1L);
        this.mockMvc.perform(get("/usuarios")).andExpect(content().string(containsString("Listado de usuarios")))
                .andExpect(content().string(containsString("usuario1@ua.com")))
                .andExpect(content().string(containsString("usuario2@ua.com")))
                .andExpect(content().string(containsString("usuario3@ua.com")));
    }

    @Test
    public void paginaDescripcionUsuariosSinSerAdministrador() throws Exception {
        when(managerUserSession.comprobarUsuarioAdministradorLogeado(any())).thenThrow(UsuarioNoAdministradorException.class);
        this.mockMvc.perform(get("/usuarios/1")).andExpect(status().isUnauthorized());
    }

    @Test
    public void paginaDescripcionUsuariosSiendoAdministrador() throws Exception {
        Usuario usuarioAConsultar = new Usuario("usuarioAConsultar@ua.com");
        usuarioAConsultar.setId(1L);
        usuarioAConsultar.setNombre("Antonio");

        when(usuarioService.findById(anyLong())).thenReturn(usuarioAConsultar);
        when(managerUserSession.usuarioLogeado(session)).thenReturn(2L);

        this.mockMvc.perform(get("/usuarios/1")).andExpect(content().string(containsString("Descripción de usuario")))
                .andExpect(content().string(containsString("usuarioAConsultar@ua.com")))
                .andExpect(content().string(containsString("Antonio")));
    }

     */

}
