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


# Getting Started with Create React App

This project was bootstrapped with [Create React App](https://github.com/facebook/create-react-app).

## Available Scripts

In the project directory, you can run:

### `npm start`

Runs the app in the development mode.\
Open [http://localhost:3000](http://localhost:3000) to view it in your browser.

The page will reload when you make changes.\
You may also see any lint errors in the console.

### `npm test`

Launches the test runner in the interactive watch mode.\
See the section about [running tests](https://facebook.github.io/create-react-app/docs/running-tests) for more information.

### `npm run build`

Builds the app for production to the `build` folder.\
It correctly bundles React in production mode and optimizes the build for the best performance.

The build is minified and the filenames include the hashes.\
Your app is ready to be deployed!

See the section about [deployment](https://facebook.github.io/create-react-app/docs/deployment) for more information.

### `npm run eject`

**Note: this is a one-way operation. Once you `eject`, you can't go back!**

If you aren't satisfied with the build tool and configuration choices, you can `eject` at any time. This command will remove the single build dependency from your project.

Instead, it will copy all the configuration files and the transitive dependencies (webpack, Babel, ESLint, etc) right into your project so you have full control over them. All of the commands except `eject` will still work, but they will point to the copied scripts so you can tweak them. At this point you're on your own.

You don't have to ever use `eject`. The curated feature set is suitable for small and middle deployments, and you shouldn't feel obligated to use this feature. However we understand that this tool wouldn't be useful if you couldn't customize it when you are ready for it.

## Learn More

You can learn more in the [Create React App documentation](https://facebook.github.io/create-react-app/docs/getting-started).

To learn React, check out the [React documentation](https://reactjs.org/).

### Code Splitting

This section has moved here: [https://facebook.github.io/create-react-app/docs/code-splitting](https://facebook.github.io/create-react-app/docs/code-splitting)

### Analyzing the Bundle Size

This section has moved here: [https://facebook.github.io/create-react-app/docs/analyzing-the-bundle-size](https://facebook.github.io/create-react-app/docs/analyzing-the-bundle-size)

### Making a Progressive Web App

This section has moved here: [https://facebook.github.io/create-react-app/docs/making-a-progressive-web-app](https://facebook.github.io/create-react-app/docs/making-a-progressive-web-app)

### Advanced Configuration

This section has moved here: [https://facebook.github.io/create-react-app/docs/advanced-configuration](https://facebook.github.io/create-react-app/docs/advanced-configuration)

### Deployment

This section has moved here: [https://facebook.github.io/create-react-app/docs/deployment](https://facebook.github.io/create-react-app/docs/deployment)

### `npm run build` fails to minify

This section has moved here: [https://facebook.github.io/create-react-app/docs/troubleshooting#npm-run-build-fails-to-minify](https://facebook.github.io/create-react-app/docs/troubleshooting#npm-run-build-fails-to-minify)
