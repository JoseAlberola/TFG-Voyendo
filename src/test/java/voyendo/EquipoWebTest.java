package voyendo;

import voyendo.authentication.ManagerUserSession;
import voyendo.authentication.UsuarioNoLogeadoException;
import voyendo.model.Category;
import voyendo.service.CategoryService;
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
import java.util.HashSet;
import java.util.Set;

import static org.hamcrest.Matchers.allOf;
import static org.hamcrest.Matchers.containsString;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.mockito.ArgumentMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
public class EquipoWebTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private CategoryService equipoService;

    @MockBean
    private CompanyService usuarioService;

    @MockBean
    ManagerUserSession managerUserSession;

    @MockBean
    MockHttpSession session;

    /*
    @Test
    public void paginaListadoEquiposTieneBotonCrearEquipo() throws Exception {
        Usuario usuario = new Usuario("josema@ua.es");
        usuario.setId(1L);

        Category equipo1 = new Category("E1");
        equipo1.setId(1L);
        Category equipo2 = new Category("E2");
        equipo2.setId(2L);
        Category equipo3 = new Category("E3");
        equipo3.setId(3L);

        ArrayList<Category> arrayListEquipos = new ArrayList<Category>(Arrays.asList(equipo1, equipo2, equipo3));

        when(usuarioService.findById(anyLong())).thenReturn(usuario);
        when(equipoService.findAllOrderedByName()).thenReturn(arrayListEquipos);

        this.mockMvc.perform(get("/equipos")).andExpect(content().string(containsString("Listado de equipos")))
                .andExpect(content().string(containsString("Crear equipo")))
                .andExpect(content().string(containsString("href=\"/equipos/nuevo\"")))
                .andExpect(content().string(containsString("E1")))
                .andExpect(content().string(containsString("E2")))
                .andExpect(content().string(containsString("E3")));
    }

    @Test
    public void paginaListadoEquiposTieneBotonUnirseEquipos() throws Exception {
        Category equipo1 = new Category("E1");
        equipo1.setId(1L);
        Category equipo2 = new Category("E2");
        equipo2.setId(2L);
        Category equipo3 = new Category("E3");
        equipo3.setId(3L);

        Usuario usuario = new Usuario("josema@ua.es");
        usuario.setId(1L);

        usuario.getEquipos().add(equipo1);
        equipo1.getUsuarios().add(usuario);

        ArrayList<Category> arrayListEquipos = new ArrayList<Category>(Arrays.asList(equipo1, equipo2, equipo3));

        when(usuarioService.findById(anyLong())).thenReturn(usuario);
        when(equipoService.findAllOrderedByName()).thenReturn(arrayListEquipos);

        this.mockMvc.perform(get("/equipos")).andExpect(content().string(containsString("Listado de equipos")))
                .andExpect(content().string(containsString("Unirme")))
                .andExpect(content().string(containsString("Abandonar")))
                .andExpect(content().string(containsString("E1")))
                .andExpect(content().string(containsString("E2")))
                .andExpect(content().string(containsString("E3")));
    }

    @Test
    public void paginaListadoEquiposVistaSiendoAdministrador() throws Exception {
        Category equipo1 = new Category("E1");
        equipo1.setId(1L);
        Category equipo2 = new Category("E2");
        equipo2.setId(2L);

        Usuario usuario = new Usuario("administrador@ua.es");
        usuario.setId(1L);
        usuario.setAdministrador(true);

        usuario.getEquipos().add(equipo1);
        equipo1.getUsuarios().add(usuario);

        ArrayList<Category> arrayListEquipos = new ArrayList<Category>(Arrays.asList(equipo1, equipo2));

        when(usuarioService.findById(anyLong())).thenReturn(usuario);
        when(equipoService.findAllOrderedByName()).thenReturn(arrayListEquipos);

        this.mockMvc.perform(get("/equipos")).andExpect(content().string(containsString("Listado de equipos")))
                .andExpect(content().string(containsString("Unirme")))
                .andExpect(content().string(containsString("Abandonar")))
                .andExpect(content().string(containsString("E1")))
                .andExpect(content().string(containsString("E2")))
                .andExpect(content().string(containsString("editar")))
                .andExpect(content().string(containsString("borrar")));
    }

    @Test
    public void paginaListadoEquiposSinEstarLogueado() throws Exception {
        when(managerUserSession.comprobarUsuarioLogeado(any(), any())).thenThrow(UsuarioNoLogeadoException.class);
        this.mockMvc.perform(get("/equipos")).andExpect(status().isUnauthorized());
    }

    @Test
    public void paginaDetallesEquipo() throws Exception {
        Usuario usuario1 = new Usuario("alberto@ua");
        usuario1.setId(1L);
        usuario1.setNombre("Alberto");

        Usuario usuario2 = new Usuario("uno@ua");
        usuario2.setId(2L);
        usuario2.setNombre("Uno");

        Category equipo1 = new Category("E1");
        equipo1.setId(1L);
        Set<Usuario> usuarios = new HashSet<>();
        usuarios.add(usuario1);
        usuarios.add(usuario2);
        equipo1.setUsuarios(usuarios);

        when(usuarioService.findById(anyLong())).thenReturn(usuario1);
        when(equipoService.findById(anyLong())).thenReturn(equipo1);

        this.mockMvc.perform(get("/equipos/1")).andExpect(content().string(containsString("Detalles del equipo E1")))
                .andExpect(content().string(containsString("alberto@ua")))
                .andExpect(content().string(containsString("Alberto")))
                .andExpect(content().string(containsString("uno@ua")))
                .andExpect(content().string(containsString("Uno")));
    }

    @Test
    public void paginaDetallesEquipoSinEstarLogueado() throws Exception {
        when(managerUserSession.comprobarUsuarioLogeado(any(), any())).thenThrow(UsuarioNoLogeadoException.class);
        this.mockMvc.perform(get("/equipos/1")).andExpect(status().isUnauthorized());
    }

    @Test
    public void obtenerPaginaFormularioCrearEquipo() throws Exception {
        Usuario usuario = new Usuario("domingo@ua.es");
        usuario.setId(1L);

        when(usuarioService.findById(anyLong())).thenReturn(usuario);

        this.mockMvc.perform(get("/equipos/nuevo")).andExpect(content().string(containsString("Nuevo equipo")))
                .andExpect(content().string(containsString("Nombre del equipo")))
                .andExpect(content().string(containsString("Crear equipo")))
                .andExpect(content().string(containsString("Cancelar")));
    }

    @Test
    public void postNuevoEquipoDevuelveListaDeEquipos() throws Exception {
        Usuario usuario = new Usuario("josema@ua.es");
        usuario.setId(1L);

        when(usuarioService.findById(anyLong())).thenReturn(usuario);

        this.mockMvc.perform(post("/equipos/nuevo")
                        .param("nombre", "El mejor equipo"))
                .andExpect(status().is3xxRedirection())
                .andExpect(redirectedUrl("/equipos"));
    }

    @Test
    public void unirseAEquipo() throws Exception {
        Category equipo1 = new Category("E1");
        equipo1.setId(1L);

        Usuario usuario = new Usuario("josema@ua.es");
        usuario.setId(1L);

        when(managerUserSession.usuarioLogeado(any())).thenReturn(1L);
        when(usuarioService.findById(anyLong())).thenReturn(usuario);
        when(equipoService.findById(1L)).thenReturn(equipo1);

        this.mockMvc.perform(get("/equipos/1/unirme"))
                .andExpect(status().is3xxRedirection())
                .andExpect(redirectedUrl("/equipos"));

        // Verificamos que se ha llamado a los métodos para
        // añadir al usuario con los parámetros correctos
        verify(equipoService).findById( 1L);
        verify(equipoService).addUsuarioEquipo(1L, 1L);
    }

    @Test
    public void borrarEquipo() throws Exception {
        Category equipo1 = new Category("E1");
        equipo1.setId(1L);

        Usuario usuario = new Usuario("josema@ua.es");
        usuario.setId(1L);
        usuario.setAdministrador(true);

        when(managerUserSession.usuarioLogeado(any())).thenReturn(1L);
        when(managerUserSession.comprobarUsuarioAdministradorLogeado(any())).thenReturn(true);
        when(usuarioService.findById(anyLong())).thenReturn(usuario);
        when(equipoService.findById(1L)).thenReturn(equipo1);

        this.mockMvc.perform(delete("/equipos/1")).andExpect(status().isOk());

        // Verificamos que se ha llamado a los métodos para
        // eliminar el equipo con los parámetros correctos
        verify(equipoService).findById( 1L);
        verify(equipoService).borraEquipo(1L);
    }

    @Test
    public void editarEquipoDevuelveForm() throws Exception {
        Usuario usuario = new Usuario("emilio@ua.es");
        usuario.setId(1L);
        usuario.setAdministrador(true);

        Category equipo = new Category("Mejor equipo");
        equipo.setId(1L);

        when(equipoService.findById(1L)).thenReturn(equipo);
        when(usuarioService.findById(anyLong())).thenReturn(usuario);

        this.mockMvc.perform(get("/equipos/1/editar"))
                .andExpect(content().string(allOf(
                        // Contiene la acción para enviar el post a la URL correcta
                        containsString("action=\"/equipos/1/editar\""),
                        // Contiene el texto del equipo a editar
                        containsString("Mejor equipo"),
                        // Contiene enlace a listar equipos si se cancela la edición
                        containsString("href=\"/equipos\""))));
    }

    @Test
    public void postModificarEquipoDevuelveListaDeEquipos() throws Exception {
        Usuario usuario = new Usuario("josema@ua.es");
        usuario.setId(1L);

        Category equipo = new Category("Equipo");
        equipo.setId(1L);

        when(equipoService.findById(1L)).thenReturn(equipo);
        when(usuarioService.findById(anyLong())).thenReturn(usuario);

        this.mockMvc.perform(post("/equipos/1/editar")
                        .param("nombre", "El mejor equipo"))
                .andExpect(status().is3xxRedirection())
                .andExpect(redirectedUrl("/equipos"));

        // Verificamos que se ha llamado a los métodos para
        // eliminar el equipo con los parámetros correctos
        verify(equipoService).findById( 1L);
        verify(equipoService).modificaEquipo(1L, "El mejor equipo");
    }

     */
}
