/* Populate tables */
INSERT INTO usuarios (email, nombre, password, fecha_nacimiento, administrador, bloqueado)
    VALUES('user@ua', 'Usuario Ejemplo', '123', '2001-02-10', 'false', 'false');
INSERT INTO tareas (titulo, usuario_id) VALUES('Lavar coche', '1');
INSERT INTO tareas (titulo, usuario_id) VALUES('Renovar DNI', '1');
INSERT INTO equipos (nombre) VALUES('Proyecto P1');
INSERT INTO equipo_usuario (fk_equipo, fk_usuario) VALUES('1', '1');
INSERT INTO equipos (nombre) VALUES('Proyecto A1');