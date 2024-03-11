<div align="center">
  <img src="https://github.com/Isaac640/IncidenciasDI/blob/Imagenes/imagenes/IRIS%20sin%20fondo%20y%20nombre%20banner.png?raw=true" alt="Banner cabecera">
</div>

# IRIS

El proyecto I.R.I.S (Incidencias Resueltas de forma Inteligente y Segura) es una solución completa para la gestión de incidencias en el entorno educativo del Instituto Miguel Herrero de Pereda. Consta de dos componentes principales de código abierto, una aplicación móvil desarrollada en Kotlin destinada al profesorado como usuarios y una aplicación de escritorio desarrollada en Windows Form.NET, que cumple las funcionalidades de la aplicación móvil pero desde el escritorio, además de contar con un apartado para administradores que permite gestionar dichas incidencias y modificar sus estados según cómo vayan resolviéndose.

Si quiere saber más sobre el proyecto IRIS visite nuestro [repositorio principal](https://github.com/Isaac640/IncidenciasDI)

## Índice

* [Descripción](#descripción)
* [Uso](#uso)
    * [Endpoint base](#endpoint-base)
    * [Endpoints](#endpoints)
* [Swagger](#swagger)
* [Miembros](#miembros)
* [Contribución](#contribución)
* [Contacto](#contacto)
* [Licencia](#licencia)
* [Seguridad](#seguridad)

## Descripción

La API REST desarrollada en Spring es la columna vertebral de nuestro proyecto, proporcionando acceso a los datos almacenados en nuestra base de datos SQL. Construida íntegramente en Java y complementada con herramientas como PostMan y Swagger, nuestra API ofrece una interfaz intuitiva y poderosa para interactuar con los datos. Cuenta con una serie de características:

 - Endpoints para la gestión de incidencias, equipos y personal: Nuestra API ofrece una amplia gama de endpoints que permiten la creación, lectura, actualización y eliminación de datos relacionados con incidencias, equipos y personal. Esto proporciona a los usuarios una forma eficiente de acceder y manipular la información según sus necesidades.

 - Implementación de estándares RESTful: Siguiendo los principios de arquitectura REST, nuestros endpoints están diseñados para ser coherentes y predecibles, facilitando su uso e integración con otras aplicaciones y servicios.

 - Documentación completa con Swagger: La API está completamente documentada utilizando Swagger, lo que proporciona a los desarrolladores una referencia clara y detallada de cada endpoint, sus parámetros y sus respuestas posibles. Esto facilita enormemente el proceso de desarrollo y la integración con otros sistemas.

 - Seguridad integrada: Implementamos medidas de seguridad sólidas, como autenticación y autorización, para proteger los datos sensibles y garantizar que solo los usuarios autorizados puedan acceder a determinadas funcionalidades.

## Uso

### Endpoint Base

Aunque no disponemos de un endpoint base específico para mostrar datos, nuestra API está configurada para su uso en entorno local, escuchando en el puerto 8089. Por lo tanto, el punto de partida de nuestra API sería la siguiente URL: http://localhost:8089/api/.

A partir de esta URL base, puedes acceder a los diferentes endpoints que ofrecemos para interactuar con la API y acceder a los datos relacionados con incidencias, equipos, personal y más. Utiliza esta URL como punto de entrada para explorar y utilizar nuestra API de manera efectiva.

### Endpoints

La API cuenta con una amplia variedad de endpoints que utilizar para obtener distintos tipos de datos o documentos. Para más información, consultar la [lista de endpoints](ENDPOINTS.md)


### Swagger

Además de l a documentación proporcionada en el apartado anterior, contamos con la documentación de Swagger, a la cual se puede acceder mediante este [enlace](http://localhost:8089/swagger-ui/index.html)

**Notas adicionales**:
- Asegúrate de que la API esté en funcionamiento para acceder a la documentación.
- Si cambias el puerto por el que la API escucha (8089), recuerda actualizar también el puerto en la dirección del enlace.


## Seguridad

En cuanto a la seguridad implementando roles se ha hecho que dependiendo de si eres administrador o profesor puedas entrar a unos recursos o a otros, esto se ha controlado desde las aplicaciones ya que cuando se fue a implementar en la API estábamos usando una clase que está deprecada y salía error.

También busqué otra forma de implementar la seguridad, pero tampoco sirvió debido a que te proporcionaba una clave y las guardaba en una keyStore en su ordenador, pero te proporcionaba un certificado por IP y al final se lo comenté a Luis y no le pareció práctico. Y luego puse una seguridad básica la cual me generaba un token aleatorio cada vez que se ejecutaba la API pero que tampoco se usó en la API final.

Para poder acceder a adjuntos que pueden ser imágenes, PDF... lo que hicimos fue desde las aplicaciones clientes se encripta en base64 y desde la API tenemos que crear otra clase Incidencias DTO la cual tenga 2 campos más de tipo String llamados cuerpo64 y extensión. Entonces creamos un método para desencriptar el cuerpo64 y luego lo guardamos en un directorio predeterminado y con un nombre aleatorio y extensión y esto sería lo que aparecería en la base de datos, y si queremos mostrar el archivo que nos han subido tendríamos que hacer estos pasos a la inversa.

Para asegurar la información de la API habría que haber metido seguridad por token y así para poder acceder a los distintos endpoints de la API en los cuales puedes ver la información de la base de datos necesitarías un token que genera y depende de si eres profesor o administrador puedes acceder a unos o a otros, pero no se implementó en el proyecto debido a que todo lo que buscábamos o casi todo estaba deprecado.

En la aplicación móvil tenemos un inicio de sesión el cual se conecta a un endpoint de la API y si el correo y la contraseña coinciden te deja acceder a ella y si no te dice que no puedes acceder ya que las credenciales no coinciden. Así podemos controlar quién puede usar la aplicación.

Y después en la aplicación de escritorio tenemos la validación, pero en este caso coge directamente qué perfil tienes atribuido si profesor o administrador para que tú no tengas que registrarte cuando usas la aplicación y no tengas que meter dos veces la clave en el ordenador. Y así validaría si eres profesor o administrador sin meter ninguna contraseña.

En cuanto a la seguridad, el proyecto ha implementado un sistema de encriptación robusto para la protección de contraseñas, una medida indispensable para salvaguardar los datos de acceso de los usuarios. Se enfrentó a desafíos significativos con herramientas obsoletas que limitan la implementación de métodos avanzados de seguridad en la API, como la autenticación basada en tokens y el uso de certificados SSL por IP. Pese a estos obstáculos, se tomaron medidas compensatorias, como la encriptación de archivos adjuntos en base64 que, aunque proporciona una capa de seguridad adicional, pone de manifiesto la necesidad de una solución más integral y moderna para proteger la información en tránsito.

## Miembros

- Tania Chocán (Desarrollador principal)
  - GitHub: [Tania105](https://github.com/Tania105)
  - Correo de contacto: [tania.chocanalexandre@iesmiguelherrero.com](mailto:tania.chocanalexandre@iesmiguelherrero.com)

- Raúl Casas Gómez (Desarrollador principal)
  - GitHub: [RaulKas07](https://github.com/RaulKas07)
  - Correo de contacto: [raul.casasgomez@iesmiguelherrero.com](mailto:raul.casasgomez@iesmiguelherrero.com)

- Miguel Ángel Calderón (Desarrollador principal)
  - GitHub: [miguelangelcalderon3](https://github.com/miguelangelcalderon3)
  - Correo de contacto: [miguelangel.calderonzuleta@iesmiguelherrero.com](mailto:miguelangel.calderonzuleta@iesmiguelherrero.com)

- Ignacio Sáez González (Desarrollador principal)
  - GitHub: [Ignaciosgh](https://github.com/Ignaciosgh)
  - Correo de contacto: [ignacio.saezgonzalez@iesmiguelherrero.com](mailto:ignacio.saezgonzalez@iesmiguelherrero.com)  

- Diego Sañudo Rodríguez (Desarrollador principal)
  - GitHub: [naego-sarophiel](https://github.com/naego-sarophiel)
  - Correo de contacto: [diego.sanudorodriguez@iesmiguelherrero.com](mailto:diego.sanudorodriguez@iesmiguelherrero.com) 

- Isaac Cabria Díez (Desarrollador principal)
  - GitHub: [isaac640](https://github.com/isaac640)
  - Correo de contacto: [isaac.cabriadiez@iesmiguelherrero.com](mailto:isaac.cabriadiez@iesmiguelherrero.com) 

Agradecemos a todos los miembros del equipo por su arduo trabajo y dedicación en el desarrollo y mantenimiento de este proyecto.

## Contribución

Si deseas contribuir al proyecto, sigue estos pasos:

1. Haz un fork del proyecto.
2. Crea una nueva rama (`git checkout -b el-nombre-de-tu-rama`).
3. Realiza tus cambios y haz commit (`git commit -am 'He cambiado el diseño de la pantalla inicial'`).
4. Haz push a la rama (`git push origin el-nombre-de-tu-rama`).
5. Crea un nuevo Pull Request.

Si las contribuciones son efectivas y corrigen u optimizan en algún sentido el código base, se añadirán a la rama main y pasarás a ser parte del apartado de miembros como colaborador.

## Contacto

Si tienes alguna pregunta, sugerencia o problema, no dudes en contactarnos a través de:

- Correo electrónico: [contacto@iris.com](mailto:contacto@iris.com)
- Twitter: [@ProyectoIris](https://twitter.com/ProyectoIris)
- Discord: [Servidor de Discord del Proyecto](enlace-al-servidor-de-discord)
- [Foro de discusión del proyecto](https://www.ProyectoIris.com/foro)
- [Formulario de contacto en mi sitio web](https://www.ProyectoIris.com/contacto)


## Licencia

Este proyecto está licenciado bajo la [Licencia MIT](LICENSE.md).

La Licencia MIT es una licencia de software libre que permite a los usuarios utilizar, modificar y distribuir el software con pocos o ningún requisito. Bajo esta licencia, los usuarios pueden hacer lo que deseen con el software, siempre y cuando se incluya el aviso de copyright y la renuncia de garantía.

Para obtener más detalles, consulta el [texto completo de la Licencia MIT](https://opensource.org/licenses/MIT).

Agradecemos a los autores de la Licencia MIT por proporcionar una estructura legal que permita compartir nuestro trabajo con otros de manera abierta y accesible.
