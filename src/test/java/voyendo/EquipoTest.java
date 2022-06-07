package voyendo;

import voyendo.model.Category;
import voyendo.model.CategoryRepository;
import voyendo.model.CompanyRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
public class EquipoTest {

    @Autowired
    private CompanyRepository usuarioRepository;

    @Autowired
    private CategoryRepository equipoRepository;

    /*
    @Test
    public void crearEquipo() {
        Category equipo = new Category("Proyecto P1");
        assertThat(equipo.getNombre()).isEqualTo("Proyecto P1");
    }

    @Test
    @Transactional
    public void grabarEquipo() {
        // GIVEN
        Category equipo = new Category("Proyecto P1");

        // WHEN
        equipoRepository.save(equipo);

        // THEN
        assertThat(equipo.getId()).isNotNull();
    }

    @Test
    public void comprobarIgualdadEquipos() {
        // GIVEN
        // Creamos tres equipos sin id, sólo con el nombre
        Category equipo1 = new Category("Proyecto P1");
        Category equipo2 = new Category("Proyecto P2");
        Category equipo3 = new Category("Proyecto P2");

        // THEN
        // Comprobamos igualdad basada en el atributo nombre
        assertThat(equipo1).isNotEqualTo(equipo2);
        assertThat(equipo2).isEqualTo(equipo3);

        // WHEN
        // Añadimos identificadores y comprobamos igualdad por identificadores
        equipo1.setId(1L);
        equipo2.setId(1L);
        equipo3.setId(2L);

        // THEN
        // Comprobamos igualdad basada en el atributo nombre
        assertThat(equipo1).isEqualTo(equipo2);
        assertThat(equipo2).isNotEqualTo(equipo3);
    }

    @Test
    public void comprobarRecuperarEquipo() {
        // GIVEN
        // En el application.properties se cargan los datos de prueba del fichero datos-test.sql

        // WHEN

        Category equipo = equipoRepository.findById(1L).orElse(null);

        // THEN
        assertThat(equipo).isNotNull();
        assertThat(equipo.getId()).isEqualTo(1L);
        assertThat(equipo.getNombre()).isEqualTo("Proyecto P1");
    }

    @Test
    @Transactional
    public void comprobarRelacionBaseDatos() {
        // GIVEN
        // En el application.properties se cargan los datos de prueba del fichero datos-test.sql

        // WHEN
        Category equipo = equipoRepository.findById(1L).orElse(null);
        Usuario usuario = usuarioRepository.findById(1L).orElse(null);

        // THEN

        assertThat(equipo.getUsuarios()).hasSize(1);
        assertThat(equipo.getUsuarios()).contains(usuario);
        assertThat(usuario.getEquipos()).hasSize(1);
        assertThat(usuario.getEquipos()).contains(equipo);
    }

    @Test
    public void comprobarFindAll() {
        // GIVEN
        // En el application.properties se cargan los datos de prueba del fichero datos-test.sql

        // WHEN
        List<Category> equipos = equipoRepository.findAll();

        // THEN
        assertThat(equipos).hasSize(2);
    }

    @Test
    @Transactional
    public void actualizarRelacionUsuarioEquipos() {
        // GIVEN
        // En el application.properties se cargan los datos de prueba del fichero datos-test.sql

        Usuario usuario = usuarioRepository.findById(1L).orElse(null);
        Category equipo = equipoRepository.findById(2L).orElse(null);

        // WHEN

        equipo.addUsuario(usuario);

        // THEN

        assertThat(equipo.getUsuarios()).contains(usuario);
        assertThat(usuario.getEquipos()).contains(equipo);
    }

    @Test
    @Transactional
    public void actualizarRelacionUsuarioEquiposEliminandoUsuario() {
        // GIVEN
        // En el application.properties se cargan los datos de prueba del fichero datos-test.sql

        Usuario usuario = usuarioRepository.findById(1L).orElse(null);
        Category equipo = equipoRepository.findById(1L).orElse(null);

        // WHEN

        equipo.deleteUsuario(usuario);

        // THEN
        assertThat(equipo.getUsuarios()).hasSize(0);
        assertThat(equipo.getUsuarios()).doesNotContain(usuario);
        assertThat(usuario.getEquipos()).hasSize(0);
        assertThat(usuario.getEquipos()).doesNotContain(equipo);
    }
     */

}
