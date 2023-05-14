# Veterinaria Web App

---

La Veterinaria Web App es una aplicación web inspirada en una clínica veterinaria que permite realizar un control de clientes y sus mascotas. Esta aplicación está desarrollada utilizando Java 17 y el framework Spring MVC. Utiliza una base de datos MySQL para almacenar la información de los clientes y sus mascotas. También cuenta con un sistema de autenticación y autorización mediante Spring Security, con la contraseña encriptada. La aplicación diferencia dos roles: usuarios y administrador.

## Evidencia rúbrica
En el directorio `Veterinaria/Evidence.pdf` se encuentra un documento PDF demostrando las implementaciones solicitadas.

## Características

- Registro y autenticación de usuarios.
- Control de acceso y protección de rutas mediante Spring Security.
- Encriptación de contraseñas para mayor seguridad.
- Gestión de clientes y sus mascotas.
- Almacenamiento de datos en una base de datos MySQL mediante JDBC Template.

## Requisitos previos

Antes de ejecutar la aplicación, asegúrate de tener instalado lo siguiente:

- Java 17: Descargar e instalar Java 1.8
- MySQL: Descargar e instalar MySQL
- IDE Eclipse: Descargar e instalar Eclipse
- Maven: Descargar e instalar Maven
- Tomcat 9: Descargar e instalar Tomcat 9

## Configuración

Clona este repositorio: git clone https://github.com/jarodsmdev/Veterinaria.git
Navega hasta el directorio del proyecto: cd Veterinaria
Abre el archivo `src/main/resources/persistencia-mysql.properties` y configura las siguientes propiedades:

- jdbc.driver: Driver de conexión del gestor de la base de datos MySQL
- jdbc.url: URL de conexión a la base de datos MySQL.
- jdbc.user: Nombre de usuario de la base de datos MySQL.
- jdbc.password: Contraseña del usuario de la base de datos MySQL.

Ejecuta MysqlWorkbench y ejecuta el script SQL para la creación y poblado de datos que se encuentra en el siguiente directorio: `Veterinaria/DOCS/BBDD/VETERINARIA_PORTFOLIO.sql`.

Ejecuta el comando correspondiente para compilar e instalar la aplicación correspondiente al IDE.( Ej: maven -> update project )
La aplicación estará disponible en http://localhost:8080/Veterinaria.

## Uso

### Registro y autenticación

Accede a la página de inicio: http://localhost:8080/Veterinaria
El sistema redirigirá hacia la pantalla de login.
La base de datos ya se encuentra cargada con 2 usuarios con la contraseña totalmente encriptada:

| usuario   | contraseña| roles                 |
|-          |-          |-                      |
|   admin   | 123       | ADMINISTRADOR, USUARIO|
|   Leonel  | 123       | USUARIO               |


### Gestión de clientes

Una vez iniciada la sesión, podrás realizar las siguientes acciones:

- Ver la lista de clientes.
- Agregar un nuevo cliente.
- Editar los datos de un cliente existente.
- Eliminar un cliente.

### Roles de usuario

La aplicación diferencia dos roles de usuario:

- Usuario: Puede ver la lista de clientes, pero no puede crear nuevos usuarios.
- Administrador: Tiene acceso completo a todas las funcionalidades, incluyendo la adición, edición y eliminación de usuarios.

Usuarios deben contar mínimo con el ROL de USUARIO para acceder a la aplicación, de no tenerlo, el sistema redirigirá a una pantalla de error tipo 403 personalizada la cual informa que no tiene los permisos para acceder, de igual manera si intenta acceder a la ruta para crear usuarios será redirigido a esta misma página de error.

Sólos usuarios con el rol de ADMINISTRADOR puede crear nuevos usuarios ya que tiene habilitado el menú en el navbar para ello.

### Contribución

Si deseas contribuir a este proyecto, puedes seguir los pasos a continuación:

Crea un fork de este repositorio.
Clona tu fork en tu máquina local: git clone https://github.com/jarodsmdev/Veterinaria.git
Crea una nueva rama para tu contribución: git checkout -b mi-contribucion
Realiza los cambios y mejoras deseados.

Verifica que los cambios funcionen correctamente y que no rompan ninguna funcionalidad existente.
Realiza commit de tus cambios: git commit -m "Agregar mi contribución"
Sube tus cambios a tu repositorio remoto: git push origin mi-contribucion
Crea un pull request en este repositorio original, describiendo tus cambios y mejoras.
Espera a que tus cambios sean revisados y fusionados al proyecto principal.

### Agradecimientos

Agradezco a todos los miembros del Bootcamp Java Trainee por su contribución en el desarrollo de esta aplicación web. También agradezco a la comunidad de desarrolladores y a los recursos en línea que me han ayudado en el proceso.

### Contacto

Si tienes alguna pregunta, sugerencia o problema relacionado con la aplicación, no dudes en ponerte en contacto conmigo. Puedes enviarme un correo electrónico a lbriones.dev@gmail.com.

¡Gracias por utilizar la Veterinaria Web App! Espero que esta aplicación sea útil y satisfaga tus necesidades de gestión de clientes y mascotas en una clínica veterinaria. Siempre estoy trabajando en mejorar y agregar nuevas funcionalidades, por lo que tus comentarios y sugerencias son bienvenidos.
