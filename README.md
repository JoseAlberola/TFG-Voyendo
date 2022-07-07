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

### 1. Usando el _goal_ `run` del _plugin_ Maven de Spring Boot
Con el perfil por defecto. Ejcutará una base de datos de memoria

```
$ ./mvnw spring-boot:run 
```   

Con el perfil `sql` ejecutará la base de datos persistente de MySQL (previamente debemos crear una base de datos con nombre `voyendo` el resto se creará automáticamente
```
$ ./mvnw spring-boot:run -D profiles=sql 
```   

### 2. Usando IntelliJ
IntelliJ IDEA detectará las 2 configuraciones de la aplicación. Una para ejecutar con la base de datos de memoria H2 y otra para la base de datos persistente de MySQL. 
```
Con la configuración por defecto `Application` ejecutaremos H2.
```
```
Con la configuración sql `Application sql` ejecutaremos MySQL. No olvidar crear antes el esquema `voyendo`
```

### Aspecto a tener en cuenta
La aplicación hace uso de las APIs de Google para geolocalizar direcciones: `Places API, Maps JavaScript API` y calcular distancias: `Distance Matrix API`. Estas APIs necesitan una clave, por lo que hemos generado una pública con una serie de restricciones de seguridad para que la aplicación pueda trabajar con direcciones sin modificar nada. Sin embargo, la API `Distance Matrix API` cuenta con otra clave que no es posible restringir y causaría graves problemas de seguridad. Debido a esto no hemos publicado esa clave. En caso de querer utilizar la aplicación al completo con todas las funciones de cálculo de distancias habrá que seguir los siguientes pasos:
1. Entrar a la plataforma de Google Cloud
2. Debéis crear un nuevo proyecto
3. Desde este proyecto acceder a `Biblioteca` y buscar la API `Distance Matrix API`
4. Clicar sobre habilitar
5. Ir a `API y servcicios` luego a `Credenciales`
6. Crear credenciales y clicar sobre la clave
7. Permitir acceso a la API `Distance Matrix API`
8. Copiamos la clave
9. Creamos la siguiente clase Java dentro del proyecto en la ruta `src/main/java/voyendo/service/ApiKeyMatrix.java` e introducimos la clave copiada
```java
package voyendo.service;

public class ApiKeyMatrix {
    private static String key = "";

    public ApiKeyMatrix(){}

    public static String getKey() {
        return key;
    }
}

```
## Abrir la aplicación
Una vez lanzada la aplicación puedes abrir un navegador y probar la página de inicio:

- [http://localhost:8080/login](http://localhost:8080/login)
