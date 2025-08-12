# Proyecto Kajum Boutique

## Descripción
Este proyecto es un sistema de gestión para Kajum Boutique, que incluye la administración de clientes, prendas, ventas, facturas, entradas y salidas de mercancía.  
Está desarrollado con Spring Boot y utiliza JPA para la persistencia de datos.

## Estructura del Proyecto
- **model:** Entidades JPA que representan las tablas de la base de datos.  
- **repository:** Interfaces para acceso a datos con JpaRepository.  
- **service:** Lógica de negocio y reglas de validación.  
- **restcontroller:** Controladores REST que exponen la API para la comunicación con clientes o frontend.  
- **config:** Configuraciones generales del proyecto.

## Endpoints principales

### Factura

| Método | URL            | Descripción                |
|--------|----------------|----------------------------|
| GET    | /facturas      | Obtener todas las facturas |
| GET    | /facturas/{id} | Obtener factura por ID     |
| POST   | /facturas      | Crear una nueva factura    |
| PUT    | /facturas/{id} | Actualizar una factura     |
| DELETE | /facturas/{id} | Eliminar factura por ID    |

### Prendas

| Método | URL           | Descripción               |
|--------|---------------|---------------------------|
| GET    | /prendas      | Obtener todas las prendas |
| GET    | /prendas/{id} | Obtener prenda por ID     |
| POST   | /prendas      | Crear una nueva prenda    |
| PUT    | /prendas/{id} | Actualizar prenda         |
| DELETE | /prendas/{id} | Eliminar prenda           |

### Usuario

| Método | URL              | Descripción               |
|--------|------------------|---------------------------|
| GET    | /usuarios        | Obtener todos los usuarios|
| GET    | /usuarios/{id}   | Obtener usuario por ID    |
| POST   | /usuarios        | Crear un nuevo usuario    |
| PUT    | /usuarios/{id}   | Actualizar usuario        |
| DELETE | /usuarios/{id}   | Eliminar usuario          |
| POST   | /usuarios/login  | Validar login de usuario  |

### Venta

| Método | URL                 | Descripción                |
|--------|---------------------|----------------------------|
| GET    | /ventas             | Obtener todas las ventas   |
| GET    | /ventas/{id}        | Obtener venta por ID       |
| POST   | /ventas             | Crear nueva venta          |
| PUT    | /ventas/{id}        | Actualizar venta           |
| DELETE | /ventas/{id}        | Eliminar venta             |
| GET    | /ventas/sin-factura | Obtener ventas sin factura |

### EntradaMercancia

| Método | URL            | Descripción                 |
|--------|----------------|-----------------------------|
| GET    | /entradas      | Obtener todas las entradas  |
| GET    | /entradas/{id} | Obtener entrada por ID      |
| POST   | /entradas      | Crear una nueva entrada     |
| PUT    | /entradas/{id} | Actualizar entrada existente|
| DELETE | /entradas/{id} | Eliminar entrada por ID     |

### SalidaMercancia

| Método | URL            | Descripción                |
|--------|----------------|----------------------------|
| GET    | /salidas       | Obtener todas las salidas  |
| GET    | /salidas/{id}  | Obtener salida por ID      |
| POST   | /salidas       | Crear nueva salida         |
| PUT    | /salidas/{id}  | Actualizar salida          |
| DELETE | /salidas/{id}  | Eliminar salida            |

### VentaDetalle

| Método | URL                 | Descripción               |
|--------|---------------------|---------------------------|
| GET    | /venta-detalles     | Obtener todos los detalles|
| GET    | /venta-detalles/{id}| Obtener detalle por ID    |
| POST   | /venta-detalles     | Crear nuevo detalle       |
| PUT    | /venta-detalles/{id}| Actualizar detalle        |
| DELETE | /venta-detalles/{id}| Eliminar detalle          |

## Tecnologías utilizadas
- Java 17  
- Spring Boot  
- Spring Data JPA  
- Hibernate  
- Maven  
- Base de datos MySQL  

## Cómo ejecutar el proyecto

Clonar el repositorio:

```bash
git clone https://github.com/julianDM24/kajumBoutiqueFRONTED.git
