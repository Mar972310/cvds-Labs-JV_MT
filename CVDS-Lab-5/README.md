# LABORATORIO 5 - SPRING MVC INTRODUCTION

## Autores 

**Maria Valentina Torres**\
**Jose Ricardo Vasquez Vega**

#### INTRODUCCIÓN A PROYECTOS WEB

### PARTE I. - JUGANDO A SER UN CLIENTE HTTP
1. Abra una terminal Linux o consola de comandos Windows.
2. Realice una conexión síncrona TCP/IP a través de Telnet al siguiente servidor:
- Host: www.escuelaing.edu.co
- Puerto: 80
Teniendo en cuenta los parámetros del comando telnet:

```sh
$ telnet HOST PORT
```

3. Antes de que el servidor cierre la conexión por falta de comunicación:

Revise el RFC del protocolo HTTP, sobre cómo realizar una petición GET.
Debe lucir más o menos de esta forma:

```
GET /with-a-resource.html HTTP/1.0
Host: www.escuelaing.edu.co
```

Con esto, solicite al servidor el recurso `sssss/abc.html`, usando la versión 1.0 de HTTP.
Copie las dos lineas de codigo con el recurso agregado y peguelas en la consola del servidor ya abierta.
Asegúrese de presionar ENTER dos veces después de ingresar el comando.

```
GET /sssss/abc.html HTTP/1.0
Host: www.escuelaing.edu.co
```

Revise el resultado obtenido.

- ¿Qué codigo de error sale?, revise el significado del mismo en la lista de códigos de estado HTTP.
- ¿Qué otros códigos de error existen?, ¿En qué caso se manejarán?
- Responder en el README.md según lo indicado en la última sección de este laboratorio (ENTREGA).

4. Realice una nueva conexión con telnet, esta vez a:
```yml
Host: www.httpbin.org
Puerto: 80
Versión HTTP: 1.1
```

Ahora, solicite (GET) el recurso /html. ¿Qué se obtiene como resultado?

¡Muy bien!, ¡Acaba de usar del protocolo HTTP sin un navegador Web!. Cada vez que se usa un navegador, éste se conecta a un servidor HTTP, envía peticiones
del protocolo HTTP, espera el resultado de las mismas, y si se trata de contenido HTML lo interpreta y dibuja.

5. Seleccione el contenido HTML de la respuesta y copielo al cortapapeles `CTRL-SHIFT-C`. Ejecute el comando wc (word count) para contar palabras con la
opción -c para contar el número de caracteres:
```sh
$ wc -c
```

Pegue el contenido del portapapeles con `CTRL-SHIFT-V` y presione `CTRL-D` (fin de archivo de Linux). Si no termina el comando `wc` presione `CTRL-D`
de nuevo. No presione mas de dos veces CTRL-D indica que se termino la entrada y puede cerrarle la terminal. Debe salir el resultado de la cantidad de
caracteres que tiene el contenido HTML que respondió el servidor.

Claro está, las peticiones GET son insuficientes en muchos casos. Investigue: ¿Cuál esla diferencia entre los verbos GET y POST? ¿Qué otros tipos de
peticiones existen?
7. En la practica no se utiliza telnet para hacer peticiones a sitios web sino el comando curl con ayuda de la linea de comandos: 
```sh
$ curl "www.httpbin.org"
```
Utilice ahora el parámetro -v y con el parámetro -i:

```sh
$ curl -v www.httpbin.org
$ curl -i www.httpbin.org
```
¿Cuáles son las diferencias con los diferentes parámetros?

### PARTE II. - HACIENDO UNA APLICACIÓN WEB DINÁMICA USANDO EL PATRÓN MVC
En este ejercicio, va a implementar una aplicación Web muy básica, haciendo uso de spring MVC.

Para esto usaremos la documentación oficial de Spring con que que aprenderemos las funciones básicas de este framework https://spring.io/guides/gs/serving-web-content/

![img.png](img%2Fimg.png)
![img_2.png](img%2Fimg_2.png)

Después de terminar el aprendizaje analice:
- ¿Por qué MVC obtiene ese nombre? (puede apoyarse de https://www.javatpoint.com/spring-mvc-tutorial) 

MVC (Modelo-Vista-Controlador) es un patrón de diseño arquitectónico que se utiliza comúnmente en el desarrollo de aplicaciones web. Obtiene su nombre de los tres componentes principales que lo componen:

**Modelo (Model)**: Representa los datos y la lógica de negocio de la aplicación. El modelo maneja la manipulación y el procesamiento de los datos, y generalmente no tiene conocimiento de la interfaz de usuario.

**Vista (View)**: Es responsable de la presentación de los datos al usuario final. La vista muestra la información al usuario y proporciona la interfaz de usuario con la que el usuario interactúa. Normalmente, la vista se encarga de la estructura y el diseño de la interfaz de usuario.

**Controlador (Controller)**: Actúa como intermediario entre el modelo y la vista. Recibe las solicitudes del usuario, procesa los datos utilizando el modelo correspondiente y devuelve la respuesta adecuada a la vista. El controlador maneja la lógica de navegación y la interacción entre el modelo y la vista

- ¿Cuáles son las ventajas de usar MVC?

**Separación de responsabilidades**: MVC divide la aplicación en componentes distintos, lo que facilita la gestión y el mantenimiento del código.

**Reutilización de código**: Al separar la lógica de negocio (modelo) de la interfaz de usuario (vista), es más fácil reutilizar y modificar cada componente de forma independiente.

**Escalabilidad**: MVC permite escalar la aplicación de forma modular, ya que cada componente puede ser escalado por separado según sea necesario.

**Facilidad para realizar pruebas unitarias**: Debido a la separación de responsabilidades, es más fácil realizar pruebas unitarias en cada componente de la aplicación.

- ¿Qué diferencia tiene la estructura de directorios de este proyecto comparado con las de proyectos pasados (con solo maven y java EE)?
 
En un proyecto Maven estándar, la estructura del directorio suele ser src/main/java para las fuentes. Sin embargo, en un proyecto MVC, la estructura del directorio puede variar dependiendo del framework específico que se esté utilizando. Por ejemplo, en un proyecto Spring MVC, podrías tener una estructura de directorios que incluya directorios separados para modelos, vistas y controladores.

En un proyecto Spring Boot, la estructura de directorios típicamente incluye:

src/main/java: Contiene el código fuente de la aplicación Java.
src/main/resources: Contiene recursos estáticos como archivos de configuración, plantillas, etc.
src/test/java: Contiene los archivos de prueba unitaria de la aplicación Java.
src/test/resources: Contiene los recursos de prueba.

- ¿Qué anotaciones usaste y cuál es la diferencia entre ellas?

  En Spring MVC, algunas anotaciones comunes incluyen:

@Controller: Esta anotación registra el controlador para Spring MVC.
@RequestMapping: Esta anotación se encarga de relacionar un método con una petición HTTP. Además, existen otras anotaciones como @Component, @Repository y @Service que son especializaciones de @Component, añadiendo un valor semántico que indica la utilidad de la clase anotada (@Repository para acceso a BD y @Service para la capa de negocio). Estas anotaciones pueden ser utilizadas en lugar de @Controller dependiendo del propósito específico del bean en tu aplicación.

### PARTE III. - APLICACIÓN MVC PARA CONSUMO DE SERVICIO RESTful
Usando la arquitectura MVC del punto anterior (el proyecto anterior), realice una aplicación simple qué permita navegar gráficamente sobre esta API
https://jsonplaceholder.typicode.com/todos/1, puede guiarse de tutoriales como https://medium.com/@nutanbhogendrasharma/consume-rest-api-in-spring-boot-web-application-354c404850f0

![img_1.png](img%2Fimg_1.png)

![img_4.png](img%2Fimg_4.png)

Luego de terminada esta parte responda:
- ¿Qué es RESTful?

RESTful es una forma de diseñar aplicaciones web de manera organizada y fácil de entender. Se basa en tratar las partes de una aplicación como si fueran objetos o cosas a las que se puede acceder a través de la web. En lugar de usar acciones complicadas, se utilizan direcciones web (URLs) para acceder y manipular estos objetos.

- Si utilizo un framework como [Boostrap CSS](https://getbootstrap.com/) para qué el apartado gráfico se vea más profesional, ¿en qué capa se haría su uso?
  
Bootstrap CSS es un framework de frontend que proporciona estilos predefinidos y componentes de interfaz de usuario para ayudar a diseñar y desarrollar interfaces web de manera rápida y consistente. En el contexto de una aplicación web, el uso de Bootstrap se realizaría principalmente en la capa de vista.

### PARTE IV. - APLICACIÓN MVC JUEGO
¡Llego la hora del reto! Teniendo las bases del uso del framework, cree una nueva ruta, por ejemplo `/guess`, y agrege formulario básico con un campo llamado "número" (guía de como crear formularios HTML https://www.w3schools.com/html/)

Y vamos a implementar la lógica de nuestro juego:
1. Se trata de un juego en línea para adivinar un número, en el que el ganador, si acierta en la primera oportunidad, recibe $100.000. Luego, por cada intento fallido, el premio
se reduce en $10.000, como en los juegos de apuesta, es natural qué quede en saldos negativos.
![img_5.png](img%2Fimg_5.png)
3. El número a adivinar debe ser generado en cada intento y comparado con el número qué el usuario está insertando, es un número de 1 a 10.
3. Debe existir un botón de reset, qué permita al jugador iniciar de nuevo.
4. La capa de controlador debe procer el número del usuario mediante método `POST`.
![img_6.png](img%2Fimg_6.png)
![img_7.png](img%2Fimg_7.png)
![img_8.png](img%2Fimg_8.png)

Analice las siguientes situaciones:
- ¿Qué pasa si abro el sitio de juegos en dos navegadores difententes?

 ![img_9.png](img%2Fimg_9.png)

Si se abren dos navegadores y se hace la consulta de la paguina, se encuentra que se corre el mismos servicio, por lo tanto, se maneja la misma instancia.

- Si quisiera qué a cada jugador le aparecieran independientemente sus respectivos saldos. ¿Qué habría que hacer?

Para lograr que cada jugador tenga su propio saldo independiente, necesitarías asociar el saldo con la sesión de cada jugador. De esta manera, cada vez que un jugador inicie sesión en tu aplicación, se le asignará un saldo único que estará asociado solo a esa sesión.

## ENTREGA
- En un README.md colocar lo siguiente:
- Una sección llamada “INTEGRANTES” y allícolocar el listado de los integrantes del taller (máximo 2).
- Una sección llamada “RESPUESTAS” colocar lasrespuestas a las preguntas:
- Configurar el archivo .gitignore para excluir del repositorio los archivos no relevantes.
- En una carpeta en la raiz del repositorio llamada diagrams y allí realizar un diagrama de clases del proyecto.

![img_11.png](img%2Fimg_11.png)