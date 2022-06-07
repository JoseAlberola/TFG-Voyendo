# Proyecto TFG
## VoYendo

Aplicación para la reserva de citas en negocios. Los negocios contarán con una parte de análisis 
de sus estadísticas con el objetivo de mejorar sus números y los clientes podrán consultar el 
calendario de su negocio favorito y hacer una reserva.

En este proyecto usaremos Java junto al framework de Spring Boot en la parte del backend y 
en la parte de frontend una combinación de Bootstrap y plantillas Thymeleaf.

## Requisitos

Necesitas tener instalado en tu sistema:

- Java 8

## Ejecución

Puedes ejecutar la aplicación usando el _goal_ `run` del _plugin_ Maven 
de Spring Boot:

```
$ ./mvnw spring-boot:run 
```   

También puedes generar un `jar` y ejecutarlo:

```
$ ./mvnw package
$ java -jar target/voyendo-1.2.0.jar 
```

Una vez lanzada la aplicación puedes abrir un navegador y probar la página de inicio:

- [http://localhost:8080/login](http://localhost:8080/login)