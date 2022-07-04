package voyendo;

import voyendo.service.CompanyService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
public class UsuarioServiceTest {

    Logger logger = LoggerFactory.getLogger(UsuarioServiceTest.class);

    @Autowired
    private CompanyService usuarioService;

    /*
    @Test
    public void servicioLoginUsuario() {
        // GIVEN
        // Datos cargados de datos-test.sql

        // WHEN

        CompanyService.LoginStatus loginStatusOK = usuarioService.login("user@ua", "123");
        CompanyService.LoginStatus loginStatusErrorPassword = usuarioService.login("user@ua", "000");
        CompanyService.LoginStatus loginStatusNoUsuario = usuarioService.login("pepito.perez@gmail.com", "12345678");

        // THEN

        assertThat(loginStatusOK).isEqualTo(CompanyService.LoginStatus.LOGIN_OK);
        assertThat(loginStatusErrorPassword).isEqualTo(CompanyService.LoginStatus.ERROR_PASSWORD);
        assertThat(loginStatusNoUsuario).isEqualTo(CompanyService.LoginStatus.USER_NOT_FOUND);
    }

    @Test
    @Transactional
    public void servicioRegistroUsuario() {
        // GIVEN

        Usuario usuario = new Usuario("usuario.prueba2@gmail.com");
        usuario.setPassword("12345678");

        // WHEN

        usuarioService.registrar(usuario);

        // THEN

        Usuario usuarioBaseDatos = usuarioService.findByEmail("usuario.prueba2@gmail.com");
        assertThat(usuarioBaseDatos).isNotNull();
        assertThat(usuarioBaseDatos.getPassword()).isEqualTo(usuario.getPassword());
    }

    @Test
    public void servicioRegistroUsuarioExcepcionConNullPassword() {
        // Pasamos como argumento un usario sin contraseña
        Usuario usuario =  new Usuario("usuario.prueba@gmail.com");

        // Se produce una excempción de tipo UsuarioServiceException
        Assertions.assertThrows(UsuarioServiceException.class, () -> {
            usuarioService.registrar(usuario);
        });
    }


    @Test
    public void servicioRegistroUsuarioExcepcionConEmailRepetido() {
        // GIVEN
        // Datos cargados de datos-test.sql

        // WHEN - THEN
        // Pasamos como argumento un usario con emaii existente en datos-test.sql
        Usuario usuario =  new Usuario("user@ua");
        usuario.setPassword("12345678");


        // Se produce una excempción de tipo UsuarioServiceException
        Assertions.assertThrows(UsuarioServiceException.class, () -> {
            usuarioService.registrar(usuario);
        });
    }

    @Test
    @Transactional
    public void servicioRegistroUsuarioDevuelveUsuarioConId() {
        // GIVEN

        Usuario usuario = new Usuario("usuario.prueba@gmail.com");
        usuario.setPassword("12345678");

        // WHEN

        usuario = usuarioService.registrar(usuario);

        // THEN

        assertThat(usuario.getId()).isNotNull();
    }

    @Test
    public void servicioConsultaUsuarioDevuelveUsuario() {
        // GIVEN
        // Datos cargados de datos-test.sql

        // WHEN

        Usuario usuario = usuarioService.findByEmail("user@ua");

        // THEN

        assertThat(usuario.getId()).isEqualTo(1L);
    }

    @Test
    public void servicioConsultaAdministrador() {
        boolean resultado = usuarioService.hayAdministrador();
        assertThat(resultado).isFalse();
    }

    @Test
    @Transactional
    public void servicioConsultaAdministrador2() {
        Usuario usuario = new Usuario("usuario.prueba2@gmail.com");
        usuario.setPassword("12345678");
        usuario.setAdministrador(true);

        Usuario usuario2 = new Usuario("usuario.prueba4@gmail.com");
        usuario2.setPassword("12345678");
        usuario2.setAdministrador(false);

        usuarioService.registrar(usuario);
        usuarioService.registrar(usuario2);

        boolean resultado = usuarioService.hayAdministrador();
        assertThat(resultado).isTrue();
    }

    @Test
    @Transactional
    public void servicioBuscarAdministrador() {
        Usuario usuario = new Usuario("jose@gmail.com");
        usuario.setPassword("12345678");
        usuario.setAdministrador(true);

        Usuario usuario2 = new Usuario("usuario.prueba4@gmail.com");
        usuario2.setPassword("12345678");
        usuario2.setAdministrador(false);

        usuarioService.registrar(usuario);
        usuarioService.registrar(usuario2);

        assertThat(usuario.equals(usuarioService.findByAdministradorTrue())).isTrue();
    }

    @Test
    public void servicioBuscarAdministrador2() {
        assertThat(usuarioService.findByAdministradorTrue()).isNull();
    }

    @Test
    @Transactional
    public void servicioBloquearUsuario() {
        assertThat(usuarioService.bloquearUsuario(1L, true).isBloqueado()).isTrue();
    }

    @Test
    @Transactional
    public void servicioBloquearUsuario2() {
        assertThat(usuarioService.bloquearUsuario(1L, false).isBloqueado()).isFalse();
    }

     */
}