# VetCare - Veterinaria de Gatos

![VetCare Logo](https://github.com/ALEYI17/ProyectoWebVeterinaria/blob/main/src/main/resources/static/img/logovetcare.png)

Bienvenido al repositorio de VetCare, una plataforma para la gestión de una veterinaria especializada en gatos. Aquí encontrarás información sobre cómo configurar y ejecutar el proyecto.

## Características

- Gestión de hospitalización y atención de mascotas.
- Interfaz de usuario amigable desarrollada con Angular.
- Backend robusto construido con el framework Spring.



Este repositorio contiene el código fuente de un sistema de gestión veterinaria desarrollado en Java utilizando el framework Spring Boot. El sistema permite gestionar datos relacionados con veterinarios, mascotas, clientes, tratamientos, administradores y medicamentos en una clínica veterinaria.

### Estructura del Proyecto

El proyecto se organiza en paquetes que representan diferentes componentes del sistema:

- `com.vetcare.proyecto.controlador`: Contiene controladores para gestionar las rutas y endpoints del sistema.
- `com.vetcare.proyecto.entities`: Define las entidades o modelos de datos utilizados en el sistema.
- `com.vetcare.proyecto.repository`: Contiene interfaces de repositorio para interactuar con la base de datos.
- `com.vetcare.proyecto.service`: Define interfaces de servicio que proporcionan la lógica de negocio.

### Controladores

Los controladores manejan las solicitudes HTTP y gestionan las respuestas. Aquí se describen algunos de los controladores disponibles:

#### Veterinario Controller

- `PUT /Veterinario/update/{id}`: Actualiza un veterinario existente por su ID.
- `POST /Veterinario/add`: Agrega un nuevo veterinario.
- `GET /Veterinario/todos`: Obtiene todos los veterinarios.
- `GET /Veterinario/find/{id}`: Busca un veterinario por su ID.
- `DELETE /Veterinario/delete/{id}`: Elimina un veterinario por su ID.

#### Mascota Controller

- `PUT /Mascota/update/{id}`: Actualiza una mascota existente por su ID.
- `POST /Mascota/agregar`: Agrega una nueva mascota.
- `GET /Mascota/todas`: Obtiene todas las mascotas.
- `GET /Mascota/find`: Busca mascotas.
- `GET /Mascota/find/{id}`: Busca una mascota por su ID.
- `GET /Mascota/find/{id}/tratamientos`: Obtiene tratamientos de una mascota por su ID.
- `GET /Mascota/find/{id}/duenocompleto`: Obtiene la información completa del dueño de una mascota por su ID.
- `GET /Mascota/find/{id}/dueno`: Obtiene el dueño de una mascota por su ID.
- `DELETE /Mascota/delete/{id}`: Elimina una mascota por su ID.

#### Cliente Controller

- `PUT /Clientes/update/{id}`: Actualiza un cliente existente por su ID.
- `POST /Clientes/add`: Agrega un nuevo cliente.
- `GET /Clientes/todos`: Obtiene todos los clientes.
- `GET /Clientes/find/{id}`: Busca un cliente por su ID.
- `DELETE /Clientes/delete/{id}`: Elimina un cliente por su ID.

#### Log-In Controller

- `POST /clientelogin`: Maneja el inicio de sesión de un cliente.
- `POST /Veterinariologin`: Maneja el inicio de sesión de un veterinario.
- `POST /AdminLogin`: Maneja el inicio de sesión de un administrador.

#### Tratamiento Controller

- `POST /Tratamiento/add`: Agrega un nuevo tratamiento.
- `POST /Tratamiento/Desactivar`: Desactiva un tratamiento por su ID.

#### Estadísticas Controller

- Varios endpoints para obtener estadísticas relacionadas con veterinarios, tratamientos, medicamentos y más.

#### Medicamento Controller

- `GET /Medicamentos/todos`: Obtiene todos los medicamentos.

### Servicios

Los servicios proporcionan la lógica de negocio del sistema. Aquí se describen algunos de los servicios disponibles:

#### VeterinarioServicio

- Métodos para buscar veterinarios, obtener todos los veterinarios, agregar, actualizar y eliminar veterinarios, y gestionar su estado activo.

#### MascotaServicio

- Métodos para buscar mascotas, obtener todas las mascotas, agregar, actualizar y eliminar mascotas, obtener tratamientos, información de dueños y más.

#### ClienteServicio

- Métodos para buscar clientes, obtener todos los clientes, agregar, actualizar y eliminar clientes.

#### TratamientoServicio

- Métodos para contar tratamientos realizados en el último mes, obtener información sobre tratamientos y medicamentos, agregar y desactivar tratamientos.

#### MedicamentoServicio

- Métodos para agregar medicamentos, calcular el total de ventas, calcular las ganancias totales, obtener los medicamentos más vendidos, encontrar medicamentos por su ID, obtener todos los medicamentos y actualizar las unidades disponibles y vendidas.

### Uso del Sistema

Para utilizar el sistema, se pueden realizar solicitudes HTTP a los endpoints proporcionados por los controladores. El sistema se encarga de gestionar las operaciones de base de datos y proporcionar respuestas adecuadas.

### Schemas

El sistema utiliza las siguientes entidades o modelos de datos:

- Veterinario
- Mascota
- Cliente
- Tratamiento
- Admin
- Medicamento

### Tecnologías Utilizadas

El proyecto utiliza Spring Boot, Java y Spring Data JPA para gestionar la lógica de negocio y la persistencia de datos. Se pueden encontrar otras tecnologías en el proyecto según las necesidades específicas.

### Contribuciones

Este proyecto es de código abierto y las contribuciones son bienvenidas. Si desea contribuir, le recomendamos seguir las mejores prácticas de desarrollo y enviar pull requests.

¡Gracias por tu interés en este proyecto!
