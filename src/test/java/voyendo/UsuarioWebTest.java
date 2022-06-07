package voyendo;

import voyendo.authentication.ManagerUserSession;
import voyendo.service.CompanyService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.mock.web.MockHttpSession;
import org.springframework.test.web.servlet.MockMvc;

import java.util.*;

import static org.hamcrest.Matchers.containsString;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
public class UsuarioWebTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private CompanyService usuarioService;

    @MockBean
    ManagerUserSession managerUserSession;

    @MockBean
    MockHttpSession session;

    /*
    // Ejemplo de test en el que se utiliza un mock
    @Test
    public void servicioLoginUsuarioOK() throws Exception {

        Usuario anaGarcia = new Usuario("ana.garcia@gmail.com");
        anaGarcia.setId(1L);

        when(usuarioService.login("ana.garcia@gmail.com", "12345678"))
                .thenReturn(CompanyService.LoginStatus.LOGIN_OK);
        when(usuarioService.findByEmail("ana.garcia@gmail.com"))
                .thenReturn(anaGarcia);

        this.mockMvc.perform(post("/login")
                .param("eMail", "ana.garcia@gmail.com")
                .param("password", "12345678"))
                //.andDo(print())
                .andExpect(status().is3xxRedirection())
                .andExpect(redirectedUrl("/usuarios/1/tareas"));
    }

    // En este test usamos los datos cargados en el fichero de prueba
    @Test
    public void servicioLoginUsuarioNotFound() throws Exception {
        when(usuarioService.login("pepito.perez@gmail.com", "12345678"))
                .thenReturn(CompanyService.LoginStatus.USER_NOT_FOUND);

        this.mockMvc.perform(post("/login")
                    .param("eMail","pepito.perez@gmail.com")
                    .param("password","12345678"))
                .andExpect(content().string(containsString("No existe usuario")));
    }

    @Test
    public void servicioLoginUsuarioErrorPassword() throws Exception {
        when(usuarioService.login("ana.garcia@gmail.com", "000"))
                .thenReturn(CompanyService.LoginStatus.ERROR_PASSWORD);

        this.mockMvc.perform(post("/login")
                    .param("eMail","ana.garcia@gmail.com")
                    .param("password","000"))
                .andExpect(content().string(containsString("Contraseña incorrecta")));
    }

    @Test
    public void servicioLoginUsuarioIsBlocked() throws Exception {
        when(usuarioService.login("ana.garcia@gmail.com", "000"))
                .thenReturn(CompanyService.LoginStatus.IS_BLOCKED);

        this.mockMvc.perform(post("/login")
                        .param("eMail","ana.garcia@gmail.com")
                        .param("password","000"))
                .andExpect(content().string(containsString("Usuario bloqueado")));
    }

    @Test
    public void servicioLoginRedirectContraseñaIncorrecta() throws Exception {
        this.mockMvc.perform(get("/login")
                .flashAttr("error", "Contraseña incorrecta"))
                .andExpect(content().string(containsString("Contraseña incorrecta")));
    }

    @Test
    public void servicioLoginRedirectUsuarioNotFound() throws Exception {
        this.mockMvc.perform(get("/login")
                .flashAttr("error", "No existe usuario"))
                .andExpect(content().string(containsString("No existe usuario")));
    }

    @Test
    public void servicioLoginRedirecIsBlocked() throws Exception {
        this.mockMvc.perform(get("/login")
                        .flashAttr("error", "Usuario bloqueado"))
                .andExpect(content().string(containsString("Usuario bloqueado")));
    }

    @Test
    public void paginaListadoUsuariosSinLogear() throws Exception {
        Usuario user1 = new Usuario("user1@ua.com");
        user1.setId(1L);
        Usuario user2 = new Usuario("user2@ua.com");
        user2.setId(2L);
        Usuario user3 = new Usuario("user3@ua.com");
        user3.setId(3L);

        ArrayList<Usuario> arrayListUsuarios = new ArrayList<Usuario>(Arrays.asList(user1, user2, user3));
        Iterable<Usuario> usuarios = arrayListUsuarios;

        when(usuarioService.findAll()).thenReturn(usuarios);

        this.mockMvc.perform(get("/usuarios")).andExpect(content().string(containsString("Listado de usuarios")))
                .andExpect(content().string(containsString("user1@ua.com")))
                .andExpect(content().string(containsString("user2@ua.com")))
                .andExpect(content().string(containsString("user3@ua.com")));
    }

    @Test
    public void paginaDescripcionUsuarios() throws Exception {
        Usuario usuarioAConsultar = new Usuario("usuarioAConsultar@ua.com");
        usuarioAConsultar.setId(1L);
        usuarioAConsultar.setNombre("Antonio");

        when(usuarioService.findById(anyLong())).thenReturn(usuarioAConsultar);
        when(managerUserSession.usuarioLogeado(session)).thenReturn(null);

        this.mockMvc.perform(get("/usuarios/1")).andExpect(content().string(containsString("Descripción de usuario")))
                .andExpect(content().string(containsString("usuarioAConsultar@ua.com")))
                .andExpect(content().string(containsString("Antonio")));
    }

     */

}
