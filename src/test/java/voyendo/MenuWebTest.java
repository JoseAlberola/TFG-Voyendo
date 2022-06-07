package voyendo;

import voyendo.authentication.ManagerUserSession;
import voyendo.service.AppointmentService;
import voyendo.service.CompanyService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import javax.servlet.http.HttpSession;

import static org.hamcrest.Matchers.*;
import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
public class MenuWebTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private CompanyService usuarioService;

    @MockBean
    private AppointmentService tareaService;

    @MockBean
    ManagerUserSession managerUserSession;

    @MockBean
    HttpSession session;

    /*
    @Test
    public void menuLogueadoPaginaAbout() throws Exception {
        Usuario anaGarcia = new Usuario("ana.garcia@gmail.com");
        anaGarcia.setId(1L);
        anaGarcia.setNombre("Ana");

        // Llamamos al método 'usuarioLogeado' con el Mock de la clase ManagerUserSession y marcamos lo que debe devolver
        when(managerUserSession.usuarioLogeado(session)).thenReturn(1L);

        // Llamamos al método 'findById' con el Mock de la clase UsuarioService y marcamos lo que debe devolver
        when(usuarioService.findById(anyLong())).thenReturn(anaGarcia);

        this.mockMvc.perform(get("/about")).andExpect(content().string(containsString("Ana")));
    }

    @Test
    public void menuNoLogueadoPaginaAbout() throws Exception {
        this.mockMvc.perform(get("/about")).andExpect(content().string(containsString("Cuenta")))
                .andExpect(content().string(not(containsString("Cerrar sesión"))));
    }

    @Test
    public void menuLogueadoPaginaTareas() throws Exception {
        Usuario ejemplo = new Usuario("user@ua");
        ejemplo.setId(1L);
        ejemplo.setNombre("Usuario Ejemplo");

        // Llamamos al método 'comprobarUsuarioLogeado' con el Mock de la clase ManagerUserSession y marcamos lo que debe devolver
        when(managerUserSession.comprobarUsuarioLogeado(session, ejemplo.getId())).thenReturn(true);

        // Llamamos al método 'findById' con el Mock de la clase UsuarioService y marcamos lo que debe devolver
        when(usuarioService.findById(anyLong())).thenReturn(ejemplo);

        this.mockMvc.perform(get("/usuarios/1/tareas"))
                .andExpect(content().string(containsString("Listado de tareas de Usuario Ejemplo")))
                .andExpect(content().string(containsString("Cerrar sesión Usuario Ejemplo")));
    }

    @Test
    public void menuLogueadoPaginaEditarTarea() throws Exception {
        Usuario ejemplo = new Usuario("user@ua");
        ejemplo.setId(1L);
        ejemplo.setNombre("Usuario Ejemplo");

        Tarea tarea = new Tarea(ejemplo, "Lavar coche");
        tarea.setId(1L);

        // Llamamos al método 'findById' con el Mock de la clase TareaService y marcamos lo que debe devolver
        when(tareaService.findById(anyLong())).thenReturn(tarea);

        // Llamamos al método 'comprobarUsuarioLogeado' con el Mock de la clase ManagerUserSession y marcamos lo que debe devolver
        when(managerUserSession.comprobarUsuarioLogeado(session, tarea.getUsuario().getId())).thenReturn(true);

        // Llamamos al método 'findById' con el Mock de la clase UsuarioService y marcamos lo que debe devolver
        when(usuarioService.findById(anyLong())).thenReturn(ejemplo);

        this.mockMvc.perform(get("/tareas/1/editar"))
                .andExpect(content().string(containsString("Modificación de la tarea 1")))
                .andExpect(content().string(containsString("Lavar coche")))
                .andExpect(content().string(containsString("Usuario Ejemplo")));
    }

    @Test
    public void menuLogueadoPaginaNuevaTarea() throws Exception {
        Usuario ejemplo = new Usuario("user@ua");
        ejemplo.setId(1L);
        ejemplo.setNombre("Usuario Ejemploo");

        // Llamamos al método 'comprobarUsuarioLogeado' con el Mock de la clase ManagerUserSession y marcamos lo que debe devolver
        when(managerUserSession.comprobarUsuarioLogeado(session, ejemplo.getId())).thenReturn(true);

        // Llamamos al método 'findById' con el Mock de la clase UsuarioService y marcamos lo que debe devolver
        when(usuarioService.findById(anyLong())).thenReturn(ejemplo);

        this.mockMvc.perform(get("/usuarios/1/tareas/nueva"))
                .andExpect(content().string(containsString("Nueva tarea para el usuario Usuario Ejemploo")))
                .andExpect(content().string(containsString("Cerrar sesión Usuario Ejemploo")));
    }

    @Test
    public void menuNoLogueadoPaginaListadoUsuarios() throws Exception {
        this.mockMvc.perform(get("/usuarios")).andExpect(content().string(containsString("Listado de usuarios")))
                .andExpect(content().string(not(containsString("Cerrar sesión"))));
    }

    @Test
    public void menuLogueadoPaginaListarUsuarios() throws Exception {
        Usuario ejemplo = new Usuario("user@ua");
        ejemplo.setId(1L);
        ejemplo.setNombre("Alberto");

        when(managerUserSession.usuarioLogeado(session)).thenReturn(1L);

        when(usuarioService.findById(anyLong())).thenReturn(ejemplo);

        this.mockMvc.perform(get("/usuarios"))
                .andExpect(content().string(containsString("Listado de usuarios")))
                .andExpect(content().string(containsString("Cerrar sesión Alberto")));
    }

    @Test
    public void menuNoLogeadoPaginaDescripcionUsuarios() throws Exception {
        Usuario usuarioAConsultar = new Usuario("usuarioAConsultar@ua.com");
        usuarioAConsultar.setId(1L);
        usuarioAConsultar.setNombre("Pepa");

        when(usuarioService.findById(anyLong())).thenReturn(usuarioAConsultar);
        when(managerUserSession.usuarioLogeado(any())).thenReturn(null);

        this.mockMvc.perform(get("/usuarios/1")).andExpect(content().string(containsString("Descripción de usuario")))
                .andExpect(content().string(containsString("usuarioAConsultar@ua.com")))
                .andExpect(content().string(containsString("Pepa")))
                .andExpect(content().string(not(containsString("Cerrar sesión"))));
    }

    @Test
    public void menuLogeadoPaginaDescripcionUsuarios() throws Exception {
        Usuario usuarioAConsultar = new Usuario("usuarioAConsultar@ua.com");
        usuarioAConsultar.setId(1L);
        usuarioAConsultar.setNombre("Pepa");

        Usuario usuarioLogeado = new Usuario("usuarioLogeado@ua.com");
        usuarioLogeado.setId(2L);
        usuarioLogeado.setNombre("Logeado");

        when(usuarioService.findById(anyLong())).thenReturn(usuarioAConsultar).thenReturn(usuarioLogeado);
        when(managerUserSession.usuarioLogeado(session)).thenReturn(2L);

        this.mockMvc.perform(get("/usuarios/1")).andExpect(content().string(containsString("Descripción de usuario")))
                .andExpect(content().string(containsString("usuarioAConsultar@ua.com")))
                .andExpect(content().string(containsString("Pepa")))
                .andExpect(content().string(containsString("Cerrar sesión Logeado")));
    }

    @Test
    public void menuPaginaListadoEquipos() throws Exception {
        Usuario ejemplo = new Usuario("alberto@ua");
        ejemplo.setId(1L);
        ejemplo.setNombre("Alberto");

        when(managerUserSession.usuarioLogeado(any())).thenReturn(1L);
        when(managerUserSession.comprobarUsuarioLogeado(any(), anyLong())).thenReturn(true);
        when(usuarioService.findById(anyLong())).thenReturn(ejemplo);

        this.mockMvc.perform(get("/equipos")).andExpect(content().string(containsString("Listado de equipos")))
                .andExpect(content().string(containsString("Equipos")))
                .andExpect(content().string(containsString("Cerrar sesión Alberto")));
    }

     */
}
