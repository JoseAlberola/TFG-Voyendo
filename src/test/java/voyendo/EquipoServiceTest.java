package voyendo;

import voyendo.model.Category;
import voyendo.service.CategoryService;
import voyendo.service.CompanyService;
import org.hibernate.LazyInitializationException;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

@SpringBootTest
public class EquipoServiceTest {

    @Autowired
    CompanyService usuarioService;

    @Autowired
    CategoryService equipoService;

    /*
    @Test
    @Transactional
    public void usuarioCreaEquipo(){
        Category equipo = equipoService.crearEquipo("nuevoEquipo");
        assertThat(equipoService.findAllOrderedByName().contains(equipo));
    }

    @Test
    public void obtenerListadoEquipos() {
        // GIVEN
        // En el application.properties se cargan los datos de prueba del fichero datos-test.sql

        // WHEN
        List<Category> equipos = equipoService.findAllOrderedByName();

        // THEN
        assertThat(equipos).hasSize(2);
        assertThat(equipos.get(0).getNombre()).isEqualTo("Proyecto A1");
        assertThat(equipos.get(1).getNombre()).isEqualTo("Proyecto P1");
    }

    @Test
    public void obtenerEquipo() {
        // GIVEN
        // En el application.properties se cargan los datos de prueba del fichero datos-test.sql

        // WHEN
        Category equipo = equipoService.findById(1L);

        // THEN
        assertThat(equipo.getNombre()).isEqualTo("Proyecto P1");
        // Comprobamos que la relación con Usuarios es lazy: al
        // intentar acceder a la colección de usuarios se debe lanzar una
        // excepción de tipo LazyInitializationException.
        assertThatThrownBy(() -> {
            equipo.getUsuarios().size();
        }).isInstanceOf(LazyInitializationException.class);
    }

    @Test
    public void comprobarRelacionUsuarioEquipos() {
        // GIVEN
        // En el application.properties se cargan los datos de prueba del fichero datos-test.sql

        // WHEN
        Usuario usuario = usuarioService.findById(1L);

        // THEN

        assertThat(usuario.getEquipos()).hasSize(1);
    }

    @Test
    public void obtenerUsuariosEquipo() {
        // GIVEN
        // En el application.properties se cargan los datos de prueba del fichero datos-test.sql

        // WHEN
        List<Usuario> usuarios = equipoService.usuariosEquipo(1L);

        // THEN
        assertThat(usuarios).hasSize(1);
        assertThat(usuarios.get(0).getEmail()).isEqualTo("user@ua");
        // Comprobamos que la relación entre usuarios y equipos es eager
        // Primero comprobamos que la colección de equipos tiene 1 elemento
        assertThat(usuarios.get(0).getEquipos()).hasSize(1);
        // Y después que el elemento es el equipo Proyecto P1
        assertThat(usuarios.get(0).getEquipos().stream().findFirst().get().getNombre()).isEqualTo("Proyecto P1");
    }

    @Test
    @Transactional
    public void addUsuarioEquipo() {
        // GIVEN
        // En el application.properties se cargan los datos de prueba del fichero datos-test.sql

        // WHEN

        equipoService.addUsuarioEquipo(1L, 2L);

        // THEN

        Usuario usuario = usuarioService.findById(1L);
        Category equipo = equipoService.findById(2L);
        List usuarios = equipoService.usuariosEquipo(2L);

        assertThat(usuario.getEquipos()).contains(equipo);
        assertThat(usuarios).hasSize(1);
        assertThat(usuarios).contains(usuario);
    }

    @Test
    @Transactional
    public void deleteUsuarioEquipo() {
        // GIVEN
        // En el application.properties se cargan los datos de prueba del fichero datos-test.sql

        // WHEN

        equipoService.deleteUsuarioEquipo(1L, 1L);

        // THEN

        Usuario usuario = usuarioService.findById(1L);
        Category equipo = equipoService.findById(1L);
        List usuarios = equipoService.usuariosEquipo(1L);

        assertThat(usuario.getEquipos()).doesNotContain(equipo);
        assertThat(usuarios).hasSize(0);
        assertThat(usuarios).doesNotContain(usuario);
    }

    @Test
    @Transactional
    public void modificarEquipo() {
        // GIVEN
        // En el application.properties se cargan los datos de prueba del fichero datos-test.sql
        Category equipo = equipoService.crearEquipo("Logística");
        Long idNuevoEquipo = equipo.getId();

        // WHEN
        Category equipoModificado = equipoService.modificaEquipo(idNuevoEquipo, "Logistics");
        Category equipoBD = equipoService.findById(idNuevoEquipo);

        // THEN
        assertThat(equipoModificado.getNombre()).isEqualTo("Logistics");
        assertThat(equipoBD.getNombre()).isEqualTo("Logistics");
    }

    @Test
    @Transactional
    public void borrarEquipo() {
        // GIVEN
        Category equipo = equipoService.crearEquipo("Logística");

        // WHEN
        equipoService.borraEquipo(equipo.getId());

        // THEN
        assertThat(equipoService.findById(equipo.getId())).isNull();
    }
    */
}
