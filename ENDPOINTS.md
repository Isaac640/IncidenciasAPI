# Índice

* [Controladores principales]()
    * [Aulas](#aulas)
    * [Comentarios](#comentarios)
    * [Departamentos](#departamentos)
    * [Equipos](#equipos)
    * [Incidencias](#incidencias)
    * [Incidencias sin resolver](#incidencias-sin-resolver)
    * [Subtipos](#subtipos)
    * [Perfiles](#perfiles)
    * [Personal](#personal)
* [Exportar en Excell](#exportar-en-excel)
    * [Estadísticas de Tipos de Incidencias](#exportar-estadísticas-de-tipos-de-incidencias)
    * [Incidencias asignadas a cada administrador](#exportar-incidencias-asignadas-a-cada-administrador)
    * [Incidencias abiertas de usuarios](#exportar-incidencias-abiertas-de-usuarios-a-excel)
    * [Incidencias Resueltas por Administrador](#exportar-incidencias-resueltas-por-administrador)
    * [Tiempo de incidencia a Excel](#exportar-tiempo-de-incidencia-a-excel)
    * [Tiempo Promedio de Resolución por Tipo de Incidencia](#generar-excel-de-tiempo-promedio-de-resolución-por-tipo-de-incidencia)
    * [Tiempo dedicado por administrador](#exportar-tiempo-dedicado-por-administrador-a-excel)
* [Adjuntos](#adjuntos)
    * [Guardar incidencias con adjunto](#guardar-incidencia-con-adjunto)
    * [Guardar comentario con adjunto](#guardar-comentario-con-adjunto)
    * [Mostrar comentario con adjunto](#mostrar-comentario-con-adjunto)
    * [Mostrar incidencia con adjunto](#mostrar-incidencia-con-adjunto)



# Controladores principales

## Aulas

### Obtener todas las aulas

- **URL**: `/api/aulas`
- **Método**: `GET`
- **Respuesta**:
 - `200 OK`: Devuelve una lista de todas las aulas.

### Obtener aula por ID

- **URL**: `/api/aulas/{id}`
- **Método**: `GET`
- **Parámetros**:
 - `id`: ID de la aula (requerido)
- **Respuesta**:
 - `200 OK`: Devuelve los detalles de la aula.
 - `404 Not Found`: Si no se encuentra la aula con el ID proporcionado.

### Crear aula

- **URL**: `/api/aulas`
- **Método**: `POST`
- **Parámetros**:
 - `codigo`: Código de la aula (requerido)
 - `descripcion`: Descripción de la aula (requerido)
 - `planta`: Planta de la aula (requerido)
- **Respuesta**:
 - `201 Created`: Devuelve los detalles de la aula creada.

### Actualizar aula

- **URL**: `/api/aulas/{id}`
- **Método**: `PUT`
- **Parámetros**:
 - `id`: ID de la aula (requerido)
 - `codigo`: Código de la aula (opcional)
 - `descripcion`: Descripción de la aula (opcional)
 - `planta`: Planta de la aula (opcional)
- **Respuesta**:
 - `200 OK`: Devuelve los detalles de la aula actualizada.
 - `404 Not Found`: Si no se encuentra la aula con el ID proporcionado.

### Eliminar aula

- **URL**: `/api/aulas/{id}`
- **Método**: `DELETE`
- **Parámetros**:
 - `id`: ID de la aula (requerido)
- **Respuesta**:
 - `204 No Content`: No devuelve contenido.

### Buscar aula por código

- **URL**: `/api/aulas/codigo={codigo}`
- **Método**: `GET`
- **Parámetros**:
 - `codigo`: Código de la aula (requerido)
- **Respuesta**:
 - `200 OK`: Devuelve una lista de aulas que coinciden con el código proporcionado.

---

**Notas**:
- Los parámetros entre paréntesis indican que son opcionales, excepto donde se especifica lo contrario.
- Los códigos de estado HTTP son parte de la respuesta.




## Comentarios

### Obtener todos los comentarios

- **URL**: `/api/comentarios`
- **Método**: `GET`
- **Respuesta**:
 - `200 OK`: Devuelve una lista de todos los comentarios.

### Obtener comentario por ID

- **URL**: `/api/comentarios/{id}`
- **Método**: `GET`
- **Parámetros**:
 - `id`: ID del comentario (requerido)
- **Respuesta**:
 - `200 OK`: Devuelve los detalles del comentario.
     - `404 Not Found`: Si no se encuentra el comentario con el ID proporcionado.

### Obtener comentario por número de incidencia

- **URL**: `/api/comentarios/incidencia/{incidenciaNum}`
- **Método**: `GET`
- **Parámetros**:
 - `incidenciaNum`: Número de la incidencia (requerido)
- **Respuesta**:
 - `200 OK`: Devuelve los detalles del comentario asociado a la incidencia.
     - `404 Not Found`: Si no se encuentra el comentario con el número de incidencia proporcionado.

### Crear comentario

- **URL**: `/api/comentarios`
- **Método**: `POST`
- **Parámetros**:
 - `texto`: Texto del comentario (requerido)
 - `fechahora`: Fecha y hora del comentario (requerido)
 - `incidencia_num`: Número de la incidencia (requerido)
 - `personal`: Personal asociado al comentario (requerido)
- **Respuesta**:
 - `201 Created`: Devuelve los detalles del comentario creado.
    
### Actualizar comentario

- **URL**: `/api/comentarios/{id}`
- **Método**: `PUT`
- **Parámetros**:
 - `id`: ID del comentario (requerido)
 - `texto`: Texto del comentario (opcional)
 - `fechahora`: Fecha y hora del comentario (opcional)
 - `incidencia_num`: Número de la incidencia (opcional)
 - `personal`: Personal asociado al comentario (opcional)
- **Respuesta**:
 - `200 OK`: Devuelve los detalles del comentario actualizado.
     - `404 Not Found`: Si no se encuentra el comentario con el ID proporcionado.

### Eliminar comentario

- **URL**: `/api/comentarios/{id}`
- **Método**: `DELETE`
- **Parámetros**:
 - `id`: ID del comentario (requerido)
- **Respuesta**:
 - `204 No Content`: No devuelve contenido.

---

**Notas**:
- Los parámetros entre paréntesis indican que son opcionales, excepto donde se especifica lo contrario.
- Los códigos de estado HTTP son parte de la respuesta.

## Departamentos

### Obtener todos los departamentos

- **URL**: `/api/Departamentos`
- **Método**: `GET`
- **Respuesta**:
 - `200 OK`: Devuelve una lista de todos los departamentos.


### Obtener departamento por ID

- **URL**: `/api/Departamentos/{id}`
- **Método**: `GET`
- **Parámetros**:
 - `id`: ID del departamento (requerido)
- **Respuesta**:
 - `200 OK`: Devuelve los detalles del departamento.
    - `404 Not Found`: Si no se encuentra el departamento con el ID proporcionado.

### Crear departamento

- **URL**: `/api/Departamentos`
- **Método**: `POST`
- **Parámetros**:
 - `cod`: Código del departamento (requerido)
 - `nombre`: Nombre del departamento (requerido)
 - `activo`: Estado activo del departamento (requerido)
 - `jefedep_Id`: ID del jefe de departamento (requerido)
- **Respuesta**:
 - `201 Created`: Devuelve los detalles del departamento creado.
    
### Actualizar departamento

- **URL**: `/api/Departamentos/{id}`
- **Método**: `PUT`
- **Parámetros**:
 - `id`: ID del departamento (requerido)
 - `cod`: Código del departamento (opcional)
 - `nombre`: Nombre del departamento (opcional)
 - `activo`: Estado activo del departamento (opcional)
 - `jefedep_Id`: ID del jefe de departamento (opcional)
- **Respuesta**:
 - `200 OK`: Devuelve los detalles del departamento actualizado.
     - `404 Not Found`: Si no se encuentra el departamento con el ID proporcionado.

### Eliminar departamento

- **URL**: `/api/Departamentos/{id}`
- **Método**: `DELETE`
- **Parámetros**:
 - `id`: ID del departamento (requerido)
- **Respuesta**:
 - `204 No Content`: No devuelve contenido.

---

**Notas**:
- Los parámetros entre paréntesis indican que son opcionales, excepto donde se especifica lo contrario.
- Los códigos de estado HTTP son parte de la respuesta.

## Equipos

### Obtener todos los equipos

- **URL**: `/api/equipos`
- **Método**: `GET`
- **Respuesta**:
 - `200 OK`: Devuelve una lista de todos los equipos.
    
### Obtener equipo por ID

- **URL**: `/api/equipos/{id}`
- **Método**: `GET`
- **Parámetros**:
 - `id`: ID del equipo (requerido)
- **Respuesta**:
 - `200 OK`: Devuelve los detalles del equipo.
 - `404 Not Found`: Si no se encuentra el equipo con el ID proporcionado.

### Crear equipo

- **URL**: `/api/equipos`
- **Método**: `POST`
- **Parámetros**:
 - `tipoEquipo`: Tipo de equipo (requerido)
 - `fechaAdquisicion`: Fecha de adquisición del equipo (requerido)
 - `etiqueta`: Etiqueta del equipo (requerido)
 - `marca`: Marca del equipo (requerido)
 - `modelo`: Modelo del equipo (requerido)
 - `descripcion`: Descripción del equipo (requerido)
 - `baja`: Estado de baja del equipo (requerido)
 - `aulaNum`: Número de aula donde se encuentra el equipo (requerido)
 - `puesto`: Puesto dentro de la aula (requerido)
- **Respuesta**:
 - `201 Created`: Devuelve los detalles del equipo creado.

### Actualizar equipo

- **URL**: `/api/equipos/{id}`
- **Método**: `PUT`
- **Parámetros**:
 - `id`: ID del equipo (requerido)
 - `tipoEquipo`: Tipo de equipo (opcional)
 - `fechaAdquisicion`: Fecha de adquisición del equipo (opcional)
 - `etiqueta`: Etiqueta del equipo (opcional)
 - `marca`: Marca del equipo (opcional)
 - `modelo`: Modelo del equipo (opcional)
 - `descripcion`: Descripción del equipo (opcional)
 - `baja`: Estado de baja del equipo (opcional)
 - `aulaNum`: Número de aula donde se encuentra el equipo (opcional)
 - `puesto`: Puesto dentro de la aula (opcional)
- **Respuesta**:
 - `200 OK`: Devuelve los detalles del equipo actualizado.
 - `404 Not Found`: Si no se encuentra el equipo con el ID proporcionado.

### Eliminar equipo

- **URL**: `/api/equipos/{id}`
- **Método**: `DELETE`
- **Parámetros**:
 - `id`: ID del equipo (requerido)
- **Respuesta**:
 - `204 No Content`: No devuelve contenido.

---

**Notas**:
- Los parámetros entre paréntesis indican que son opcionales, excepto donde se especifica lo contrario.
- Los códigos de estado HTTP son parte de la respuesta.

## Incidencias 

### Obtener todas las incidencias

- **URL**: `/api/incidencias`
- **Método**: `GET`
- **Respuesta**:
 - `200 OK`: Devuelve una lista de todas las incidencias.

### Obtener incidencia por ID

- **URL**: `/api/incidencias/{id}`
- **Método**: `GET`
- **Parámetros**:
 - `id`: ID de la incidencia (requerido)
- **Respuesta**:
 - `200 OK`: Devuelve los detalles de la incidencia.
 - `404 Not Found`: Si no se encuentra la incidencia con el ID proporcionado.

### Obtener incidencias por tipo

- **URL**: `/api/incidencias/tipo={tipo}`
- **Método**: `GET`
- **Parámetros**:
 - `tipo`: Tipo de la incidencia (requerido)
- **Respuesta**:
 - `200 OK`: Devuelve una lista de incidencias que coinciden con el tipo proporcionado.

### Guardar archivo adjunto

- **URL**: `/api/incidencias/guardarAdjunto`
- **Método**: `POST`
- **Parámetros**:
 - `extension`: Extensión del archivo adjunto (requerido)
 - `id`: ID de la incidencia a la que se adjuntará el archivo (requerido)
 - `cuerpoBase64`: Contenido del archivo adjunto codificado en Base64 (requerido)
 - `directorio`: Directorio donde se guardará el archivo adjunto (opcional, por defecto se usa un directorio predeterminado)
- **Respuesta**:
 - `200 OK`: Devuelve un mensaje indicando que la URL del adjunto se actualizó correctamente.
 - `404 Not Found`: Si no se encuentra la incidencia con el ID proporcionado.
 - `500 Internal Server Error`: Si ocurre un error al guardar el archivo adjunto.

---

**Notas**:
- Los parámetros entre paréntesis indican que son opcionales, excepto donde se especifica lo contrario.
- Los códigos de estado HTTP son parte de la respuesta.

## Incidencias sin resolver

### Crear incidencia sin resolver

- **URL**: `/api/incidencias`
- **Método**: `POST`
- **Parámetros**:
 - `tipo`: Tipo de la incidencia (requerido)
 - `subtipo_id`: ID del subtipo de incidencia (requerido)
 - `descripcion`: Descripción de la incidencia (requerido)
 - `creador_id`: ID del creador de la incidencia (requerido)
 - `fecha_creacion`: Fecha de creación de la incidencia (requerido)
- **Respuesta**:
 - `201 Created`: Devuelve los detalles de la incidencia sin resolver creada.

### Actualizar incidencia sin resolver

- **URL**: `/api/incidencias/{id}`
- **Método**: `PUT`
- **Parámetros**:
 - `id`: ID de la incidencia sin resolver (requerido)
 - `tipo`: Tipo de la incidencia (opcional)
 - `subtipo_id`: ID del subtipo de incidencia (opcional)
 - `descripcion`: Descripción de la incidencia (opcional)
 - `creador_id`: ID del creador de la incidencia (opcional)
 - `fecha_creacion`: Fecha de creación de la incidencia (opcional)
- **Respuesta**:
 - `200 OK`: Devuelve los detalles de la incidencia sin resolver actualizada.
 - `404 Not Found`: Si no se encuentra la incidencia sin resolver con el ID proporcionado.

### Eliminar incidencia sin resolver

- **URL**: `/api/incidencias/{id}`
- **Método**: `DELETE`
- **Parámetros**:
 - `id`: ID de la incidencia sin resolver (requerido)
- **Respuesta**:
 - `204 No Content`: No devuelve contenido.

### Obtener incidencias sin resolver por creador

- **URL**: `/api/incidencias/creadorId/{id}`
- **Método**: `GET`
- **Parámetros**:
 - `id`: ID del creador (requerido)
- **Respuesta**:
 - `200 OK`: Devuelve una lista de incidencias sin resolver creadas por el usuario especificado.

---

**Notas**:
- Los parámetros entre paréntesis indican que son opcionales, excepto donde se especifica lo contrario.
- Los códigos de estado HTTP son parte de la respuesta.


## Subtipos 

### Obtener todos los subtipos de incidencias

- **URL**: `/api/incidenciasSubtipos`
- **Método**: `GET`
- **Respuesta**:
 - `200 OK`: Devuelve una lista de todos los subtipos de incidencias.

### Obtener subtipo de incidencia por ID

- **URL**: `/api/incidenciasSubtipos/{id}`
- **Método**: `GET`
- **Parámetros**:
 - `id`: ID del subtipo de incidencia (requerido)
- **Respuesta**:
 - `200 OK`: Devuelve los detalles del subtipo de incidencia.
 - `404 Not Found`: Si no se encuentra el subtipo de incidencia con el ID proporcionado.

### Crear subtipo de incidencia

- **URL**: `/api/incidenciasSubtipos`
- **Método**: `POST`
- **Parámetros**:
 - `tipo`: Tipo de la incidencia (requerido)
 - `subtipoNombre`: Nombre del subtipo de incidencia (requerido)
 - `subSubtipo`: Subtipo de la incidencia (requerido)
- **Respuesta**:
 - `201 Created`: Devuelve los detalles del subtipo de incidencia creado.

### Actualizar subtipo de incidencia

- **URL**: `/api/incidenciasSubtipos/{id}`
- **Método**: `PUT`
- **Parámetros**:
 - `id`: ID del subtipo de incidencia (requerido)
 - `tipo`: Tipo de la incidencia (opcional)
 - `subtipoNombre`: Nombre del subtipo de incidencia (opcional)
 - `subSubtipo`: Subtipo de la incidencia (opcional)
- **Respuesta**:
 - `200 OK`: Devuelve los detalles del subtipo de incidencia actualizado.
 - `404 Not Found`: Si no se encuentra el subtipo de incidencia con el ID proporcionado.

### Eliminar subtipo de incidencia

- **URL**: `/api/incidenciasSubtipos/{id}`
- **Método**: `DELETE`
- **Parámetros**:
 - `id`: ID del subtipo de incidencia (requerido)
- **Respuesta**:
 - `204 No Content`: No devuelve contenido.

---

**Notas**:
- Los parámetros entre paréntesis indican que son opcionales, excepto donde se especifica lo contrario.
- Los códigos de estado HTTP son parte de la respuesta.


## Perfiles

### Obtener todos los perfiles

- **URL**: `/api/perfiles`
- **Método**: `GET`
- **Respuesta**:
 - `200 OK`: Devuelve una lista de todos los perfiles.

### Obtener perfil por ID

- **URL**: `/api/perfiles/{id}`
- **Método**: `GET`
- **Parámetros**:
 - `id`: ID del perfil (requerido)
- **Respuesta**:
 - `200 OK`: Devuelve los detalles del perfil.
 - `404 Not Found`: Si no se encuentra el perfil con el ID proporcionado.

### Crear perfil

- **URL**: `/api/perfiles`
- **Método**: `POST`
- **Parámetros**:
 - `personal_id`: ID del personal (requerido)
 - `dominio`: Dominio del perfil (requerido)
 - `educantabria`: Indica si el perfil es de Educantabria (requerido)
 - `password`: Contraseña del perfil (requerido)
 - `perfil`: Tipo de perfil (requerido)
- **Respuesta**:
 - `201 Created`: Devuelve los detalles del perfil creado.

### Actualizar perfil

- **URL**: `/api/perfiles/{id}`
- **Método**: `PUT`
- **Parámetros**:
 - `id`: ID del perfil (requerido)
 - `personal_id`: ID del personal (opcional)
 - `dominio`: Dominio del perfil (opcional)
 - `educantabria`: Indica si el perfil es de Educantabria (opcional)
 - `password`: Contraseña del perfil (opcional)
 - `perfil`: Tipo de perfil (opcional)
- **Respuesta**:
 - `200 OK`: Devuelve los detalles del perfil actualizado.
 - `404 Not Found`: Si no se encuentra el perfil con el ID proporcionado.

### Eliminar perfil

- **URL**: `/api/perfiles/{id}`
- **Método**: `DELETE`
- **Parámetros**:
 - `id`: ID del perfil (requerido)
- **Respuesta**:
 - `204 No Content`: No devuelve contenido.

### Validar perfil por dominio y contraseña

- **URL**: `/api/perfiles/validacion?educantabria={educantabria}&password={password}`
- **Método**: `GET`
- **Parámetros**:
 - `educantabria`: Indica si el perfil es de Educantabria (requerido)
 - `password`: Contraseña del perfil (requerido)
- **Respuesta**:
 - `200 OK`: Devuelve los detalles del perfil que coincide con el dominio y la contraseña proporcionados.
 - `404 Not Found`: Si no se encuentra ningún perfil que coincida con el dominio y la contraseña proporcionados.

### Obtener perfil por dominio

- **URL**: `/api/perfiles/dominio?dominio={dominio}`
- **Método**: `GET`
- **Parámetros**:
 - `dominio`: Dominio del perfil (requerido)
- **Respuesta**:
 - `200 OK`: Devuelve los detalles del perfil que coincide con el dominio proporcionado.
 - `404 Not Found`: Si no se encuentra ningún perfil que coincida con el dominio proporcionado.

---

**Notas**:
- Los parámetros entre paréntesis indican que son opcionales, excepto donde se especifica lo contrario.
- Los códigos de estado HTTP son parte de la respuesta.

## Personal

### Obtener todos los personal

- **URL**: `/api/personal`
- **Método**: `GET`
- **Respuesta**:
 - `200 OK`: Devuelve una lista de todos los personal.

### Obtener personal por ID

- **URL**: `/api/personal/{id}`
- **Método**: `GET`
- **Parámetros**:
 - `id`: ID del personal (requerido)
- **Respuesta**:
 - `200 OK`: Devuelve los detalles del personal.
 - `404 Not Found`: Si no se encuentra el personal con el ID proporcionado.

### Crear personal

- **URL**: `/api/personal`
- **Método**: `POST`
- **Parámetros**:
 - Todos los campos del modelo `Personal` (requeridos)
- **Respuesta**:
 - `201 Created`: Devuelve los detalles del personal creado.

### Actualizar personal

- **URL**: `/api/personal/{id}`
- **Método**: `PUT`
- **Parámetros**:
 - `id`: ID del personal (requerido)
 - Todos los campos del modelo `Personal` (opcionales)
- **Respuesta**:
 - `200 OK`: Devuelve los detalles del personal actualizado.
 - `404 Not Found`: Si no se encuentra el personal con el ID proporcionado.

### Eliminar personal

- **URL**: `/api/personal/{id}`
- **Método**: `DELETE`
- **Parámetros**:
 - `id`: ID del personal (requerido)
- **Respuesta**:
 - `204 No Content`: No devuelve contenido.

### Obtener personal por nombre y apellido1

- **URL**: `/api/personal/?nombre={nombre}&apellido1={apellido1}`
- **Método**: `GET`
- **Parámetros**:
 - `nombre`: Nombre del personal (requerido)
 - `apellido1`: Primer apellido del personal (requerido)
- **Respuesta**:
 - `200 OK`: Devuelve una lista de personal que coincide con el nombre y primer apellido proporcionados.

### Obtener personal por DNI

- **URL**: `/api/personal/dni={dni}`
- **Método**: `GET`
- **Parámetros**:
 - `dni`: DNI del personal (requerido)
- **Respuesta**:
 - `200 OK`: Devuelve una lista de personal que coincide con el DNI proporcionado.

---

**Notas**:
- Los parámetros entre paréntesis indican que son opcionales, excepto donde se especifica lo contrario.
- Los códigos de estado HTTP son parte de la respuesta.

# Exportar en Excell

## Exportar Estadísticas de Tipos de Incidencias

- **URL**: `/export/estadisticaTipoIncidencias`
- **Método**: `GET`
- **Descripción**: Este endpoint permite exportar las estadísticas de los tipos de incidencias registradas en la base de datos a un archivo Excel. Las estadísticas incluyen el tipo de incidencia y el número de incidencias para cada tipo.
- **Respuesta**:
 - `200 OK`: Devuelve un archivo Excel (.xlsx) con las estadísticas de los tipos de incidencias.
    - **Encabezados**:
      - `Tipo incidencias`
      - `Numero de incidencias`
    - **Ejemplo**:
      - El archivo Excel generado contendrá una hoja llamada "Estadisticas Tipo de incidencias" con dos columnas. La primera columna mostrará el tipo de incidencia y la segunda columna mostrará el número de incidencias para cada tipo.
- **Notas**:
 - Este endpoint no requiere parámetros.
 - El archivo Excel se descargará automáticamente con el nombre "incident_statistics.xlsx".

---

**Notas adicionales**:
- El endpoint utiliza una consulta SQL para obtener las estadísticas de los tipos de incidencias de la base de datos.
- La respuesta es un archivo Excel, por lo que no se proporciona un ejemplo en formato JSON o similar.

## Exportar incidencias asignadas a cada administrador

- **URL**: `/export/incidenciaACadaAdmin`
- **Método**: `GET`
- **Respuesta**:
 - `200 OK`: Genera y descarga un archivo Excel con las incidencias asignadas a cada administrador.
 - **Cabeceras**:
   - `Content-Type`: `application/vnd.openxmlformats-officedocument.spreadsheetml.sheet`
   - `Content-Disposition`: `attachment; filename=incidents_assigned_to_admin.xlsx`
 - **Cuerpo**:
   - Contiene el archivo Excel descargable.

---

**Notas**:
- Este endpoint utiliza una consulta SQL para obtener las incidencias y los detalles de los administradores asignados a cada incidencia.
- Los datos incluidos en el archivo Excel son: Nombre del Administrador, ID de la Incidencia, Tipo de Incidencia, Descripción de la Incidencia, Fecha de Creación de la Incidencia y Fecha de Resolución de la Incidencia.
- El archivo Excel se genera dinámicamente y se descarga directamente al usuario sin necesidad de almacenamiento previo en el servidor.

## Exportar incidencias abiertas de usuarios a Excel

- **URL**: `/export/IncidenciasAbiertasUsuario`
- **Método**: `GET`
- **Respuesta**:
 - `200 OK`: Devuelve un archivo Excel con las incidencias abiertas de los usuarios.
### Descripción

Este endpoint genera un archivo Excel que contiene información sobre las incidencias abiertas por los usuarios. La consulta SQL utilizada para obtener los datos incluye los siguientes campos:

- Nombre del usuario (`user_name`)
- ID de la incidencia (`incident_id`)
- Tipo de incidencia (`incident_type`)
- Descripción de la incidencia (`incident_description`)
- Fecha de creación de la incidencia (`incident_creation_date`)

Los datos se ordenan por el nombre del usuario.

### Cómo usar

Para acceder a este endpoint, simplemente realiza una solicitud GET a la URL proporcionada. El archivo Excel resultante se descargará automáticamente con el nombre `open_incidents_report.xlsx`.

---

**Notas**:
- Este endpoint no requiere parámetros.
- Los códigos de estado HTTP son parte de la respuesta.

## Exportar Incidencias Resueltas por Administrador

- **URL**: `/export/IncidenciasUser`
- **Método**: `GET`
- **Descripción**: Este endpoint permite exportar a un archivo Excel (.xlsx) todas las incidencias resueltas asignadas a cada administrador.
- **Respuesta**:
 - `200 OK`: Devuelve un archivo Excel con las incidencias resueltas por administrador. El archivo se descargará automáticamente con el nombre `IncidenciasResueltasAdministrador.xlsx`.

### Estructura del archivo Excel

El archivo Excel generado contendrá las siguientes columnas:

- **Administrador**: Nombre del administrador responsable de la incidencia.
- **ID incidencia**: Identificador único de la incidencia.
- **Tipo incidencia**: Tipo de incidencia (por ejemplo, "Hardware", "Software").
- **Descripción incidencia**: Descripción detallada de la incidencia.
- **Fecha creación incidencia**: Fecha y hora en que se creó la incidencia.
- **Fecha cierre incidencia**: Fecha y hora en que se resolvió la incidencia.

### Ejemplo de uso

Para utilizar este endpoint, simplemente accede a la URL `/export/IncidenciasUser` utilizando un navegador web o cualquier cliente HTTP que soporte la descarga de archivos. El navegador te solicitará descargar el archivo `IncidenciasResueltasAdministrador.xlsx`.

**Notas**:
- El archivo Excel generado incluirá todas las incidencias resueltas (`estado = 'resuelta'`) ordenadas por el nombre del administrador responsable.
- Este endpoint está diseñado para ser utilizado por administradores o personal autorizado que necesiten revisar el historial de incidencias resueltas.
- Este endpoint está protegido por la autenticación y autorización del sistema, asegurando que solo usuarios autorizados puedan acceder a la información de las incidencias resueltas.
- Los códigos de estado HTTP son parte de la respuesta.


## Exportar tiempo de incidencia a Excel

- **URL**: `/export/tiempoIncidencia`
- **Método**: `GET`
- **Respuesta**:
 - `200 OK`: Devuelve un archivo Excel descargable con la información del tiempo de incidencia.
    - El archivo Excel incluye las columnas:
      - ID incidencia
      - Tipo incidencia
      - Descripción incidencia
      - Fecha creación
      - Fecha cierre
      - Duración en minutos
 - **Notas**:
 - El archivo Excel se genera dinámicamente basándose en los datos actuales de las incidencias en la base de datos.
 - La duración se calcula en minutos entre la fecha de creación y la fecha de cierre de cada incidencia.
 - Si una incidencia no ha sido resuelta, la fecha de cierre se considera como el momento actual.

---

**Ejemplo de uso**:

Para descargar el archivo Excel con el tiempo de incidencia, simplemente accede a la URL del endpoint desde un navegador o utiliza una herramienta como `curl` o Postman para hacer una solicitud GET.


## Generar Excel de Tiempo Promedio de Resolución por Tipo de Incidencia

- **URL**: `/export/tiempoTipoIncidencia`
- **Método**: `GET`
- **Respuesta**:
 - `200 OK`: Genera un archivo Excel descargable con el tiempo promedio de resolución por tipo de incidencia.
    - **Contenido**: El archivo Excel contiene dos columnas: "Incident Type" y "Average Resolution Time (minutes)".
    - **Ejemplo de Respuesta**:
      El usuario recibirá una descarga de un archivo Excel con los datos solicitados.

---

**Notas**:
- Este endpoint utiliza una consulta SQL para calcular el tiempo promedio de resolución de incidencias agrupadas por tipo.
- La respuesta es un archivo Excel (.xlsx) que el usuario puede descargar.
- El nombre del archivo Excel descargado será `incident_resolution_time.xlsx`.


Esta consulta selecciona el tipo de incidencia y calcula el tiempo promedio de resolución (en minutos) para cada tipo de incidencia, filtrando solo aquellas incidencias que están resueltas (`estado = 'resuelta'`).

---

**Requisitos**:
- El usuario debe tener permisos para descargar archivos del servidor.
- El servidor debe tener permisos para escribir archivos temporales y enviar archivos al cliente.

**Errores Comunes**:
- Si ocurre un error al generar el archivo Excel o al escribir los datos en el archivo, se imprimirá un stack trace en el servidor. Es recomendable manejar adecuadamente estos errores para proporcionar una respuesta más amigable al usuario en caso de fallo.

## Exportar tiempo dedicado por administrador a Excel

- **URL**: `/export/tiempoPorAdministrador`
- **Método**: `GET`
- **Descripción**: Este endpoint genera un archivo Excel que contiene el tiempo total dedicado por cada administrador en incidencias resueltas.
- **Respuesta**:
 - `200 OK`: Devuelve el archivo Excel con el nombre `TiempoAdministrador.xlsx`.
 - `Content-Type`: `application/vnd.openxmlformats-officedocument.spreadsheetml.sheet`
 - `Content-Disposition`: `attachment; filename=TiempoAdministrador.xlsx`
 - El archivo Excel contiene dos columnas:
   - **Nombre Admin**: Nombre del administrador.
   - **Total minutos**: Tiempo total dedicado por el administrador en incidencias resueltas, en minutos.

**Notas**:
- Este endpoint utiliza una consulta SQL que suma el tiempo diferencia entre `fecha_creacion` y `fecha_cierre` de las incidencias resueltas (`estado = 'resuelta'`) y agrupa los resultados por el nombre del administrador.
- El archivo Excel generado se descarga directamente al cliente, sin necesidad de almacenar el archivo en el servidor.

---

**Ejemplo de uso**:

Para generar el archivo Excel, simplemente realiza una petición GET al endpoint: GET /export/tiempoPorAdministrador


# Adjuntos

## Guardar incidencia con adjunto

- **URL**: `/api/guardarIncidenciaConAdjunto`
- **Método**: `POST`
- **Cuerpo de la petición**:
 - `IncidenciasDTO`: Objeto que contiene los detalles de la incidencia y el adjunto.
- **Respuesta**:
 - `204 No Content`: No devuelve contenido. Indica que la incidencia con adjunto se guardó correctamente.

## Guardar comentario con adjunto

- **URL**: `/api/guardarComentarioConAdjunto`
- **Método**: `POST`
- **Cuerpo de la petición**:
 - `ComentariosDTO`: Objeto que contiene los detalles del comentario y el adjunto.
- **Respuesta**:
 - `204 No Content`: No devuelve contenido. Indica que el comentario con adjunto se guardó correctamente.

## Mostrar comentario con adjunto

- **URL**: `/api/mostrarComentarioConAdjunto/{id}`
- **Método**: `GET`
- **Parámetros**:
 - `id`: ID del comentario (requerido)
- **Respuesta**:
 - `200 OK`: Devuelve los detalles del comentario con el adjunto.
 - `404 Not Found`: Si no se encuentra el comentario con el ID proporcionado.

## Mostrar incidencia con adjunto

- **URL**: `/api/mostrarIncidenciaConAdjunto/{id}`
- **Método**: `GET`
- **Parámetros**:
 - `id`: ID de la incidencia (requerido)
- **Respuesta**:
 - `200 OK`: Devuelve los detalles de la incidencia con el adjunto.
 - `404 Not Found`: Si no se encuentra la incidencia con el ID proporcionado.

---

**Notas**:
- Los parámetros entre paréntesis indican que son opcionales, excepto donde se especifica lo contrario.
- Los códigos de estado HTTP son parte de la respuesta.
- Los métodos para mostrar comentarios y incidencias con adjuntos están comentados en el código y no están activos.




