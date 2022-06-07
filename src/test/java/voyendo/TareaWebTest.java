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

import static org.hamcrest.Matchers.allOf;
import static org.hamcrest.Matchers.containsString;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
public class TareaWebTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private CompanyService usuarioService;

    @MockBean
    private AppointmentService tareaService;

    // Al mocker el manegerUserSession, no lanza la excepción cuando
    // se intenta comprobar si un usuario está logeado
    @MockBean
    private ManagerUserSession managerUserSession;

    /*
    @Test
    public void getNuevaTareaDevuelveForm() throws Exception {
        Usuario usuario = new Usuario("domingo@ua.es");
        usuario.setId(1L);

        when(usuarioService.findById(1L)).thenReturn(usuario);

        this.mockMvc.perform(get("/usuarios/1/tareas/nueva"))
                .andExpect(content().string(containsString("action=\"/usuarios/1/tareas/nueva\"")));
    }

    // En este test usamos los datos cargados en el fichero de prueba
    @Test
    public void postNuevaTareaDevuelveListaConTarea() throws Exception {
        Usuario usuario = new Usuario("domingo@ua.es");
        usuario.setId(1L);

        when(usuarioService.findById(1L)).thenReturn(usuario);

        this.mockMvc.perform(post("/usuarios/1/tareas/nueva")
                    .param("titulo", "Estudiar examen MADS"))
                    .andExpect(status().is3xxRedirection())
                    .andExpect(redirectedUrl("/usuarios/1/tareas"));
    }

    @Test
    public void getNuevaTareaDevuelveNotFoundCuandoNoExisteUsuario() throws Exception {

        when(usuarioService.findById(1L)).thenReturn(null);

        this.mockMvc.perform(get("/usuarios/1/tareas/nueva"))
                .andExpect(status().isNotFound());
    }

    @Test
    public void editarTareaDevuelveForm() throws Exception {
        Usuario usuario = new Usuario("domingo@ua.es");
        usuario.setId(1L);

        Tarea tarea = new Tarea(usuario, "Tarea de prueba");
        tarea.setId(1L);

        when(tareaService.findById(1L)).thenReturn(tarea);
        when(usuarioService.findById(1L)).thenReturn(usuario);

        this.mockMvc.perform(get("/tareas/1/editar"))
                .andExpect(content().string(allOf(
                    // Contiene la acción para enviar el post a la URL correcta
                    containsString("action=\"/tareas/1/editar\""),
                    // Contiene el texto de la tarea a editar
                    containsString("Tarea de prueba"),
                    // Contiene enlace a listar tareas del usuario si se cancela la edición
                    containsString("href=\"/usuarios/1/tareas\""))));
    }

    // Usamos el mock para verificar que se ha llamado al método de añadir una tarea
    @Test
    public void postNuevaTareaDevuelveRedirectYAñadeTarea() throws Exception {
        Usuario usuario = new Usuario("Usuario");
        usuario.setId(1L);

        when(usuarioService.findById(1L)).thenReturn(usuario);


        this.mockMvc.perform(post("/usuarios/1/tareas/nueva")
                .param("titulo", "Estudiar examen MADS"))
                .andExpect(status().is3xxRedirection())
                .andExpect(redirectedUrl("/usuarios/1/tareas"));

        // Verificamos que se ha llamado al método para
        // añadir una tarea con los parámetros correctos

        verify(tareaService).nuevaTareaUsuario(1L, "Estudiar examen MADS");
    }

     */
}
