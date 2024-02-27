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
    * [Parámetros](#parámetros)
    * [Ejemplos](#ejemplos)
        * [Solicitud](#solicitud)
        * [Respuesta](#respuesta)
* [Seguridad](#seguridad)
* [Documentación](#documentación)
    * [Swagger](#swagger)
    * [Errores comunes](#errores-comunes)
* [Miembros](#miembros)
* [Contribución](#contribución)
* [Contacto](#contacto)
* [Licencia](#licencia)

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

### Parámetros

### Ejemplos

#### Solicitud

#### Respuesta

## Seguridad

## Documentación

### Swagger

### Errores comunes

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

Este proyecto está licenciado bajo la [Licencia MIT](LICENSE).

La Licencia MIT es una licencia de software libre que permite a los usuarios utilizar, modificar y distribuir el software con pocos o ningún requisito. Bajo esta licencia, los usuarios pueden hacer lo que deseen con el software, siempre y cuando se incluya el aviso de copyright y la renuncia de garantía.

Para obtener más detalles, consulta el [texto completo de la Licencia MIT](https://opensource.org/licenses/MIT).

Agradecemos a los autores de la Licencia MIT por proporcionar una estructura legal que permita compartir nuestro trabajo con otros de manera abierta y accesible.
