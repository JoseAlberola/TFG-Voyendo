# Proyecto TFG
## VoYendo

Voyendo es una aplicación para la reserva de citas online con especial énfasis en las empresas. Los negocios contarán con una parte de análisis 
de sus estadísticas con el objetivo de mejorar sus números y los clientes podrán consultar el calendario de su negocio favorito y hacer una reserva.

En este proyecto usaremos Java junto al framework de Spring Boot en la parte del backend y en la parte de frontend una combinación de Bootstrap y plantillas Thymeleaf. Para el acceso a la base de datos utilizaremos la tecnología de Spring Data JPA, creando repositorios que serán los que accedan a ella.

## Requisitos

Necesitas tener instalado en tu sistema:

- Java 8
- MySQL `en caso de querer ejecutar el sistema con una base de datos persistente`

## Ejecución

Puedes ejecutar la aplicación principalmente de 2 maneras

### Usando el _goal_ `run` del _plugin_ Maven de Spring Boot
Con el perfil por defecto. Ejcutará una base de datos de memoria

```
$ ./mvnw spring-boot:run 
```   

Con el perfil `sql` ejecutará la base de datos persistente de MySQL (previamente debemos crear una base de datos con nombre `voyendo` el resto se creará automáticamente
```
$ ./mvnw spring-boot:run -D profiles=sql 
```   

### Usando IntelliJ
IntelliJ IDEA detectará las 2 configuraciones de la aplicación. Una para ejecutar con la base de datos de memoria H2 y otra para la base de datos persistente de MySQL. 
```
Con la configuración por defecto `Application` ejecutaremos H2.
```
```
Con la configuración sql `Application sql` ejecutaremos MySQL. No olvidar crear antes el esquema `voyendo`
```

## Abrir la aplicación
Una vez lanzada la aplicación puedes abrir un navegador y probar la página de inicio:

- [http://localhost:8080/login](http://localhost:8080/login)
